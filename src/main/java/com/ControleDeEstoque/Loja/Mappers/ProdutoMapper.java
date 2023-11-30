package com.ControleDeEstoque.Loja.Mappers;

import com.ControleDeEstoque.Loja.Dtos.ProdutoRequestDto;
import com.ControleDeEstoque.Loja.Dtos.ProdutoResponseDto;
import com.ControleDeEstoque.Loja.Entidades.Produto;

public class ProdutoMapper {

    public static Produto produtoRequestToProduto(ProdutoRequestDto produto){

        Produto outProduto = new Produto();

        outProduto.setId(produto.getId());
        outProduto.setCodigoEan(produto.getCodigoEan());
        outProduto.setNome(produto.getNome());
        outProduto.setDescricao(produto.getDescricao());

        return outProduto;
    }

    public static ProdutoResponseDto produtoToProdutoResponse(Produto produto){

        ProdutoResponseDto outProduto = new ProdutoResponseDto();

        outProduto.setId(produto.getId());
        outProduto.setCodigoEan(produto.getCodigoEan());
        outProduto.setNome(produto.getNome());
        outProduto.setDescricao(produto.getDescricao());

        return outProduto;
    }
}
