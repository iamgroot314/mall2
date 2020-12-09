package com.sk.mall2.service.impl;

import com.sk.mall2.dao.GoodsMapper;
import com.sk.mall2.dao.ImagePathMapper;
import com.sk.mall2.service.CateService;

import com.sk.mall2.entity.Category;

import com.sk.mall2.entity.Goods;
import com.sk.mall2.entity.ImagePath;

import com.sk.mall2.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {


    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private CateService cateService;


    @Autowired
    private ImagePathMapper imagePathMapper;



    @Override
    public List<Goods> selectFavByUserId(Integer userId) {
        return goodsMapper.selectFavByUserId(userId);
    }


    @Override
    public Integer addGoods(Goods goods) {
        Category category = cateService.selectById(goods.getCategory());
        if (category != null) {
            goods.setCategoryName(category.getCateName());
        }
        goodsMapper.insertSelective(goods);
        return goods.getId();
    }

    @Override
    public void addImagePath(ImagePath imagePath) {
        imagePathMapper.addImagePath(imagePath);
    }


    @Override
    public List<Goods> getAllGoods() {
        return goodsMapper.getAllGoods();
    }


    @Override
    public void deleteGoodsById(Integer id) {
        goodsMapper.deleteById(id);
    }


    @Override
    public void updateGoodsById(Goods goods) {
        Category category = cateService.selectById(goods.getCategory());
        if (category != null) {
            goods.setCategoryName(category.getCateName());
        }
        goodsMapper.updateByPrimaryKeySelective(goods);
    }


    @Override
    public Goods selectById(Integer goodsid) {
        return goodsMapper.getById(goodsid);
    }

    @Override
    public List<Goods> getBySearchName(String keyWord) {
        return goodsMapper.getBySearchName("%" + keyWord + "%");
    }




    @Override
    public List<Goods> selectGoodsByCateLike(String cate) {
        return goodsMapper.selectGoodsByCateLike("%" + cate + "%");
    }

    @Override
    public List<Goods> getHotGoods() {
        return goodsMapper.getHotGoods();
    }


}
