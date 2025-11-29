package com.tsi.gerenciamento_estoque.Services;

import com.tsi.gerenciamento_estoque.Models.Categoria;
import com.tsi.gerenciamento_estoque.Repositories.CategoriaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    public void adicionarCategoria(Categoria categoria) {
        categoriaRepository.save(categoria);
        System.out.printf("A categoria \"%s\" foi criada com sucesso!", categoria.getNome());
    }

    public List<Categoria> listarTodasCategorias() {
        return categoriaRepository.findAll();
    }

    public Optional<Categoria> pesquisarCategoriaPorId(int id) {
        return categoriaRepository.findById(id);
    }

    public Optional<Categoria> pesquisarCategoriaPorNome(String nome) {
        return categoriaRepository.findByNome(nome);
    }

    @Transactional
    public void atualizarCategoria(String nome, Categoria atualizarCategoria) {
        Categoria categoria = pesquisarCategoriaPorNome(nome).orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
        categoria.setNome(atualizarCategoria.getNome());
        categoria.setDescricao(atualizarCategoria.getDescricao());
        System.out.println("Categoria atualizada com sucesso!");
    }

    public void deletarCategoria(String nome) {
        Categoria categoria = pesquisarCategoriaPorNome(nome).orElseThrow(() -> new RuntimeException(("Categoria não encontrada")));
        categoriaRepository.delete(categoria);
        System.out.printf("A categoria \"%s\" foi deletada com sucesso!\n", categoria.getNome());
    }
}
