package com.example.transaBuddy.transabuddy;

import com.example.transaBuddy.domain.contact.ContactService;
import com.example.transaBuddy.domain.order.OrderService;
import com.example.transaBuddy.domain.user.UserService;
import com.example.transaBuddy.transabuddy.contact.ContactInfo;
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
    @Resource
    private UserService userService;
    @Resource
    private ContactService contactService;

    @GetMapping("/orders/date")
    @Operation(summary = "FInd all orders by dates")
    public List<OrderInfo> findAllOrderByDates(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate, @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate ){
        return orderService.findAllOrdersByDates(startDate, endDate);
    }


    @GetMapping("/user/orders")
    @Operation(summary = "Find all orders by user ID")
    public List<OrderInfo> findOrdersByUserId(Integer userId) {
        return transaBuddyService.findOrdersByUserId(userId);
    }

    @GetMapping("/user/active-orders")
    @Operation(summary = "Find all active orders by user ID")
    public List<OrderInfo> findUserOrdersByStatus(@RequestParam Integer userId, @RequestParam String status) {
        return transaBuddyService.findUserOrdersByStatus(userId, status);
    }


    @PostMapping("/order")
    @Operation(summary = "Lisab uue tellimuse")
    public OrderResponse addNewOrder(@RequestBody OrderRequest request) {
        return orderService.addNewOrder(request);
    }
    @PatchMapping("/user/password")
    @Operation(summary = "Change password")
    public void updateUserPassword(String newPassword, Integer userId) {
        userService.updateUserPassword(newPassword, userId);
    }
    @PatchMapping("/user/contacts")
    @Operation(summary = "Change contact info")
    public void updateContactInfo(ContactInfo contactInfo) {
        contactService.updateContactInfo(contactInfo);

    }

    @PatchMapping("/order/status")
    @Operation(summary = "Change order status")
    public void updateOrderStatus(@RequestBody OrderResponse orderResponse, String status) {
        orderService.updateOrderStatus(orderResponse, status);
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
