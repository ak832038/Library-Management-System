package org.gfg.Library_Management_Minor.controller;

import jakarta.validation.Valid;
import org.gfg.Library_Management_Minor.dto.BookRequest;
import org.gfg.Library_Management_Minor.model.Book;
import org.gfg.Library_Management_Minor.model.FilterType;
import org.gfg.Library_Management_Minor.model.Operator;
import org.gfg.Library_Management_Minor.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

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

    @GetMapping("/filter")
    public List<Book> findBookListDynamically(@RequestParam("filterBy")FilterType filterType,
                                              @RequestParam("operator")Operator operator,
                                              @RequestParam("filterValue")String filterValue){
        return bookService.findBookListDynamically(filterType, operator, filterValue);

    }
}
