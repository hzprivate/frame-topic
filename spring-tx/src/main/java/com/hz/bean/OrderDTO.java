package com.hz.bean;

import com.hz.aop.TrimField;
import com.hz.aop.TrimType;

/**
 * @author hz
 * @Description:
 * @create 2021-02-25
 */
@TrimType
public class OrderDTO {
//    @TrimField
    private Integer orderId;
//    @TrimField
    private String orderName;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }
}
