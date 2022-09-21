package com.example.transaBuddy.admin;

import com.example.transaBuddy.domain.contact.Contact;
import com.example.transaBuddy.domain.contact.ContactService;
import com.example.transaBuddy.domain.order.Order;
import com.example.transaBuddy.domain.order.OrderService;
import com.example.transaBuddy.domain.shipment.Shipment;
import com.example.transaBuddy.domain.shipment.shipmentprice.ShipmentPrice;
import com.example.transaBuddy.domain.shipment.shipmentprice.ShipmentPriceMapper;
import com.example.transaBuddy.domain.shipment.shipmentprice.ShipmentPriceService;
import com.example.transaBuddy.domain.user.User;
import com.example.transaBuddy.domain.user.UserMapper;
import com.example.transaBuddy.domain.user.UserRepository;
import com.example.transaBuddy.domain.user.UserService;
import com.example.transaBuddy.domain.user.userrole.UserRole;
import com.example.transaBuddy.domain.user.userrole.UserRoleService;
import com.example.transaBuddy.transabuddy.contact.ContactInfo;
import com.example.transaBuddy.transabuddy.login.LoginService;
import com.example.transaBuddy.transabuddy.order.OrderInfo;
import com.example.transaBuddy.transabuddy.shipment.ShipmentPriceInfo;
import com.example.transaBuddy.transabuddy.shipment.ShipmentPriceRequest;
import com.example.transaBuddy.transabuddy.shipment.ShipmentPriceResponse;
import com.example.transaBuddy.transabuddy.user.UserResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Service
public class AdminService {
    @Resource
    private UserService userService;

    @Resource
    private UserRepository userRepository;

    @Resource
    private ContactService contactService;

    @Resource
    private OrderService orderService;

    @Resource
    private ShipmentPriceMapper shipmentPriceMapper;
    @Resource
    private UserRoleService userRoleService;
    @Resource
    private UserMapper userMapper;


    @Resource
    private ShipmentPriceService shipmentPriceService;

    public void updateUserIsActiveStatus(UserResponse userResponse) {
        User user = userService.getValidUser(userResponse.getUserId());
        user.setIsActive(!user.getIsActive());
        userRepository.save(user);
    }

    public List<ContactInfo> getAllContacts() {
        List<Contact> contacts = contactService.getAllContacts();
        return contactService.mapContactsToContactInfosAndUpdateUserIds(contacts);
    }

    public List<ContactInfo> findContacts(String firstName, String lastName, String personalCode) {
        List<Contact> contacts = contactService.findContacts(firstName, lastName, personalCode);
        return contactService.mapContactsToContactInfosAndUpdateUserIds(contacts);
    }

    public List<OrderInfo> getAllOrders() {
        return orderService.getAllOrders();
    }

    public List<ShipmentPriceInfo> getAllPrices() {
        List<ShipmentPrice> shipmentPrices = shipmentPriceService.getAllPrices();
        return shipmentPriceMapper.shipmentPricesToShipmentPriceInfos(shipmentPrices);

    }


    public ShipmentPriceResponse addPriceCategory(ShipmentPriceRequest request) {
        return shipmentPriceService.addPriceCategory(request);
    }

    public void updatePrice(ShipmentPriceInfo shipmentPriceInfo) {
        shipmentPriceService.updatePrice(shipmentPriceInfo);

    }

    public ContactInfo getUserInfoByUserId(Integer userId) {
        List<UserRole> userRoles = userRoleService.getUserRolesByUserId(userId);
        ContactInfo contactInfo = userMapper.userToContactInfo(userRoles.get(0).getUser());
        contactInfo.setRoleNames(getRolesNames(userRoles));
        return contactInfo;

    }

    private List<String> getRolesNames(List<UserRole> userRoles) {
        List<String> roleNames = new ArrayList<>();
        for (UserRole userRole : userRoles) {
            roleNames.add(userRole.getRole().getName());
        }
        return roleNames;
    }
}

