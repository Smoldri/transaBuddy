package com.example.transaBuddy.domain.user;

import com.example.transaBuddy.domain.contact.ContactRepository;
import com.example.transaBuddy.domain.user.userrole.UserRoleService;
import com.example.transaBuddy.domain.contact.Contact;
import com.example.transaBuddy.transabuddy.contact.ContactInfo;
import com.example.transaBuddy.transabuddy.order.OrderInfo;
import com.example.transaBuddy.transabuddy.user.UserRequest;
import com.example.transaBuddy.transabuddy.user.UserResponse;
import com.example.transaBuddy.validation.ValidationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserRepository userRepository;

    @Resource
    private UserRoleService userRoleService;
    @Resource
    private ContactRepository contactRepository;


    public User createAndAddUser(UserRequest request, Contact contact) {
        User user = userMapper.userRequestToUser(request);
        user.setContact(contact);
        userRepository.save(user);
        return user;
    }


    public User getValidUser(Integer userId) {
        Optional<User> user = userRepository.findById(userId);
        ValidationService.validateUserExists(user, userId);
        return user.get();
    }


    public void updateContactsInfosWithUserIds(List<ContactInfo> contactInfos) {
        for (ContactInfo contactInfo : contactInfos) {
            User user = userRepository.getUserByContactId(contactInfo.getContactId());
            contactInfo.setUserId(user.getId());
        }
    }

    public void updateContactsInfosWithRoleNames(List<ContactInfo> contactInfos) {
        for (ContactInfo contactInfo : contactInfos) {
            contactInfo.setRoleNames(userRoleService.findUserRolesByUserId(contactInfo));
        }
    }

    public User getUserByUserId(Integer senderUsedId) {
        return userRepository.getUserByUserId(senderUsedId);
    }

    public void updateOrderInfosWithUserIds(List<OrderInfo> orderInfos) {
        for (OrderInfo orderInfo : orderInfos) {
            User senderUser = (userRepository.getUserByUserId(orderInfo.getSenderUserId()));
            orderInfo.setSenderUserId(senderUser.getId());
            User courierUser = (userRepository.getUserByUserId(orderInfo.getCourierUserId()));
            orderInfo.setCourierUserId(courierUser.getId());
        }

    }

    public Boolean checkUserIsActive(Integer userId) {
        System.out.println();
        User user = userRepository.getUserByUserId(userId);
        return user.getIsActive();
    }

    public void updateUserPassword(String newPassword, Integer userId) {
        User user = userRepository.getReferenceById(userId);
        user.setPassword(newPassword);
        userRepository.save(user);
    }


}
