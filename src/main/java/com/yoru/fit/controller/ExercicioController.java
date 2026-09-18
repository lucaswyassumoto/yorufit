package com.yoru.fit.controller;

import com.yoru.fit.entity.Exercicio;
import com.yoru.fit.service.ExercicioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exercicio")
public class ExercicioController {

    private final ExercicioService exercicioService;

    public ExercicioController(ExercicioService exercicioService) {
        this.exercicioService = exercicioService;
    }

    @PostMapping("/criar")
    public Exercicio criar(@RequestBody Exercicio exercicio){
        return exercicioService.criarExercicio(exercicio);
    }

    @PutMapping("/editar")
    public Exercicio editar(@RequestBody Exercicio exercicio, @RequestParam Long exercicioId){
        return exercicioService.editarExercicio(exercicio, exercicioId);
    }

    @DeleteMapping("/deletar")
    public void deletar(@RequestParam Long exercicioId){
        exercicioService.deletarExercicio(exercicioId);
    }

    @GetMapping("/listar")
    public List<Exercicio> listar(){
        return exercicioService.listarTodos();
    }

}
