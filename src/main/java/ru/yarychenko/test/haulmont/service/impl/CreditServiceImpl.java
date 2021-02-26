package ru.yarychenko.test.haulmont.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.yarychenko.test.haulmont.model.Credit;
import ru.yarychenko.test.haulmont.repository.CreditRepository;
import ru.yarychenko.test.haulmont.service.CreditService;

import java.util.List;
import java.util.UUID;

@Service
public class CreditServiceImpl implements CreditService {

    private final CreditRepository creditRepository;

    @Autowired
    public CreditServiceImpl(CreditRepository creditRepository) {
        this.creditRepository = creditRepository;
    }

    @Override
    public List<Credit> findAll() {
        return creditRepository.findAll();
    }

    @Override
    public void save(Credit credit) {
        creditRepository.save(credit);
    }

    @Override
    public Credit findById(UUID id) {
        return creditRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(UUID id) {
        creditRepository.deleteById(id);
    }
}
