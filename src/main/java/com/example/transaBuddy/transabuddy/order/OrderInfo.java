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
    private Integer fromHour;
    private Integer toHour;
    private String senderName;
    private String senderPhoneNumber;
    private Integer pickUpDistrictId;
    private String pickUpAddress;
    private Integer dropOffDistrictId;
    private String dropOffAddress;
    private String receiverName;
    private String receiverPhoneNumber;
    private String priceCategory;
    private String comment;
    private String status;

}
