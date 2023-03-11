package yk.springframework.intro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import yk.springframework.intro.domain.Book;

public interface BookRepository extends JpaRepository<Book,Long> {

}
