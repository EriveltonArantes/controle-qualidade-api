package com.controlequalidadeapi.mapper;

import com.controlequalidadeapi.dto.InspecaoQualidadeRequestDTO;
import com.controlequalidadeapi.dto.InspecaoQualidadeResponseDTO;
import com.controlequalidadeapi.model.InspecaoQualidade;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface InspecaoQualidadeMapper {

    @Mapping(target = "lote", ignore = true)
    InspecaoQualidade toEntity(InspecaoQualidadeRequestDTO dto);

    @Mapping(target = "loteId", source = "lote.id")
    InspecaoQualidadeResponseDTO toResponseDTO(InspecaoQualidade entity);
}
