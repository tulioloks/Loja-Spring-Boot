package com.ControleDeEstoque.Loja.Repositorys;

import com.ControleDeEstoque.Loja.Entidades.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
