package com.example.SocialBookstore.dao;

import com.example.SocialBookstore.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookDAO extends JpaRepository<Book,Integer> {
}
