package com.sk.mall2.dao;

import com.sk.mall2.entity.ImagePath;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImagePathMapper {

    /**
     * 添加照片
     *
     * @param record 图片
     */
    void addImagePath(ImagePath record);


    /**
     * 查询商品的所有图片
     *
     * @param id 商品id
     * @return List<ImagePath>
     */
    List<ImagePath> getImagesByGoodsId(String id);
}