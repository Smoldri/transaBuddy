package com.example.transaBuddy.domain.order;

import com.example.transaBuddy.temp.Order;
import com.example.transaBuddy.transabuddy.order.OrderInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderService {
    @Resource
    private OrderRepository orderRepository;

    @Resource
    private OrderMapper orderMapper;
    public List<OrderInfo> findOrdersBySenderId(Integer senderId) {
        List<Order> orders = orderRepository.findOrdersBySenderId(senderId);
        return orderMapper.ordersToOrderInfos(orders);
    }

    public List<OrderInfo> findOrdersByCourierId(Integer courierId) {
        List<Order> orders = orderRepository.findOrdersByCourierId(courierId);
        return orderMapper.ordersToOrderInfos(orders);
    }
}
