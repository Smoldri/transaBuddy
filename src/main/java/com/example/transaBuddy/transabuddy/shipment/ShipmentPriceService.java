package com.example.transaBuddy.transabuddy.shipment;

import com.example.transaBuddy.temp.ShipmentPrice;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ShipmentPriceService {

    @Resource
    private ShipmentPriceRepository shipmentPriceRepository;
    public ShipmentPrice getShipmentPriceCategoryById(Integer shipmentPriceId) {
       return shipmentPriceRepository.getShipmentPriceById(shipmentPriceId);
    }
}
