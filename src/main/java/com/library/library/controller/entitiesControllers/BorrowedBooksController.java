package com.library.library.controller.entitiesControllers;

import com.library.library.entities.BorrowedBooks;
import com.library.library.services.BorrowedBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/borrowed_books")
public class BorrowedBooksController {


    @Autowired
    private BorrowedBooksService service;

    @GetMapping
    public String viewHomePageBorrowedBooks(Model modelBorrowedBooks) {
        List<BorrowedBooks> listBorrowedBooks = service.listAll();
        modelBorrowedBooks.addAttribute("listBorrowedBooks", listBorrowedBooks);
        return "borrowed_books/borrowed_books";
    }

    @RequestMapping("/new")
    public String showNewBorrowedBooksPage(Model model) {
        BorrowedBooks borrowed_books = new BorrowedBooks();
        model.addAttribute("borrowed_books", borrowed_books);

        return "borrowed_books/new_borrowedBooks";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveBorrowedBooks(@ModelAttribute("borrowed_books") BorrowedBooks borrowed_books) {
        service.save(borrowed_books);

        return "redirect:/borrowed_books";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditBorrowedBooksPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("borrowed_books/book_card");
        BorrowedBooks borrowed_books = service.get(id);
        mav.addObject("borrowed_books", borrowed_books);

        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deleteBorrowedBooks(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/borrowed_books";
    }
}
