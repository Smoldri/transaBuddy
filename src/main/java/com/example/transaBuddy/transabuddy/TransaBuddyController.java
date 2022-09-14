package com.example.transaBuddy.transabuddy;

import com.example.transaBuddy.transabuddy.order.OrderInfo;
import com.example.transaBuddy.transabuddy.order.OrderRequest;
import com.example.transaBuddy.transabuddy.order.OrderResponse;
import com.example.transaBuddy.transabuddy.order.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController

public class TransaBuddyController {

    @Resource
    private TransaBuddyService transaBuddyService;

    @Resource
    private OrderService orderService;

    @PostMapping("/order")
    @Operation(summary = "Lisab uue tellimuse")
    public OrderResponse addNewOrder (@RequestBody OrderRequest request){
        return orderService.addNewOrder(request);
    }

}
