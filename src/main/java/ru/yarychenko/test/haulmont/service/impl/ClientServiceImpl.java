package ru.yarychenko.test.haulmont.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.yarychenko.test.haulmont.model.Client;
import ru.yarychenko.test.haulmont.repository.ClientRepository;
import ru.yarychenko.test.haulmont.service.ClientService;

import java.util.List;
import java.util.UUID;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public void save(Client client) {
        clientRepository.save(client);
    }

    @Override
    public void deleteById(UUID id) {
        clientRepository.deleteById(id);
    }

    @Override
    public Client findById(UUID id) {
        return clientRepository.findById(id).orElse(null);
    }
}
