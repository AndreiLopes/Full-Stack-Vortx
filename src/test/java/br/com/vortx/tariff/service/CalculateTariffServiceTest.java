package br.com.vortx.tariff.service;

import br.com.vortx.tariff.dto.RequestDTO;
import br.com.vortx.tariff.dto.ResponseDTO;
import br.com.vortx.tariff.exception.InvalidDataException;
import br.com.vortx.tariff.model.Tariff;
import br.com.vortx.tariff.repository.TariffRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Optional;

@SpringBootTest
public class CalculateTariffServiceTest {

    @Autowired
    private CalculateTariffService service;

    @MockBean
    private TariffRepository repository;

    @Test
    public void plan30MinSuccessTest1() {

        Optional<Tariff> tariff = Optional.of(new Tariff(11, 16,
                BigDecimal.valueOf(1.90)));

        Mockito.when(repository.findByOriginAndDestiny(Mockito.any(Integer.class),
                Mockito.any(Integer.class)))
                .thenReturn(tariff);

        RequestDTO request = new RequestDTO(11, 16, 20D, 30);

        ResponseDTO result = service.calculateTariff(request);

        Assertions.assertThat(BigDecimal.valueOf(0.00)
                .setScale(2, RoundingMode.HALF_UP))
                .isEqualTo(result.getValueWithPlan());
        Assertions.assertThat(BigDecimal.valueOf(38.00)
                .setScale(2, RoundingMode.HALF_UP))
                .isEqualTo(result.getValueWithoutPlan());
    }

    @Test
    public void plan30MinSuccessTest2() {

        Optional<Tariff> tariff = Optional.of(new Tariff(11, 18,
                BigDecimal.valueOf(0.90)));

        Mockito.when(repository.findByOriginAndDestiny(Mockito.any(Integer.class),
                Mockito.any(Integer.class)))
                .thenReturn(tariff);

        RequestDTO request = new RequestDTO(11, 18, 50D, 30);

        ResponseDTO result = service.calculateTariff(request);

        Assertions.assertThat(BigDecimal.valueOf(19.80)
                .setScale(2, RoundingMode.HALF_UP))
                .isEqualTo(result.getValueWithPlan());
        Assertions.assertThat(BigDecimal.valueOf(45.00)
                .setScale(2, RoundingMode.HALF_UP))
                .isEqualTo(result.getValueWithoutPlan());
    }

    @Test
    public void plan30MinSuccessTest3() {

        Optional<Tariff> tariff = Optional.of(new Tariff(17, 11,
                BigDecimal.valueOf(2.70)));

        Mockito.when(repository.findByOriginAndDestiny(Mockito.any(Integer.class),
                Mockito.any(Integer.class)))
                .thenReturn(tariff);

        RequestDTO request = new RequestDTO(17, 11, 38.5D, 30);

        ResponseDTO result = service.calculateTariff(request);

        Assertions.assertThat(BigDecimal.valueOf(26.73)
                .setScale(2, RoundingMode.HALF_UP))
                .isEqualTo(result.getValueWithPlan());
        Assertions.assertThat(BigDecimal.valueOf(105.30)
                .setScale(2, RoundingMode.HALF_UP))
                .isEqualTo(result.getValueWithoutPlan());
    }


    @Test
    public void plan60MinSuccessTest1() {

        Optional<Tariff> tariff = Optional.of(new Tariff(11, 17,
                BigDecimal.valueOf(1.70)));

        Mockito.when(repository.findByOriginAndDestiny(Mockito.any(Integer.class),
                Mockito.any(Integer.class)))
                .thenReturn(tariff);

        RequestDTO request = new RequestDTO(11, 17, 80D, 60);

        ResponseDTO result = service.calculateTariff(request);

        Assertions.assertThat(BigDecimal.valueOf(37.40)
                .setScale(2, RoundingMode.HALF_UP))
                .isEqualTo(result.getValueWithPlan());
        Assertions.assertThat(BigDecimal.valueOf(136.00)
                .setScale(2, RoundingMode.HALF_UP))
                .isEqualTo(result.getValueWithoutPlan());

    }

    @Test
    public void plan60MinSuccessTest2() {

        Optional<Tariff> tariff = Optional.of(new Tariff(16, 11,
                BigDecimal.valueOf(2.90)));

        Mockito.when(repository.findByOriginAndDestiny(Mockito.any(Integer.class),
                Mockito.any(Integer.class)))
                .thenReturn(tariff);

        RequestDTO request = new RequestDTO(16, 11, 81D, 60);

        ResponseDTO result = service.calculateTariff(request);

        Assertions.assertThat(BigDecimal.valueOf(66.99)
                .setScale(2, RoundingMode.HALF_UP))
                .isEqualTo(result.getValueWithPlan());
        Assertions.assertThat(BigDecimal.valueOf(234.90)
                .setScale(2, RoundingMode.HALF_UP))
                .isEqualTo(result.getValueWithoutPlan());

    }

    @Test
    public void plan60MinSuccessTest3() {

        Optional<Tariff> tariff = Optional.of(new Tariff(18, 11,
                BigDecimal.valueOf(1.90)));

        Mockito.when(repository.findByOriginAndDestiny(Mockito.any(Integer.class),
                Mockito.any(Integer.class)))
                .thenReturn(tariff);

        RequestDTO request = new RequestDTO(18, 11, 53D, 60);

        ResponseDTO result = service.calculateTariff(request);

        Assertions.assertThat(BigDecimal.valueOf(0.00)
                .setScale(2, RoundingMode.HALF_UP))
                .isEqualTo(result.getValueWithPlan());
        Assertions.assertThat(BigDecimal.valueOf(100.70)
                .setScale(2, RoundingMode.HALF_UP))
                .isEqualTo(result.getValueWithoutPlan());

    }

    @Test
    public void plan120MinSuccessTest1() {

        Optional<Tariff> tariff = Optional.of(new Tariff(18, 11,
                BigDecimal.valueOf(1.90)));

        Mockito.when(repository.findByOriginAndDestiny(Mockito.any(Integer.class),
                Mockito.any(Integer.class)))
                .thenReturn(tariff);

        RequestDTO request = new RequestDTO(18, 11, 200D, 120);

        ResponseDTO result = service.calculateTariff(request);

        Assertions.assertThat(BigDecimal.valueOf(167.20)
                .setScale(2, RoundingMode.HALF_UP))
                .isEqualTo(result.getValueWithPlan());
        Assertions.assertThat(BigDecimal.valueOf(380.00)
                .setScale(2, RoundingMode.HALF_UP))
                .isEqualTo(result.getValueWithoutPlan());

    }

    @Test
    public void plan120MinSuccessTest2() {

        Optional<Tariff> tariff = Optional.of(new Tariff(11, 17,
                BigDecimal.valueOf(1.70)));

        Mockito.when(repository.findByOriginAndDestiny(Mockito.any(Integer.class),
                Mockito.any(Integer.class)))
                .thenReturn(tariff);

        RequestDTO request = new RequestDTO(11, 17, 158D, 120);

        ResponseDTO result = service.calculateTariff(request);

        Assertions.assertThat(BigDecimal.valueOf(71.06)
                .setScale(2, RoundingMode.HALF_UP))
                .isEqualTo(result.getValueWithPlan());
        Assertions.assertThat(BigDecimal.valueOf(268.60)
                .setScale(2, RoundingMode.HALF_UP))
                .isEqualTo(result.getValueWithoutPlan());

    }

    @Test
    public void plan120MinSuccessTest3() {

        Optional<Tariff> tariff = Optional.of(new Tariff(11, 18,
                BigDecimal.valueOf(0.90)));

        Mockito.when(repository.findByOriginAndDestiny(Mockito.any(Integer.class),
                Mockito.any(Integer.class)))
                .thenReturn(tariff);

        RequestDTO request = new RequestDTO(11, 18, 95D, 120);

        ResponseDTO result = service.calculateTariff(request);

        Assertions.assertThat(BigDecimal.valueOf(0.00)
                .setScale(2, RoundingMode.HALF_UP))
                .isEqualTo(result.getValueWithPlan());
        Assertions.assertThat(BigDecimal.valueOf(85.50)
                .setScale(2, RoundingMode.HALF_UP))
                .isEqualTo(result.getValueWithoutPlan());

    }

    @Test
    public void invalidPlanErrorTest() {

        RequestDTO request = new RequestDTO(11, 16, 35D, 40);

        try {
            service.calculateTariff(request);

        } catch (Exception e) {
            Assertions.assertThat(InvalidDataException.class)
                    .isEqualTo(e.getClass());
            Assertions.assertThat("Plano Inválido.")
                    .isEqualTo(e.getMessage());
        }
    }

    @Test
    public void invalidOriginAndDestinyErrorTest() {

        RequestDTO request = new RequestDTO(18, 17, 100D, 30);

        try {
            service.calculateTariff(request);

        } catch (Exception e) {
            Assertions.assertThat(InvalidDataException.class)
                    .isEqualTo(e.getClass());
            Assertions.assertThat("DDDs de Origem e Destino não encontrados.")
                    .isEqualTo(e.getMessage());
        }
    }
}
