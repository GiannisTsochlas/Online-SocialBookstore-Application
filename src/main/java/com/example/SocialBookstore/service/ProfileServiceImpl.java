package com.example.SocialBookstore.service;

import com.example.SocialBookstore.dao.ProfileDAO;
import com.example.SocialBookstore.dao.UserDAO;
import com.example.SocialBookstore.model.Profile;
import org.hibernate.annotations.SecondaryRow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileServiceImpl implements ProfileService{
    @Autowired
    private ProfileDAO ProfileDAO;
    @Override
    public void saveUserProfile(Profile profile) {
        ProfileDAO.save(profile);
    }
}
