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
import com.example.transaBuddy.validation.ValidationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;


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

    public List<OrderInfo> findOrdersBySenderId(Integer senderId) {
        List<Order> orders = orderRepository.findOrdersBySenderId(senderId);
        return orderMapper.ordersToOrderInfos(orders);
    }

    public List<OrderInfo> findOrdersByCourierId(Integer courierId) {
        List<Order> orders = orderRepository.findOrdersByCourierId(courierId);
        return orderMapper.ordersToOrderInfos(orders);
    }

    public List<OrderInfo> findAllOrdersByDates(LocalDate startDate, LocalDate endDate) {
//        if (endDate.equals(null)) {
//            return  orderMapper.ordersToOrderInfos(orderRepository.findAllOrdersFromStartDate(startDate));
//        } else if (startDate.equals(null)){
//            return  orderMapper.ordersToOrderInfos(orderRepository.findAllOrdersToEndDate(endDate));
//        } else {
        return orderMapper.ordersToOrderInfos(orderRepository.findOrdersByDates(startDate, endDate));
//        }
    }

    public void acceptOrder(Integer orderId, Integer courierId) {
        Order order = orderRepository.findById(orderId).get();
        order.setCourierUser(userRepository.getUserByUserId(courierId));
        order.setStatus("A"); //ACCEPTED
        orderRepository.save(order);
    }

    public void rejectOrder (Integer orderId) {
        Order order = orderRepository.findById(orderId).get();
        order.setCourierUser(null);
        order.setStatus("N"); // NEW
        orderRepository.save(order);
    }

    public void confirmOrderPickUp(Integer orderId) {
        Order order = orderRepository.findById(orderId).get();
        order.setStatus("P"); // PICKED UP
        orderRepository.save(order);
    }

    public void confirmOrderDelivery(Integer orderId) {
        Order order = orderRepository.findById(orderId).get();
        order.setStatus("C"); // COMPLETED
        orderRepository.save(order);
    }

    public void deleteOrder(Integer orderId) {
        Order order = orderRepository.findById(orderId).get();
        order.setCourierUser(null);
        order.setStatus("D"); // DELETED
        orderRepository.save(order);
        }

    }

