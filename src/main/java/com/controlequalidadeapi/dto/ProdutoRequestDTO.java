package com.controlequalidadeapi.dto;

import jakarta.validation.constraints.*;

public class ProdutoRequestDTO {

    @NotBlank(message = "nome não pode estar em branco")
    private String nome;
    @NotBlank(message = "descricao não pode estar em branco")
    private String descricao;
    @NotBlank(message = "categoria não pode estar em branco")
    private String categoria;
    @NotBlank(message = "unidade não pode estar em branco")
    private String unidade;
    @NotNull(message = "peso não pode ser nulo")
    private Double peso;
    @NotBlank(message = "especificacoes não pode estar em branco")
    private String especificacoes;
    @NotNull(message = "ativo não pode ser nulo")
    private Boolean ativo;

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
