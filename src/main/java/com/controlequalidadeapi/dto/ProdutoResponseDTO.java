package com.controlequalidadeapi.dto;

public class ProdutoResponseDTO {

    private Long id;
    private String nome;
    private String descricao;
    private String categoria;
    private String unidade;
    private Double peso;
    private String especificacoes;
    private Boolean ativo;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
    public String getUnidade() { return unidade; }
    public void setUnidade(String unidade) { this.unidade = unidade; }
    public Double getPeso() { return peso; }
    public void setPeso(Double peso) { this.peso = peso; }
    public String getEspecificacoes() { return especificacoes; }
    public void setEspecificacoes(String especificacoes) { this.especificacoes = especificacoes; }
    public Boolean getAtivo() { return ativo; }
    public void setAtivo(Boolean ativo) { this.ativo = ativo; }
}
