package com.library.library.controller;

import com.library.library.entities.Books;
import com.library.library.entities.BorrowedBooks;
import com.library.library.entities.User;
import com.library.library.services.BooksService;
import com.library.library.services.BorrowedBooksService;
import com.library.library.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class HomePageUserController {

    @Autowired
    private BooksService service;

    @Autowired
    private BorrowedBooksService serviceBooks;

    @RequestMapping(value="/userHome", method = RequestMethod.GET)
    public String viewHomePageBooks(Model modelBooks) {
        List<Books> listBooks = service.listAll();
        modelBooks.addAttribute("listBooks", listBooks);
        return "indexUser";
    }

    @GetMapping(value="/reserveBook")
    public String viewHomePageBorrowedBooksUser(Model modelBorrowedBooksUser) {
        List<BorrowedBooks> listBorrowedBooks = serviceBooks.listAll();
        modelBorrowedBooksUser.addAttribute("listBorrowedBooks", listBorrowedBooks);
        return "borrowed_books/borrowed_books_user";
    }
}
