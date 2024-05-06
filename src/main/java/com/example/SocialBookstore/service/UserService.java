package com.example.SocialBookstore.service;

import org.springframework.stereotype.Service;

import com.example.SocialBookstore.model.User;

@Service
public interface UserService {
	public void saveUser(User user);
    public boolean isUserPresent(User user);
}
