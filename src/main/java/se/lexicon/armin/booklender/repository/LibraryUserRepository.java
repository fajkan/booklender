package se.lexicon.armin.booklender.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.armin.booklender.entity.LibraryUser;

import java.util.Optional;

public interface LibraryUserRepository extends CrudRepository<LibraryUser,Integer> {

    Optional<LibraryUser> findByEmailIgnoreCase(String email);

}
