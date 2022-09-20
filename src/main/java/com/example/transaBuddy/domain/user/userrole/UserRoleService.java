package com.example.transaBuddy.domain.user.userrole;

import com.example.transaBuddy.domain.user.UserMapper;
import com.example.transaBuddy.domain.user.UserRepository;
import com.example.transaBuddy.domain.user.role.RoleRepository;
import com.example.transaBuddy.domain.user.role.Role;
import com.example.transaBuddy.domain.user.User;
import com.example.transaBuddy.transabuddy.contact.ContactInfo;
import com.example.transaBuddy.transabuddy.login.LoginRequest;
import com.example.transaBuddy.transabuddy.user.UserResponse;
import com.example.transaBuddy.validation.ValidationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserRoleService {

    @Resource
    private UserRoleRepository userRoleRepository;

    @Resource
    private UserRepository userRepository;

    @Resource
    private RoleRepository roleRepository;

    @Resource
    private UserRoleMapper userRoleMapper;

    @Resource
    private UserMapper userMapper;

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

    public void addRoleToUser(User user, Role role) {
        UserRole userRole = new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);
        userRoleRepository.save(userRole);
    }

    public void addRoleNewRoleToUser(UserResponse userResponse, Role role) {
        User user = userMapper.userResponseToUser(userResponse);
        addRoleToUser(user, role);
    }

    public List<UserRole> getUserRolesByUserId(Integer userId) {
        return userRoleRepository.findUserRolesByUserId(userId);
    }
}

