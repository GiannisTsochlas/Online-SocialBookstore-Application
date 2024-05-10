package com.example.SocialBookstore.controller;

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
        return"Book/bookdash";
    }
    @RequestMapping("/user/bookdash/addBook")
    public String AddBook(){
        return"Book/AddBook";
    }
    @RequestMapping("/saveBook")
    public String saveBook(@ModelAttribute("book") Book book, Model model){
        BookService.saveUserBook(book);
        return "Book/bookdash";
    }
    @RequestMapping("/MyBooks")
    public String MyBooks(Model theModel){
        List<Book> Books = BookService.findAll();
        theModel.addAttribute("Books", Books);
        return "Book/Books";
    }
}
