package com.vortex.fullstack.controller;

import com.vortex.fullstack.dto.RequestDTO;
import com.vortex.fullstack.dto.ResponseDTO;
import com.vortex.fullstack.service.CalculateTaxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculateTaxController {

    @Autowired
    private CalculateTaxService service;

    @PostMapping
    public ResponseDTO calculateTax(@RequestBody RequestDTO dto){

        return service.calculateTax(dto);
    }
}
