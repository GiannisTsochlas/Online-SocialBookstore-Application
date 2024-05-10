package com.example.SocialBookstore.controller;

import com.example.SocialBookstore.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.SocialBookstore.model.Book;
import com.example.SocialBookstore.service.BookService;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookService BookService;

    @RequestMapping("/user/bookdash")
    public String Homebook(){
        return"user/bookdash";
    }
    @RequestMapping("/user/bookdash/addBook")
    public String AddBook(){
        return"Book/AddBook";
    }
    @RequestMapping("/saveBook")
    public String saveBook(@ModelAttribute("book") Book book, Model model){
        BookService.saveUserBook(book);
        return "user/bookdash";
    }
    @RequestMapping("/MyBooks")
    public String MyBooks(Model theModel){
        List<Book> Books = BookService.findAll();
        theModel.addAttribute("Books", Books);
        return "Book/Books";
    }
}
