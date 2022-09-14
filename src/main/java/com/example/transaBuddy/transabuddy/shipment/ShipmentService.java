package com.example.transaBuddy.transabuddy.shipment;

import com.example.transaBuddy.domain.shipment.Shipment;
import com.example.transaBuddy.domain.shipment.shipmentPrice.ShipmentPrice;
import com.example.transaBuddy.transabuddy.order.OrderRequest;
import com.example.transaBuddy.transabuddy.shipment.shipmentprice.ShipmentPriceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ShipmentService {

    @Resource
    private ShipmentRepository shipmentRepository;
    @Resource
    private ShipmentMapper shipmentMapper;
    @Resource
    private ShipmentPriceService shipmentPriceService;

    public Shipment createAndAddShipment(OrderRequest request){
        Shipment shipment = shipmentMapper.orderRequestToShipment(request);
        ShipmentPrice shipmentPrice = shipmentPriceService.getShipmentPriceCategoryById(request.getShipmentPriceId());
        shipment.setShipmentPrice(shipmentPrice);
        return shipmentRepository.save(shipment);

    }

}
