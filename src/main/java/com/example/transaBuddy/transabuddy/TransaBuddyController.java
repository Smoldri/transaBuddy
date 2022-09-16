package com.example.transaBuddy.transabuddy;


import com.example.transaBuddy.domain.order.OrderService;
import com.example.transaBuddy.transabuddy.order.OrderInfo;
import com.example.transaBuddy.transabuddy.order.OrderRequest;
import com.example.transaBuddy.transabuddy.order.OrderResponse;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/transabuddy")
public class TransaBuddyController {

    @Resource
    private TransaBuddyService transaBuddyService;
    @Resource
    private OrderService orderService;

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

    @GetMapping("/orders/date")
    @Operation(summary = "FInd all orders by dates")
    public List<OrderInfo> findAllOrderByDates(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate, @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate ){
        return orderService.findAllOrdersByDates(startDate, endDate);
    }

    @PostMapping("/order")
    @Operation(summary = "Lisab uue tellimuse")
    public OrderResponse addNewOrder (@RequestBody OrderRequest request){
        return orderService.addNewOrder(request);
    }
    @PatchMapping("/order/delete")
    @Operation (summary = "Delete order")
    public void deleteOrder(Integer orderId){
        orderService.deleteOrder(orderId);
    }

    @PatchMapping("/order/accepted")
    @Operation (summary = "Order delivery accepted by courier")
    public void acceptOrder(Integer orderId, Integer courierId){
        orderService.acceptOrder(orderId, courierId);
    }
    @PatchMapping("/order/rejected")
    @Operation (summary = "Accepted order rejection by courier")
    public void rejectOrder(Integer orderId){
        orderService.rejectOrder(orderId);
    }
    @PatchMapping("/order/pickedup")
    @Operation (summary = "Order picked up by courier")
    public void confirmOrderPickUp (Integer orderId){
        orderService.confirmOrderPickUp(orderId);
    }
    @PatchMapping("/order/delivery")
    @Operation (summary = "Order delivered by courier")
    public void confirmOrderDelivery (Integer orderId){
        orderService.confirmOrderDelivery(orderId);
    }
}
