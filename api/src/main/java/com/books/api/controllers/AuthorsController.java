package com.books.api.controllers;

import com.books.data.entities.Authors;
import com.books.data.services.AuthorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("AuthorsApiController")
@RequestMapping(value = "/api")
public class AuthorsController {

    @Autowired
    private AuthorsService authorsService;

    @GetMapping("/authors")
    List<Authors> findAll(){
        return authorsService.listAll();
    }
}
