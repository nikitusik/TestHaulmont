package ru.yarychenko.test.haulmont.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.yarychenko.test.haulmont.model.Credit;
import ru.yarychenko.test.haulmont.model.CreditOffer;
import ru.yarychenko.test.haulmont.model.PaymentSchedule;
import ru.yarychenko.test.haulmont.service.PaymentScheduleService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/payment-schedule")
public class PaymentScheduleController {

    private final PaymentScheduleService paymentScheduleService;

    @Autowired
    public PaymentScheduleController(PaymentScheduleService paymentScheduleService) {
        this.paymentScheduleService = paymentScheduleService;
    }

    @GetMapping("/show")
    public String showPaymentSchedule(Model model, @ModelAttribute CreditOffer creditOffer){

        Credit credit = creditOffer.getCredit();
        LocalDate date = LocalDate.now();
        BigDecimal sumCredit = BigDecimal.valueOf(creditOffer.getSumCredit());
        double percent = credit.getPercent()/100/12;
        Integer month = creditOffer.getMonth();

        List<PaymentSchedule> paymentSchedules =
                paymentScheduleService.getPaymentSchedules(date, month, percent,sumCredit, creditOffer);

        paymentScheduleService.saveAll(paymentSchedules);

        model.addAttribute("graphics", paymentSchedules);
        model.addAttribute("creditOffer", creditOffer);

        return "schedule/list";
    }
}
