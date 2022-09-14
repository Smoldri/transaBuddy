package com.example.transaBuddy.transabuddy.order;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class OrderRequest implements Serializable {
    private Integer senderUserId;
    private Integer courierUserId;
    private LocalDate deliveryDate;
    private Integer fromHour;
    private Integer toHour;
    private Integer pickUpDistrict;
    private String pickUpAddress;
    private Integer dropOffDistrictId;
    private String dropOffAddress;
    private String receiverName;
    private String receiverPhoneNumber;
    private Integer packageAmountInShipment;
    private Integer shipmentPriceId;
    private String shipmentDescription;
    private String comment;

}
