package se.lexicon.armin.booklender.service;


import se.lexicon.armin.booklender.dto.LibraryUserDto;


import java.util.List;

public interface LibraryUserService {

    LibraryUserDto findByID(int userId);
    LibraryUserDto findByEmail(String email);
    List<LibraryUserDto> findAll();
    LibraryUserDto create(LibraryUserDto libraryUserDto);
    LibraryUserDto update(LibraryUserDto libraryUserDto);
    boolean delete (int userId);
}
