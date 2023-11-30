package com.ControleDeEstoque.Loja.Controllers;

import com.ControleDeEstoque.Loja.Dtos.LojaRequestDto;
import com.ControleDeEstoque.Loja.Dtos.LojaResponseDto;
import com.ControleDeEstoque.Loja.Entidades.Loja;
import com.ControleDeEstoque.Loja.Mappers.LojaMapper;
import com.ControleDeEstoque.Loja.Repositorys.LojaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/lojas")
public class LojaController {

    @Autowired
    private LojaRepository lojaRepository;

    @GetMapping("/")
    @CrossOrigin
    public ResponseEntity<List<LojaResponseDto>> carregarLojas(){

        List<Loja> retorno = lojaRepository.findAll();
        List<LojaResponseDto> out = retorno.stream().map(LojaMapper:: lojaToProdutoResponse).toList();
        return ResponseEntity.ok().body(out);
    }

    @PostMapping("/")
    @CrossOrigin
    public ResponseEntity<LojaResponseDto> criarLoja(@RequestBody LojaRequestDto loja){

        Loja retorno = lojaRepository.save(LojaMapper.lojaRequestToLoja(loja));

        LojaResponseDto out = LojaMapper.lojaToProdutoResponse(retorno);
        return ResponseEntity.status(HttpStatus.CREATED).body(out);
    }

    @DeleteMapping("/{id}")
    @CrossOrigin
    public ResponseEntity<Void> deletarLoja(@PathVariable Long id){
        lojaRepository.deleteById(id);
        return ResponseEntity.ok(null);
    }

    @PutMapping("/{id}")
    @CrossOrigin
    public ResponseEntity<LojaResponseDto> atualizarLoja(@PathVariable Long id, @RequestBody LojaRequestDto loja) {

        Loja retorno = lojaRepository.findById(id).map(record -> {
            record.setNome(loja.getNome());
            record.setResponsavel(loja.getResponsavel());
            record.setCnpj(loja.getCnpj());
            return lojaRepository.save(record);
        }).get();

        LojaResponseDto out = LojaMapper.lojaToProdutoResponse(retorno);

        return ResponseEntity.ok(out);

    }
}
