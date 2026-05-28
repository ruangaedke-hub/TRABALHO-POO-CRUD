package com.biblioteca.controller;

import com.biblioteca.model.Autor;
import com.biblioteca.model.Categoria;
import com.biblioteca.model.Livro;
import com.biblioteca.service.AutorService;
import com.biblioteca.service.CategoriaService;
import com.biblioteca.service.LivroService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/livros")
@RequiredArgsConstructor
public class LivroController {

    private final LivroService livroService;
    private final AutorService autorService;
    private final CategoriaService categoriaService;

    @GetMapping
    public String listar(Model model, @RequestParam(required = false) String busca) {
        if (busca != null && !busca.isBlank()) {
            model.addAttribute("livros", livroService.buscarPorTitulo(busca));
            model.addAttribute("busca", busca);
        } else {
            model.addAttribute("livros", livroService.listarTodos());
        }
        return "livro/lista";
    }

    @GetMapping("/novo")
    public String novoForm(Model model) {
        model.addAttribute("livro", new Livro());
        model.addAttribute("autores", autorService.listarTodos());
        model.addAttribute("categorias", categoriaService.listarTodas());
        return "livro/form";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid @ModelAttribute Livro livro,
                         BindingResult result,
                         @RequestParam Long autorId,
                         @RequestParam Long categoriaId,
                         Model model,
                         RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            model.addAttribute("autores", autorService.listarTodos());
            model.addAttribute("categorias", categoriaService.listarTodas());
            return "livro/form";
        }
        Autor autor = autorService.buscarPorId(autorId);
        Categoria categoria = categoriaService.buscarPorId(categoriaId);
        livro.setAutor(autor);
        livro.setCategoria(categoria);
        livroService.salvar(livro);
        redirectAttributes.addFlashAttribute("sucesso", "Livro salvo com sucesso!");
        return "redirect:/livros";
    }

    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable Long id, Model model) {
        Livro livro = livroService.buscarPorId(id);
        model.addAttribute("livro", livro);
        model.addAttribute("autores", autorService.listarTodos());
        model.addAttribute("categorias", categoriaService.listarTodas());
        model.addAttribute("autorIdSelecionado", livro.getAutor() != null ? livro.getAutor().getId() : null);
        model.addAttribute("categoriaIdSelecionada", livro.getCategoria() != null ? livro.getCategoria().getId() : null);
        return "livro/form";
    }

    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            livroService.deletar(id);
            redirectAttributes.addFlashAttribute("sucesso", "Livro deletado com sucesso!");
        } catch (RuntimeException e) {
            redirectAttributes.addFlashAttribute("erro", e.getMessage());
        }
        return "redirect:/livros";
    }
}
