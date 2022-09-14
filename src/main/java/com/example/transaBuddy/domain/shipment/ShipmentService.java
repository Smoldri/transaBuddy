package com.example.transaBuddy.domain.shipment;

import com.example.transaBuddy.domain.shipment.shipmentPrice.ShipmentPrice;
import com.example.transaBuddy.domain.shipment.shipmentPrice.ShipmentPriceService;
import com.example.transaBuddy.transabuddy.order.OrderInfo;
import com.example.transaBuddy.transabuddy.order.OrderRequest;
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

    public void updateOrderInfosWithShipmentIds(List<OrderInfo> orderInfos) {
        for (OrderInfo orderInfo : orderInfos){
            Shipment shipment = shipmentRepository.getShipmentById(orderInfo.getShipmentId());
            orderInfo.setShipmentId((shipment.getId()));
        }
    }

}
