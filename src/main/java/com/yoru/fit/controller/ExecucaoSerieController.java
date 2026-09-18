package com.yoru.fit.controller;

import com.yoru.fit.entity.ExecucaoSerie;
import com.yoru.fit.service.ExecucaoSerieService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/registrar-serie")
public class ExecucaoSerieController {

    private final ExecucaoSerieService execucaoSerieService;

    public ExecucaoSerieController(ExecucaoSerieService execucaoSerieService) {
        this.execucaoSerieService = execucaoSerieService;
    }

    @PostMapping
    public ExecucaoSerie registrar(@RequestBody ExecucaoSerie execucaoSerie, @RequestParam Long execucaoExercicioId, @RequestParam Long usuarioId){
        return execucaoSerieService.registrarSerie(execucaoSerie, execucaoExercicioId, usuarioId);
    }

}
