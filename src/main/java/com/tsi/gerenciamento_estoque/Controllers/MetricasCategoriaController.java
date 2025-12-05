package com.tsi.gerenciamento_estoque.Controllers;

import com.tsi.gerenciamento_estoque.Models.MetricasCategoria;
import com.tsi.gerenciamento_estoque.Services.MetricasCategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/metricas")
public class MetricasCategoriaController {
    @Autowired
    private MetricasCategoriaService service;

    @GetMapping
    public List<MetricasCategoria> listarMetricas() {
        return service.listarMetricas();
    }
}