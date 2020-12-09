package com.sk.mall2.dao;

import com.sk.mall2.entity.Goods;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsMapper {

    /**
     * 根据id删除
     *
     * @param id id
     * @return int
     */
    int deleteById(Integer id);

    /**
     * 添加商品
     * @param record 商品
     * @return int
     */
    int insertSelective(Goods record);

    /**
     * 获取所有商品
     *
     * @return  List<Goods>
     */
    List<Goods> getAllGoods();


    /**
     * 根据id查询商品
     *
     * @param goodsId 商品id
     * @return Goods
     */
    Goods getById(Integer goodsId);

    /**
     * 更改商品信息
     *
     * @param record 商品信息
     * @return int
     */
    int updateByPrimaryKeySelective(Goods record);

    /**
     * 根据名称模糊查询
     *
     * @param keyWord 名称
     * @return   List<Goods>
     */
    List<Goods> getBySearchName(String keyWord);

    /**
     * 根据用户id来查找喜欢的商品
     *
     * @param userId 用户id
     * @return List<Goods>
     */
    List<Goods> selectFavByUserId(Integer userId);

    /**
     * 根据分类名称模糊查询
     *
     * @param cate 分类名称
     * @return List<Goods>
     */
    List<Goods> selectGoodsByCateLike(String cate);

    List<Goods> getHotGoods();

}