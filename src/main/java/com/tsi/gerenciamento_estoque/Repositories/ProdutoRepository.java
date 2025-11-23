package com.tsi.gerenciamento_estoque.Repositories;

import com.tsi.gerenciamento_estoque.Models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
