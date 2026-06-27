package com.controlequalidadeapi.dto;

import jakarta.validation.constraints.*;

public class NaoConformidadeRequestDTO {

    @NotNull(message = "LoteId é obrigatório")
    @Positive(message = "LoteId deve ser um ID válido (positivo)")
    private Long loteId;
    @NotBlank(message = "descricao não pode estar em branco")
    private String descricao;
    @NotBlank(message = "categoria não pode estar em branco")
    private String categoria;
    @NotBlank(message = "severidade não pode estar em branco")
    private String severidade;
    @NotBlank(message = "acao não pode estar em branco")
    private String acao;
    @NotBlank(message = "responsavel não pode estar em branco")
    private String responsavel;
    @NotNull(message = "prazo não pode ser nulo")
    private java.time.LocalDateTime prazo;
    @NotBlank(message = "status não pode estar em branco")
    private String status;

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
