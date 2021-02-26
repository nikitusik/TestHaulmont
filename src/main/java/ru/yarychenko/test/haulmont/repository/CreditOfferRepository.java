package ru.yarychenko.test.haulmont.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.yarychenko.test.haulmont.model.CreditOffer;

import java.util.UUID;

@Repository
public interface CreditOfferRepository extends JpaRepository<CreditOffer, UUID> {
    CreditOffer findCreditOfferByBankId( UUID id);
}
