package com.example.transaBuddy.transabuddy;


import com.example.transaBuddy.domain.contact.ContactRepository;
import com.example.transaBuddy.domain.contact.ContactService;
import com.example.transaBuddy.domain.order.OrderService;
import com.example.transaBuddy.domain.user.UserService;
import com.example.transaBuddy.transabuddy.contact.ContactInfo;
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
    private UserService userService;
    @Resource
    private ContactService contactService;


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



}
