package com.sk.mall2.entity;

import java.util.Date;
import java.util.List;

public class Goods {
    private Integer id;

    private String goodsName;

    private Integer price;

    private Integer num;

    private Date upTime;

    private Integer category;

    private String categoryName;

    private String detailCate;

    private Integer activityId;

    private String description;

    private List<ImagePath> imagePaths;

    private boolean fav;

    private Activity activity;

    private Float newPrice;

    private Integer isSale;

    private HotGoods hotGoods;

    public HotGoods getHotGoods() {
        return hotGoods;
    }

    public void setHotGoods(HotGoods hotGoods) {
        this.hotGoods = hotGoods;
    }
//private List<Comment> comments;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Date getUpTime() {
        return upTime;
    }

    public void setUpTime(Date upTime) {
        this.upTime = upTime;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

//    public List<Comment> getComments() {
//        return comments;
//    }
//
//    public void setComments(List<Comment> comments) {
//        this.comments = comments;
//    }

    public String getDetailCate() {
        return detailCate;
    }

    public void setDetailCate(String detailCate) {
        this.detailCate = detailCate;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ImagePath> getImagePaths() {
        return imagePaths;
    }

    public void setImagePaths(List<ImagePath> imagePaths) {
        this.imagePaths = imagePaths;
    }

    public boolean isFav() {
        return fav;
    }

    public void setFav(boolean fav) {
        this.fav = fav;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public Float getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(Float newPrice) {
        this.newPrice = newPrice;
    }

    public Integer getIsSale() {
        return isSale;
    }

    public void setIsSale(Integer isSale) {
        this.isSale = isSale;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", goodsName='" + goodsName + '\'' +
                ", price=" + price +
                ", num=" + num +
                ", uptime=" + upTime +
                ", category=" + category +
                ", categoryName='" + categoryName + '\'' +
                ", detailCate='" + detailCate + '\'' +
                ", activityId=" + activityId +
                ", description='" + description + '\'' +
                ", imagePaths=" + imagePaths +
                ", fav=" + fav +
                ", activity=" + activity +
                ", newPrice=" + newPrice +
                ", isSale=" + isSale +
                '}';
    }
}