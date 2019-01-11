package com.example.amqp.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Order implements Serializable {
    private static final long serialVersionUID = -1599884464140070077L;

    // 订单ID
    private String orderId;
    // 订单状态 0:未支付 1:已支付 2:订单已取消
    private Integer orderStatus;
    // 订单名字
    private String orderName;

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", orderStatus=" + orderStatus +
                ", orderName='" + orderName + '\'' +
                '}';
    }
}
