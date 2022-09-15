package com.example.transaBuddy.domain.shipment;

import com.example.transaBuddy.domain.shipment.shipmentprice.ShipmentPrice;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "shipment")
public class Shipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "amount", nullable = false)
    private Integer amount;

    @Column(name = "description", length = 500)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "shipment_price_id", nullable = false)
    private ShipmentPrice shipmentPrice;

}