package myy803.springboot.OnlineBookStore.dao;

import myy803.springboot.OnlineBookStore.model.bookrequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestDAO extends JpaRepository<bookrequest,Integer> {
}
