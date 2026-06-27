package com.controlequalidadeapi.mapper;

import com.controlequalidadeapi.dto.ProdutoRequestDTO;
import com.controlequalidadeapi.dto.ProdutoResponseDTO;
import com.controlequalidadeapi.model.Produto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProdutoMapper {

    Produto toEntity(ProdutoRequestDTO dto);

    ProdutoResponseDTO toResponseDTO(Produto entity);
}
