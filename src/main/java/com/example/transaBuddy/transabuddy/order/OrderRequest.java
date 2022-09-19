package com.example.transaBuddy.transabuddy.order;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Data
public class OrderRequest implements Serializable {
    private Integer senderUserId;
    private Integer courierUserId;
    private LocalDate deliveryDate;
    private Integer fromHour;
    private Integer toHour;
    private Integer pickUpDistrictId;
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
