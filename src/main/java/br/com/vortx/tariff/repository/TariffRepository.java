package br.com.vortx.tariff.repository;

import br.com.vortx.tariff.model.Tariff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TariffRepository extends JpaRepository<Tariff, Long> {

    Optional<Tariff> findByOriginAndDestiny(Integer origin, Integer destiny);
}
