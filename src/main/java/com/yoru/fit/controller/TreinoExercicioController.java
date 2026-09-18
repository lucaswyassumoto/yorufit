package com.yoru.fit.controller;

import com.yoru.fit.entity.TreinoExercicio;
import com.yoru.fit.service.TreinoExercicioService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/treino-exercicio")
public class TreinoExercicioController {

    private final TreinoExercicioService treinoExercicioService;

    public TreinoExercicioController(TreinoExercicioService treinoExercicioService) {
        this.treinoExercicioService = treinoExercicioService;
    }

    @PostMapping
    public TreinoExercicio criar(@RequestBody TreinoExercicio treinoExercicio, @RequestParam Long usuarioId){
        return treinoExercicioService.criarTreinoExercicio(treinoExercicio, usuarioId);
    }

    @PutMapping("/{treinoExercicioId}")
    public TreinoExercicio editar(@RequestBody TreinoExercicio treinoExercicio, @PathVariable Long treinoExercicioId, @RequestParam Long usuarioId){
        return treinoExercicioService.editarTreinoExercicio(treinoExercicio, treinoExercicioId, usuarioId);
    }

    @DeleteMapping("/{treinoExercicioId}")
    public void deletar(@PathVariable Long treinoExercicioId, @RequestParam Long usuarioId){
        treinoExercicioService.excluirTreinoExercicio(treinoExercicioId, usuarioId);
    }

}
