package com.sk.mall2.entity;

public class HotGoods {

    private Integer goodsId;
    private Integer countNum;

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getCountNum() {
        return countNum;
    }

    public void setCountNum(Integer countNum) {
        this.countNum = countNum;
    }

    @Override
    public String toString() {
        return "HotGoods{" +
                "goodsId=" + goodsId +
                ", countNum=" + countNum +
                '}';
    }
}
