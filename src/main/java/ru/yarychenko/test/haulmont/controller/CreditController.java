package ru.yarychenko.test.haulmont.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.yarychenko.test.haulmont.model.Credit;
import ru.yarychenko.test.haulmont.service.BankService;
import ru.yarychenko.test.haulmont.service.CreditService;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/credits")
public class CreditController {

    private final CreditService creditService;

    @Autowired
    public CreditController(CreditService creditService) {
        this.creditService = creditService;
    }

    @GetMapping("/")
    public String showCredits(Model model) {
        List<Credit> credits = creditService.findAll();
        model.addAttribute("credits", credits);
        return "credit/list";
    }

    @GetMapping("/create")
    public String createCreditForm(Credit credit, Model model) {
        model.addAttribute("path", "create");
        return "credit/form";
    }

    @PostMapping("/create")
    public String createCredit(@Valid Credit credit, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("path", "create");
            return "credit/form";
        }

        creditService.save(credit);
        return "redirect:/credits/";
    }

    @GetMapping("/update/{id}")
    public String updateCreditForm(@PathVariable("id") UUID id, Model model) {
        Credit credit = creditService.findById(id);
        model.addAttribute("credit", credit);
        model.addAttribute("path", "update");
        return "credit/form";
    }

    @PostMapping("/update")
    public String updateCredit(@Valid Credit credit, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("path", "update");
            return "credit/form";
        }

        creditService.save(credit);
        return "redirect:/credits/";
    }

    @GetMapping("/delete/{id}")
    public String deleteCredit(@PathVariable("id") UUID id) {
        creditService.deleteById(id);
        return "redirect:/credits/";
    }
}
