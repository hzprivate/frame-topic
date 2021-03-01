package com.hz.bean;


import com.hz.aop.TrimField;

/**
 * @author hz
 * @Description:
 * @create 2021-02-25
 */
//@TrimType
public class OrderDTO {
    @TrimField
    private String orderId;
//    @TrimField
    private String orderName;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }
}
