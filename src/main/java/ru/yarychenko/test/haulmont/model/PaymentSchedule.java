package ru.yarychenko.test.haulmont.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "payment_schedule")
public class PaymentSchedule extends BasicEntity{

    @Column(name = "date_payment")
    private Date datePayment;

    @Column(name = "sum_payment")
    private BigDecimal sumPayment;

    @Column(name = "sum_body")
    private BigDecimal sumBody;

    @Column(name = "sum_percent")
    private BigDecimal sumPercent;

    @ManyToOne
    @JoinColumn(name = "credit_offer_id")
    private CreditOffer creditOffer;
}
