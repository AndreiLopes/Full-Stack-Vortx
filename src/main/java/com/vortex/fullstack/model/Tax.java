package com.vortex.fullstack.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "taxes")
public class Tax {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "origin")
    private Integer origin;

    @Column(name = "destiny")
    private Integer destiny;

    @Column(name = "value_minutes")
    private BigDecimal value;

    public Tax(Integer origin, Integer destiny, BigDecimal value) {

        this.origin = origin;
        this.destiny = destiny;
        this.value = value;
    }
}
