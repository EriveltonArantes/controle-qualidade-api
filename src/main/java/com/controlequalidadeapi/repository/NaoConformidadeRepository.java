package com.controlequalidadeapi.repository;

import com.controlequalidadeapi.model.NaoConformidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NaoConformidadeRepository extends JpaRepository<NaoConformidade, Long> {
}
