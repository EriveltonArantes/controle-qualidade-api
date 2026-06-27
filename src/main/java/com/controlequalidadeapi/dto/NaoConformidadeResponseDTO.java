package com.controlequalidadeapi.dto;

public class NaoConformidadeResponseDTO {

    private Long id;
    private Long loteId;
    private String descricao;
    private String categoria;
    private String severidade;
    private String acao;
    private String responsavel;
    private java.time.LocalDateTime prazo;
    private String status;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getLoteId() { return loteId; }
    public void setLoteId(Long loteId) { this.loteId = loteId; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
    public String getSeveridade() { return severidade; }
    public void setSeveridade(String severidade) { this.severidade = severidade; }
    public String getAcao() { return acao; }
    public void setAcao(String acao) { this.acao = acao; }
    public String getResponsavel() { return responsavel; }
    public void setResponsavel(String responsavel) { this.responsavel = responsavel; }
    public java.time.LocalDateTime getPrazo() { return prazo; }
    public void setPrazo(java.time.LocalDateTime prazo) { this.prazo = prazo; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
