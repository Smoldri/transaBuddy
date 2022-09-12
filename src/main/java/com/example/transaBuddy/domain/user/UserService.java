package com.example.transaBuddy.domain.user;

import com.example.transaBuddy.temp.Contact;
import com.example.transaBuddy.temp.User;
import com.example.transaBuddy.transabuddy.user.UserRequest;
import com.example.transaBuddy.transabuddy.user.UserResponse;
import com.example.transaBuddy.validation.ValidationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserRepository userRepository;

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
}
