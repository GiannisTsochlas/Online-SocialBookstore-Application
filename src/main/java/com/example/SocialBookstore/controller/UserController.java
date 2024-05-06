package com.example.SocialBookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @RequestMapping("/user/dashboard")
    public String getUserHome(){
		
        return "user/dashboard";
    }
}
