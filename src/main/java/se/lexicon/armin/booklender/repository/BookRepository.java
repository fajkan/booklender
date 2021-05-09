package se.lexicon.armin.booklender.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.armin.booklender.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends CrudRepository<Book, Integer> {

    List<Book> findByAvailable(boolean available);
    List<Book> findByReserved (boolean reserved);

    Optional<Book> findByTitleIgnoreCase(String title);

}
