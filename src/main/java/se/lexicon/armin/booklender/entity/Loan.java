package se.lexicon.armin.booklender.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;


@Data
@Entity
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long loanId;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private LibraryUser loanTaker;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Book book;
    @Column(nullable = false)
    private LocalDate loanDate;
    @Column(nullable = false)
    private boolean terminated;

    public Loan() {
    }

    public Loan(LibraryUser loanTaker, Book book, LocalDate loanDate, boolean terminated) {
        this.loanTaker = loanTaker;
        this.book = book;
        this.loanDate = loanDate;
        this.terminated = terminated;
    }
}
