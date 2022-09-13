package com.example.transaBuddy.transabuddy.order;

import com.example.transaBuddy.temp.User;
import lombok.Data;

import java.time.Instant;
import java.time.LocalDate;

@Data
public class OrderRequest {
    private LocalDate deliveryDate;
    private Integer fromHour;
    private Integer toHour;
    private String pickUpAddress;
    private String dropOffAddress;
    private String receiverName;
    private String receiverPhoneNumber;
    private Integer packageAmountInShipment;
    private Character priceCategory;
    private String shipmentDescription;
    private String comment;

}
