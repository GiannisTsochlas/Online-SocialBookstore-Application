package com.example.SocialBookstore.controller;

import com.example.SocialBookstore.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.SocialBookstore.model.Profile;
import com.example.SocialBookstore.service.ProfileService;
@Controller
public class UserController {
    @Autowired
    ProfileService profileService;

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
    @RequestMapping("/save_profile")
    public String registerUser(@ModelAttribute("profile") Profile profile, Model model){

        profileService.saveUserProfile(profile);
        return "user/submit_profile";
    }
}
