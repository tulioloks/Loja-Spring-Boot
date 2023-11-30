package com.ControleDeEstoque.Loja.Mappers;

import com.ControleDeEstoque.Loja.Dtos.LojaRequestDto;
import com.ControleDeEstoque.Loja.Dtos.LojaResponseDto;
import com.ControleDeEstoque.Loja.Dtos.ProdutoRequestDto;
import com.ControleDeEstoque.Loja.Dtos.ProdutoResponseDto;
import com.ControleDeEstoque.Loja.Entidades.Loja;
import com.ControleDeEstoque.Loja.Entidades.Produto;

public  class LojaMapper {

    public static Loja lojaRequestToLoja(LojaRequestDto loja){

        Loja outLoja = new Loja();

        outLoja.setId(loja.getId());
        outLoja.setCnpj(loja.getCnpj());
        outLoja.setNome(loja.getNome());
        outLoja.setResponsavel(loja.getResponsavel());

        return outLoja;
    }

    public static LojaResponseDto lojaToProdutoResponse(Loja loja){

        LojaResponseDto outLoja = new LojaResponseDto();

        outLoja.setId(loja.getId());
        outLoja.setCnpj(loja.getCnpj());
        outLoja.setNome(loja.getNome());
        outLoja.setResponsavel(loja.getResponsavel());

        return outLoja;
    }
}
