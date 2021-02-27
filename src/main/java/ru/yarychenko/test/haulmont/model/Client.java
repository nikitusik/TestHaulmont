package ru.yarychenko.test.haulmont.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "client")
public class Client extends BasicEntity {

    @NotBlank
    @Column(name = "first_name")
    private String firstName;

    @NotBlank
    @Column(name = "middle_name")
    private String middleName;

    @NotBlank
    @Column(name = "last_name")
    private String lastName;

    @NotNull
    @Column(name = "mobile_phone")
    private Long mobilePhone;

    @NotBlank
    @Email
    @Column(name = "email")
    private String email;

    @NotNull
    @Column(name = "passport")
    private Long passport;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Bank> banks;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<CreditOffer> creditOffers;
}
