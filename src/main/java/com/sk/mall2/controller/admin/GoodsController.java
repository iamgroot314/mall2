package com.sk.mall2.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.sk.mall2.entity.Category;
import com.sk.mall2.entity.Goods;
import com.sk.mall2.entity.ImagePath;
import com.sk.mall2.service.CateService;
import com.sk.mall2.service.GoodsService;
import com.sk.mall2.util.ImageUtil;
import com.sk.mall2.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;


@Controller
@RequestMapping("/admin/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;


    @Autowired
    private CateService cateService;

    /**
     * 重定向当商品页
     *
     * @param model   存数据
     * @return String
     */
    @RequestMapping("/show")
    public String goodsManage(Model model) {

        // 把商品类型查询出来返回给前端，以供商品修改使用
        List<Category> categoryList = cateService.getAllCate();
        model.addAttribute("categoryList", categoryList);
        return "admin/adminAllGoods";
    }



    /**
     * 分页显示商品
     *
     * @param pn      页码
     * @param model   返回给前端的值
     * @return Msg
     */
    @RequestMapping("/showjson")
    @ResponseBody
    public Msg getAllGoods(@RequestParam(value = "page", defaultValue = "1") Integer pn, Model model) {
        //一页显示几个数据
        PageHelper.startPage(pn, 10);
        List<Goods> goods = goodsService.getAllGoods();
        PageInfo<Goods> page = new PageInfo<>(goods);
        model.addAttribute("pageInfo", page);
        return Msg.success("查询成功!").add("pageInfo", page);
    }


    /**
     * 添加商品回调函数
     *
     * @param msg     添加商品信息发返回值
     * @param model   前端传值
     * @return String
     */
    @RequestMapping("/add")
    public String showAdd(@ModelAttribute("succeseMsg") String msg, Model model) {
        if (!"".equals(msg)) {
            model.addAttribute("msg", msg);
        }
        //还需要查询分类传给addGoods页面
        List<Category> categoryList = cateService.getAllCate();
        model.addAttribute("categoryList", categoryList);
        return "admin/addGoods";
    }

    /**
     * 修改商品
     *
     * @param goods   商品
     * @return Msg
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public Msg updateGoods(Goods goods) {
        goodsService.updateGoodsById(goods);
        return Msg.success("更新成功!");
    }

    /**
     * 删除商品信息
     *
     * @param goodsid 商品id
     * @return Msg
     */
    @RequestMapping(value = "/delete/{goodsid}", method = RequestMethod.DELETE)
    @ResponseBody
    public Msg deleteGoods(@PathVariable("goodsid") Integer goodsid) {
        goodsService.deleteGoodsById(goodsid);
        return Msg.success("删除成功!");
    }


    /**
     * 添加商品，添加完成之后，重定向当添加商品页面
     *
     * @param goods              商品
     * @param fileToUpload       文件
     * @param redirectAttributes 重定向传递数据
     * @return String
     */
    @RequestMapping("/addGoodsSuccess")
    @Transactional(rollbackFor = Exception.class)
    public String addGoods(Goods goods,
                           @RequestParam MultipartFile[] fileToUpload,
                           RedirectAttributes redirectAttributes) {
        goods.setUpTime(new Date());
        goods.setActivityId(1);
        goods.setIsSale(1);
        try {
            goodsService.addGoods(goods);
            for (MultipartFile multipartFile : fileToUpload) {
                if (multipartFile.getOriginalFilename() == null || multipartFile.getOriginalFilename().equals("")) {
                    throw new RuntimeException("请添加图片");
                }
                String fileName = multipartFile.getOriginalFilename();
                String imagePath = ImageUtil.imagePath(multipartFile, fileName);
                //把图片路径存入数据库中
                goodsService.addImagePath(new ImagePath(null, goods.getId(), imagePath));
            }
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("succeseMsg", "商品添加失败!");
        }
        redirectAttributes.addFlashAttribute("succeseMsg", "商品添加成功!");
        return "redirect:/admin/goods/add";
    }


    /**
     * 添加商品分类
     *
     * @param msg     分类信息
     * @param model   返回给前端的数据
     * @return String
     */
    @RequestMapping("/addCategory")
    public String addcategory(@ModelAttribute("succeseMsg") String msg, Model model) {

        // 查询所有分类
        List<Category> categoryList = cateService.getAllCate();
        model.addAttribute("categoryList", categoryList);
        if (!"".equals(msg)) {
            model.addAttribute("msg", msg);
        }
        return "admin/addCategory";
    }


    @RequestMapping("/addCategoryResult")
    public String addCategoryResult(Category category, RedirectAttributes redirectAttributes) {
        Category c = cateService.selectByName(category.getCateName());
        if (c != null) {
            redirectAttributes.addAttribute("succeseMsg", "分类已存在");
            return "redirect:/admin/goods/addCategory";
        } else {
            cateService.insertSelective(category);
            redirectAttributes.addFlashAttribute("succeseMsg", "分类添加成功!");
            return "redirect:/admin/goods/addCategory";
        }
    }


    /**
     * 编辑分类
     *
     * @param category 分类
     * @return Msg
     */
    @RequestMapping("/saveCate")
    @ResponseBody
    public Msg saveCate(Category category) {
        Category categoryList = cateService.selectByName(category.getCateName());
        if (categoryList == null) {
            cateService.updateByPrimaryKeySelective(category);
            return Msg.success("更新成功");
        } else {
            return Msg.success("名字已经存在");
        }
    }


    /**
     * 删除分类
     *
     * @param category 分类信息
     * @return Msg
     */
    @RequestMapping("/deleteCate")
    @ResponseBody
    public Msg deleteCate(Category category) {
        cateService.deleteById(category.getId());
        return Msg.success("删除成功");
    }

    /**
     * 商品上下架
     *
     * @param goodsId 商品id
     * @return Msg
     */
    @RequestMapping("/operationSale")
    @ResponseBody
    public Msg operationSale(Integer goodsId) {
        Goods goods = goodsService.selectById(goodsId);
        if (goods.getIsSale() == 1){
            goods.setIsSale(0);
            goodsService.updateGoodsById(goods);
            return Msg.success("下架成功");
        } else{
            goods.setIsSale(1);
            goodsService.updateGoodsById(goods);
            return Msg.success("上架成功");
        }
    }

    /**
     * 重定向当商品页
     *
     * @param model   存数据
     * @return String
     */
    @RequestMapping("/showhot")

    public String hotGoodsManage(Model model) {
        // 把商品类型查询出来返回给前端，以供商品修改使用
        List<Category> categoryList = cateService.getAllCate();
        model.addAttribute("categoryList", categoryList);
        return "admin/showHot";
    }



    /**
     * 分页显示商品
     *
     * @param pn      页码
     * @param model   返回给前端的值
     * @return Msg
     */
    @RequestMapping("/showhotjson")
    @ResponseBody
    public Msg getHotGoods(@RequestParam(value = "page", defaultValue = "1") Integer pn, Model model) {
        //一页显示几个数据
        PageHelper.startPage(pn, 10);
        List<Goods> goods = goodsService.getHotGoods();
        PageInfo<Goods> page = new PageInfo<>(goods);
        model.addAttribute("pageInfo", page);
        return Msg.success("查询成功!").add("pageInfo", page);
    }


}
