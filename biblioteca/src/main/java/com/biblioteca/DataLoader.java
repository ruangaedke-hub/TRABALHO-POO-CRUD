package com.biblioteca;

import com.biblioteca.model.Autor;
import com.biblioteca.model.Categoria;
import com.biblioteca.model.Livro;
import com.biblioteca.repository.AutorRepository;
import com.biblioteca.repository.CategoriaRepository;
import com.biblioteca.repository.LivroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final AutorRepository autorRepository;
    private final CategoriaRepository categoriaRepository;
    private final LivroRepository livroRepository;

    @Override
    public void run(String... args) {
        // Categorias
        Categoria romance = new Categoria();
        romance.setNome("Romance");
        romance.setDescricao("Obras de ficção centradas em histórias de amor.");
        categoriaRepository.save(romance);

        Categoria ficcaoCientifica = new Categoria();
        ficcaoCientifica.setNome("Ficção Científica");
        ficcaoCientifica.setDescricao("Narrativas que exploram ciência e tecnologia futurista.");
        categoriaRepository.save(ficcaoCientifica);

        Categoria fantasia = new Categoria();
        fantasia.setNome("Fantasia");
        fantasia.setDescricao("Obras com elementos mágicos e mundos imaginários.");
        categoriaRepository.save(fantasia);

        Categoria terror = new Categoria();
        terror.setNome("Terror");
        terror.setDescricao("Obras que buscam provocar medo e suspense.");
        categoriaRepository.save(terror);

        // Autores
        Autor machado = new Autor();
        machado.setNome("Machado de Assis");
        machado.setNacionalidade("Brasileiro");
        machado.setBiografia("Considerado o maior nome da literatura brasileira, fundador da Academia Brasileira de Letras.");
        autorRepository.save(machado);

        Autor tolkien = new Autor();
        tolkien.setNome("J.R.R. Tolkien");
        tolkien.setNacionalidade("Britânico");
        tolkien.setBiografia("Escritor e professor universitário, criador do universo da Terra Média.");
        autorRepository.save(tolkien);

        Autor asimov = new Autor();
        asimov.setNome("Isaac Asimov");
        asimov.setNacionalidade("Americano");
        asimov.setBiografia("Um dos maiores nomes da ficção científica, conhecido pelas Leis da Robótica.");
        autorRepository.save(asimov);

        Autor king = new Autor();
        king.setNome("Stephen King");
        king.setNacionalidade("Americano");
        king.setBiografia("Mestre do terror moderno, com mais de 60 romances publicados.");
        autorRepository.save(king);

        Autor clarice = new Autor();
        clarice.setNome("Clarice Lispector");
        clarice.setNacionalidade("Brasileira");
        clarice.setBiografia("Uma das escritoras mais importantes do Brasil, conhecida pelo estilo introspectivo.");
        autorRepository.save(clarice);

        // Livros
        Livro livro1 = new Livro();
        livro1.setTitulo("Dom Casmurro");
        livro1.setIsbn("978-85-359-0277-1");
        livro1.setAnoPublicacao(1899);
        livro1.setNumeroPaginas(256);
        livro1.setSinopse("A obra mais famosa de Machado de Assis, narrada por Bentinho.");
        livro1.setAutor(machado);
        livro1.setCategoria(romance);
        livroRepository.save(livro1);

        Livro livro2 = new Livro();
        livro2.setTitulo("O Senhor dos Anéis");
        livro2.setIsbn("978-85-325-2014-0");
        livro2.setAnoPublicacao(1954);
        livro2.setNumeroPaginas(1178);
        livro2.setSinopse("A épica jornada de Frodo para destruir o Um Anel.");
        livro2.setAutor(tolkien);
        livro2.setCategoria(fantasia);
        livroRepository.save(livro2);

        Livro livro3 = new Livro();
        livro3.setTitulo("Fundação");
        livro3.setIsbn("978-85-352-6052-9");
        livro3.setAnoPublicacao(1951);
        livro3.setNumeroPaginas(320);
        livro3.setSinopse("A saga da queda e reconstrução da civilização galáctica.");
        livro3.setAutor(asimov);
        livro3.setCategoria(ficcaoCientifica);
        livroRepository.save(livro3);

        Livro livro4 = new Livro();
        livro4.setTitulo("It - A Coisa");
        livro4.setIsbn("978-85-325-3115-3");
        livro4.setAnoPublicacao(1986);
        livro4.setNumeroPaginas(1104);
        livro4.setSinopse("Uma entidade aterrorizante desperta a cada 27 anos em Derry.");
        livro4.setAutor(king);
        livro4.setCategoria(terror);
        livroRepository.save(livro4);

        Livro livro5 = new Livro();
        livro5.setTitulo("A Hora da Estrela");
        livro5.setIsbn("978-85-359-0119-4");
        livro5.setAnoPublicacao(1977);
        livro5.setNumeroPaginas(96);
        livro5.setSinopse("A trágica história de Macabéa, nordestina que vive no Rio de Janeiro.");
        livro5.setAutor(clarice);
        livro5.setCategoria(romance);
        livroRepository.save(livro5);

        Livro livro6 = new Livro();
        livro6.setTitulo("O Hobbit");
        livro6.setIsbn("978-85-325-2013-3");
        livro6.setAnoPublicacao(1937);
        livro6.setNumeroPaginas(336);
        livro6.setSinopse("A aventura de Bilbo Bolseiro com anões e o dragão Smaug.");
        livro6.setAutor(tolkien);
        livro6.setCategoria(fantasia);
        livroRepository.save(livro6);

        Livro livro7 = new Livro();
        livro7.setTitulo("O Iluminado");
        livro7.setIsbn("978-85-325-3116-0");
        livro7.setAnoPublicacao(1977);
        livro7.setNumeroPaginas(592);
        livro7.setSinopse("Jack Torrance leva sua família para um hotel isolado nas montanhas.");
        livro7.setAutor(king);
        livro7.setCategoria(terror);
        livroRepository.save(livro7);

        Livro livro8 = new Livro();
        livro8.setTitulo("Eu, Robô");
        livro8.setIsbn("978-85-352-6053-6");
        livro8.setAnoPublicacao(1950);
        livro8.setNumeroPaginas(272);
        livro8.setSinopse("Coletânea de contos que definiram as Três Leis da Robótica.");
        livro8.setAutor(asimov);
        livro8.setCategoria(ficcaoCientifica);
        livroRepository.save(livro8);
    }
}
