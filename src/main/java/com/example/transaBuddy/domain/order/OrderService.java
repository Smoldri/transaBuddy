package com.example.transaBuddy.domain.order;

import com.example.transaBuddy.domain.user.UserRepository;
import com.example.transaBuddy.domain.user.UserService;
import com.example.transaBuddy.domain.shipment.Shipment;
import com.example.transaBuddy.domain.user.User;
import com.example.transaBuddy.transabuddy.order.OrderInfo;
import com.example.transaBuddy.transabuddy.order.OrderRequest;
import com.example.transaBuddy.transabuddy.order.OrderResponse;
import com.example.transaBuddy.domain.order.pickupdropoff.PickUpDropOffService;
import com.example.transaBuddy.domain.shipment.ShipmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.List;


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
    @Resource
    private UserRepository userRepository;


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
        return orderMapper.ordersToOrderInfos(orders);
    }


    public List<OrderInfo> findAllOrdersByDate(LocalDate date) {
        List<Order> orders = orderRepository.findOrdersByDate(date);
        return orderMapper.ordersToOrderInfos(orders);
    }

    public void updateOrderStatus(OrderResponse orderResponse, String status) {
        Order order = orderRepository.getReferenceById(orderResponse.getOrderId());
        order.setStatus(status);
        orderRepository.save(order);
    }

    public void acceptOrderAndSetCourierId(OrderResponse response, Integer courierId) {
        Order order = orderRepository.getReferenceById(response.getOrderId());
        User user = userRepository.getUserByUserId(courierId);
        order.setStatus("A");
        order.setCourierUser(user);
        orderRepository.save(order);
    }
}
