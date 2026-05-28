package com.biblioteca.controller;

import com.biblioteca.service.AutorService;
import com.biblioteca.service.CategoriaService;
import com.biblioteca.service.LivroService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final LivroService livroService;
    private final AutorService autorService;
    private final CategoriaService categoriaService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("totalLivros", livroService.listarTodos().size());
        model.addAttribute("totalAutores", autorService.listarTodos().size());
        model.addAttribute("totalCategorias", categoriaService.listarTodas().size());
        model.addAttribute("ultimosLivros", livroService.listarTodos().stream().limit(5).toList());
        return "index";
    }
}
