package com.controlequalidadeapi.controller;

import com.controlequalidadeapi.dto.LoteProducaoRequestDTO;
import com.controlequalidadeapi.dto.LoteProducaoResponseDTO;
import com.controlequalidadeapi.service.LoteProducaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "LoteProducao", description = "Gerenciamento de loteproducaos")
@RestController
@RequestMapping("/api/loteproducaos")
public class LoteProducaoController {

    @Autowired
    private LoteProducaoService service;

    @Operation(summary = "Listar todos os LoteProducao")
    @GetMapping
    public List<LoteProducaoResponseDTO> listar(@RequestParam(required = false) String numero, @RequestParam(required = false) Long produtoId) {
        List<LoteProducaoResponseDTO> resultado = service.listar();
        if (numero != null && !numero.isBlank()) {
            resultado = resultado.stream().filter(item -> item.getNumero() != null &&
                item.getNumero().toLowerCase().contains(numero.toLowerCase()))
                .collect(java.util.stream.Collectors.toList());
        }
        if (produtoId != null) {
            resultado = resultado.stream().filter(item -> produtoId.equals(item.getProdutoId())).collect(java.util.stream.Collectors.toList());
        }
        return resultado;
    }

    @Operation(summary = "Buscar LoteProducao por ID")
    @GetMapping("/{id}")
    public LoteProducaoResponseDTO buscar(@PathVariable Long id) { return service.buscar(id); }

    @Operation(summary = "Criar LoteProducao")
    @PostMapping
    public ResponseEntity<LoteProducaoResponseDTO> criar(@Valid @RequestBody LoteProducaoRequestDTO loteProducao) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(loteProducao));
    }

    @Operation(summary = "Atualizar LoteProducao")
    @PutMapping("/{id}")
    public LoteProducaoResponseDTO atualizar(@PathVariable Long id, @Valid @RequestBody LoteProducaoRequestDTO loteProducao) {
        return service.atualizar(id, loteProducao);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Excluir LoteProducao")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
