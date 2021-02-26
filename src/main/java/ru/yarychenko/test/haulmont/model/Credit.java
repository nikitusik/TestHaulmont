package ru.yarychenko.test.haulmont.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.*;

@NoArgsConstructor
@Data
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
}
