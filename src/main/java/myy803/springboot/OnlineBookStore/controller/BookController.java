package myy803.springboot.OnlineBookStore.controller;

import myy803.springboot.OnlineBookStore.dao.BookDAO;
import myy803.springboot.OnlineBookStore.dao.UserProfileMapper;
import myy803.springboot.OnlineBookStore.forms.BookData;
import myy803.springboot.OnlineBookStore.forms.UserProfileFormData;
import myy803.springboot.OnlineBookStore.model.Book;
import myy803.springboot.OnlineBookStore.model.User;
import myy803.springboot.OnlineBookStore.model.UserProfile;
import myy803.springboot.OnlineBookStore.model.bookrequest;
import myy803.springboot.OnlineBookStore.service.BookService;
import myy803.springboot.OnlineBookStore.service.RequestService;
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
import java.util.Optional;

@Controller
public class BookController {
    @Autowired
    private BookService BookService;
    @Autowired
    private BookDAO BookDAO;
    @Autowired
    private RequestService requestService;

    @Autowired
    private UserProfileMapper profileMapper;
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
                              @RequestParam(name = "searchType", required = false) String searchType, Model model) {
        if(searchType.equals("exact")) {
            List<Book> books = BookDAO.findByTitleAndAuthors(title, author);
            model.addAttribute("books", books);
        }else {
            List<Book> books = BookDAO.findByAuthors(author);
            model.addAttribute("books", books);
        }
        return "Book/searchres";
    }
    @RequestMapping("/requestBook")
    public String requestbook(@ModelAttribute("request") bookrequest bookrequest, Model model, @RequestParam("title") String title, @RequestParam("owner") String owner){
        String loggedInUsername = getUsername();
        bookrequest.setUsername(loggedInUsername);
        bookrequest.setTitle(title);
        bookrequest.setOwner(owner);
        requestService.save(bookrequest);
        return "user/dashboard";
    }
    @RequestMapping("/recommended")
    public String recommended(Model theModel){
        String loggedInUsername = getUsername();
        Optional<UserProfile> profileOptional = profileMapper.findByUsername(loggedInUsername);
        if (profileOptional.isPresent()) {
            UserProfile profile = profileOptional.get();
            List<Book> books = BookDAO.findByCategoryOrAuthors(profile.getCategory(), profile.getAuthor());
            theModel.addAttribute("Books", books);
            return "Book/searchres";
        }
        return "user/booksearch";
    }
}
