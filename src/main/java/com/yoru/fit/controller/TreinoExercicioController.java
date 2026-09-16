package com.yoru.fit.controller;

import com.yoru.fit.entity.TreinoExercicio;
import com.yoru.fit.service.TreinoExercicioService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/treinos/exercicios")
public class TreinoExercicioController {

    private final TreinoExercicioService treinoExercicioService;

    public TreinoExercicioController(TreinoExercicioService treinoExercicioService) {
        this.treinoExercicioService = treinoExercicioService;
    }

    @PostMapping("/criar")
    public TreinoExercicio criar(@RequestBody TreinoExercicio treinoExercicio, @RequestParam Long usuarioId){
        return treinoExercicioService.criarTreinoExercicio(treinoExercicio, usuarioId);
    }

    @PutMapping("/editar")
    public TreinoExercicio editar(@RequestBody TreinoExercicio treinoExercicio, @RequestParam Long usuarioId){
        return treinoExercicioService.editarTreinoExercicio(treinoExercicio, usuarioId);
    }

    @DeleteMapping("/deletar")
    public void deletar(@RequestParam Long treinoExercicioId, @RequestParam Long usuarioId){
        treinoExercicioService.excluirTreinoExercicio(treinoExercicioId, usuarioId);
    }

}
