package com.example.transaBuddy.domain.shipment.shipmentPrice;

import com.example.transaBuddy.domain.shipment.shipmentPrice.ShipmentPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ShipmentPriceRepository extends JpaRepository<ShipmentPrice, Integer> {
    @Query("select s from ShipmentPrice s where s.id = ?1")
    ShipmentPrice getShipmentPriceById(Integer id);


}
