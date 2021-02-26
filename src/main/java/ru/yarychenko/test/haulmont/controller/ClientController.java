package ru.yarychenko.test.haulmont.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.yarychenko.test.haulmont.model.Client;
import ru.yarychenko.test.haulmont.service.ClientService;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/clients")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/")
    public String showClients(Model model){
        List<Client> clients = clientService.findAll();
        model.addAttribute("clients", clients);
        return "client/list";
    }

    @GetMapping("/create")
    public String createClientForm(Client client, Model model){
        model.addAttribute("path", "create");
        return "client/form";
    }

    @PostMapping("/create")
    public String createClient(@Valid Client client, BindingResult bindingResult, Model model){

        if (bindingResult.hasErrors()){
            model.addAttribute("path", "create");
            return "client/form";
        }

        clientService.save(client);
        return "redirect:/clients/";
    }

    @GetMapping("/update/{id}")
    public String updateClientForm(@PathVariable("id") UUID id, Model model){
        Client client = clientService.findById(id);
        model.addAttribute("client", client);
        model.addAttribute("path", "update");
        return "client/form";
    }

    @PostMapping("/update")
    public  String updateClient(@Valid Client client, BindingResult bindingResult, Model model){

        if (bindingResult.hasErrors()){
            model.addAttribute("path", "update");
            return "client/form";
        }

        clientService.save(client);
        return "redirect:/clients/";
    }

    @GetMapping("/delete/{id}")
    public String deleteClient(@PathVariable("id") UUID id){
        clientService.deleteById(id);
        return "redirect:/clients/";
    }
}
