package se.lexicon.armin.booklender.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;


@Data
@Entity
public class LibraryUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    @Column(nullable = false)
    private LocalDate regDate;
    @Column(nullable = false,length = 100)
    private String name;
    @Column(nullable = false,unique = true,length = 100)
    private String email;

    public LibraryUser() {
    }

    public LibraryUser(LocalDate regDate, String name, String email) {
        this.regDate = regDate;
        this.name = name;
        this.email = email;
    }
}
