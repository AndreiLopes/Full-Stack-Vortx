package com.vortex.fullstack.repository;

import com.vortex.fullstack.model.Tax;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaxRepository extends JpaRepository<Tax, Long> {

    Optional<Tax> findByOriginAndDestiny(Integer origin, Integer destiny);
}
