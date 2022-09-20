package com.example.transaBuddy.transabuddy.order;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;


@Data
public class OrderInfo implements Serializable {

    private Integer orderId;
    private Integer senderUserId;
    private Integer courierUserId;
    private Integer shipmentId;
    private LocalDate deliveryDate;
    private String timeFrame;
    private String senderName;
    private String senderPhoneNumber;
    private Integer pickUpDistrictId;
    private String pickUpAddress;
    private Integer dropOffDistrictId;
    private String dropOffAddress;
    private String receiverName;
    private String receiverPhoneNumber;
    private Integer packageAmount;
    private String shipmentDescription;
    private String priceCategory;
    private String comment;
    private String status;

}
