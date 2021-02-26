package ru.yarychenko.test.haulmont.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.yarychenko.test.haulmont.model.Bank;
import ru.yarychenko.test.haulmont.model.CreditOffer;
import ru.yarychenko.test.haulmont.service.BankService;
import ru.yarychenko.test.haulmont.service.CreditOfferService;

@Controller
@RequestMapping("/credit-offer")
public class CreditOfferController {

    private final CreditOfferService creditOfferService;
    private final BankService bankService;

    @Autowired
    public CreditOfferController(CreditOfferService creditOfferService, BankService bankService) {
        this.creditOfferService = creditOfferService;
        this.bankService = bankService;
    }

    @PostMapping("/create")
    public String createOffer(CreditOffer creditOffer,
                              Model model,
                              BindingResult bindingResult,
                              RedirectAttributes attributes) {
//        ????
        if (bindingResult.hasErrors()) {
            model.addAttribute("error");
            return "credit-offer/create";
        }

        Bank bank = new Bank();
        bank.setClient(creditOffer.getClient());
        bank.setCredit(creditOffer.getCredit());
        bankService.save(bank);
        creditOffer.setBankId(bank.getId());

        creditOfferService.save(creditOffer);
        attributes.addFlashAttribute(creditOffer);
        return "redirect:/payment-schedule/show";
    }
}
