package com.controlequalidadeapi.repository;

import com.controlequalidadeapi.model.InspecaoQualidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InspecaoQualidadeRepository extends JpaRepository<InspecaoQualidade, Long> {
}
