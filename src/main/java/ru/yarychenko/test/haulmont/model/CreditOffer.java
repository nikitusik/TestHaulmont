package ru.yarychenko.test.haulmont.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "credit_offer")
public class CreditOffer extends BasicEntity {
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "credit_id")
    private Credit credit;

    @NotNull
    @Column(name = "sum_credit")
    private Double sumCredit;

    @NotNull
    @Column(name = "month")
    private Integer month;

    @OneToMany(mappedBy = "creditOffer")
    private List<PaymentSchedule> schedules;

    @Column(name = "bank_id")
    private UUID bankId;
}
