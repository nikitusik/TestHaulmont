package ru.yarychenko.test.haulmont.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.yarychenko.test.haulmont.model.Bank;

import java.util.UUID;

@Repository
public interface BankRepository extends JpaRepository<Bank, UUID> {
}
