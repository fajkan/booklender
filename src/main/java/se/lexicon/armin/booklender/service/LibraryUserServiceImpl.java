package se.lexicon.armin.booklender.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lexicon.armin.booklender.dto.LibraryUserDto;
import se.lexicon.armin.booklender.entity.LibraryUser;
import se.lexicon.armin.booklender.repository.LibraryUserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LibraryUserServiceImpl implements LibraryUserService{

    LibraryUserRepository libraryUserRepository;
    ModelMapper modelMapper;


    @Autowired
    public void setLibraryUserRepository(LibraryUserRepository libraryUserRepository){
        this.libraryUserRepository =libraryUserRepository;
    }

    @Autowired
    public void setModelMapper(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

    @Override
    public LibraryUserDto findByID(int userId) {
        Optional<LibraryUser> libraryUser = libraryUserRepository.findById(userId);
        return modelMapper.map(libraryUser.get(), LibraryUserDto.class);
    }

    @Override
    public LibraryUserDto findByEmail(String email) {
        Optional<LibraryUser> libraryUser = libraryUserRepository.findByEmailIgnoreCase(email);
        return modelMapper.map(libraryUser.get(),LibraryUserDto.class);
    }

    @Override
    public List<LibraryUserDto> findAll() {
        List<LibraryUser> libraryUserList = new ArrayList<>();
        libraryUserRepository.findAll().iterator().forEachRemaining(libraryUserList::add);
        List<LibraryUserDto> libraryUserDtoList = libraryUserList.stream().map(libraryUser -> modelMapper.map(libraryUser,LibraryUserDto.class)).collect(Collectors.toList());
        return libraryUserDtoList;
    }

    @Override
    public LibraryUserDto create(LibraryUserDto libraryUserDto) {
        return null;
    }

    @Override
    public LibraryUserDto update(LibraryUserDto libraryUserDto) {
        return null;
    }

    @Override
    public boolean delete(int userId) {
        return false;
    }
}
