package com.itdr.pojo;

import java.math.BigDecimal;

/**
 * Class: Order
 * create: 2019-08-06 19:29:16
 *
 * @version: JDK 1.8
 * @author: heyuu
 *
 * description:
 */
public class Order {
    private String orderNo;
    private BigDecimal payment;
    private Integer paymentType;
    private String paymentTypeDesc;
    private Integer postage;
    private Integer status;
    private String statusDesc;
    private String paymentTime;
    private String sendTime;
    private String endTime;
    private String closeTime;
    private String createTime;
    private Integer orderItemVoList;
    private String imageHost;
    private Integer shippingId;
    private String receiverName;
    private Integer shippingVo;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public BigDecimal getPayment() {
        return payment;
    }

    public void setPayment(BigDecimal payment) {
        this.payment = payment;
    }

    public Integer getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(Integer paymentType) {
        this.paymentType = paymentType;
    }

    public String getPaymentTypeDesc() {
        return paymentTypeDesc;
    }

    public void setPaymentTypeDesc(String paymentTypeDesc) {
        this.paymentTypeDesc = paymentTypeDesc;
    }

    public Integer getPostage() {
        return postage;
    }

    public void setPostage(Integer postage) {
        this.postage = postage;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }

    public String getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(String paymentTime) {
        this.paymentTime = paymentTime;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(String closeTime) {
        this.closeTime = closeTime;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getOrderItemVoList() {
        return orderItemVoList;
    }

    public void setOrderItemVoList(Integer orderItemVoList) {
        this.orderItemVoList = orderItemVoList;
    }

    public String getImageHost() {
        return imageHost;
    }

    public void setImageHost(String imageHost) {
        this.imageHost = imageHost;
    }

    public Integer getShippingId() {
        return shippingId;
    }

    public void setShippingId(Integer shippingId) {
        this.shippingId = shippingId;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public Integer getShippingVo() {
        return shippingVo;
    }

    public void setShippingVo(Integer shippingVo) {
        this.shippingVo = shippingVo;
    }

//    @Override
//    public String toString() {
//        return "{" +
//                "orderNo:'" + orderNo + '\'' +
//                ", payment:" + payment +
//                ", paymentType:" + paymentType +
//                ", paymentTypeDesc:'" + paymentTypeDesc + '\'' +
//                ", postage:" + postage +
//                ", status:" + status +
//                ", statusDesc:'" + statusDesc + '\'' +
//                ", paymentTime:'" + paymentTime + '\'' +
//                ", sendTime:'" + sendTime + '\'' +
//                ", endTime:'" + endTime + '\'' +
//                ", closeTime:'" + closeTime + '\'' +
//                ", createTime:'" + createTime + '\'' +
//                ", orderItemVoList:" + orderItemVoList +
//                ", imageHost:'" + imageHost + '\'' +
//                ", shippingId:" + shippingId +
//                ", receiverName:'" + receiverName + '\'' +
//                ", shippingVo:" + shippingVo +
//                '}';
//    }
}
