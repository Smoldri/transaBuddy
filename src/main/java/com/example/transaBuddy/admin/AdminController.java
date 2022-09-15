package com.example.transaBuddy.admin;

import com.example.transaBuddy.domain.order.OrderService;
import com.example.transaBuddy.transabuddy.contact.ContactInfo;
import com.example.transaBuddy.transabuddy.shipment.ShipmentPriceInfo;
import com.example.transaBuddy.transabuddy.order.OrderInfo;
import com.example.transaBuddy.transabuddy.user.UserResponse;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Resource
    private AdminService adminService;
    @Resource
    private OrderService orderService;
    @PatchMapping("/user/status")
    @Operation(summary = "Kliendi või kulleri konto  isActive staatuse muutmine")
    public void updateUserIsActiveStatus (@RequestBody UserResponse userResponse){
        adminService.updateUserIsActiveStatus(userResponse);
    }

    @GetMapping("/users")
    @Operation (summary = "Kõikide kasutajate leidmine")
    public List<ContactInfo> getAllContacts (){
        return adminService.getAllContacts();

    }
    @GetMapping("/find")
    @Operation (summary = "Kasutajate leidmine erinevate parameetrite alusel")
    public List<ContactInfo> findContacts(String firstName, String lastName, String personalCode){
        return adminService.findContacts(firstName, lastName, personalCode);
    }

    @GetMapping ("/prices")
    @Operation(summary = "Get all shipment prices")
    public List<ShipmentPriceInfo> getAllPrices() {
        return adminService.getAllPrices();
    }

    @GetMapping("/orders")
    @Operation(summary = "Leiab kõik tellimused")
    public List<OrderInfo> getAllOrders() {
        return adminService.getAllOrders();
    }

    // EI tööta
    @GetMapping("/orders/date")
    @Operation(summary = "Leiab kõik tellimused kuupäeva järgi")
    public List<OrderInfo> findAllOrderByDate(LocalDate date){
        return orderService.findAllOrdersByDate(date);
    }

    @GetMapping ("/orders/district")
    @Operation (summary = "Leiab kõik tellimused piirkonna järgi")
    public List<OrderInfo> findAllOrdersByDistrict(Integer pickUpDistrictId, Integer dropOffDistrictId){
        return orderService.findAllOrdersByDistricts(pickUpDistrictId, dropOffDistrictId);
    }

}
