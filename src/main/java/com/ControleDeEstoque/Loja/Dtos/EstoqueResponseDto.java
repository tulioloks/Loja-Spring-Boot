package com.ControleDeEstoque.Loja.Dtos;

public class EstoqueResponseDto {

    private Long id;
    private LojaResponseDto loja;
    private ProdutoResponseDto produto;
    private Integer quantidade;

    public LojaResponseDto getLoja() {
        return loja;
    }

    public void setLoja(LojaResponseDto loja) {
        this.loja = loja;
    }

    public ProdutoResponseDto getProduto() {
        return produto;
    }

    public void setProduto(ProdutoResponseDto produto) {
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
