package com.yoru.fit.controller;

import com.yoru.fit.entity.Musculo;
import com.yoru.fit.service.MusculoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/musculos")
public class MusculoController {

    private final MusculoService musculoService;

    public MusculoController(MusculoService musculoService) {
        this.musculoService = musculoService;
    }

    @PostMapping
    public Musculo criar(@RequestBody Musculo musculo, @RequestParam Long regiaoCorporalId){
        return musculoService.addMusculo(musculo, regiaoCorporalId);
    }

    @PutMapping("/{musculoId}")
    public Musculo editar(@RequestBody Musculo musculo, @PathVariable Long musculoId, @RequestParam Long regiaoCorporalId){
        return musculoService.editarMusculo(musculo, musculoId, regiaoCorporalId);
    }

    @DeleteMapping("/{musculoId}")
    public void deletar(@PathVariable Long musculoId){
        musculoService.deletarMusculo(musculoId);
    }

    @GetMapping
    public List<Musculo> listar(){
        return musculoService.listarMusculos();
    }

}
