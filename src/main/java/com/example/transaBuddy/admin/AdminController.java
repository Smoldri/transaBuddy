package com.example.transaBuddy.admin;

import com.example.transaBuddy.temp.User;
import com.example.transaBuddy.transabuddy.user.UserResponse;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Resource
    private AdminService adminService;
    @PatchMapping("/user/status")
    @Operation (summary = "Kliendi või kulleri konto  isActive staatuse muutmine")
    public void updateUserIsActiveStatus (@RequestBody UserResponse userResponse){
        adminService.updateUserIsActiveStatus(userResponse);
    }

    @PatchMapping("/users")
    @Operation (summary = "Kõikide kontode leidmine")
    public List<User> findUserByUserName (String userName){
        return null;
    }

}
