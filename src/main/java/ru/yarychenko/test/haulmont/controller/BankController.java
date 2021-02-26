package ru.yarychenko.test.haulmont.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.yarychenko.test.haulmont.model.*;
import ru.yarychenko.test.haulmont.service.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/banks")
public class BankController {
    private final BankService bankService;
    private final ClientService clientService;
    private final CreditService creditService;
    private final CreditOfferService creditOfferService;
    private final PaymentScheduleService paymentScheduleService;

    @Autowired
    public BankController(BankService bankService, ClientService clientService, CreditService creditService, CreditOfferService creditOfferService, PaymentScheduleService paymentScheduleService) {
        this.bankService = bankService;
        this.clientService = clientService;
        this.creditService = creditService;
        this.creditOfferService = creditOfferService;
        this.paymentScheduleService = paymentScheduleService;
    }

    @GetMapping("/")
    public String showBanks(Model model){
        List<Bank> banks = bankService.findAll();
        model.addAttribute("banks", banks);
        return "bank/list";
    }

    @GetMapping("/create")
    public String createBankForm(Bank bank, Model model){
        List<Client> clients = clientService.findAll();
        List<Credit> credits = creditService.findAll();
        model.addAttribute("clients", clients);
        model.addAttribute("credits", credits);
        return "bank/create";
    }

    @PostMapping("/create")
    public String createBank(@Valid Bank bank, BindingResult bindingResult, Model model){

        if (bindingResult.hasErrors()){
            return "bank/create";
        }

        Client client = clientService.findById(bank.getClient().getId());
        Credit credit = creditService.findById(bank.getCredit().getId());
        CreditOffer creditOffer = new CreditOffer();
        creditOffer.setClient(client);
        creditOffer.setCredit(credit);
        model.addAttribute("creditOffer", creditOffer);

        return "credit-offer/create";
    }

    @GetMapping("/update/{id}")
    public String updateBankForm(@PathVariable("id") UUID id, Model model){
        Bank bank = bankService.findById(id);
        List<Client> clients = clientService.findAll();
        model.addAttribute("clients", clients);
        model.addAttribute("bank", bank);
        return "bank/update";
    }

    @PostMapping("/update")
    public  String updateBank(@Valid Bank bank, BindingResult bindingResult, Model model){

        if (bindingResult.hasErrors()){
            return "bank/update";
        }
        bankService.save(bank);
        return "redirect:/banks/";
    }


    @GetMapping("/delete/{id}")
    public String deleteBank(@PathVariable("id") UUID id){
        bankService.deleteById(id);
        return "redirect:/banks/";
    }

    @GetMapping("/about/{id}")
    public String aboutCredit(@PathVariable("id") UUID id, Model model){
        //найти по айди банка предложение и по нему найти графики
        CreditOffer creditOffer = creditOfferService.findCreditOfferByBankId(id);
        List<PaymentSchedule> paymentSchedules = paymentScheduleService.findByCreditOffer(creditOffer);
        model.addAttribute("graphics", paymentSchedules);
        return "schedule/list";
    }
}
