package com.example.transaBuddy.transabuddy.login;

import com.example.transaBuddy.domain.user.UserService;
import com.example.transaBuddy.transabuddy.user.UserResponse;
import com.example.transaBuddy.transabuddy.contact.ContactInfo;
import com.example.transaBuddy.transabuddy.user.UserRequest;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class LoginController {
    @Resource
    private LoginService loginService;
    @Resource
    private UserService userService;


    @PostMapping("/login")
    @Operation(summary = "Sisse logimine")
    public ContactInfo logIn(@RequestBody LoginRequest request) {
        return loginService.logIn(request);
    }


    @PostMapping("register/user")
    @Operation(summary = "Registreeri kasutaja")
    public UserResponse registerNewUser(@RequestBody UserRequest request) {
        return loginService.registerNewUser(request);
    }

    @GetMapping("/user/status/check")
    @Operation(summary = "Kontrolli konto staatust")
    public Boolean checkUserIsActive(Integer userId) {
        return userService.checkUserIsActive(userId);
    }







}
