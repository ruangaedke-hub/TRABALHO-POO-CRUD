package com.biblioteca.service;

import com.biblioteca.model.Livro;
import com.biblioteca.repository.LivroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LivroService {

    private final LivroRepository livroRepository;

    public List<Livro> listarTodos() {
        return livroRepository.findAll();
    }

    public Livro buscarPorId(Long id) {
        return livroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado com id: " + id));
    }

    @Transactional
    public Livro salvar(Livro livro) {
        return livroRepository.save(livro);
    }

    @Transactional
    public void deletar(Long id) {
        livroRepository.deleteById(id);
    }

    public List<Livro> buscarPorTitulo(String titulo) {
        return livroRepository.findByTituloContainingIgnoreCase(titulo);
    }

    public List<Object[]> getLivrosPorCategoria() {
        return livroRepository.contarLivrosPorCategoria();
    }

    public List<Object[]> getLivrosPorAutor() {
        return livroRepository.contarLivrosPorAutor();
    }

    public List<Object[]> getLivrosPorAno() {
        return livroRepository.contarLivrosPorAno();
    }
}
