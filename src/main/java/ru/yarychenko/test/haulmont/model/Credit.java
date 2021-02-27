package ru.yarychenko.test.haulmont.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "credit")
public class Credit extends BasicEntity{

    @NotBlank
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "limit")
    private Long limit;

    @NotNull
    @Column(name = "percent")
    private Double percent;

    @OneToMany(mappedBy = "credit", cascade = CascadeType.ALL)
    private List<Bank> banks;

    @OneToMany(mappedBy = "credit", cascade = CascadeType.ALL)
    private List<CreditOffer> creditOffers;
}
