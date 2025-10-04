package org.gfg.Library_Management_Minor.service;

import jakarta.validation.Valid;
import org.gfg.Library_Management_Minor.dto.BookRequest;
import org.gfg.Library_Management_Minor.model.Author;
import org.gfg.Library_Management_Minor.model.Book;
import org.gfg.Library_Management_Minor.repository.AuthorRepository;
import org.gfg.Library_Management_Minor.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
