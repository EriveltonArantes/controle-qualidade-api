package com.controlequalidadeapi.service;

import com.controlequalidadeapi.dto.InspecaoQualidadeRequestDTO;
import com.controlequalidadeapi.dto.InspecaoQualidadeResponseDTO;
import com.controlequalidadeapi.exception.ResourceNotFoundException;
import com.controlequalidadeapi.mapper.InspecaoQualidadeMapper;
import com.controlequalidadeapi.model.InspecaoQualidade;
import com.controlequalidadeapi.repository.InspecaoQualidadeRepository;
import com.controlequalidadeapi.repository.LoteProducaoRepository;
import com.controlequalidadeapi.model.LoteProducao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class InspecaoQualidadeService {

    @Autowired
    private InspecaoQualidadeRepository repository;

    @Autowired
    private InspecaoQualidadeMapper mapper;

    @Autowired
    private LoteProducaoRepository loteRepository;

    @Transactional(readOnly = true)
    public List<InspecaoQualidadeResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public InspecaoQualidadeResponseDTO buscar(Long id) {
        InspecaoQualidade entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("InspecaoQualidade não encontrado com id: " + id));
        return mapper.toResponseDTO(entity);
    }

    public InspecaoQualidadeResponseDTO criar(InspecaoQualidadeRequestDTO dto) {
        InspecaoQualidade entity = mapper.toEntity(dto);
        LoteProducao lote = loteRepository.findById(dto.getLoteId())
            .orElseThrow(() -> new ResourceNotFoundException("LoteProducao não encontrado com id: " + dto.getLoteId()));
        entity.setLote(lote);
        InspecaoQualidade salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public InspecaoQualidadeResponseDTO atualizar(Long id, InspecaoQualidadeRequestDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("InspecaoQualidade não encontrado com id: " + id);
        }
        InspecaoQualidade entity = mapper.toEntity(dto);
        entity.setId(id);
        LoteProducao lote = loteRepository.findById(dto.getLoteId())
            .orElseThrow(() -> new ResourceNotFoundException("LoteProducao não encontrado com id: " + dto.getLoteId()));
        entity.setLote(lote);
        InspecaoQualidade salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("InspecaoQualidade não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}
