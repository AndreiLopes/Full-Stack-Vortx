package com.vortex.fullstack.service;

import com.vortex.fullstack.constants.GenericConstants;
import com.vortex.fullstack.dto.RequestDTO;
import com.vortex.fullstack.dto.ResponseDTO;
import com.vortex.fullstack.enumeration.PlanEnum;
import com.vortex.fullstack.exception.InvalidDataException;
import com.vortex.fullstack.model.Tax;
import com.vortex.fullstack.repository.TaxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Optional;

@Service
public class CalculateTaxService {

    @Autowired
    private TaxRepository repository;

    public ResponseDTO calculateTax(RequestDTO dto) {

        if (!isPlanValid(dto.getPlan())) {
            throw new InvalidDataException(GenericConstants.INVALID_PLAN_ERROR);
        }

        Optional<Tax> tax = getFixedTax(dto.getOrigin(), dto.getDestiny());
        tax.orElseThrow(() -> new InvalidDataException(GenericConstants.DDD_NOT_FOUND_ERROR));

        Double minutes = Math.ceil(dto.getMinutes());

        BigDecimal valueWithPlan = calculateValueTaxWithTalkMore(tax.get().getValue(),
                minutes, dto.getPlan());

        BigDecimal valueWithoutPlan = calculateValueTaxWithoutTalkMore(tax.get().getValue(),
                minutes);

        return new ResponseDTO(valueWithPlan,valueWithoutPlan);
    }

    private BigDecimal calculateValueTaxWithTalkMore(BigDecimal value, Double minutes, Integer plan) {

        Double extraMinutes = minutes - plan.doubleValue();

        if (extraMinutes.compareTo(Double.valueOf(0)) < 0) {
            extraMinutes = 0D;
        }

        BigDecimal total = value.add(value.multiply(BigDecimal.valueOf(0.1)))
                .multiply(BigDecimal.valueOf(extraMinutes))
                .setScale(2, RoundingMode.HALF_UP);

        return total;
    }

    private BigDecimal calculateValueTaxWithoutTalkMore(BigDecimal value, Double minutes) {

        BigDecimal total = value.multiply(BigDecimal.valueOf(minutes))
                .setScale(2, RoundingMode.HALF_UP);

        return total;
    }


    private Optional<Tax> getFixedTax(Integer origin, Integer destiny) {

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
