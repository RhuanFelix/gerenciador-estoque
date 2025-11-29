package com.tsi.gerenciamento_estoque.Services;

import com.tsi.gerenciamento_estoque.Models.MetricasCategoria;
import com.tsi.gerenciamento_estoque.Repositories.MetricasCategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MetricasCategoriaService {
    @Autowired
    private MetricasCategoriaRepository repository;

    public List<MetricasCategoria> listarMetricas() {
        return repository.findAll();
    }
}
