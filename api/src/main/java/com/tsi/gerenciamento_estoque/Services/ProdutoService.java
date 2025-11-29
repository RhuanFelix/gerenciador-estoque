package com.tsi.gerenciamento_estoque.Services;

import com.tsi.gerenciamento_estoque.Models.Produto;
import com.tsi.gerenciamento_estoque.Repositories.ProdutoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public void adicionarProdutoAoEstoque(Produto produto) {
        produtoRepository.save(produto);
        System.out.printf("O produto \"%s\" foi adicionado ao estoque!\n", produto.getNome());
    }

    public List<Produto> listarTodosOsProdutos() {
        return produtoRepository.findAll();
    }

    public Optional<Produto> pesquisarProdutoPorId(int id) {
        return produtoRepository.findById(id);
    }

    @Transactional
    public void atualizarProduto(int id, Produto atualizarProduto) {
        Produto produto = pesquisarProdutoPorId(id).orElseThrow(() -> new RuntimeException(("Produto não encontrado")));
        produto.setNome(atualizarProduto.getNome());
        produto.setMarca(atualizarProduto.getMarca());
        produto.setQuantidade(atualizarProduto.getQuantidade());
        produto.setPreco(atualizarProduto.getPreco());
        produto.setCategoria(atualizarProduto.getCategoria());
        System.out.println("Produto atualizado com sucesso!");
    }

    public void deletarProdutoPorId(int id) {
        Produto produto = pesquisarProdutoPorId(id).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        produtoRepository.delete(produto);
    }
}
