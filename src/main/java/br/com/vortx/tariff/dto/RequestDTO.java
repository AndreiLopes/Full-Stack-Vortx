package br.com.vortx.tariff.dto;

import lombok.Data;

/**
 * Class that represents a request dto
 */
@Data
public class RequestDTO {

    private Integer origin;
    private Integer destiny;
    private Double minutes;
    private Integer plan;

    public RequestDTO() {
    }

    public RequestDTO(Integer origin, Integer destiny, Double minutes, Integer plan) {
        this.origin = origin;
        this.destiny = destiny;
        this.minutes = minutes;
        this.plan = plan;
    }
}