package org.gfg.Library_Management_Minor.controller;

import jakarta.validation.Valid;
import org.gfg.Library_Management_Minor.dto.BookRequest;
import org.gfg.Library_Management_Minor.model.Book;
import org.gfg.Library_Management_Minor.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/addBook")
    public Book addBook(@RequestBody @Valid BookRequest bookRequest) {
        //validations before business logic

        //call business logic
       return bookService.addBook(bookRequest);
    }
}
