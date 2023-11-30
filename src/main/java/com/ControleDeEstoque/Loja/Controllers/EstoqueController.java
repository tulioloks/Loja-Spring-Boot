package com.ControleDeEstoque.Loja.Controllers;

import com.ControleDeEstoque.Loja.Dtos.EstoqueRequestDto;
import com.ControleDeEstoque.Loja.Dtos.EstoqueResponseDto;
import com.ControleDeEstoque.Loja.Entidades.Estoque;
import com.ControleDeEstoque.Loja.Mappers.EstoqueMapper;
import com.ControleDeEstoque.Loja.Mappers.LojaMapper;
import com.ControleDeEstoque.Loja.Mappers.ProdutoMapper;
import com.ControleDeEstoque.Loja.Repositorys.EstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/estoques")
public class EstoqueController {

    @Autowired
    private EstoqueRepository estoqueRepository;

    @GetMapping("/")
    @CrossOrigin
    public ResponseEntity<List<EstoqueResponseDto>> carregarEstoques(){

        List<Estoque> retorno = estoqueRepository.findAll();
        List<EstoqueResponseDto> out = retorno.stream().map(EstoqueMapper:: estoqueRequestToEstoque).toList();
        return ResponseEntity.ok().body(out);
    }

    @PostMapping("/")
    @CrossOrigin
    public ResponseEntity<EstoqueResponseDto> criarEstoque(@RequestBody EstoqueRequestDto estoque){

        Estoque retorno = estoqueRepository.save(EstoqueMapper.estoqueRequestToEstoque(estoque));

        EstoqueResponseDto out = EstoqueMapper.estoqueRequestToEstoque(retorno);
        return ResponseEntity.status(HttpStatus.CREATED).body(out);
    }

    @DeleteMapping("/{id}")
    @CrossOrigin
    public ResponseEntity<Void> deletarEstoque(@PathVariable Long id){
        estoqueRepository.deleteById(id);
        return ResponseEntity.ok(null);
    }

    @PutMapping("/{id}")
    @CrossOrigin
    public ResponseEntity<EstoqueResponseDto> atualizarEstoque(@PathVariable Long id, @RequestBody EstoqueRequestDto estoques){

        Estoque retorno = estoqueRepository.findById(id).map(record -> {
            record.setQuantidade(estoques.getQuantidade());
            record.setProduto(ProdutoMapper.produtoRequestToProduto(estoques.getProduto()));
            record.setLoja(LojaMapper.lojaRequestToLoja(estoques.getLoja()));
            return estoqueRepository.save(record);
        }).get();

        EstoqueResponseDto out = EstoqueMapper.estoqueRequestToEstoque(retorno);

        return ResponseEntity.ok(out);
    }
}
