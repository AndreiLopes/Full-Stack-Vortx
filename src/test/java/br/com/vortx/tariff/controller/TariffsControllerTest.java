package br.com.vortx.tariff.controller;

import br.com.vortx.tariff.common.Utils;
import br.com.vortx.tariff.constants.UniversalConstants;
import br.com.vortx.tariff.dto.RequestDTO;
import br.com.vortx.tariff.dto.ResponseDTO;
import br.com.vortx.tariff.exception.ExceptionResponse;
import br.com.vortx.tariff.exception.InvalidDataException;
import br.com.vortx.tariff.model.Tariff;
import br.com.vortx.tariff.repository.TariffRepository;
import br.com.vortx.tariff.service.CalculateTariffService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TariffsControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private TariffRepository repository;

    @MockBean
    private CalculateTariffService service;

    @Test
    public void tariffWithStatusCode200Success() throws Exception {

        Optional<Tariff> mockTariff = Optional.of(new Tariff(11, 16, BigDecimal.valueOf(1.9)));

        Mockito.when(repository.findByOriginAndDestiny(
                Mockito.any(Integer.class), Mockito.any(Integer.class)))
                .thenReturn(mockTariff);

        ResponseDTO expectedResponseDTO = new ResponseDTO(BigDecimal.valueOf(0.00),
                BigDecimal.valueOf(38.00));

        Mockito.when(service.calculateTariff(Mockito.any(RequestDTO.class)))
                .thenReturn(expectedResponseDTO);

        RequestDTO requestDTO = new RequestDTO(11, 16, 20D, 30);

        mvc.perform(post(UniversalConstants.TARIFF_URL)
                .content(Utils.asJsonString(requestDTO))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status()
                        .isOk())
                .andExpect(content()
                        .json(Utils
                                .asJsonString(expectedResponseDTO)));
    }

    @Test
    public void postTariffWithStatusCode400Test1() throws Exception {

        Mockito.when(service.calculateTariff(Mockito.any(RequestDTO.class)))
                .thenThrow(new InvalidDataException(UniversalConstants.INVALID_PLAN_ERROR));

        ExceptionResponse expectedResponse = new ExceptionResponse(Utils.getStringWithLocalDateTime(),
                "Plano Inválido.", "uri=/tariffs");

        RequestDTO request = new RequestDTO(11, 16, 20D, 50);

        mvc.perform(post(UniversalConstants.TARIFF_URL)
                .content(Utils.asJsonString(request))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status()
                        .isBadRequest())
                .andExpect(content()
                        .json(Utils.asJsonString(expectedResponse)));
    }

    @Test
    public void postTariffWithStatusCode400Test2() throws Exception {

        Mockito.when(service.calculateTariff(Mockito.any(RequestDTO.class)))
                .thenThrow(new InvalidDataException(UniversalConstants.DDD_NOT_FOUND_ERROR));

        ExceptionResponse expectedResponse = new ExceptionResponse(Utils.getStringWithLocalDateTime(),
                "DDDs de Origem e Destino não encontrados.", "uri=/tariffs");

        RequestDTO request = new RequestDTO(11, 16, 20D, 50);

        mvc.perform(post(UniversalConstants.TARIFF_URL)
                .content(Utils.asJsonString(request))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status()
                        .isBadRequest())
                .andExpect(content()
                        .json(Utils.asJsonString(expectedResponse)));
    }
}