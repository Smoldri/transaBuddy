package com.example.transaBuddy.transabuddy;

import com.example.transaBuddy.domain.contact.ContactService;
import com.example.transaBuddy.domain.order.OrderService;
import com.example.transaBuddy.domain.user.UserService;
import com.example.transaBuddy.transabuddy.contact.ContactInfo;
import com.example.transaBuddy.transabuddy.order.AvailableOrders;
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

    @Resource
    private UserService userService;
    @Resource
    private ContactService contactService;

    @GetMapping("/orders/date")
    @Operation(summary = "FInd all orders by dates")
    public List<OrderInfo> findAllOrderByDates(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate, @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return orderService.findAllOrdersByDates(startDate, endDate);
    }

    @GetMapping("/user/orders")
    @Operation(summary = "Find all orders by user ID")
    public List<OrderInfo> findOrdersByUserId(Integer userId) {
        return transaBuddyService.findOrdersByUserId(userId);
    }

    @GetMapping("/user/active-orders")
    @Operation(summary = "Find all active orders by user ID")
    public List<OrderInfo> findUserOrdersByStatus(Integer userId, String status) {
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

    @PatchMapping("/order/delete")
    @Operation(summary = "Delete order")
    public void deleteOrder(Integer orderId) {
        orderService.deleteOrder(orderId);
    }

    @PatchMapping("/order/accepted")
    @Operation(summary = "Order delivery accepted by courier")
    public void acceptOrder(Integer orderId, Integer courierId) {
        orderService.acceptOrder(orderId, courierId);
    }

    @PatchMapping("/order/rejected")
    @Operation(summary = "Accepted order rejection by courier")
    public void rejectOrder(Integer orderId) {
        orderService.rejectOrder(orderId);
    }

    @PatchMapping("/order/pickedup")
    @Operation(summary = "Order picked up by courier")
    public void confirmOrderPickUp(Integer orderId) {
        orderService.confirmOrderPickUp(orderId);
    }

    @PatchMapping("/order/delivery")
    @Operation(summary = "Order delivered by courier")
    public void confirmOrderDelivery(Integer orderId) {
        orderService.confirmOrderDelivery(orderId);
    }

    @GetMapping("/orders/available")
    @Operation(summary = "find all available orders by district and status")
    public List<OrderInfo> findOrdersByDistrictStatus(Integer pickUpDistrictId, Integer dropOffDistrictId, String status) {
        return orderService.findOrdersByDistrictAndStatus(pickUpDistrictId, dropOffDistrictId, status);
    }

    @GetMapping("/order")
    @Operation(summary = "Find order by order ID")
    public OrderInfo findOrderByOrderId(Integer orderId) {
        return transaBuddyService.findOrderByOrderId(orderId);
    }
}
