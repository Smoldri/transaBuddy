package com.example.transaBuddy.transabuddy.shipment;

import com.example.transaBuddy.temp.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipmentRepository extends JpaRepository<Shipment, Integer> {
}