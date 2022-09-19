package com.example.transaBuddy.transabuddy.order;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class AvailableOrders implements Serializable {
    private Integer orderId;
    private LocalDate deliveryDate;
    private Integer fromHour;
    private Integer toHour;
    private String pickUpAddress;
    private String dropOffAddress;
    private String status;
}
