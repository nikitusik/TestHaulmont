package ru.yarychenko.test.haulmont.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Data
@Entity
@Table(name = "bank")
public class Bank extends BasicEntity{

    @NotNull
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "credit_id")
    private Credit credit;
}
