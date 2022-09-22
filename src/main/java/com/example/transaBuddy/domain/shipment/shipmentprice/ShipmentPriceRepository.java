package com.example.transaBuddy.domain.shipment.shipmentprice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ShipmentPriceRepository extends JpaRepository<ShipmentPrice, Integer> {
    @Query("select s from ShipmentPrice s where s.id = ?1")
    ShipmentPrice getShipmentPriceById(Integer id);

    @Query("select s from ShipmentPrice s where s.type = ?1")
    ShipmentPrice findByType(String type);

    @Query("select (count(s) > 0) from ShipmentPrice s where upper(s.type) = upper(?1)")
    boolean existsByType(String type);

    @Query("select s from ShipmentPrice s where s.type = ?1")
    ShipmentPrice findByPriceType(String type);



}
