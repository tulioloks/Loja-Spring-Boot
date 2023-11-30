package com.ControleDeEstoque.Loja.Mappers;

import com.ControleDeEstoque.Loja.Dtos.EstoqueRequestDto;
import com.ControleDeEstoque.Loja.Dtos.EstoqueResponseDto;
import com.ControleDeEstoque.Loja.Dtos.LojaResponseDto;
import com.ControleDeEstoque.Loja.Dtos.ProdutoResponseDto;
import com.ControleDeEstoque.Loja.Entidades.Estoque;
import com.ControleDeEstoque.Loja.Entidades.Loja;
import com.ControleDeEstoque.Loja.Entidades.Produto;

import java.util.List;

public class EstoqueMapper {


    public static EstoqueResponseDto estoqueRequestToEstoque(Estoque estoque){

        EstoqueResponseDto out = new EstoqueResponseDto();
        LojaResponseDto outLoja = new LojaResponseDto();
        ProdutoResponseDto outProduto = new ProdutoResponseDto();

        //Loja
        outLoja.setResponsavel(estoque.getLoja().getResponsavel());
        outLoja.setCnpj(estoque.getLoja().getCnpj());
        outLoja.setNome(estoque.getLoja().getNome());
        outLoja.setId(estoque.getLoja().getId());

        //Produto
        outProduto.setDescricao(estoque.getProduto().getDescricao());
        outProduto.setNome(estoque.getProduto().getNome());
        outProduto.setCodigoEan(estoque.getProduto().getCodigoEan());
        outProduto.setId(estoque.getProduto().getId());

        //Estoque
        out.setId(estoque.getId());
        out.setLoja(outLoja);
        out.setProduto(outProduto);
        out.setQuantidade(estoque.getQuantidade());

        return out;
    }

    public static Estoque estoqueRequestToEstoque(EstoqueRequestDto estoque){

        Estoque out = new Estoque();
        Produto outProduto = new Produto();
        Loja outLoja = new Loja();

        //Produto
        outProduto.setId(estoque.getProduto().getId());
        outProduto.setCodigoEan(estoque.getProduto().getCodigoEan());
        outProduto.setNome(estoque.getProduto().getNome());
        outProduto.setDescricao(estoque.getProduto().getDescricao());

        //Loja
        out.setId(estoque.getLoja().getId());
        outLoja.setCnpj(estoque.getLoja().getCnpj());
        outLoja.setNome(estoque.getLoja().getNome());
        outLoja.setResponsavel(estoque.getLoja().getResponsavel());

        //Estoque
        out.setId(estoque.getId());
        out.setQuantidade(estoque.getQuantidade());
        out.setLoja(outLoja);
        out.setProduto(outProduto);

        return out;
    }
}
