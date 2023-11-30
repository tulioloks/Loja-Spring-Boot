package com.ControleDeEstoque.Loja.Repositorys;

import com.ControleDeEstoque.Loja.Entidades.Loja;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LojaRepository extends JpaRepository<Loja, Long> {
}
