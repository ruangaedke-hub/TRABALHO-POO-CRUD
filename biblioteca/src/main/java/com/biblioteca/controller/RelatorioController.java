package com.biblioteca.controller;

import com.biblioteca.service.LivroService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/relatorio")
@RequiredArgsConstructor
public class RelatorioController {

    private final LivroService livroService;

    @GetMapping
    public String relatorio(Model model) {
        // Dados para gráfico de pizza - Livros por Categoria
        List<Object[]> dadosCategoria = livroService.getLivrosPorCategoria();
        String labelsCategoria = dadosCategoria.stream()
                .map(row -> "\"" + row[0] + "\"")
                .collect(Collectors.joining(","));
        String valoresCategoria = dadosCategoria.stream()
                .map(row -> row[1].toString())
                .collect(Collectors.joining(","));

        // Dados para gráfico de barras - Livros por Autor
        List<Object[]> dadosAutor = livroService.getLivrosPorAutor();
        String labelsAutor = dadosAutor.stream()
                .map(row -> "\"" + row[0] + "\"")
                .collect(Collectors.joining(","));
        String valoresAutor = dadosAutor.stream()
                .map(row -> row[1].toString())
                .collect(Collectors.joining(","));

        // Dados para gráfico de linha - Livros por Ano
        List<Object[]> dadosAno = livroService.getLivrosPorAno();
        String labelsAno = dadosAno.stream()
                .map(row -> "\"" + row[0] + "\"")
                .collect(Collectors.joining(","));
        String valoresAno = dadosAno.stream()
                .map(row -> row[1].toString())
                .collect(Collectors.joining(","));

        model.addAttribute("labelsCategoria", "[" + labelsCategoria + "]");
        model.addAttribute("valoresCategoria", "[" + valoresCategoria + "]");
        model.addAttribute("labelsAutor", "[" + labelsAutor + "]");
        model.addAttribute("valoresAutor", "[" + valoresAutor + "]");
        model.addAttribute("labelsAno", "[" + labelsAno + "]");
        model.addAttribute("valoresAno", "[" + valoresAno + "]");
        model.addAttribute("totalLivros", livroService.listarTodos().size());

        return "relatorio/dashboard";
    }
}
