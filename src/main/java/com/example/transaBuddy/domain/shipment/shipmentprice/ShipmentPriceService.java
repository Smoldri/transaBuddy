package com.example.transaBuddy.domain.shipment.shipmentprice;

import com.example.transaBuddy.transabuddy.shipment.ShipmentPriceInfo;
import com.example.transaBuddy.transabuddy.shipment.ShipmentPriceRequest;
import com.example.transaBuddy.transabuddy.shipment.ShipmentPriceResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ShipmentPriceService {

    @Resource
    private ShipmentPriceRepository shipmentPriceRepository;

    @Resource
    private ShipmentPriceMapper shipmentPriceMapper;

    public ShipmentPrice getShipmentPriceCategoryById(Integer shipmentPriceId) {
       return shipmentPriceRepository.getShipmentPriceById(shipmentPriceId);
    }

    public List<ShipmentPrice> getAllPrices() {
        return shipmentPriceRepository.findAll();
    }

    public ShipmentPriceResponse addPriceCategory(ShipmentPriceRequest request) {
        ShipmentPrice shipmentPrice = shipmentPriceMapper.shipmentPriceRequestToShipmentPrice(request);
//        ValidationService.validatePriceTypeExists(getAllPrices(),shipmentPrice.getType());
        shipmentPriceRepository.save(shipmentPrice);
        return shipmentPriceMapper.shipmentPriceToShipmentPriceResponse(shipmentPrice);
    }


    public void updatePrice(ShipmentPriceInfo shipmentPriceInfo) {
        ShipmentPrice shipmentPrice = shipmentPriceRepository.getReferenceById(shipmentPriceInfo.getShipmentPriceId());
        shipmentPrice.setPrice(shipmentPriceInfo.getPrice());
        shipmentPrice.setType(shipmentPriceInfo.getType());
        shipmentPrice.setDimensions(shipmentPriceInfo.getDimensions());
        shipmentPrice.setWeight(shipmentPriceInfo.getWeight());
        shipmentPriceRepository.save(shipmentPrice);
    }
}
