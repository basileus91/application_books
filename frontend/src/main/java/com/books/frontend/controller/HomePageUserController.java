package com.books.frontend.controller;

import com.books.data.entities.Books;
import com.books.data.entities.BorrowedBooks;
import com.books.data.services.BooksService;
import com.books.data.services.BorrowedBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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

    @GetMapping(value="/userHome/reserveBook")
    public String viewHomePageBorrowedBooksUser(Model modelBorrowedBooksUser) {
        List<BorrowedBooks> listBorrowedBooks = serviceBooks.listAll();
        modelBorrowedBooksUser.addAttribute("listBorrowedBooks", listBorrowedBooks);
        return "borrowed_books/borrowed_books_user";
    }

    @RequestMapping("/userHome/new")
    public String showNewBorrowedBooksPage(Model model) {
        BorrowedBooks borrowed_books = new BorrowedBooks();
        model.addAttribute("borrowed_books", borrowed_books);


        return "borrowed_books/new_borrowed_book_user";
    }

    @RequestMapping(value = "userHome/save", method = RequestMethod.POST)
    public String saveBorrowedBooks(@ModelAttribute("borrowed_books") BorrowedBooks borrowed_books) {

        serviceBooks.save(borrowed_books);

        return "redirect:/userHome";
    }
}
