package com.tsi.gerenciamento_estoque.Controllers;

import com.tsi.gerenciamento_estoque.Models.Produto;
import com.tsi.gerenciamento_estoque.Services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public void adicionarProdutoAoEstoque(@RequestBody Produto produto) {
        produtoService.adicionarProdutoAoEstoque(produto);
    }

    @GetMapping
    public List<Produto> listarTodosOsProdutos() {
        return produtoService.listarTodosOsProdutos();
    }

    @GetMapping("/{id}")
    public Optional<Produto> pesquisarProdutoPorId(@PathVariable int id) {
        return produtoService.pesquisarProdutoPorId(id);
    }

    @PutMapping("/{id}")
    public void atualizarProduto(@PathVariable int id, @RequestBody Produto produto) {
        produtoService.atualizarProduto(id, produto);
    }

    @DeleteMapping("/{id}")
    public void deletarProdutoPorId(@PathVariable int id) {
        produtoService.deletarProdutoPorId(id);
    }
}
