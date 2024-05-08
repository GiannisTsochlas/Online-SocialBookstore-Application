package com.example.SocialBookstore.service;

import com.example.SocialBookstore.model.Profile;
import org.springframework.stereotype.Service;

@Service
public interface ProfileService {
    public void saveUserProfile(Profile profile);
}
