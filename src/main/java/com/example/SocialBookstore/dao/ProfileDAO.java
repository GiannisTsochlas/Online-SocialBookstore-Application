package com.example.SocialBookstore.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SocialBookstore.model.Profile;
public interface ProfileDAO extends JpaRepository<Profile,Integer> {
}
