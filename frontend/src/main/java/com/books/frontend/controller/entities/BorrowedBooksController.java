package com.books.frontend.controller.entities;

import com.books.data.entities.BorrowedBooks;
import com.books.data.services.BorrowedBooksService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Slf4j
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

    @GetMapping(value="/new/{bookName}")
    public ModelAndView newBorrowedBook(
                                    @PathVariable(name = "bookName") String bookName
    ){
        ModelAndView modelAndView = new ModelAndView();
        BorrowedBooks borrowed_books = new BorrowedBooks();
        modelAndView.addObject("borrowed_books", borrowed_books);
        modelAndView.setViewName("borrowed_books/new_borrowed_book");
        return modelAndView;
    }

    @PostMapping(value = "/new")
    public ModelAndView createNewBorrowedBook(@Valid BorrowedBooks borrowed_books,
//                                              @PathVariable(name = "bookName") String bookName,
                                              BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("borrowed_books/new_borrowed_book");
        } else {

            service.save(borrowed_books);
            modelAndView.addObject("borrowed_books", borrowed_books);
            modelAndView.setViewName("redirect:/home");

        }
        return modelAndView;
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditBorrowedBooksPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("borrowed_books/edit_borrowed_books");
        BorrowedBooks borrowed_books = service.get(id);
        mav.addObject("borrowed_books", borrowed_books);

        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deleteBorrowedBooks(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/home/borrowed_books";
    }
}
