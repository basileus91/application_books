package com.library.library.controller.entitiesControllers;

import com.library.library.entities.Authors;
import com.library.library.entities.Books;
import com.library.library.entities.Publishers;
import com.library.library.services.AuthorsService;
import com.library.library.services.BooksService;
import com.library.library.services.PublishersService;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import javax.validation.Valid;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.ByteBuffer;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/home/books")
public class BooksController {

    @Autowired
    private BooksService service;

    @Autowired
    private AuthorsService authorsService;

    @Autowired
    private PublishersService publishersService;

    @GetMapping
    public String viewHomePageBooks(Model modelBooks) {
        List<Books> listBooks = service.listAll();
        modelBooks.addAttribute("listBooks", listBooks);
        return "books/books";
    }

    @RequestMapping(value="/new", method = RequestMethod.GET)
    public ModelAndView newBook(ModelAndView modelAndView ){

        List<Publishers> listPublishers = publishersService.listAll();
        modelAndView.addObject("listPublishers", listPublishers);
        System.out.println(" ++++++++++ "+listPublishers);

        List<Authors> listAuthors = authorsService.listAll();
        modelAndView.addObject("listAuthors", listAuthors);
        System.out.println(" ++++++++++ "+listPublishers);

        Books books = new Books();
        modelAndView.addObject("books", books);
        modelAndView.setViewName("books/new_book");





        return modelAndView;

    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public ModelAndView createNewUser(@Valid Books books,
                                      @RequestParam("cover") MultipartFile file,
                                      BindingResult bindingResult
                                      ) {

        ModelAndView modelAndView = new ModelAndView();
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("books/new_book");
        } else {

            try {
            String imageString = Base64.encodeBase64String(file.getBytes());
            books.setBookImage(imageString);
        } catch (IOException e) {
            e.printStackTrace();
        }

            service.save(books);
            modelAndView.addObject("books", new Books());
            modelAndView.setViewName("redirect:/home/books");

        }
        return modelAndView;
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



}

