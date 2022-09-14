package com.example.transaBuddy.domain.shipment.shipmentPrice;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ShipmentPriceService {

    @Resource
    private ShipmentPriceRepository shipmentPriceRepository;
    public ShipmentPrice getShipmentPriceCategoryById(Integer shipmentPriceId) {
       return shipmentPriceRepository.getShipmentPriceById(shipmentPriceId);
    }

    public List<ShipmentPrice> getAllPrices() {
        return shipmentPriceRepository.findAll();
    }
}
