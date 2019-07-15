package com.library.library.controller.entitiesControllers;

import com.library.library.entities.Authors;
import com.library.library.services.AuthorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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


    @RequestMapping("/new")
    public String showNewAuthorsPage(Model model) {
        Authors authors = new Authors();
        model.addAttribute("authors", authors);

        return "authors/new_author";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveAuthors(@ModelAttribute("authors") Authors authors) {
        service.save(authors);

        return "redirect:/home/authors";
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
