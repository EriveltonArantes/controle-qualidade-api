package com.controlequalidadeapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "naoconformidades")
public class NaoConformidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "lote_id")
    private LoteProducao lote;
    @Column(columnDefinition = "TEXT", nullable = false)
    private String descricao;
    @Column(nullable = false)
    private String categoria;
    @Column(nullable = false)
    private String severidade;
    @Column(nullable = false)
    private String acao;
    @Column(nullable = false)
    private String responsavel;
    private java.time.LocalDateTime prazo;
    @Column(nullable = false)
    private String status;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LoteProducao getLote() { return lote; }
    public void setLote(LoteProducao lote) { this.lote = lote; }
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
