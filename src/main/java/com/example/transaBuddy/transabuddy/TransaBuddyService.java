package com.example.transaBuddy.transabuddy;

import com.example.transaBuddy.domain.order.OrderService;
import com.example.transaBuddy.transabuddy.order.OrderInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TransaBuddyService {

    @Resource
    private OrderService orderService;

    public List<OrderInfo> findOrdersByUserId(Integer userId) {
        return orderService.findOrdersByUserId(userId);
    }

    public List<OrderInfo> findActiveOrdersByUserId(Integer userId) {
        return orderService.findActiveOrdersByUserId(userId);
    }

    public OrderInfo findOrderByOrderId(Integer orderId) {
        return orderService.findOrderByOrderId(orderId);
    }

    public List<OrderInfo> findAllActiveOrders() {
        return orderService.findAllActiveOrders();
    }
}
