package ru.yarychenko.test.haulmont.service;

import ru.yarychenko.test.haulmont.model.CreditOffer;
import ru.yarychenko.test.haulmont.model.PaymentSchedule;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface PaymentScheduleService {

    List<PaymentSchedule> findAll();

    void save(PaymentSchedule paymentSchedule);

    void delete(PaymentSchedule paymentSchedule);

    List<PaymentSchedule> getPaymentSchedules(LocalDate date, Integer month,
                                              double percent, BigDecimal sumCredit,
                                              CreditOffer creditOffer);

    void saveAll(List<PaymentSchedule> paymentSchedules);

    List<PaymentSchedule> findByCreditOffer(CreditOffer creditOffer);
}
