package com.example.transaBuddy.validation;

import com.example.transaBuddy.domain.order.Order;
import com.example.transaBuddy.domain.user.User;
import com.example.transaBuddy.domain.user.userrole.UserRole;
import com.example.transaBuddy.infrastructure.exception.DataNotFoundException;
import com.example.transaBuddy.transabuddy.order.OrderInfo;

import java.util.List;
import java.util.Optional;

public class ValidationService {

    public static final String ACCOUNT_NOT_EXISTS = "Sellist kontot ei eksisteeri";
    public static final String USER_NOT_EXISTS = "Sellist kasutajat ei eksisteeri";
    public static final String CATEGORY_EXISTS = "Price type already exists";
    public static final String ORDERS_NOT_EXISTS = "Orders don't exist";
    public static final String ORDERS_WITH_STATUS_NOT_EXISTS = "Orders with status don't exist";

    public static void validatePasswordUserExists(List<UserRole> userRoles) {
        if (userRoles.isEmpty()) {
            throw new DataNotFoundException(ACCOUNT_NOT_EXISTS, "Sellise kasutajanime ja parooliga kontot ei eksisteeri ");
        }
    }
    public static void validateUserExists(Optional<User> user,Integer userId){
        if (user.isEmpty()){
            throw new DataNotFoundException(USER_NOT_EXISTS, "Sellist kasutajat ID'ga " + userId + " ei leitud");
        }
    }

    public static void validatePriceTypeExists() {
            throw new DataNotFoundException(CATEGORY_EXISTS, "Price with the same type already exists");
    }

    public static void validateOrdersExist(List<Order> orders) {
        if (orders.isEmpty()) {
            throw new DataNotFoundException(ORDERS_NOT_EXISTS, "User does not have orders");
        }
    }

    public static void validateStatusOrdersExist(List<OrderInfo> statusOrderInfos, String status) {
        if (statusOrderInfos.isEmpty()) {
            throw new DataNotFoundException(ORDERS_WITH_STATUS_NOT_EXISTS,
            "User does not have orders with status " + status);
        }
    }
}
