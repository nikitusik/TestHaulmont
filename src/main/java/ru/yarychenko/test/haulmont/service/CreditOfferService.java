package ru.yarychenko.test.haulmont.service;

import ru.yarychenko.test.haulmont.model.CreditOffer;

import java.util.List;
import java.util.UUID;

public interface CreditOfferService {

    List<CreditOffer> findAll();

    void save(CreditOffer creditOffer);

    void delete(CreditOffer creditOffer);

    CreditOffer findCreditOfferByBankId( UUID id);
}
