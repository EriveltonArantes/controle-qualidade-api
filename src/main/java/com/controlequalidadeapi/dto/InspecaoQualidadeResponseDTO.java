package com.controlequalidadeapi.dto;

public class InspecaoQualidadeResponseDTO {

    private Long id;
    private Long loteId;
    private String inspector;
    private java.time.LocalDateTime dataInspecao;
    private Integer totalAmostras;
    private Integer aprovadas;
    private Integer reprovadas;
    private String resultado;
    private String observacoes;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
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
