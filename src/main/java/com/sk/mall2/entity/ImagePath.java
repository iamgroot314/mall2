package com.sk.mall2.entity;

public class ImagePath {
    private Integer id;

    private Integer goodId;

    private String path;

    public ImagePath() {
    }

    public ImagePath(Integer id, Integer goodId, String path) {
        this.id = id;
        this.goodId = goodId;
        this.path = path;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGoodId() {
        return goodId;
    }

    public void setGoodId(Integer goodId) {
        this.goodId = goodId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "ImagePath{" +
                "id=" + id +
                ", goodId=" + goodId +
                ", path='" + path + '\'' +
                '}';
    }
}