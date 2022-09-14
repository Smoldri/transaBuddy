package com.example.transaBuddy.domain.shipment;

import com.example.transaBuddy.domain.shipment.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipmentRepository extends JpaRepository<Shipment, Integer> {
}