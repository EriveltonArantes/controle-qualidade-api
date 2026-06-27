package com.controlequalidadeapi.mapper;

import com.controlequalidadeapi.dto.LoteProducaoRequestDTO;
import com.controlequalidadeapi.dto.LoteProducaoResponseDTO;
import com.controlequalidadeapi.model.LoteProducao;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LoteProducaoMapper {

    @Mapping(target = "produto", ignore = true)
    LoteProducao toEntity(LoteProducaoRequestDTO dto);

    @Mapping(target = "produtoId", source = "produto.id")
    LoteProducaoResponseDTO toResponseDTO(LoteProducao entity);
}
