package com.example.SocialBookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    private boolean flag = false;
    @RequestMapping("/user/dashboard")
    public String getUserHome(){
		
        return "user/dashboard";
    }
    @RequestMapping("/profile")
    public  String Createprofile(){
        flag=true;
        return "user/profile";
    }
    @RequestMapping("/submit_profile")
    public  String Subprofile(){
        if (!flag){
            return "user/submit_profile_null";
        }
        return "user/submit_profile";
    }
}
