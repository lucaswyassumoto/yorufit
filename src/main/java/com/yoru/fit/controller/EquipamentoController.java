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

    @PostMapping
    public Equipamento adicionar(@RequestBody Equipamento equipamento){
        return equipamentoService.addEquipamento(equipamento);
    }

    @PutMapping("/{equipamentoId}")
    public Equipamento editar(@RequestBody Equipamento equipamento, @PathVariable Long equipamentoId){
        return equipamentoService.editarEquipamento(equipamento, equipamentoId);
    }

    @DeleteMapping("/{equipamentoId}")
    public void deletar(@PathVariable Long equipamentoId){
        equipamentoService.deletarEquipamento(equipamentoId);
    }

    @GetMapping
    public List<Equipamento> listar(){
        return equipamentoService.listarEquipamentos();
    }

}
