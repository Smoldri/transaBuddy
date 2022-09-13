package com.example.transaBuddy.transabuddy.shipment;

import com.example.transaBuddy.temp.Shipment;
import com.example.transaBuddy.transabuddy.order.OrderRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ShipmentService {

    @Resource
    private ShipmentRepository shipmentRepository;

    @Resource
    private ShipmentMapper shipmentMapper;

    public Shipment addShipment (OrderRequest request){
        Shipment shipment = shipmentMapper.orderRequestToShipment(request);
        shipmentRepository.save(shipment);
        return shipment;
    }
}
