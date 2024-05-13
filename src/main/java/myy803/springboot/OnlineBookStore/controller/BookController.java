package myy803.springboot.OnlineBookStore.controller;

import myy803.springboot.OnlineBookStore.dao.BookDAO;
import myy803.springboot.OnlineBookStore.forms.BookData;
import myy803.springboot.OnlineBookStore.forms.UserProfileFormData;
import myy803.springboot.OnlineBookStore.model.Book;
import myy803.springboot.OnlineBookStore.model.UserProfile;
import myy803.springboot.OnlineBookStore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookService BookService;
    @Autowired
    private BookDAO BookDAO;
    private String getUsername() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            return ((UserDetails) principal).getUsername();
        } else {
            return principal.toString();
        }
    }

    @RequestMapping("/book/form")
    public String AddBook(Model model){
        BookData books = new BookData();
        model.addAttribute("book", books);
        return"Book/bookform";
    }
    @RequestMapping("/book/back")
    public String back(){
        return"user/dashboard";
    }

    @RequestMapping("/saveBook")
    public String saveBook(@ModelAttribute("books") Book book, Model model){
        String loggedInUsername = getUsername();
        book.setUsername(loggedInUsername);
        BookService.saveUserBook(book);
        return "redirect:user/bookdash";
    }
    @RequestMapping("/user/bookdash")
    public String MyBooks(Model theModel){
        String loggedInUsername = getUsername();
        List<Book> Books = BookDAO.findByUsername(loggedInUsername);
        theModel.addAttribute("Books", Books);
        return "Book/bookdash";
    }
    @RequestMapping("/deleteBook")
    public String deleteBook(@RequestParam("BookId") int theId){
        BookService.deleteById(theId);
        return "redirect:user/bookdash";
    }
    @RequestMapping("/user/searchdash")
    public String searchdash(){
        return"Book/booksearch";
    }

    @GetMapping("/search")
    public String searchBooks(@RequestParam(name = "title", required = false) String title,
                              @RequestParam(name = "author", required = false) String author,
                              Model model) {
        List<Book> books = BookDAO.findByTitleAndAuthors(title, author);
        model.addAttribute("books", books);
        return "Book/searchres";
    }
}
