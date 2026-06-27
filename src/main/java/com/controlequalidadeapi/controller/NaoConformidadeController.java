package com.controlequalidadeapi.controller;

import com.controlequalidadeapi.dto.NaoConformidadeRequestDTO;
import com.controlequalidadeapi.dto.NaoConformidadeResponseDTO;
import com.controlequalidadeapi.service.NaoConformidadeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "NaoConformidade", description = "Gerenciamento de naoconformidades")
@RestController
@RequestMapping("/api/naoconformidades")
public class NaoConformidadeController {

    @Autowired
    private NaoConformidadeService service;

    @Operation(summary = "Listar todos os NaoConformidade")
    @GetMapping
    public List<NaoConformidadeResponseDTO> listar(@RequestParam(required = false) String descricao, @RequestParam(required = false) Long loteId) {
        List<NaoConformidadeResponseDTO> resultado = service.listar();
        if (descricao != null && !descricao.isBlank()) {
            resultado = resultado.stream().filter(item -> item.getDescricao() != null &&
                item.getDescricao().toLowerCase().contains(descricao.toLowerCase()))
                .collect(java.util.stream.Collectors.toList());
        }
        if (loteId != null) {
            resultado = resultado.stream().filter(item -> loteId.equals(item.getLoteId())).collect(java.util.stream.Collectors.toList());
        }
        return resultado;
    }

    @Operation(summary = "Buscar NaoConformidade por ID")
    @GetMapping("/{id}")
    public NaoConformidadeResponseDTO buscar(@PathVariable Long id) { return service.buscar(id); }

    @Operation(summary = "Criar NaoConformidade")
    @PostMapping
    public ResponseEntity<NaoConformidadeResponseDTO> criar(@Valid @RequestBody NaoConformidadeRequestDTO naoConformidade) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(naoConformidade));
    }

    @Operation(summary = "Atualizar NaoConformidade")
    @PutMapping("/{id}")
    public NaoConformidadeResponseDTO atualizar(@PathVariable Long id, @Valid @RequestBody NaoConformidadeRequestDTO naoConformidade) {
        return service.atualizar(id, naoConformidade);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Excluir NaoConformidade")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
