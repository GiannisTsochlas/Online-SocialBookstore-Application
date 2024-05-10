package com.example.SocialBookstore.service;
import com.example.SocialBookstore.dao.BookDAO;
import com.example.SocialBookstore.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements BookServiceImpl{
    @Autowired
    private BookDAO BookDAO;
    @Override
    public void saveUserBook(Book book) {
        BookDAO.save(book);
    }

    @Override
    public List<Book> findAll() {
        return BookDAO.findAll();
    }
}
