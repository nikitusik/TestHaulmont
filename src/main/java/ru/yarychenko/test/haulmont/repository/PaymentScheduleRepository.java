package ru.yarychenko.test.haulmont.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.yarychenko.test.haulmont.model.CreditOffer;
import ru.yarychenko.test.haulmont.model.PaymentSchedule;

import java.util.List;
import java.util.UUID;

@Repository
public interface PaymentScheduleRepository extends JpaRepository<PaymentSchedule, UUID> {
    List<PaymentSchedule> findByCreditOfferOrderByDatePayment(CreditOffer creditOffer);
}
