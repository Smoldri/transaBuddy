package com.example.transaBuddy.domain.user.userrole;

import com.example.transaBuddy.transabuddy.login.LoginRequest;
import com.example.transaBuddy.validation.ValidationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
}
