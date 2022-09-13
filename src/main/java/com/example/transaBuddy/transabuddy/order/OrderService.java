package com.example.transaBuddy.transabuddy.order;

import com.example.transaBuddy.domain.order.OrderMapper;
import com.example.transaBuddy.domain.order.OrderRepository;
import com.example.transaBuddy.domain.user.UserRepository;
import com.example.transaBuddy.domain.user.UserService;
import com.example.transaBuddy.temp.Order;
import com.example.transaBuddy.temp.Shipment;
import com.example.transaBuddy.temp.User;
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
    private UserRepository userRepository;

    @Resource
    private UserService userService;


    public OrderResponse addNewOrder(OrderRequest request) {
        Order order = orderMapper.orderRequestToOrder(request);
        User user = userService.getUserByUserId(request.getSenderUserId());

        order.setSenderUser(user);
        shipmentService.addShipment(request);
        return null;
    }
}
