package com.example.transaBuddy.transabuddy;

import com.example.transaBuddy.temp.Order;
import com.example.transaBuddy.transabuddy.order.OrderInfo;
import com.example.transaBuddy.transabuddy.order.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TransaBuddyService {

    @Resource
    private OrderService orderService;

}
