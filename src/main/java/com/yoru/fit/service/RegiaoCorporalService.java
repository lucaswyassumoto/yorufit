package com.yoru.fit.service;

import com.yoru.fit.entity.RegiaoCorporal;
import com.yoru.fit.repository.RegiaoCorporalRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegiaoCorporalService {

    private final RegiaoCorporalRepository regiaoCorporalRepository;

    public RegiaoCorporalService(RegiaoCorporalRepository regiaoCorporalRepository) {
        this.regiaoCorporalRepository = regiaoCorporalRepository;
    }

    public RegiaoCorporal criarRegiaoCorporal(RegiaoCorporal regiaoCorporal){

        if(regiaoCorporal.getNome() == null || regiaoCorporal.getNome().isBlank()){
            throw new IllegalArgumentException("Você precisa digitar o nome da região corporal");
        }

        String nome = regiaoCorporal.getNome().trim();

        if(regiaoCorporalRepository.existsByNome(nome)){
            throw new IllegalArgumentException("Esse nome já pertence a uma região corporal");
        }

        regiaoCorporal.setNome(nome);

        if(regiaoCorporal.getDescricao() != null && !regiaoCorporal.getDescricao().isBlank()){
            regiaoCorporal.setDescricao(
                    regiaoCorporal.getDescricao().trim()
            );
        }

        return regiaoCorporalRepository.save(regiaoCorporal);

    }

    public RegiaoCorporal editarRegiaoCorporal(RegiaoCorporal regiaoCorporal, Long regialCorporalId){

        RegiaoCorporal regiaoCorporalBanco = regiaoCorporalRepository.findById(regialCorporalId).orElseThrow(() ->
                new IllegalArgumentException("Região corporal não encontrada"));

        if(regiaoCorporal.getNome() != null && !regiaoCorporal.getNome().isBlank()){

            String nome = regiaoCorporal.getNome().trim();

            if(regiaoCorporalRepository.existsByNomeAndIdNot(nome, regialCorporalId)){
                throw new IllegalArgumentException("Esse nome já pertence a uma região corporal existente");
            }

            regiaoCorporalBanco.setNome(nome);

        }

        if(regiaoCorporal.getDescricao() != null && !regiaoCorporal.getDescricao().isBlank()){

            regiaoCorporalBanco.setDescricao(
                    regiaoCorporal.getDescricao().trim()
            );

        }

        return regiaoCorporalRepository.save(regiaoCorporalBanco);

    }

    public void deletarRegiaoCorporal(Long regiaoCorporalId){

        RegiaoCorporal regiaoCorporal = regiaoCorporalRepository.findById(regiaoCorporalId).orElseThrow(() ->
                new IllegalArgumentException("Região corporal não encontrada"));

        regiaoCorporalRepository.delete(regiaoCorporal);

    }

    public List<RegiaoCorporal> listarRegiaoCorporal(){
        return regiaoCorporalRepository.findAll();
    }

}
