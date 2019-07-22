package com.books.frontend.controller.entities;

import com.books.data.entities.Authors;
import com.books.data.services.AuthorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
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
