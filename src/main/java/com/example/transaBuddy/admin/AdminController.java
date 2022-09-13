package com.example.transaBuddy.admin;

import com.example.transaBuddy.transabuddy.contact.ContactInfo;
import com.example.transaBuddy.transabuddy.user.UserResponse;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/users")
    @Operation (summary = "Kõikide kasutajate leidmine")
    public List<ContactInfo> getAllContacts (){
        return adminService.getAllContacts();

    }
    @GetMapping("/find")
    @Operation (summary = "Kasutajate leidmine erinevate parameetrite alusel")
    public List<ContactInfo> findContacts(String firstName, String lastName, String personalCode){
        return adminService.findContacts(firstName, lastName, personalCode);
    }

}
