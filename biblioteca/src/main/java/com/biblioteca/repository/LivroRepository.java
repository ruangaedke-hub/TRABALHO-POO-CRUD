package com.biblioteca.repository;

import com.biblioteca.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
    List<Livro> findByTituloContainingIgnoreCase(String titulo);
    List<Livro> findByAutorId(Long autorId);
    List<Livro> findByCategoriaId(Long categoriaId);

    @Query("SELECT c.nome, COUNT(l) FROM Livro l JOIN l.categoria c GROUP BY c.nome ORDER BY COUNT(l) DESC")
    List<Object[]> contarLivrosPorCategoria();

    @Query("SELECT a.nome, COUNT(l) FROM Livro l JOIN l.autor a GROUP BY a.nome ORDER BY COUNT(l) DESC")
    List<Object[]> contarLivrosPorAutor();

    @Query("SELECT l.anoPublicacao, COUNT(l) FROM Livro l GROUP BY l.anoPublicacao ORDER BY l.anoPublicacao")
    List<Object[]> contarLivrosPorAno();
}
