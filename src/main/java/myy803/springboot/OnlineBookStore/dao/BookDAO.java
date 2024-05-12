package myy803.springboot.OnlineBookStore.dao;


import myy803.springboot.OnlineBookStore.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookDAO extends JpaRepository<Book,Integer> {
    List<Book> findByUsername(String username);
}
