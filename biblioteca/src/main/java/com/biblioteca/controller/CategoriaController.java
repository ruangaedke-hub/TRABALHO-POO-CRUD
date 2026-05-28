package com.biblioteca.controller;

import com.biblioteca.model.Categoria;
import com.biblioteca.service.CategoriaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/categorias")
@RequiredArgsConstructor
public class CategoriaController {

    private final CategoriaService categoriaService;

    @GetMapping
    public String listar(Model model, @RequestParam(required = false) String busca) {
        if (busca != null && !busca.isBlank()) {
            model.addAttribute("categorias", categoriaService.buscarPorNome(busca));
            model.addAttribute("busca", busca);
        } else {
            model.addAttribute("categorias", categoriaService.listarTodas());
        }
        return "categoria/lista";
    }

    @GetMapping("/novo")
    public String novoForm(Model model) {
        model.addAttribute("categoria", new Categoria());
        return "categoria/form";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid @ModelAttribute Categoria categoria,
                         BindingResult result,
                         RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "categoria/form";
        }
        categoriaService.salvar(categoria);
        redirectAttributes.addFlashAttribute("sucesso", "Categoria salva com sucesso!");
        return "redirect:/categorias";
    }

    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable Long id, Model model) {
        model.addAttribute("categoria", categoriaService.buscarPorId(id));
        return "categoria/form";
    }

    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            categoriaService.deletar(id);
            redirectAttributes.addFlashAttribute("sucesso", "Categoria deletada com sucesso!");
        } catch (RuntimeException e) {
            redirectAttributes.addFlashAttribute("erro", e.getMessage());
        }
        return "redirect:/categorias";
    }
}
