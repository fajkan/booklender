package se.lexicon.armin.booklender.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.armin.booklender.entity.Book;
import se.lexicon.armin.booklender.entity.LibraryUser;
import se.lexicon.armin.booklender.entity.Loan;


import java.util.List;
import java.util.Optional;

public interface LoanRepository extends CrudRepository<Loan, Long> {

    Optional<Book> findByBook_BookId (Integer bookId);
    Optional<LibraryUser> findByLoanTaker_UserId(Integer userId);

    List<Loan> findByTerminated(boolean terminated);
}
