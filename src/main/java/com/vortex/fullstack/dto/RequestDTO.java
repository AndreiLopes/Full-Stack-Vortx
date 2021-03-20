package com.vortex.fullstack.dto;

import lombok.Data;

/**
 * Class that represents request dto
 */
@Data
public class RequestDTO {

    private Integer origin;
    private Integer destiny;
    private Integer plan;
    private Double minutes;

    public RequestDTO(Integer origin, Integer destiny, Double minutes, Integer plan) {

        this.origin = origin;
        this.destiny = destiny;
        this.minutes = minutes;
        this.plan = plan;
    }
}