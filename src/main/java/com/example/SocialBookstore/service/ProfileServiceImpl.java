package com.example.SocialBookstore.service;

import com.example.SocialBookstore.dao.ProfileDAO;
import com.example.SocialBookstore.dao.UserDAO;
import com.example.SocialBookstore.model.Profile;
import org.hibernate.annotations.SecondaryRow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ProfileServiceImpl implements ProfileService {
    @Autowired
    private ProfileDAO ProfileDAO;
    @Autowired
    public ProfileServiceImpl(ProfileDAO theProfileRepository) {
        ProfileDAO = theProfileRepository;
    }

    @Override
    public void saveUserProfile(Profile profile) {

        ProfileDAO.save(profile);
    }

    @Override
    public void deleteById(int theId) {
        ProfileDAO.deleteById(theId);
    }

    @Override
    public Profile findById(int theId) {
        Profile result = ProfileDAO.findById(theId);

        if (result != null ) {
            return result;
        }
        else {
            throw new RuntimeException("Did not find Profile - " + theId);
        }
    }
}
