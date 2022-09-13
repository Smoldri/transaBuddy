package com.example.transaBuddy.transabuddy.order;

import lombok.Data;

import java.io.Serializable;

@Data
public class OrderInfo implements Serializable {
    private Integer orderId;
    private Integer senderUserId;
    private Integer receiverPhoneNumber;
    private Integer courierUserId;
    private Integer deliveryDate;
    private Integer fromHour;
    private Integer toHour;
    private Integer comment;
    private Integer status;
    private Integer shipmentId;
}
