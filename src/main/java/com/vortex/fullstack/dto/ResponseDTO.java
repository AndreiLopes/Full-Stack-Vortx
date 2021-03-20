package com.vortex.fullstack.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ResponseDTO {

    private BigDecimal valueWithPlan;
    private BigDecimal valueWithoutPlan;


    public ResponseDTO(BigDecimal valueWithPlan, BigDecimal valueWithoutPlan) {
        this.valueWithPlan = valueWithPlan;
        this.valueWithoutPlan = valueWithoutPlan;
    }
}
