package ru.yarychenko.test.haulmont.service;

import ru.yarychenko.test.haulmont.model.Credit;

import java.util.List;
import java.util.UUID;

public interface CreditService {

    List<Credit> findAll();

    void save(Credit credit);

    void deleteById(UUID id);

    Credit findById(UUID id);
}
