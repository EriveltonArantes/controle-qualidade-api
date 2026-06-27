package com.controlequalidadeapi.dto;

import jakarta.validation.constraints.*;

public class LoteProducaoRequestDTO {

    @NotNull(message = "ProdutoId é obrigatório")
    @Positive(message = "ProdutoId deve ser um ID válido (positivo)")
    private Long produtoId;
    @NotBlank(message = "numero não pode estar em branco")
    private String numero;
    @NotNull(message = "data producao não pode ser nulo")
    private java.time.LocalDateTime dataProducao;
    @Min(value = 0, message = "quantidade não pode ser negativo")
    @NotNull(message = "quantidade não pode ser nulo")
    private Long quantidade;
    @NotBlank(message = "status não pode estar em branco")
    private String status;

    private String observacoes;

    public Long getProdutoId() { return produtoId; }
    public void setProdutoId(Long produtoId) { this.produtoId = produtoId; }
    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }
    public java.time.LocalDateTime getDataProducao() { return dataProducao; }
    public void setDataProducao(java.time.LocalDateTime dataProducao) { this.dataProducao = dataProducao; }
    public Long getQuantidade() { return quantidade; }
    public void setQuantidade(Long quantidade) { this.quantidade = quantidade; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getObservacoes() { return observacoes; }
    public void setObservacoes(String observacoes) { this.observacoes = observacoes; }
}
