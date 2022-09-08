package com.example.transaBuddy.application.login;

import com.example.transaBuddy.application.user.UserRequest;
import com.example.transaBuddy.application.user.UserResponse;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class LoginController {
    @Resource
    private LoginService loginService;


    @PostMapping("register/user")
    @Operation(summary = "Registreeri kasutaja")
    public UserResponse registerNewUser(@RequestBody UserRequest request) {
        return loginService.registerNewUser(request);
    }







}
