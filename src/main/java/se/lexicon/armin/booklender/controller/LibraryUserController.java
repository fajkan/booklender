package se.lexicon.armin.booklender.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import se.lexicon.armin.booklender.dto.LibraryUserDto;
import se.lexicon.armin.booklender.service.LibraryUserService;

import java.util.List;

@RestController

public class LibraryUserController {


    LibraryUserService libraryUserService;

    @Autowired
    public void setLibraryUserService(LibraryUserService libraryUserService){
        this.libraryUserService = libraryUserService;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<LibraryUserDto>> findById(@PathVariable("userId") Integer userId) {
        return null;
    }

}
