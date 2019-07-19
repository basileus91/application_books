package com.library.library.controller.entitiesControllers;

import com.library.library.entities.Clients;
import com.library.library.services.ClientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/home/clients")
public class ClientsController {


    @Autowired
    private ClientsService service;

    @GetMapping
    public String viewHomePageClients(Model modelClients) {
        List<Clients> listClients = service.listAll();
        modelClients.addAttribute("listClients", listClients);

        return "clients/clients";
    }

    @RequestMapping(value="/new", method = RequestMethod.GET)
    public ModelAndView newClient(){
        ModelAndView modelAndView = new ModelAndView();
        Clients clients = new Clients();
        modelAndView.addObject("clients", clients);
        modelAndView.setViewName("clients/new_clients");
        return modelAndView;
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public ModelAndView createNewClient(@Valid Clients clients,
                                      BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("clients/new_clients");
        } else {
            service.save(clients);
            modelAndView.addObject("clients", clients);
            modelAndView.setViewName("redirect:/home/clients");

        }
        return modelAndView;
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditClientsPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("clients/edit_clients");
        Clients clients = service.get(id);
        mav.addObject("clients", clients);

        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deleteClients(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/home/clients";
    }
}
