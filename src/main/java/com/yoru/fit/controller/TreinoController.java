package com.yoru.fit.controller;

import com.yoru.fit.entity.Treino;
import com.yoru.fit.service.TreinoService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/treinos")
public class TreinoController {

    private final TreinoService treinoService;

    public TreinoController(TreinoService treinoService) {
        this.treinoService = treinoService;
    }

    @GetMapping("/buscar-treinos")
    public Treino buscar(@RequestParam Long treinoId){
        return treinoService.buscarTreino(treinoId);
    }

    @PostMapping("/criar-treino")
    public Treino criar(@RequestBody Treino treino, @RequestParam Long usuarioId){
        return treinoService.criarTreino(treino, usuarioId);
    }

    @PutMapping("/editar-treino")
    public Treino editar(@RequestBody Treino treino, @RequestParam Long usuarioId){
        return treinoService.editarTreino(treino, usuarioId);
    }

}
