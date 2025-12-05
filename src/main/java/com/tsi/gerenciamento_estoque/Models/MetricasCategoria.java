package com.tsi.gerenciamento_estoque.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "metricas_categoria")
public class MetricasCategoria {
    @Id
    private String categoria;
    private Double valorTotal;

    public MetricasCategoria() {}

    public MetricasCategoria(String categoria, Double valorTotal) {
        this.categoria = categoria;
        this.valorTotal = valorTotal;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }
}
