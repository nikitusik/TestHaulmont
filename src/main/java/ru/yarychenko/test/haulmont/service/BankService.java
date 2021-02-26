package ru.yarychenko.test.haulmont.service;

import ru.yarychenko.test.haulmont.model.Bank;

import java.util.List;
import java.util.UUID;

public interface BankService {

    List<Bank> findAll();

    void save(Bank bank);

    void deleteById(UUID id);

    Bank findById(UUID id);
}
