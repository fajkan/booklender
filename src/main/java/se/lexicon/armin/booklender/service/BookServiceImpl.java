package se.lexicon.armin.booklender.service;



import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lexicon.armin.booklender.dto.BookDto;
import se.lexicon.armin.booklender.entity.Book;
import se.lexicon.armin.booklender.repository.BookRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService{

    BookRepository bookRepository;
    ModelMapper modelMapper;

    @Autowired
    public void setBookRepository(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    @Autowired
    public void setModelMapper(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }


    @Override
    public List<BookDto> findByReserved(boolean reserved) {
        List<Book> bookList = new ArrayList<>();
        bookRepository.findByReserved(reserved).iterator().forEachRemaining(bookList::add);
        List<BookDto> bookDtoList = bookList.stream().map(book -> modelMapper.map(book,BookDto.class)).collect(Collectors.toList());
        return bookDtoList;
    }

    @Override
    public List<BookDto> findByAvailable(boolean available) {
        List<Book> bookList = new ArrayList<>();
        bookRepository.findByAvailable(available).iterator().forEachRemaining(bookList::add);
        List<BookDto> bookDtoList = bookList.stream().map(book -> modelMapper.map(book,BookDto.class)).collect(Collectors.toList());
        return bookDtoList;
    }

    @Override
    public List<BookDto> findByTitle(String title) {
        List<Book> bookList = new ArrayList<>();
        bookRepository.findByTitleIgnoreCase(title).get();
        List<BookDto> bookDtoList = bookList.stream().map(book -> modelMapper.map(book,BookDto.class)).collect(Collectors.toList());
        return bookDtoList;
    }

    @Override
    public BookDto findById(int bookId) {
        Optional<Book> book = bookRepository.findById(bookId);
        return modelMapper.map(book.get(), BookDto.class);
    }

    @Override
    public List<BookDto> findAll() {
        List<Book> bookList = new ArrayList<>();
        bookRepository.findAll().iterator().forEachRemaining(bookList::add);
        List<BookDto> bookDtoList = bookList.stream().map(book -> modelMapper.map(book,BookDto.class)).collect(Collectors.toList());
        return bookDtoList;
    }

    @Override
    public BookDto create(BookDto bookDto) {
        return null;
    }

    @Override
    public BookDto update(BookDto bookDto) {
        return null;
    }

    @Override
    public boolean delete(int bookId) {
        return false;
    }
}
