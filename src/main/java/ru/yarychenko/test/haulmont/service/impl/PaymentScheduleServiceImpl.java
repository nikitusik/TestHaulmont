package ru.yarychenko.test.haulmont.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.yarychenko.test.haulmont.model.CreditOffer;
import ru.yarychenko.test.haulmont.model.PaymentSchedule;
import ru.yarychenko.test.haulmont.repository.PaymentScheduleRepository;
import ru.yarychenko.test.haulmont.service.CreditOfferService;
import ru.yarychenko.test.haulmont.service.PaymentScheduleService;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class PaymentScheduleServiceImpl implements PaymentScheduleService {

    private final PaymentScheduleRepository scheduleRepository;

    @Autowired
    public PaymentScheduleServiceImpl(PaymentScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    @Override
    public List<PaymentSchedule> findAll() {
        return scheduleRepository.findAll();
    }

    @Override
    public void save(PaymentSchedule paymentSchedule) {
        scheduleRepository.save(paymentSchedule);
    }

    @Override
    public void delete(PaymentSchedule paymentSchedule) {
        scheduleRepository.delete(paymentSchedule);
    }

    @Override
    public List<PaymentSchedule> getPaymentSchedules(LocalDate date, Integer month,
                                                     double percent, BigDecimal sumCredit,
                                                     CreditOffer creditOffer) {

        List<PaymentSchedule> paymentSchedules = new ArrayList<>();
        BigDecimal body = sumCredit.divide(BigDecimal.valueOf(month), 2, BigDecimal.ROUND_HALF_UP);

        for (int i = 0; i < month; i++) {

            BigDecimal sumPercent = sumCredit
                    .multiply(BigDecimal.valueOf(percent))
                    .setScale(2, BigDecimal.ROUND_HALF_UP);

            sumCredit = sumCredit
                    .subtract(body)
                    .setScale(2, BigDecimal.ROUND_HALF_UP);

            BigDecimal payment = sumPercent
                    .add(body)
                    .setScale(2, BigDecimal.ROUND_HALF_UP);

            PaymentSchedule paymentSchedule = new PaymentSchedule();
            paymentSchedule.setDatePayment(Date.valueOf(date.plusMonths(i)));
            paymentSchedule.setSumBody(body);
            paymentSchedule.setSumPayment(payment);
            paymentSchedule.setSumPercent(sumPercent);
            paymentSchedule.setCreditOffer(creditOffer);

            paymentSchedules.add(paymentSchedule);
        }

        return paymentSchedules;
    }

    public void saveAll(List<PaymentSchedule> paymentSchedules) {
        scheduleRepository.saveAll(paymentSchedules);
    }

    @Override
    public List<PaymentSchedule> findByCreditOffer(CreditOffer creditOffer) {
        return scheduleRepository.findByCreditOfferOrderByDatePayment(creditOffer);
    }
}
