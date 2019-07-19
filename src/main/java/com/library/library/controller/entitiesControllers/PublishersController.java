package com.library.library.controller.entitiesControllers;

import com.library.library.entities.Publishers;
import com.library.library.services.PublishersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
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

    @RequestMapping(value="/new", method = RequestMethod.GET)
    public ModelAndView newPublisher(){
        ModelAndView modelAndView = new ModelAndView();
        Publishers publishers = new Publishers();
        modelAndView.addObject("publishers", publishers);
        modelAndView.setViewName("publishers/new_publishers");
        return modelAndView;
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public ModelAndView createNewPublisher(@Valid Publishers publishers,
                                        BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("publishers/new_publishers");
        } else {
            service.save(publishers);
            modelAndView.addObject("publishers", publishers);
            modelAndView.setViewName("redirect:/home/publishers");

        }
        return modelAndView;
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
