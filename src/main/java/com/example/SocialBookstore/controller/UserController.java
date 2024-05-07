package com.example.SocialBookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @RequestMapping("/user/dashboard")
    public String getUserHome(){
		
        return "user/dashboard";
    }
    @RequestMapping("/profile")
    public  String Createprofile(){
        return "user/profile";
    }
    @RequestMapping("/submit_profile")
    public  String Subprofile(){
        return "user/submit_profile";
    }
}
