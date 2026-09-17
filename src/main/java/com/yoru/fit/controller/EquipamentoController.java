package com.yoru.fit.controller;

import com.yoru.fit.entity.Equipamento;
import com.yoru.fit.service.EquipamentoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipamentos")
public class EquipamentoController {

    private final EquipamentoService equipamentoService;

    public EquipamentoController(EquipamentoService equipamentoService) {
        this.equipamentoService = equipamentoService;
    }

    @PostMapping("/criar-equipamento")
    public Equipamento adicionar(@RequestBody Equipamento equipamento){
        return equipamentoService.addEquipamento(equipamento);
    }

    @PutMapping("/editar-equipamento")
    public Equipamento editar(@RequestBody Equipamento equipamento, @RequestParam Long equipamentoId){
        return equipamentoService.editarEquipamento(equipamento, equipamentoId);
    }

    @DeleteMapping("/deletar-equipamento")
    public void deletar(@RequestParam Long equipamentoId){
        equipamentoService.deletarEquipamento(equipamentoId);
    }

    @GetMapping("/listar-equipamentos")
    public List<Equipamento> listar(){
        return equipamentoService.listarEquipamentos();
    }

}
