package com.controlequalidadeapi.service;

import com.controlequalidadeapi.dto.NaoConformidadeRequestDTO;
import com.controlequalidadeapi.dto.NaoConformidadeResponseDTO;
import com.controlequalidadeapi.exception.ResourceNotFoundException;
import com.controlequalidadeapi.mapper.NaoConformidadeMapper;
import com.controlequalidadeapi.model.NaoConformidade;
import com.controlequalidadeapi.repository.NaoConformidadeRepository;
import com.controlequalidadeapi.repository.LoteProducaoRepository;
import com.controlequalidadeapi.model.LoteProducao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class NaoConformidadeService {

    @Autowired
    private NaoConformidadeRepository repository;

    @Autowired
    private NaoConformidadeMapper mapper;

    @Autowired
    private LoteProducaoRepository loteRepository;

    @Transactional(readOnly = true)
    public List<NaoConformidadeResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public NaoConformidadeResponseDTO buscar(Long id) {
        NaoConformidade entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("NaoConformidade não encontrado com id: " + id));
        return mapper.toResponseDTO(entity);
    }

    public NaoConformidadeResponseDTO criar(NaoConformidadeRequestDTO dto) {
        NaoConformidade entity = mapper.toEntity(dto);
        LoteProducao lote = loteRepository.findById(dto.getLoteId())
            .orElseThrow(() -> new ResourceNotFoundException("LoteProducao não encontrado com id: " + dto.getLoteId()));
        entity.setLote(lote);
        NaoConformidade salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public NaoConformidadeResponseDTO atualizar(Long id, NaoConformidadeRequestDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("NaoConformidade não encontrado com id: " + id);
        }
        NaoConformidade entity = mapper.toEntity(dto);
        entity.setId(id);
        LoteProducao lote = loteRepository.findById(dto.getLoteId())
            .orElseThrow(() -> new ResourceNotFoundException("LoteProducao não encontrado com id: " + dto.getLoteId()));
        entity.setLote(lote);
        NaoConformidade salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("NaoConformidade não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}
