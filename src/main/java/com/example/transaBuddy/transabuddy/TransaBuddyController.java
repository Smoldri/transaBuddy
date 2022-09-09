package com.example.transaBuddy.transabuddy;

import com.example.transaBuddy.transabuddy.order.OrderInfo;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController

public class TransaBuddyController {
    @Resource
    private TransaBuddyService transaBuddyService;


    @GetMapping("/order")
    @Operation(summary = "Leiab kõik tellimused")
    public List<OrderInfo> findOrders(Integer customerId) {
        return null;
    }


}
