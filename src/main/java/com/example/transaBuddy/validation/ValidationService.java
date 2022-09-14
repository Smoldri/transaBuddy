package com.example.transaBuddy.validation;

import com.example.transaBuddy.infrastructure.exception.DataNotFoundException;
import com.example.transaBuddy.domain.user.userrole.UserRole;
import com.example.transaBuddy.domain.user.User;

import java.util.List;
import java.util.Optional;

public class ValidationService {

    public static final String ACCOUNT_NOT_EXISTS = "Sellist kontot ei eksisteeri";
    public static final String USER_NOT_EXISTS = "Sellist kasutajat ei eksisteeri";

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
}
