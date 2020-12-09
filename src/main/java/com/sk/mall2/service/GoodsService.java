package com.sk.mall2.service;



import com.sk.mall2.entity.Goods;
import com.sk.mall2.entity.ImagePath;

import java.util.List;

public interface GoodsService {
    Integer addGoods(Goods goods);

    void addImagePath(ImagePath imagePath);

    List<Goods> getAllGoods();

    void deleteGoodsById(Integer id);

    void updateGoodsById(Goods goods);

    Goods selectById(Integer goodsId);

    List<Goods> getBySearchName(String keyWord);



    /**
     * 查找个人喜欢的商品
     *
     * @param userId 用户id
     * @return List<Goods>
     */
    List<Goods> selectFavByUserId(Integer userId);


    /**
     * 根据分类名称模糊查询
     *
     * @param cate 用户id
     * @return List<Goods>
     */
    List<Goods> selectGoodsByCateLike(String cate);

    /**
     *
     * @param
     * @return
     */
    List<Goods> getHotGoods();
}
