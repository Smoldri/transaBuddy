package com.example.transaBuddy.transabuddy.order;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class OrderInfo implements Serializable {
    private Integer orderId;
    private Integer senderUserId;
    private String receiverName;
    private String receiverPhoneNumber;
    private Integer courierUserId;
    private Date deliveryDate;
    private Integer fromHour;
    private Integer toHour;
    private String comment;
    private String status;
    private Integer shipmentId;

}
