package com.hsyd.yycw.model;

import java.util.List;

/**
 * 查询条件
 * Created by vie1224 on 2017/5/15.
 */
public class SearchModel {

    private Integer id;// 各种业务ide
    private String userId;// 用户编号
    private String orderId;// 订单编号
    private String  sex;//性别
    private String  name;// 各种业务名称
    private String  startPrice;//起始价格
    private String  endPrice;// 终止价格
    private String  startTime;// 起始时间
    private String  endTime;// 终止时间
    private List<String> types;// 类型集合
    private String type;// 单类型
    private Boolean countDesc = false; // 销量排序 true：升序 false：不排序
    private Boolean priceSort = null; // null：不排序 true：升序 false：降序

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(String startPrice) {
        this.startPrice = startPrice;
    }

    public String getEndPrice() {
        return endPrice;
    }

    public void setEndPrice(String endPrice) {
        this.endPrice = endPrice;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getCountDesc() {
        return countDesc;
    }

    public void setCountDesc(Boolean countDesc) {
        this.countDesc = countDesc;
    }

    public Boolean getPriceSort() {
        return priceSort;
    }

    public void setPriceSort(Boolean priceSort) {
        this.priceSort = priceSort;
    }
}
