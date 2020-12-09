package com.sk.mall2.service;


import com.sk.mall2.entity.Category;

import java.util.List;


public interface CateService {
    /**
     * 查找所有分类
     *
     * @return List<Category>
     */
    List<Category> getAllCate();

    /**
     * 添加商品分类
     *
     * @param category 分类
     */
    void insertSelective(Category category);

    /**
     * 通过主键id查找
     *
     * @param cateId id
     * @return Category
     */
    Category selectById(Integer cateId);

    /**
     * 通过名称查找
     *
     * @param name 名称
     * @return Category
     */
    Category selectByName(String name);

    /**
     * 修改分类
     *
     * @param category 信息
     */
    void updateByPrimaryKeySelective(Category category);

    /**
     * 通过id删除
     *
     * @param id id
     */
    void deleteById(Integer id);

}
