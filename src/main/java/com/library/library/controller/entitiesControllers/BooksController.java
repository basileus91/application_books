package com.library.library.controller.entitiesControllers;

import com.library.library.entities.Books;
import com.library.library.services.BooksService;
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

    @InitBinder
    public void iniBinder(WebDataBinder binder){
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }
    public String finalString = null;

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
    public String saveBooks(@ModelAttribute("books") Books books,
                            @RequestParam("cover") MultipartFile file,
                            BindingResult bindingResult
                            ) {

        //        log.debug(file.getName());
        try {
            String imageString = Base64.encodeBase64String(file.getBytes());
            books.setBookImage(imageString);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(bindingResult.hasErrors()){
            return "books/new_book";
        }else{

            service.save(books);

            return "redirect:/home/books";
        }
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


    public String checkNullString (String str){
        String endString = null;
        if(str == null|| str.isEmpty()){
            System.out.println("yes it is empty");
            str = null;
            Optional<String> opt = Optional.ofNullable(str);
            endString = opt.orElse("None");
            System.out.println("endString: "+endString);
        }
        else{
            ;
        }
        return endString;
    }
}

