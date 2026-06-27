package com.controlequalidadeapi.dto;

public class LoteProducaoResponseDTO {

    private Long id;
    private Long produtoId;
    private String numero;
    private java.time.LocalDateTime dataProducao;
    private Long quantidade;
    private String status;
    private String observacoes;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
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
