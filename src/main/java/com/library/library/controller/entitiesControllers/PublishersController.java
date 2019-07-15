package com.library.library.controller.entitiesControllers;

import com.library.library.entities.Publishers;
import com.library.library.services.PublishersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/home/publishers")
public class PublishersController {

    @Autowired
    private PublishersService service;

    @GetMapping
    public String viewHomePagePublishers(Model modelpublisher) {
        List<Publishers> listPublishers = service.listAll();
        modelpublisher.addAttribute("listPublishers", listPublishers);

        return "publishers/publishers";
    }

    @RequestMapping("/new")
    public String showNewPublishersPage(Model model) {
        Publishers publishers = new Publishers();
        model.addAttribute("publishers", publishers);

        return "publishers/new_publishers";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String savePublishers(@ModelAttribute("publishers") Publishers publishers) {
        service.save(publishers);

        return "redirect:/home/publishers";

    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditPublishersPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("publishers/edit_publishers");
        Publishers publishers = service.get(id);
        mav.addObject("publishers", publishers);

        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deletePublishers(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/home/publishers";
    }
}
