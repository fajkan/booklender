package se.lexicon.armin.booklender.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookId;
    @Column(nullable = false,length = 100)
    private String title;
    @Column(nullable = false)
    private boolean available;
    @Column(nullable = false)
    private boolean reserved;
    @Column(nullable = false)
    private int maxLoanDays;
    @Column(nullable = false)
    private BigDecimal finePerDay;
    @Column(nullable = false,length = 200)
    private String description;

    public Book() {
    }

    public Book(String title, int maxLoanDays, BigDecimal finePerDay, String description) {
        this.title = title;
        this.maxLoanDays = maxLoanDays;
        this.finePerDay = finePerDay;
        this.description = description;
    }


}
