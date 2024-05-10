package com.example.SocialBookstore.service;

import com.example.SocialBookstore.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookServiceImpl {
    public void saveUserBook(Book book);
    public List<Book> findAll();
}
