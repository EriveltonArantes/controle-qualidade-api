package com.controlequalidadeapi.controller;

import com.controlequalidadeapi.model.Produto;
import com.controlequalidadeapi.model.LoteProducao;
import com.controlequalidadeapi.model.InspecaoQualidade;
import com.controlequalidadeapi.model.NaoConformidade;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@Tag(name = "Dashboard", description = "KPIs e totais do sistema")
@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    @Autowired
    private com.controlequalidadeapi.repository.ProdutoRepository produtoRepository;

    @Autowired
    private com.controlequalidadeapi.repository.LoteProducaoRepository loteProducaoRepository;

    @Autowired
    private com.controlequalidadeapi.repository.InspecaoQualidadeRepository inspecaoQualidadeRepository;

    @Autowired
    private com.controlequalidadeapi.repository.NaoConformidadeRepository naoConformidadeRepository;

    @Operation(summary = "Resumo com totais, somas e gráficos de status")
    @Transactional(readOnly = true)
    @GetMapping("/resumo")
    public Map<String, Object> resumo() {
        Map<String, Object> resumo = new LinkedHashMap<>();
        resumo.put("totalProduto", produtoRepository.count());
        resumo.put("somaPesoProduto", produtoRepository.findAll().stream().filter(e -> e.getPeso() != null).mapToDouble(e -> e.getPeso()).sum());
        resumo.put("totalLoteProducao", loteProducaoRepository.count());
        resumo.put("somaQuantidadeLoteProducao", loteProducaoRepository.findAll().stream().filter(e -> e.getQuantidade() != null).mapToLong(e -> e.getQuantidade()).sum());
        resumo.put("graficoLoteProducao", loteProducaoRepository.findAll().stream()
            .collect(java.util.stream.Collectors.groupingBy(
                item -> String.valueOf(item.getStatus()),
                java.util.LinkedHashMap::new,
                java.util.stream.Collectors.counting())));
        resumo.put("totalInspecaoQualidade", inspecaoQualidadeRepository.count());
        resumo.put("somaTotalAmostrasInspecaoQualidade", inspecaoQualidadeRepository.findAll().stream().filter(e -> e.getTotalAmostras() != null).mapToInt(e -> e.getTotalAmostras()).sum());
        resumo.put("totalNaoConformidade", naoConformidadeRepository.count());
        resumo.put("graficoNaoConformidade", naoConformidadeRepository.findAll().stream()
            .collect(java.util.stream.Collectors.groupingBy(
                item -> String.valueOf(item.getStatus()),
                java.util.LinkedHashMap::new,
                java.util.stream.Collectors.counting())));
        return resumo;
    }
}
