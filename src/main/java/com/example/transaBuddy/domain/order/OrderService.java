package com.example.transaBuddy.domain.order;

import com.example.transaBuddy.domain.order.pickupdropoff.PickUpDropOffService;
import com.example.transaBuddy.domain.shipment.Shipment;
import com.example.transaBuddy.domain.shipment.ShipmentService;
import com.example.transaBuddy.domain.user.User;
import com.example.transaBuddy.domain.user.UserService;
import com.example.transaBuddy.transabuddy.order.OrderInfo;
import com.example.transaBuddy.transabuddy.order.OrderRequest;
import com.example.transaBuddy.transabuddy.order.OrderResponse;
import com.example.transaBuddy.validation.ValidationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;


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

    public List<OrderInfo> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return orderMapper.ordersToOrderInfos(orders);
    }

    public List<OrderInfo> findOrdersByUserId(Integer userId) {
        List<Order> orders = orderRepository.findOrdersByUserId(userId, userId);
        ValidationService.validateOrdersExist(orders);
        return orderMapper.ordersToOrderInfos(orders);
    }

    public List<OrderInfo> findUserOrdersByStatus(Integer userId, String status) {
        List<OrderInfo> orderInfos = findOrdersByUserId(userId);
        List<OrderInfo> statusOrderInfos = orderInfos.stream().
                filter(orderInfo -> orderInfo.getStatus().contains(status)).collect(Collectors.toList());
        ValidationService.validateStatusOrdersExist(statusOrderInfos, status);
        return statusOrderInfos;
    }
}
