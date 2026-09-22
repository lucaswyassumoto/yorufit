package com.yoru.fit.service;

import com.yoru.fit.entity.Musculo;
import com.yoru.fit.entity.RegiaoCorporal;
import com.yoru.fit.repository.MusculoRepository;
import com.yoru.fit.repository.RegiaoCorporalRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusculoService {

    private final MusculoRepository musculoRepository;
    private final RegiaoCorporalRepository regiaoCorporalRepository;

    public MusculoService(MusculoRepository musculoRepository, RegiaoCorporalRepository regiaoCorporalRepository) {
        this.musculoRepository = musculoRepository;
        this.regiaoCorporalRepository = regiaoCorporalRepository;
    }

    public Musculo addMusculo(Musculo musculo, Long regiaoCorporalId){

        RegiaoCorporal regiaoCorporal = regiaoCorporalRepository.findById(regiaoCorporalId).orElseThrow(() ->
                new IllegalArgumentException("Região corporal não encontrada"));

        if(musculo.getNome() == null || musculo.getNome().isBlank()){
            throw new IllegalArgumentException("Você precisa digitar o nome do músculo");
        }

        String nome = musculo.getNome().trim();

        if(musculoRepository.existsByNome(nome)){
            throw new IllegalArgumentException("Esse nome já pertence a um músculo existente");
        }

        musculo.setNome(nome);

        if(musculo.getDescricao() == null || musculo.getDescricao().isBlank()){
            throw new IllegalArgumentException("Você precisa adicionar uma descrição");
        }

        musculo.setDescricao(
                musculo.getDescricao().trim()
        );

        if(musculo.getImagemUrl() == null || musculo.getImagemUrl().isBlank()){
            musculo.setImagemUrl("/");
        }

        musculo.setRegiaoCorporal(regiaoCorporal);

        return musculoRepository.save(musculo);

    }

    public Musculo editarMusculo(Musculo musculo, Long musculoId, Long regiaoCorporalId){

        Musculo musculoBanco = musculoRepository.findById(musculoId).orElseThrow(() ->
                new IllegalArgumentException("Músculo não encontrado"));

        if(musculo.getNome() != null && !musculo.getNome().isBlank()){

            String nome = musculo.getNome().trim();

            if(musculoRepository.existsByNomeAndNotId(nome, musculoId)){
                throw new IllegalArgumentException("Esse nome já pertence a um músculo");
            }

            musculoBanco.setNome(nome);

        }

        if(musculo.getDescricao() != null && !musculo.getDescricao().isBlank()){

            musculoBanco.setDescricao(
                    musculo.getDescricao().trim()
            );

        }

        if(musculo.getImagemUrl() != null && !musculo.getImagemUrl().isBlank()){

            musculoBanco.setImagemUrl(
                    musculo.getImagemUrl().trim()
            );

        }

        if(musculo.getRegiaoCorporal() != null){

            RegiaoCorporal regiaoCorporal = regiaoCorporalRepository.findById(regiaoCorporalId).orElseThrow(() ->
                    new IllegalArgumentException("Região corporal não encontrada"));

            musculoBanco.setRegiaoCorporal(regiaoCorporal);
        }

        return musculoRepository.save(musculoBanco);

    }

    public void deletarMusculo(Long musculoId){

        Musculo musculo = musculoRepository.findById(musculoId).orElseThrow(() ->
                new IllegalArgumentException("Músculo não encontrado"));

        musculoRepository.delete(musculo);

    }

    public List<Musculo> listarMusculos(){
        return musculoRepository.findAll();
    }

}