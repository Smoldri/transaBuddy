package com.example.transaBuddy.domain.shipment.shipmentprice;

import com.example.transaBuddy.transabuddy.shipment.ShipmentPriceResponse;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "shipment_price")
public class ShipmentPrice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "dimensions", nullable = false)
    private String dimensions;

    @Column(name = "weight", nullable = false)
    private Integer weight;

    @Column(name = "price", nullable = true)
    private Integer price;

    @Column(name = "type", nullable = false)
    private String type;

}