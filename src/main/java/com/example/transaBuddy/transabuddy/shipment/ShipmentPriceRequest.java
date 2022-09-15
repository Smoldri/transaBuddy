package com.example.transaBuddy.transabuddy.shipment;

import lombok.Data;

@Data
public class ShipmentPriceRequest {
    private String dimensions;
    private Integer weight;
    private Integer price;
    private String type;
}
