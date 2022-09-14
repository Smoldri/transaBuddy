package com.example.transaBuddy.admin;

import com.example.transaBuddy.domain.contact.ContactService;
import com.example.transaBuddy.domain.user.UserRepository;
import com.example.transaBuddy.domain.user.UserService;
import com.example.transaBuddy.domain.user.userrole.UserRole;
import com.example.transaBuddy.domain.user.userrole.UserRoleService;
import com.example.transaBuddy.temp.Contact;
import com.example.transaBuddy.temp.User;
import com.example.transaBuddy.transabuddy.contact.ContactInfo;
import com.example.transaBuddy.transabuddy.user.UserResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
    private UserRoleService userRoleService;

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

}

