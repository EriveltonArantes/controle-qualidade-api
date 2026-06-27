package com.controlequalidadeapi.mapper;

import com.controlequalidadeapi.dto.NaoConformidadeRequestDTO;
import com.controlequalidadeapi.dto.NaoConformidadeResponseDTO;
import com.controlequalidadeapi.model.NaoConformidade;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface NaoConformidadeMapper {

    @Mapping(target = "lote", ignore = true)
    NaoConformidade toEntity(NaoConformidadeRequestDTO dto);

    @Mapping(target = "loteId", source = "lote.id")
    NaoConformidadeResponseDTO toResponseDTO(NaoConformidade entity);
}
