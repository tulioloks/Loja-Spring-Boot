package com.ControleDeEstoque.Loja.Dtos;

import com.ControleDeEstoque.Loja.Entidades.Loja;
import com.ControleDeEstoque.Loja.Entidades.Produto;

public class EstoqueRequestDto{

    private Long id;
    private LojaRequestDto loja;
    private ProdutoRequestDto produto;
    private Integer quantidade;

    public LojaRequestDto getLoja() {
        return loja;
    }

    public void setLoja(LojaRequestDto loja) {
        this.loja = loja;
    }

    public ProdutoRequestDto getProduto() {
        return produto;
    }

    public void setProduto(ProdutoRequestDto produto) {
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
