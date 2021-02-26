package ru.yarychenko.test.haulmont.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.yarychenko.test.haulmont.model.CreditOffer;
import ru.yarychenko.test.haulmont.repository.CreditOfferRepository;
import ru.yarychenko.test.haulmont.service.CreditOfferService;

import java.util.List;
import java.util.UUID;

@Service
public class CreditOfferServiceImpl implements CreditOfferService{

    private final CreditOfferRepository creditOfferRepository;

    @Autowired
    public CreditOfferServiceImpl(CreditOfferRepository creditOfferRepository) {
        this.creditOfferRepository = creditOfferRepository;
    }

    @Override
    public List<CreditOffer> findAll() {
        return creditOfferRepository.findAll();
    }

    @Override
    public void save(CreditOffer creditOffer) {
        creditOfferRepository.save(creditOffer);
    }

    @Override
    public void delete(CreditOffer creditOffer) {
        creditOfferRepository.delete(creditOffer);
    }

    @Override
    public CreditOffer findCreditOfferByBankId(UUID id) {
        return creditOfferRepository.findCreditOfferByBankId(id);
    }
}
