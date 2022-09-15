package com.example.transaBuddy.transabuddy;

import com.example.transaBuddy.domain.order.OrderService;
import com.example.transaBuddy.transabuddy.order.OrderInfo;
import com.example.transaBuddy.transabuddy.user.UserResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TransaBuddyService {

    @Resource
    private OrderService orderService;

    public List<OrderInfo> findOrdersBySenderId(Integer senderId) {
        return orderService.findOrdersBySenderId(senderId);
    }

    public List<OrderInfo> findOrdersByCourierId(Integer courierId) {
        return orderService.findOrdersByCourierId(courierId);
    }

}
