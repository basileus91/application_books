package com.books.api.controllers;

import com.books.data.entities.Books;
import com.books.data.services.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("BooksApiController")
@RequestMapping(value = "/api")
public class BookController {

    @Autowired
    private BooksService booksService;

    @GetMapping("/books")
    List<Books> findAll(){
        return booksService.listAll();
    }

}
