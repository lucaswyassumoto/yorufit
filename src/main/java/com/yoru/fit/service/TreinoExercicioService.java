package com.yoru.fit.service;

import com.yoru.fit.entity.Exercicio;
import com.yoru.fit.entity.Treino;
import com.yoru.fit.entity.TreinoExercicio;
import com.yoru.fit.repository.ExercicioRepository;
import com.yoru.fit.repository.TreinoExercicioRepository;
import com.yoru.fit.repository.TreinoRepository;
import org.springframework.stereotype.Service;

@Service
public class TreinoExercicioService {

    private final TreinoExercicioRepository treinoExercicioRepository;
    private final TreinoRepository treinoRepository;
    private final ExercicioRepository exercicioRepository;

    public TreinoExercicioService(TreinoExercicioRepository treinoExercicioRepository, TreinoRepository treinoRepository, ExercicioRepository exercicioRepository){
        this.treinoExercicioRepository = treinoExercicioRepository;
        this.treinoRepository = treinoRepository;
        this.exercicioRepository = exercicioRepository;
    }

    public TreinoExercicio criarTreinoExercicio(TreinoExercicio treinoExercicio, Long usuarioId){

        Treino treino = treinoRepository.findById(treinoExercicio.getTreino().getId()).orElseThrow(() ->
                new IllegalArgumentException("Treino não encontrado"));

        if(!treino.getUsuario().getId().equals(usuarioId)){
            throw new IllegalArgumentException("Este usuário não pode adicionar este treino");
        }

        Exercicio exercicio = exercicioRepository.findById(treinoExercicio.getExercicio().getId()).orElseThrow(() ->
                new IllegalArgumentException("Exercicio não encontrado"));

        if(treinoExercicio.getOrdem() == null){
            throw new IllegalArgumentException("A ordem não pode ser nula");
        }

        if(treinoExercicio.getSeries() == null || treinoExercicio.getSeries() <= 0){
            throw new IllegalArgumentException("O número de séries deve ser maior que zero");
        }

        if(treinoExercicio.getRepeticoes() == null || treinoExercicio.getRepeticoes() <= 0){
            throw new IllegalArgumentException("O número de repetições deve ser maior que zero");
        }

        if(treinoExercicio.getDescanso() == null || treinoExercicio.getDescanso() < 0){
            throw new IllegalArgumentException("O tempo de descanso não pode ser menor que zero");
        }

        if(treinoExercicioRepository.existsByTreinoIdAndOrdem(
                treinoExercicio.getTreino().getId(),
                treinoExercicio.getOrdem()
        )){
            throw new IllegalArgumentException("Já existe um exercicio nessa posição da ordem");
        }

        treinoExercicio.setTreino(treino);
        treinoExercicio.setExercicio(exercicio);

        if(treinoExercicio.getObservacao() != null && !treinoExercicio.getObservacao().isBlank()){
            treinoExercicio.setObservacao(
                    treinoExercicio.getObservacao().trim()
            );
        }

        return treinoExercicioRepository.save(treinoExercicio);

    }

    public TreinoExercicio editarTreinoExercicio(TreinoExercicio treinoExercicio, Long usuarioId){

        TreinoExercicio treinoExercicioBanco = treinoExercicioRepository.findById(treinoExercicio.getId()).orElseThrow(() ->
                new IllegalArgumentException("Treino de exercícios não encontrado"));

        if(!treinoExercicioBanco.getTreino().getUsuario().getId().equals(usuarioId)){
            throw new IllegalArgumentException("Usuário não pode editar este treino");
        }

        if(treinoExercicio.getSeries() != null){
            if(treinoExercicio.getSeries() <= 0){
                throw new IllegalArgumentException("O número de séries deve ser maior que zero");
            }

            treinoExercicioBanco.setSeries(
                    treinoExercicio.getSeries()
            );
        }

        if(treinoExercicio.getRepeticoes() != null){
            if(treinoExercicio.getRepeticoes() <= 0){
                throw new IllegalArgumentException("O número de repetições deve ser maior que zero");
            }

            treinoExercicioBanco.setRepeticoes(
                    treinoExercicio.getRepeticoes()
            );
        }

        if(treinoExercicio.getDescanso() != null){
            if(treinoExercicio.getDescanso() < 0){
                throw new IllegalArgumentException("O tempo de descanso não pode ser menor que zero");
            }

            treinoExercicioBanco.setDescanso(
                    treinoExercicio.getDescanso()
            );
        }

        if(treinoExercicio.getObservacao() != null && !treinoExercicio.getObservacao().isBlank()){
            treinoExercicioBanco.setObservacao(
                    treinoExercicio.getObservacao().trim()
            );
        }

        return treinoExercicioRepository.save(treinoExercicioBanco);

    }

    public void excluirTreinoExercicio(Long treinoExercicioId, Long usuarioId){

        TreinoExercicio treinoExercicio = treinoExercicioRepository.findById(treinoExercicioId).orElseThrow(() ->
                new IllegalArgumentException("TreinoExercicio não encontrado"));

        if(!treinoExercicio.getTreino().getUsuario().getId().equals(usuarioId)){
            throw new IllegalArgumentException("Usuário não tem permissão para apagar este exercício");
        }

        treinoExercicioRepository.delete(treinoExercicio);

    }

}
