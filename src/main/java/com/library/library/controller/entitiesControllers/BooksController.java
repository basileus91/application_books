package com.library.library.controller.entitiesControllers;

import com.library.library.entities.Books;
import com.library.library.services.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/home/books")
public class BooksController {

    @Autowired
    private BooksService service;

    @GetMapping
    public String viewHomePageBooks(Model modelBooks) {
        List<Books> listBooks = service.listAll();
        modelBooks.addAttribute("listBooks", listBooks);
        return "books/books";
    }

    @RequestMapping("/new")
    public String showNewBooksPage(Model model) {
        Books books = new Books();
        model.addAttribute("books", books);

        return "books/new_book";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveBooks(@ModelAttribute("books") Books books) {
        service.save(books);

        return "redirect:/home/books";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditBooksPage(@PathVariable(name = "id") int id
                           ) {
        ModelAndView mav = new ModelAndView("books/edit_books");
        Books books = service.get(id);
        mav.addObject("books", books);

        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deleteBooks(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/home/books";
    }

//    private String uploadFile(MultipartFile file){
//
//    }
}
