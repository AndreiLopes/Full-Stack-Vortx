package br.com.vortx.tariff.exception;

import lombok.Data;

import java.io.Serializable;

@Data
public class ExceptionResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private String dateTime;
    private String message;
    private String description;

    public ExceptionResponse(String dateTime, String message, String description) {

        super();
        this.dateTime = dateTime;
        this.message = message;
        this.description = description;
    }
}
