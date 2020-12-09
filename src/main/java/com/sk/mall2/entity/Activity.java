package com.sk.mall2.entity;

/**
 * 促销活动
 */
public class Activity {

    /**
     * 活动id
     */
    private Integer id;

    /**
     * 活动名
     */
    private String activityName;

    /**
     * 活动地址
     */
    private String activityAddress;


    /**
     * 活动满减
     */
    private Float disCount;

    /**
     * 活动满金额
     */
    private Integer fullPrice;

    /**
     * 活动减金额
     */
    private Integer reducePrice;


    private Integer fullNum;


    private Integer reduceNum;

    private String activityDes;

    public String getActivityDes() {
        return activityDes;
    }

    public void setActivityDes(String activityDes) {
        this.activityDes = activityDes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getActivityAddress() {
        return activityAddress;
    }

    public void setActivityAddress(String activityAddress) {
        this.activityAddress = activityAddress;
    }

    public Float getDisCount() {
        return disCount;
    }

    public void setDisCount(Float disCount) {
        this.disCount = disCount;
    }

    public Integer getFullPrice() {
        return fullPrice;
    }

    public void setFullPrice(Integer fullPrice) {
        this.fullPrice = fullPrice;
    }

    public Integer getReducePrice() {
        return reducePrice;
    }

    public void setReducePrice(Integer reducePrice) {
        this.reducePrice = reducePrice;
    }

    public Integer getFullNum() {
        return fullNum;
    }

    public void setFullNum(Integer fullNum) {
        this.fullNum = fullNum;
    }

    public Integer getReduceNum() {
        return reduceNum;
    }

    public void setReduceNum(Integer reduceNum) {
        this.reduceNum = reduceNum;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "id=" + id +
                ", activityName='" + activityName + '\'' +
                ", activityAddress='" + activityAddress + '\'' +
                ", disCount=" + disCount +
                ", fullPrice=" + fullPrice +
                ", reducePrice=" + reducePrice +
                ", fullNum=" + fullNum +
                ", reduceNum=" + reduceNum +
                '}';
    }
}