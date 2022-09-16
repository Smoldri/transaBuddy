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

    public List<OrderInfo> findUserOrdersByStatus(Integer userId, String status) {
        return orderService.findUserOrdersByStatus(userId, status);
    }
}
