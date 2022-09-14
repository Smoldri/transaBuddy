package com.example.transaBuddy.transabuddy.shipment.shipmentprice;

import com.example.transaBuddy.domain.shipment.shipmentPrice.ShipmentPrice;
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
