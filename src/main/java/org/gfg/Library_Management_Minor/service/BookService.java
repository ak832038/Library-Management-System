package org.gfg.Library_Management_Minor.service;

import jakarta.validation.Valid;
import org.gfg.Library_Management_Minor.dto.BookRequest;
import org.gfg.Library_Management_Minor.model.*;
import org.gfg.Library_Management_Minor.repository.AuthorRepository;
import org.gfg.Library_Management_Minor.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    public Book addBook(@Valid BookRequest bookRequest) {
        Author authorFromDb = authorRepository.getAuthorByEmail(bookRequest.getAuthorEmail()); //dummy code, later we will fetch author from db using author email

        if(authorFromDb == null){
            //author not present in db, so we will create a new author
            authorFromDb = authorRepository.save(bookRequest.toAuthor());
        }

        //create book object from bookRequest
        Book book = bookRequest.toBook();
        book.setAuthor(authorFromDb);
        return bookRepository.save(book);
    }

    public List<Book> findBookListDynamically(FilterType bookFilterType, Operator operator, String value) {

        switch (bookFilterType){
            case BOOK_TITLE :
                switch (operator){
                    case EQUALS :
                        return bookRepository.findByTitle(value);
                    case LIKE:
                        return bookRepository.findByTitleContaining(value);
                    default:
                        return new ArrayList<>();
                }
            case BOOK_TYPE:
                switch (operator) {
                    case EQUALS:
                        return bookRepository.findByBookType(BookType.valueOf(value));
                }
            case BOOK_NO:
                switch (operator) {
                    case EQUALS:
                        return bookRepository.findByBookNo(value);
                }

        }
        return new ArrayList<>();
    }

    public void updateBookData(Book bookFromDb) {
        bookRepository.save(bookFromDb);
    }
}
