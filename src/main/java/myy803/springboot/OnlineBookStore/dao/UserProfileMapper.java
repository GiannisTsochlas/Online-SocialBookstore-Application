package myy803.springboot.OnlineBookStore.dao;

import myy803.springboot.OnlineBookStore.model.User;
import myy803.springboot.OnlineBookStore.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface UserProfileMapper extends JpaRepository<UserProfile, Long>{
	Optional<UserProfile> findByUsername(String username);
}

