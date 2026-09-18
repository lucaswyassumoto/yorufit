package com.yoru.fit.controller;

import com.yoru.fit.entity.ExecucaoExercicio;
import com.yoru.fit.service.ExecucaoExercicioService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/execucao-exercicio")
public class ExecucaoExercicioController {

    private final ExecucaoExercicioService execucaoExercicioService;

    public ExecucaoExercicioController(ExecucaoExercicioService execucaoExercicioService) {
        this.execucaoExercicioService = execucaoExercicioService;
    }

    @PostMapping
    public ExecucaoExercicio iniciar(@RequestParam Long treinoExecucaoId, @RequestParam Long treinoExercicioId, @RequestParam Long usuarioId){
        return execucaoExercicioService.iniciarExecucaoExercicio(treinoExecucaoId, treinoExercicioId, usuarioId);
    }

}
