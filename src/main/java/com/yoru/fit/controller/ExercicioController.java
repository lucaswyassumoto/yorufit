package com.yoru.fit.controller;

import com.yoru.fit.entity.Exercicio;
import com.yoru.fit.service.ExercicioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exercicios")
public class ExercicioController {

    private final ExercicioService exercicioService;

    public ExercicioController(ExercicioService exercicioService) {
        this.exercicioService = exercicioService;
    }

    @PostMapping
    public Exercicio criar(@RequestBody Exercicio exercicio){
        return exercicioService.criarExercicio(exercicio);
    }

    @PutMapping("/{exercicioId}")
    public Exercicio editar(@RequestBody Exercicio exercicio, @PathVariable Long exercicioId){
        return exercicioService.editarExercicio(exercicio, exercicioId);
    }

    @DeleteMapping("/{exercicioId}")
    public void deletar(@PathVariable Long exercicioId){
        exercicioService.deletarExercicio(exercicioId);
    }

    @GetMapping
    public List<Exercicio> listar(){
        return exercicioService.listarTodos();
    }

}
