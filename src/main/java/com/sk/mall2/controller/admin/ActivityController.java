package com.sk.mall2.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sk.mall2.entity.Activity;

import com.sk.mall2.entity.Goods;
import com.sk.mall2.service.ActivityService;
import com.sk.mall2.service.GoodsService;
import com.sk.mall2.util.Msg;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/admin/activity")
@Api(value = "促销活动controller", tags = {"促销活动操作接口"})
public class ActivityController {

    @Autowired(required = false)
    ActivityService activityService;

    @Autowired(required = false)
    GoodsService goodsService;

    @RequestMapping("/show")
    public String showActivity(@RequestParam(value = "page", defaultValue = "1") Integer pn, Model model) {
        //一页显示几个数据
        PageHelper.startPage(pn, 10);
        List<Activity> activityList = activityService.getAllActivity();
        //显示几个页号
        PageInfo page = new PageInfo(activityList, 5);
        model.addAttribute("pageInfo", page);
        return "admin/activity";
    }

    @RequestMapping("/showjson")
    @ResponseBody
    public Msg showActivityJson(@RequestParam(value = "page", defaultValue = "1") Integer pn, Model model) {

        List<Activity> activityList = activityService.getAllActivity();
        return Msg.success("获取活动信息成功").add("activity", activityList);
    }

    @RequestMapping("/add")
    public String showAddActivity(HttpSession session) {
        return "admin/addActivity";
    }

    @RequestMapping("/addResult")
    public String addActivity(Activity activity) {
        activityService.insertActivitySelective(activity);
        return "redirect:/admin/activity/show";
    }

    @RequestMapping("/update")
    @ResponseBody
    public Msg updateActivity(Integer goodsId, Integer activityId) {
        Goods goods = new Goods();
        goods.setActivityId(activityId);
        goods.setId(goodsId);
        goodsService.updateGoodsById(goods);
        return Msg.success("更新商品活动成功");
    }

    @RequestMapping("delete")
    public String deleteActivity(Integer activityid) {

        activityService.deleteByActivityId(activityid);
        return "redirect:/admin/activity/show";
    }
}
