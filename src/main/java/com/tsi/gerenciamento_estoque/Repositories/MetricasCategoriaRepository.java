package com.tsi.gerenciamento_estoque.Repositories;

import com.tsi.gerenciamento_estoque.Models.MetricasCategoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MetricasCategoriaRepository extends JpaRepository<MetricasCategoria, String> {
}