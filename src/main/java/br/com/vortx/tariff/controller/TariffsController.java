package br.com.vortx.tariff.controller;

import br.com.vortx.tariff.constants.UniversalConstants;
import br.com.vortx.tariff.dto.RequestDTO;
import br.com.vortx.tariff.dto.ResponseDTO;
import br.com.vortx.tariff.service.CalculateTariffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Controller class for tariffs calculation, with the verb Post.
 */
@RestController
@RequestMapping(UniversalConstants.TARIFF_URL)
public class TariffsController {

    @Autowired
    private CalculateTariffService service;

    @PostMapping
    public ResponseDTO calculateTariff(@RequestBody RequestDTO dto) {

        return service.calculateTariff(dto);
    }
}
