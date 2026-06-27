package com.controlequalidadeapi.controller;

import com.controlequalidadeapi.dto.InspecaoQualidadeRequestDTO;
import com.controlequalidadeapi.dto.InspecaoQualidadeResponseDTO;
import com.controlequalidadeapi.service.InspecaoQualidadeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "InspecaoQualidade", description = "Gerenciamento de inspecaoqualidades")
@RestController
@RequestMapping("/api/inspecaoqualidades")
public class InspecaoQualidadeController {

    @Autowired
    private InspecaoQualidadeService service;

    @Operation(summary = "Listar todos os InspecaoQualidade")
    @GetMapping
    public List<InspecaoQualidadeResponseDTO> listar(@RequestParam(required = false) String inspector, @RequestParam(required = false) Long loteId) {
        List<InspecaoQualidadeResponseDTO> resultado = service.listar();
        if (inspector != null && !inspector.isBlank()) {
            resultado = resultado.stream().filter(item -> item.getInspector() != null &&
                item.getInspector().toLowerCase().contains(inspector.toLowerCase()))
                .collect(java.util.stream.Collectors.toList());
        }
        if (loteId != null) {
            resultado = resultado.stream().filter(item -> loteId.equals(item.getLoteId())).collect(java.util.stream.Collectors.toList());
        }
        return resultado;
    }

    @Operation(summary = "Buscar InspecaoQualidade por ID")
    @GetMapping("/{id}")
    public InspecaoQualidadeResponseDTO buscar(@PathVariable Long id) { return service.buscar(id); }

    @Operation(summary = "Criar InspecaoQualidade")
    @PostMapping
    public ResponseEntity<InspecaoQualidadeResponseDTO> criar(@Valid @RequestBody InspecaoQualidadeRequestDTO inspecaoQualidade) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(inspecaoQualidade));
    }

    @Operation(summary = "Atualizar InspecaoQualidade")
    @PutMapping("/{id}")
    public InspecaoQualidadeResponseDTO atualizar(@PathVariable Long id, @Valid @RequestBody InspecaoQualidadeRequestDTO inspecaoQualidade) {
        return service.atualizar(id, inspecaoQualidade);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Excluir InspecaoQualidade")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
