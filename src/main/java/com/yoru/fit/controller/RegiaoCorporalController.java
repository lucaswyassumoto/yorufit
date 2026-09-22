package com.yoru.fit.controller;

import com.yoru.fit.entity.RegiaoCorporal;
import com.yoru.fit.service.RegiaoCorporalService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/regiao-corporal")
public class RegiaoCorporalController {

    private final RegiaoCorporalService regiaoCorporalService;

    public RegiaoCorporalController(RegiaoCorporalService regiaoCorporalService) {
        this.regiaoCorporalService = regiaoCorporalService;
    }

    @PostMapping
    public RegiaoCorporal criar(@RequestBody RegiaoCorporal regiaoCorporal){
        return regiaoCorporalService.criarRegiaoCorporal(regiaoCorporal);
    }

    @PutMapping("/{regiaoCorporalId}")
    public RegiaoCorporal editar(@RequestBody RegiaoCorporal regiaoCorporal, @PathVariable Long regiaoCorporalId){
        return regiaoCorporalService.editarRegiaoCorporal(regiaoCorporal, regiaoCorporalId);
    }

    @DeleteMapping("/{regiaoCorporalId}")
    public void deletar(@PathVariable Long regiaoCorporalId){
        regiaoCorporalService.deletarRegiaoCorporal(regiaoCorporalId);
    }

    @GetMapping
    public List<RegiaoCorporal> listar(){
        return regiaoCorporalService.listarRegiaoCorporal();
    }

}
