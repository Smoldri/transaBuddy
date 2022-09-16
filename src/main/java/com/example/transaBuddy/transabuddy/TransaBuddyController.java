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
@RequestMapping("/transabuddy")
public class TransaBuddyController {

    @Resource
    private TransaBuddyService transaBuddyService;

    @Resource
    private OrderService orderService;


    @GetMapping("/orders/user")
    @Operation(summary = "Find all orders by user ID")
    public List<OrderInfo> findOrdersByUserId(Integer userId) {
        return transaBuddyService.findOrdersByUserId(userId);
    }


    @PostMapping("/order")
    @Operation(summary = "Lisab uue tellimuse")
    public OrderResponse addNewOrder(@RequestBody OrderRequest request) {
        return orderService.addNewOrder(request);
    }

    @PatchMapping("/order/status")
    @Operation(summary = "Change order status")
    public void updateOrderStatus(@RequestBody OrderResponse orderResponse, String status) {
        orderService.updateOrderStatus(orderResponse, status);
    }

    @PatchMapping("/order/courier")
    @Operation (summary = "Accept order and set courierID")
    public void acceptOrderAndSetCourierId(@RequestBody OrderResponse response, Integer courierId) {
        orderService.acceptOrderAndSetCourierId(response, courierId);
    }
}
