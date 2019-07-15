package com.library.library.controller.entitiesControllers;

import com.library.library.entities.Clients;
import com.library.library.services.ClientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/clients")
public class ClientsController {


    @Autowired
    private ClientsService service;

    @GetMapping
    public String viewHomePageClients(Model modelClients) {
        List<Clients> listClients = service.listAll();
        modelClients.addAttribute("listClients", listClients);

        return "clients/clients";
    }


    @RequestMapping("/new")
    public String showNewAClientsPage(Model model) {
        Clients clients = new Clients();
        model.addAttribute("clients", clients);

        return "clients/new_clients";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveClients(@ModelAttribute("clients") Clients clients) {
        service.save(clients);

        return "redirect:/clients";
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
        return "redirect:/clients";
    }
}
