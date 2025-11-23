package com.tsi.gerenciamento_estoque.Controllers;

import com.tsi.gerenciamento_estoque.Models.Categoria;
import com.tsi.gerenciamento_estoque.Services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    @PostMapping
    public void adicionarCategoria(@RequestBody Categoria categoria) {
        categoriaService.adicionarCategoria(categoria);
    }

    @GetMapping
    public List<Categoria> listarTodasCategorias() {
        return categoriaService.listarTodasCategorias();
    }

    @GetMapping("/id/{id}")
    public Optional<Categoria> pesquisarCategoriaPorId(@PathVariable int id) {
        return categoriaService.pesquisarCategoriaPorId(id);
    }

    @GetMapping("/nome/{nome}")
    public Optional<Categoria> pesquisarCategoriaPorNome(@PathVariable String nome) {
        return categoriaService.pesquisarCategoriaPorNome(nome);
    }

    @PutMapping("/{nome}")
    public void atualizarCategoria(@PathVariable String nome, @RequestBody Categoria categoria) {
        categoriaService.atualizarCategoria(nome, categoria);
    }

    @DeleteMapping("/{nome}")
    public void deletarCategoria(@PathVariable String nome) {
        categoriaService.deletarCategoria(nome);
    }
}
