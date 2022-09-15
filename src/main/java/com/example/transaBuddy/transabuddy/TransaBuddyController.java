package com.example.transaBuddy.transabuddy;


import com.example.transaBuddy.domain.order.OrderService;
import com.example.transaBuddy.transabuddy.order.OrderInfo;
import com.example.transaBuddy.transabuddy.order.OrderRequest;
import com.example.transaBuddy.transabuddy.order.OrderResponse;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class TransaBuddyController {

    @Resource
    private TransaBuddyService transaBuddyService;


    @GetMapping("/order/sender")
    @Operation(summary = "Find all orders by sender ID")
    public List<OrderInfo> findOrdersBySenderId(Integer senderId) {
        return transaBuddyService.findOrdersBySenderId(senderId);
    }


    @GetMapping("/order/courier")
    @Operation(summary = "Find all orders by courier ID")
    public List<OrderInfo> findOrdersByCourierId(Integer courierId) {

        return transaBuddyService.findOrdersByCourierId(courierId);
    }

    @Resource
    private OrderService orderService;

    @PostMapping("/order")
    @Operation(summary = "Lisab uue tellimuse")
    public OrderResponse addNewOrder (@RequestBody OrderRequest request){
        return orderService.addNewOrder(request);
    }
    @PatchMapping("/order/status")
    @Operation (summary = "Change order status")
    public void updateOrderStatus (@RequestBody OrderResponse orderResponse, String status){
        orderService.updateOrderStatus(orderResponse, status);
    }


}
