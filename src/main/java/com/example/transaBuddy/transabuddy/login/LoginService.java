package com.example.transaBuddy.transabuddy.login;

import com.example.transaBuddy.domain.contact.ContactService;
import com.example.transaBuddy.domain.user.role.RoleService;
import com.example.transaBuddy.domain.user.UserMapper;
import com.example.transaBuddy.domain.user.userrole.UserRoleMapper;
import com.example.transaBuddy.domain.user.userrole.UserRoleRepository;
import com.example.transaBuddy.domain.user.role.Role;
import com.example.transaBuddy.domain.user.User;
import com.example.transaBuddy.transabuddy.user.UserResponse;
import com.example.transaBuddy.domain.user.UserService;
import com.example.transaBuddy.domain.user.userrole.UserRoleService;
import com.example.transaBuddy.domain.contact.Contact;
import com.example.transaBuddy.domain.user.userrole.UserRole;
import com.example.transaBuddy.transabuddy.contact.ContactInfo;
import com.example.transaBuddy.transabuddy.user.UserRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class LoginService {

    @Resource
    private ContactService contactService;
    @Resource
    private UserRoleService userRoleService;
    @Resource
    private UserMapper userMapper;
    @Resource
    private UserService userService;
    @Resource
    private RoleService roleService;
    @Resource
    private UserRoleMapper userRoleMapper;

    @Resource
    private UserRoleRepository userRoleRepository;

    @Transactional
    public UserResponse registerNewUser(UserRequest request) {
        Contact contact = contactService.createAndAddContact(request);
        User user = userService.createAndAddUser(request, contact);
        Role role = roleService.getRoleByRoleId(request.getRoleId());
        userRoleService.addRoleToUser(user, role);
//        todo Lisa userResponsele juurde roleId requestist

        return userMapper.userToUserResponse(user);
    }

    public ContactInfo logIn(LoginRequest request) {
        List<UserRole> userRoles = userRoleService.getValidUserRoles(request);
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
