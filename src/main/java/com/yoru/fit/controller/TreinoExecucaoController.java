package com.yoru.fit.controller;

import com.yoru.fit.entity.TreinoExecucao;
import com.yoru.fit.service.TreinoExecucaoService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/execucao")
public class TreinoExecucaoController {

    private final TreinoExecucaoService treinoExecucaoService;

    public TreinoExecucaoController(TreinoExecucaoService treinoExecucaoService) {
        this.treinoExecucaoService = treinoExecucaoService;
    }

    @PostMapping("/iniciar-execucao")
    public TreinoExecucao iniciar(@RequestParam Long treinoId, @RequestParam Long usuarioId){
        return treinoExecucaoService.iniciarExecucao(treinoId, usuarioId);
    }

    @PutMapping("/finalizar-execucao")
    public TreinoExecucao finalizar(@RequestParam Long treinoExecucaoId, @RequestParam Long usuarioId){
        return treinoExecucaoService.finalizarExecucao(treinoExecucaoId, usuarioId);
    }


}
