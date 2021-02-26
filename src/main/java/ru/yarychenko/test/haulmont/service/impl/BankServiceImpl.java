package ru.yarychenko.test.haulmont.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.yarychenko.test.haulmont.model.Bank;
import ru.yarychenko.test.haulmont.repository.BankRepository;
import ru.yarychenko.test.haulmont.service.BankService;

import java.util.List;
import java.util.UUID;

@Service
public class BankServiceImpl implements BankService {

    private final BankRepository bankRepository;

    @Autowired
    public BankServiceImpl(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    @Override
    public List<Bank> findAll() {
        return bankRepository.findAll();
    }

    @Override
    public void save(Bank bank) {
        bankRepository.save(bank);
    }

    @Override
    public void deleteById(UUID id) {
        bankRepository.deleteById(id);
    }

    @Override
    public Bank findById(UUID id) {
        return bankRepository.findById(id).orElse(null);
    }
}
