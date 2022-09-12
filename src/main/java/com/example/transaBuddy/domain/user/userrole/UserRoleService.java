package com.example.transaBuddy.domain.user.userrole;

import com.example.transaBuddy.transabuddy.contact.ContactInfo;
import com.example.transaBuddy.transabuddy.login.LoginRequest;
import com.example.transaBuddy.validation.ValidationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserRoleService {

    @Resource
    private UserRoleRepository userRoleRepository;



    public List<UserRole> getValidUserRoles(LoginRequest request) {
        List<UserRole> userRoles = userRoleRepository.findUserRoleBy(request.getUsername(), request.getPassword());
        ValidationService.validatePasswordUserExists(userRoles);
        return userRoles;
    }

    public List<String> findUserRolesByUserId(ContactInfo contactInfo) {

        List<UserRole> userRoles = userRoleRepository.findUserRolesByUserId(contactInfo.getUserId());
        List<String> roleNames = new ArrayList<>();
        for (UserRole userRole : userRoles) {
            roleNames.add(userRole.getRole().getName());
        }

        return roleNames;

    }
}
