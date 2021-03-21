package br.com.vortx.tariff.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Class Entity that represents the tariffs according to plans.
 */
@Data
@Entity
@Table(name = "tariffs")
public class Tariff {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "origin")
    private Integer origin;

    @Column(name = "destiny")
    private Integer destiny;

    @Column(name = "value_by_minutes")
    private BigDecimal value;

    public Tariff(Integer origin, Integer destiny, BigDecimal value) {

        this.origin = origin;
        this.destiny = destiny;
        this.value = value;
    }

    public Tariff() {
    }
}
