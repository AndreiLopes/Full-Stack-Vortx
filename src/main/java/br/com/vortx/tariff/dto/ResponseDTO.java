package br.com.vortx.tariff.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Class that represents a response dto
 */
@Data
public class ResponseDTO {

    private BigDecimal valueWithPlan;
    private BigDecimal valueWithoutPlan;

    public ResponseDTO() { }

    public ResponseDTO(BigDecimal valueWithPlan, BigDecimal valueWithoutPlan) {
        this.valueWithPlan = valueWithPlan;
        this.valueWithoutPlan = valueWithoutPlan;
    }
}
