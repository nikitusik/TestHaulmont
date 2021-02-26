package ru.yarychenko.test.haulmont.service;

import ru.yarychenko.test.haulmont.model.Client;

import java.util.List;
import java.util.UUID;

public interface ClientService {

    List<Client> findAll();

    void save(Client client);

    void deleteById(UUID id);

    Client findById(UUID id);
}
