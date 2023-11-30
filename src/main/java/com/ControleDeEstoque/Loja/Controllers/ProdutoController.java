package com.ControleDeEstoque.Loja.Controllers;

import com.ControleDeEstoque.Loja.Dtos.ProdutoRequestDto;
import com.ControleDeEstoque.Loja.Dtos.ProdutoResponseDto;
import com.ControleDeEstoque.Loja.Entidades.Produto;
import com.ControleDeEstoque.Loja.Mappers.ProdutoMapper;
import com.ControleDeEstoque.Loja.Repositorys.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping("/")
    @CrossOrigin
    public ResponseEntity<List<ProdutoResponseDto>> carregarProdutos(){

        List<Produto> retorno = produtoRepository.findAll();
        List<ProdutoResponseDto> out = retorno.stream().map(ProdutoMapper:: produtoToProdutoResponse).toList();
        return ResponseEntity.ok().body(out);
    }

    @PostMapping("/")
    @CrossOrigin
    public ResponseEntity<ProdutoResponseDto> criarProduto(@RequestBody ProdutoRequestDto produto){

        Produto retorno = produtoRepository.save(ProdutoMapper.produtoRequestToProduto(produto));

        ProdutoResponseDto out = ProdutoMapper.produtoToProdutoResponse(retorno);
        return ResponseEntity.status(HttpStatus.CREATED).body(out);
    }

    @DeleteMapping("/{id}")
    @CrossOrigin
    public ResponseEntity<Void> deletarProduto(@PathVariable Long id){
        produtoRepository.deleteById(id);
        return ResponseEntity.ok(null);
    }

    @PutMapping("/{id}")
    @CrossOrigin
    public ResponseEntity<ProdutoResponseDto> atualizarProduto(@PathVariable Long id, @RequestBody ProdutoRequestDto produto) {

        Produto retorno = produtoRepository.findById(id).map(record -> {
            record.setNome(produto.getNome());
            record.setDescricao(produto.getDescricao());
            record.setCodigoEan(produto.getCodigoEan());
            return produtoRepository.save(record);
        }).get();

        ProdutoResponseDto out = ProdutoMapper.produtoToProdutoResponse(retorno);

        return ResponseEntity.ok(out);

    }

}
