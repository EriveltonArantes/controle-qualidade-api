package com.controlequalidadeapi.service;

import com.controlequalidadeapi.dto.LoteProducaoRequestDTO;
import com.controlequalidadeapi.dto.LoteProducaoResponseDTO;
import com.controlequalidadeapi.exception.ResourceNotFoundException;
import com.controlequalidadeapi.mapper.LoteProducaoMapper;
import com.controlequalidadeapi.model.LoteProducao;
import com.controlequalidadeapi.repository.LoteProducaoRepository;
import com.controlequalidadeapi.repository.ProdutoRepository;
import com.controlequalidadeapi.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class LoteProducaoService {

    @Autowired
    private LoteProducaoRepository repository;

    @Autowired
    private LoteProducaoMapper mapper;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Transactional(readOnly = true)
    public List<LoteProducaoResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public LoteProducaoResponseDTO buscar(Long id) {
        LoteProducao entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("LoteProducao não encontrado com id: " + id));
        return mapper.toResponseDTO(entity);
    }

    public LoteProducaoResponseDTO criar(LoteProducaoRequestDTO dto) {
        LoteProducao entity = mapper.toEntity(dto);
        Produto produto = produtoRepository.findById(dto.getProdutoId())
            .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado com id: " + dto.getProdutoId()));
        entity.setProduto(produto);
        LoteProducao salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public LoteProducaoResponseDTO atualizar(Long id, LoteProducaoRequestDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("LoteProducao não encontrado com id: " + id);
        }
        LoteProducao entity = mapper.toEntity(dto);
        entity.setId(id);
        Produto produto = produtoRepository.findById(dto.getProdutoId())
            .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado com id: " + dto.getProdutoId()));
        entity.setProduto(produto);
        LoteProducao salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("LoteProducao não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}
