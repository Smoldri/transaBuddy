package com.example.transaBuddy.admin;

import com.example.transaBuddy.domain.order.OrderService;
import com.example.transaBuddy.domain.user.role.Role;
import com.example.transaBuddy.domain.user.userrole.UserRoleService;
import com.example.transaBuddy.transabuddy.contact.ContactInfo;
import com.example.transaBuddy.transabuddy.shipment.ShipmentPriceInfo;
import com.example.transaBuddy.transabuddy.order.OrderInfo;
import com.example.transaBuddy.transabuddy.shipment.ShipmentPriceRequest;
import com.example.transaBuddy.transabuddy.shipment.ShipmentPriceResponse;
import com.example.transaBuddy.transabuddy.user.UserResponse;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Resource
    private AdminService adminService;

    @Resource
    private UserRoleService userRoleService;

    @Resource
    private OrderService orderService;

    @PatchMapping("/user/status")
    @Operation(summary = "Kliendi või kulleri konto  isActive staatuse muutmine")
    public void updateUserIsActiveStatus(@RequestBody UserResponse userResponse) {
        adminService.updateUserIsActiveStatus(userResponse);
    }

    @GetMapping("/users")
    @Operation(summary = "Kõikide kasutajate leidmine")
    public List<ContactInfo> getAllContacts() {
        return adminService.getAllContacts();

    }

    @GetMapping("/find")
    @Operation(summary = "Kasutajate leidmine erinevate parameetrite alusel")
    public List<ContactInfo> findContacts(String firstName, String lastName, String personalCode) {
        return adminService.findContacts(firstName, lastName, personalCode);
    }

    @GetMapping("/prices")
    @Operation(summary = "Get all shipment prices")
    public List<ShipmentPriceInfo> getAllPrices() {
        return adminService.getAllPrices();
    }

    @GetMapping("/orders")
    @Operation(summary = "Leiab kõik tellimused")
    public List<OrderInfo> getAllOrders() {
        return adminService.getAllOrders();
    }

    @PostMapping("/prices")
    @Operation(summary = "Add new price category")
    public ShipmentPriceResponse addPriceCategory(@RequestBody ShipmentPriceRequest request) {
        return adminService.addPriceCategory(request);
    }

    @PatchMapping("/prices")
    @Operation(summary = "Update existing prices by PriceID")
    public void updatePrice(@RequestBody ShipmentPriceInfo shipmentPriceInfo) {
        adminService.updatePrice(shipmentPriceInfo);
    }

    @PostMapping ("/user/role")
    @Operation (summary = "Add new role to user")
    public void addNewRoleToUser (UserResponse userResponse, Role role){
        userRoleService.addRoleNewRoleToUser(userResponse, role);
    }

    @GetMapping ("/orders/district")
    @Operation (summary = "Find orders by district ids")
    public List<OrderInfo> findAllOrdersByPickUpOrDropOffDistrict(Integer pickUpDistrictId, Integer dropOffDistrictId){
        return orderService.findAllOrdersByPickUpAndOrDropOffDistrict(pickUpDistrictId, dropOffDistrictId);
    }
//    @GetMapping ("/orders/districtandtype")
//    @Operation (summary = "Find orders by district id on type")
//    public List<OrderInfo> findAllOrdersByDistrictAndPickUpDropOffType(Integer districtId, String type){
//        return orderService.findAllOrdersByDistrictAndPickUpDropOffType(districtId, type);
//    }

}
