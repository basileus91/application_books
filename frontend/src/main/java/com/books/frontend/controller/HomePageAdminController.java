package com.books.frontend.controller;

import com.books.data.entities.Books;
import com.books.data.services.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/home")
public class HomePageAdminController {

    @Autowired
    private BooksService service;

    @GetMapping
    public String viewHomePageBooks(Model modelBooks) {
        List<Books> listBooks = service.listAll();
        modelBooks.addAttribute("listBooks", listBooks);
        return "index";
    }



}
