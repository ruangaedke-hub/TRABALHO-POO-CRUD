package com.biblioteca.service;

import com.biblioteca.model.Autor;
import com.biblioteca.repository.AutorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AutorService {

    private final AutorRepository autorRepository;

    public List<Autor> listarTodos() {
        return autorRepository.findAll();
    }

    public Autor buscarPorId(Long id) {
        return autorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Autor não encontrado com id: " + id));
    }

    @Transactional
    public Autor salvar(Autor autor) {
        return autorRepository.save(autor);
    }

    @Transactional
    public void deletar(Long id) {
        Autor autor = buscarPorId(id);
        if (autor.getLivros() != null && !autor.getLivros().isEmpty()) {
            throw new RuntimeException("Não é possível deletar autor com livros associados.");
        }
        autorRepository.deleteById(id);
    }

    public List<Autor> buscarPorNome(String nome) {
        return autorRepository.findByNomeContainingIgnoreCase(nome);
    }
}
