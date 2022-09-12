package com.example.transaBuddy.domain.user;

import com.example.transaBuddy.domain.user.userrole.UserRoleService;
import com.example.transaBuddy.temp.Contact;
import com.example.transaBuddy.temp.User;
import com.example.transaBuddy.transabuddy.contact.ContactInfo;
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

    public UserResponse mapRequestAndAddUser(UserRequest request, Contact contact) {
        User user = userMapper.userRequestToUser(request);
        user.setContact(contact);
        userRepository.save(user);
        return userMapper.userToUserResponse(user);
    }


    public User getValidUser(Integer userId) {
        Optional<User> user = userRepository.findById(userId);
        ValidationService.validateUserExists(user, userId);
        return user.get();
    }



    public void updateContactsInfosWithUserIds(List<ContactInfo> contactInfos) {
        for(ContactInfo contactInfo : contactInfos){
            User user = userRepository.getUserBy(contactInfo.getContactId());
            contactInfo.setUserId(user.getId());

        }
    }

    public void updateContactsInfosWithRoleNames(List<ContactInfo> contactInfos) {
        for (ContactInfo contactInfo : contactInfos) {
        contactInfo.setRoleNames(userRoleService.findUserRolesByUserId(contactInfo));        }
    }
}
