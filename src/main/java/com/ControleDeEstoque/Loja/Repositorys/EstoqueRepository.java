package com.ControleDeEstoque.Loja.Repositorys;

import com.ControleDeEstoque.Loja.Entidades.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstoqueRepository extends JpaRepository<Estoque, Long> {
}
