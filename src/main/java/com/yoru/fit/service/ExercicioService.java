package com.yoru.fit.service;

import com.yoru.fit.entity.Exercicio;
import com.yoru.fit.repository.ExercicioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExercicioService {

    private final ExercicioRepository exercicioRepository;

    public ExercicioService(ExercicioRepository exercicioRepository) {
        this.exercicioRepository = exercicioRepository;
    }

    public Exercicio criarExercicio(Exercicio exercicio){

        if(exercicio.getNome() == null || exercicio.getNome().isBlank()){
            throw new IllegalArgumentException("Você precisa digitar um nome para o exercício");
        }

        String nome = exercicio.getNome().trim();

        if(exercicioRepository.existsByNome(nome)){
            throw new IllegalArgumentException("Esse nome já pertence a um exercício existente");
        }

        exercicio.setNome(nome);

        if(exercicio.getDescricao() == null || exercicio.getDescricao().isBlank()){
            throw new IllegalArgumentException("Você precisa escrever a descrição do exercício");
        }

        exercicio.setDescricao(exercicio.getDescricao().trim());

        if(exercicio.getInstrucoes() == null || exercicio.getInstrucoes().isBlank()){
            throw new IllegalArgumentException("Você precisa escrever a instrução do exercício");
        }

        exercicio.setInstrucoes(exercicio.getInstrucoes().trim());

        if(exercicio.getImagemUrl() == null || exercicio.getImagemUrl().isBlank()){
            exercicio.setImagemUrl("/");
        }

        if(exercicio.getVideoUrl() == null || exercicio.getVideoUrl().isBlank()){
            exercicio.setVideoUrl("/");
        }

        return exercicioRepository.save(exercicio);

    }

    public Exercicio editarExercicio(Exercicio exercicio, Long exercicioId){

        Exercicio exercicioBanco = exercicioRepository.findById(exercicioId).orElseThrow(() ->
                new IllegalArgumentException("Exercício não encontrado"));

        if(exercicio.getNome() != null && !exercicio.getNome().isBlank()){

            String nome = exercicio.getNome().trim();

            if(exercicioRepository.existsByNomeAndIdNot(nome, exercicioId)){
                throw new IllegalArgumentException("Esse nome já pertence a um exercício");
            }

            exercicioBanco.setNome(nome);

        }

        if(exercicio.getDescricao() != null && !exercicio.getDescricao().isBlank()){
            exercicioBanco.setDescricao(exercicio.getDescricao().trim());
        }

        if(exercicio.getInstrucoes() != null && !exercicio.getInstrucoes().isBlank()){
            exercicioBanco.setInstrucoes(exercicio.getInstrucoes().trim());
        }

        if(exercicio.getImagemUrl() != null && !exercicio.getImagemUrl().isBlank()){
            exercicioBanco.setImagemUrl(exercicio.getImagemUrl());
        }

        if(exercicio.getVideoUrl() != null && !exercicio.getVideoUrl().isBlank()){
            exercicioBanco.setVideoUrl(exercicio.getVideoUrl());
        }

        return exercicioRepository.save(exercicioBanco);

    }

    public void deletarExercicio(Long exercicioId){

        Exercicio exercicio = exercicioRepository.findById(exercicioId).orElseThrow(() ->
                new IllegalArgumentException("Exercício não encontrado"));

        exercicioRepository.delete(exercicio);

    }

    public List<Exercicio> listarTodos(){
        return exercicioRepository.findAll();
    }

}
