package com.library.library.controller.entitiesControllers;

import com.library.library.entities.Books;
import com.library.library.services.BooksService;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.ByteBuffer;
import java.util.Date;
import java.util.List;

@Slf4j
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
    public String saveBooks(@ModelAttribute("books") Books books, @RequestParam("cover") MultipartFile file) {
//        log.debug(file.getName());
        try {
            String imageString = Base64.encodeBase64String(file.getBytes());
            books.setBookImage(imageString);
        } catch (IOException e) {
            e.printStackTrace();
        }

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



    public static String encodeToString(BufferedImage image, String type) {
        String imageString = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        try {
            ImageIO.write(image, type, bos);
            byte[] imageBytes = bos.toByteArray();

            BASE64Encoder encoder = new BASE64Encoder();
            imageString = encoder.encode(imageBytes);

            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imageString;
    }

    }

