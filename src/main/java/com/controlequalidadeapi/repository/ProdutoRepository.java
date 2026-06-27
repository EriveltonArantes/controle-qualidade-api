package com.controlequalidadeapi.repository;

import com.controlequalidadeapi.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
