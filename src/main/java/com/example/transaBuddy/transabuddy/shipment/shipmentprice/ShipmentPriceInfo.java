package com.example.transaBuddy.transabuddy.shipment.shipmentprice;

import lombok.Data;



@Data
public class ShipmentPriceInfo {
    private Integer id;
    private String dimensions;
    private Integer weight;
    private Integer price;
    private String type;
}
