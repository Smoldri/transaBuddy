package com.example.transaBuddy.transabuddy.shipment;

import com.example.transaBuddy.temp.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ShipmentRepository extends JpaRepository<Shipment, Integer> {
    @Query("select s from Shipment s where s.id = ?1")
    Shipment getShipmentById(Integer shipmentId);


}