package com.sk.mall2.dao;


import com.sk.mall2.entity.Category;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author qiaochx
 */
@Repository
public interface CategoryMapper {

    /**
     * 通过id删除
     *
     * @param id id
     */
    void deleteById(Integer id);

    /**
     * 添加商品分类
     *
     * @param record 分类
     * @return int
     */
    int insertSelective(Category record);

    /**
     * 查找所有分类
     *
     * @return List<Category>
     */
    List<Category> getAllCate();

    /**
     * 通过主键id查找
     *
     * @param cateId id
     * @return Category
     */
    Category selectByPrimaryKey(Integer cateId);

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
     * @return int
     */
    int updateByPrimaryKeySelective(Category category);

}