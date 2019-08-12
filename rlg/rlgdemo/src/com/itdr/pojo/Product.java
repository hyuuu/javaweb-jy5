package com.itdr.pojo;

import java.math.BigDecimal;

/**
 * @ClassName: Product
 * @author: heyuu
 * @create: 2019-08-03 09:19:42
 * @version: JDK 1.8
 * @description:
 */
public class Product {
    private Integer id;
    private Integer categoryId;
    private Integer parentCategoryId;
    private String name;
    private String subtitle;
    private String imageHost;
    private String mainImage;
    private String subImages;
    private String detail;
    private BigDecimal price;
    private String stock;
    private Integer status;
    private String createTime;
    private String updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getParentCategoryId() {
        return parentCategoryId;
    }

    public void setParentCategoryId(Integer parentCategoryId) {
        this.parentCategoryId = parentCategoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getImageHost() {
        return imageHost;
    }

    public void setImageHost(String imageHost) {
        this.imageHost = imageHost;
    }

    public String getMainImage() {
        return mainImage;
    }

    public void setMainImage(String mainImage) {
        this.mainImage = mainImage;
    }

    public String getSubImages() {
        return subImages;
    }

    public void setSubImages(String subImages) {
        this.subImages = subImages;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

//    @Override
//    public String toString() {
//        return "{" +
//                "id:" + id +
//                ", categoryId:" + categoryId +
//                ", parentCategoryId:" + parentCategoryId +
//                ", name:'" + name + '\'' +
//                ", subtitle:'" + subtitle + '\'' +
//                ", imageHost:'" + imageHost + '\'' +
//                ", mainImage:'" + mainImage + '\'' +
//                ", subImages:'" + subImages + '\'' +
//                ", detail:'" + detail + '\'' +
//                ", price:" + price +
//                ", stock:'" + stock + '\'' +
//                ", status:" + status +
//                ", createTime:'" + createTime + '\'' +
//                ", updateTime:'" + updateTime + '\'' +
//                '}';
//    }
}
