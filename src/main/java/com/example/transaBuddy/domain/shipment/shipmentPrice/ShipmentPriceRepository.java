package com.example.transaBuddy.domain.shipment.shipmentPrice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ShipmentPriceRepository extends JpaRepository<ShipmentPrice, Integer> {
    @Query("select s from ShipmentPrice s where s.id = ?1")
    ShipmentPrice getShipmentPriceById(Integer id);

}
