package com.itdr.pojo;

/**
 * Class: category
 * create: 2019-08-05 19:59:45
 *
 * @version: JDK 1.8
 * @author: heyuu
 * description:
 */
public class Category {
    private Integer id;
    private Integer parentId;
    private String name;
    private Integer status;
    private Integer sortOrder;
    private String createTime;
    private String updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
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
//                ", parentId:" + parentId +
//                ", name:'" + name + '\'' +
//                ", status:" + status +
//                ", sortOrder:" + sortOrder +
//                ", createTime:'" + createTime + '\'' +
//                ", updateTime:'" + updateTime + '\'' +
//                '}';
//    }
}
