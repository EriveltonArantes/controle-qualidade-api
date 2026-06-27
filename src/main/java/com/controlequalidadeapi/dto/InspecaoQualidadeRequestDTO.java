package com.controlequalidadeapi.dto;

import jakarta.validation.constraints.*;

public class InspecaoQualidadeRequestDTO {

    @NotNull(message = "LoteId é obrigatório")
    @Positive(message = "LoteId deve ser um ID válido (positivo)")
    private Long loteId;
    @NotBlank(message = "inspector não pode estar em branco")
    private String inspector;
    @NotNull(message = "data inspecao não pode ser nulo")
    private java.time.LocalDateTime dataInspecao;
    @NotNull(message = "total amostras não pode ser nulo")
    private Integer totalAmostras;
    @NotNull(message = "aprovadas não pode ser nulo")
    private Integer aprovadas;
    @NotNull(message = "reprovadas não pode ser nulo")
    private Integer reprovadas;
    @NotBlank(message = "resultado não pode estar em branco")
    private String resultado;

    private String observacoes;

    public Long getLoteId() { return loteId; }
    public void setLoteId(Long loteId) { this.loteId = loteId; }
    public String getInspector() { return inspector; }
    public void setInspector(String inspector) { this.inspector = inspector; }
    public java.time.LocalDateTime getDataInspecao() { return dataInspecao; }
    public void setDataInspecao(java.time.LocalDateTime dataInspecao) { this.dataInspecao = dataInspecao; }
    public Integer getTotalAmostras() { return totalAmostras; }
    public void setTotalAmostras(Integer totalAmostras) { this.totalAmostras = totalAmostras; }
    public Integer getAprovadas() { return aprovadas; }
    public void setAprovadas(Integer aprovadas) { this.aprovadas = aprovadas; }
    public Integer getReprovadas() { return reprovadas; }
    public void setReprovadas(Integer reprovadas) { this.reprovadas = reprovadas; }
    public String getResultado() { return resultado; }
    public void setResultado(String resultado) { this.resultado = resultado; }
    public String getObservacoes() { return observacoes; }
    public void setObservacoes(String observacoes) { this.observacoes = observacoes; }
}
