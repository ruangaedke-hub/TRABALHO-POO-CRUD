package com.biblioteca.controller;

import com.biblioteca.model.Autor;
import com.biblioteca.service.AutorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/autores")
@RequiredArgsConstructor
public class AutorController {

    private final AutorService autorService;

    @GetMapping
    public String listar(Model model, @RequestParam(required = false) String busca) {
        if (busca != null && !busca.isBlank()) {
            model.addAttribute("autores", autorService.buscarPorNome(busca));
            model.addAttribute("busca", busca);
        } else {
            model.addAttribute("autores", autorService.listarTodos());
        }
        return "autor/lista";
    }

    @GetMapping("/novo")
    public String novoForm(Model model) {
        model.addAttribute("autor", new Autor());
        return "autor/form";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid @ModelAttribute Autor autor,
                         BindingResult result,
                         RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "autor/form";
        }
        autorService.salvar(autor);
        redirectAttributes.addFlashAttribute("sucesso", "Autor salvo com sucesso!");
        return "redirect:/autores";
    }

    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable Long id, Model model) {
        model.addAttribute("autor", autorService.buscarPorId(id));
        return "autor/form";
    }

    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            autorService.deletar(id);
            redirectAttributes.addFlashAttribute("sucesso", "Autor deletado com sucesso!");
        } catch (RuntimeException e) {
            redirectAttributes.addFlashAttribute("erro", e.getMessage());
        }
        return "redirect:/autores";
    }
}
