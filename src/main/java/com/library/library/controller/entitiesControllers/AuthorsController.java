package com.library.library.controller.entitiesControllers;

import com.library.library.entities.Authors;
import com.library.library.services.AuthorsService;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/home/authors")
public class AuthorsController {

    @Autowired
    private AuthorsService service;

    @GetMapping
    public String viewHomePageAuthors(Model modelAuthors) {
        List<Authors> listAuthors = service.listAll();
        modelAuthors.addAttribute("listAuthors", listAuthors);

        return "authors/authors";
    }

    @RequestMapping(value="/new", method = RequestMethod.GET)
    public ModelAndView newAuthor(){
        ModelAndView modelAndView = new ModelAndView();
        Authors authors = new Authors();
        modelAndView.addObject("authors", authors);
        modelAndView.setViewName("authors/new_author");
        return modelAndView;
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public ModelAndView createNewAuthor(@Valid Authors authors,
                                      BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("authors/new_author");
        } else {
            service.save(authors);
            modelAndView.addObject("authors", authors);
            modelAndView.setViewName("redirect:/home/authors");

        }
        return modelAndView;
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditAuthorsPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("authors/edit_authors");
        Authors authors = service.get(id);
        mav.addObject("authors", authors);

        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deleteAuthors(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/home/authors";
    }
}
