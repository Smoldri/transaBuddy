package com.example.transaBuddy.transabuddy.order;

import com.example.transaBuddy.domain.order.OrderMapper;
import com.example.transaBuddy.domain.order.OrderRepository;
import com.example.transaBuddy.domain.user.UserService;
import com.example.transaBuddy.temp.Order;
import com.example.transaBuddy.temp.Shipment;
import com.example.transaBuddy.temp.User;
import com.example.transaBuddy.transabuddy.order.pickup_dropoff.PickUpDropOffService;
import com.example.transaBuddy.transabuddy.shipment.ShipmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class OrderService {

    @Resource
    private OrderRepository orderRepository;

    @Resource
    private ShipmentService shipmentService;
    @Resource
    private OrderMapper orderMapper;
    @Resource
    private UserService userService;
    @Resource
    private PickUpDropOffService pickUpDropOffService;


    public OrderResponse addNewOrder(OrderRequest request) {
        Shipment shipment = shipmentService.createAndAddShipment(request);
        Order order = orderMapper.orderRequestToOrder(request);
        User user = userService.getUserByUserId(request.getSenderUserId());
        order.setShipment(shipment);
        order.setSenderUser(user);
        orderRepository.save(order);
        pickUpDropOffService.createAndAddPickUp(request, order);
        pickUpDropOffService.createAndAddDropOff(request, order);

        return orderMapper.orderToOrderResponse(order);
    }
}
