package com.sk.mall2.service.impl;

import com.sk.mall2.dao.CategoryMapper;
import com.sk.mall2.entity.Category;
import com.sk.mall2.service.CateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("cateService")
public class CateServiceImpl implements CateService {

    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public List<Category> getAllCate() {
        return categoryMapper.getAllCate();
    }

    @Override
    public void insertSelective(Category category) {
        categoryMapper.insertSelective(category);
    }

    @Override
    public Category selectById(Integer cateId) {
        return categoryMapper.selectByPrimaryKey(cateId);
    }

    @Override
    public Category selectByName(String name) {
        return categoryMapper.selectByName(name);
    }

    @Override
    public void updateByPrimaryKeySelective(Category category) {
        categoryMapper.updateByPrimaryKeySelective(category);
    }

    @Override
    public void deleteById(Integer id) {
        categoryMapper.deleteById(id);
    }
}
