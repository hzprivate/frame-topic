package com.hz.bean;

import com.hz.config.DTOTrim;

/**
 * @author hz
 * @Description:
 * @create 2021-02-25
 */

public class OrderDTO {
    @DTOTrim
    private String orderId;
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
