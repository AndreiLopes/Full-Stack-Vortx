package br.com.vortx.tariff.service;

import br.com.vortx.tariff.enumeration.PlanEnum;
import br.com.vortx.tariff.constants.UniversalConstants;
import br.com.vortx.tariff.dto.RequestDTO;
import br.com.vortx.tariff.dto.ResponseDTO;
import br.com.vortx.tariff.exception.InvalidDataException;
import br.com.vortx.tariff.model.Tariff;
import br.com.vortx.tariff.repository.TariffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Optional;

/**
 * Service class for calculating tariffs according to each plan.
 */
@Service
public class CalculateTariffService {

    @Autowired
    private TariffRepository repository;

    public ResponseDTO calculateTariff(RequestDTO dto) {

        if (!isPlanValid(dto.getPlan())) {
            throw new InvalidDataException(UniversalConstants.INVALID_PLAN_ERROR);
        }

        Optional<Tariff> tariff = getFixedTariff(dto.getOrigin(), dto.getDestiny());
        tariff.orElseThrow(() -> new InvalidDataException(UniversalConstants.DDD_NOT_FOUND_ERROR));

        Double minutes = Math.ceil(dto.getMinutes());

        BigDecimal valueWithPlan = calculateValueTariffWithTalkMore(tariff.get().getValue(),
                minutes, dto.getPlan());

        BigDecimal valueWithoutPlan = calculateValueTariffWithoutTalkMore(tariff.get().getValue(),
                minutes);

        return new ResponseDTO(valueWithPlan,valueWithoutPlan);
    }

    private BigDecimal calculateValueTariffWithTalkMore(BigDecimal value, Double minutes, Integer plan) {

        Double extraMinutes = minutes - plan.doubleValue();

        if (extraMinutes.compareTo(Double.valueOf(0)) < 0) {
            extraMinutes = 0D;
        }

        BigDecimal total = value.add(value.multiply(BigDecimal.valueOf(0.1)))
                .multiply(BigDecimal.valueOf(extraMinutes))
                .setScale(2, RoundingMode.HALF_UP);

        return total;
    }

    private BigDecimal calculateValueTariffWithoutTalkMore(BigDecimal value, Double minutes) {

        BigDecimal total = value.multiply(BigDecimal.valueOf(minutes))
                .setScale(2, RoundingMode.HALF_UP);

        return total;
    }


    private Optional<Tariff> getFixedTariff(Integer origin, Integer destiny) {

        return repository.findByOriginAndDestiny(origin, destiny);
    }

    private boolean isPlanValid(Integer plan) {

        if (plan.equals(PlanEnum.TALK_MORE_30.getValue()) ||
                plan.equals(PlanEnum.TALK_MORE_60.getValue()) ||
                plan.equals(PlanEnum.TALK_MORE_120.getValue())) {

            return true;
        }
        return false;
    }
}