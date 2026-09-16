package com.yoru.fit.service;

import com.yoru.fit.entity.ExecucaoExercicio;
import com.yoru.fit.entity.TreinoExecucao;
import com.yoru.fit.entity.TreinoExercicio;
import com.yoru.fit.enums.Status;
import com.yoru.fit.repository.ExecucaoExercicioRepository;
import com.yoru.fit.repository.TreinoExecucaoRepository;
import com.yoru.fit.repository.TreinoExercicioRepository;
import org.springframework.stereotype.Service;

@Service
public class ExecucaoExercicioService {

    private final ExecucaoExercicioRepository execucaoExercicioRepository;
    private final TreinoExecucaoRepository treinoExecucaoRepository;
    private final TreinoExercicioRepository treinoExercicioRepository;

    public ExecucaoExercicioService(ExecucaoExercicioRepository execucaoExercicioRepository, TreinoExecucaoRepository treinoExecucaoRepository, TreinoExercicioRepository treinoExercicioRepository) {
        this.execucaoExercicioRepository = execucaoExercicioRepository;
        this.treinoExecucaoRepository = treinoExecucaoRepository;
        this.treinoExercicioRepository = treinoExercicioRepository;
    }

    public ExecucaoExercicio iniciarExecucaoExercicio(Long treinoExecucaoId, Long treinoExercicioId, Long usuarioId){

        TreinoExecucao treinoExecucao = treinoExecucaoRepository.findById(treinoExecucaoId).orElseThrow(() ->
                new IllegalArgumentException("Execução não encontrada"));

        if(!treinoExecucao.getTreino().getUsuario().getId().equals(usuarioId)){
            throw new IllegalArgumentException("Usuário não pode iniciar execução");
        }

        TreinoExercicio treinoExercicio = treinoExercicioRepository.findById(treinoExercicioId).orElseThrow(() ->
                new IllegalArgumentException("Exercício não encontrado"));

        if(!treinoExercicio.getTreino().getId().equals(treinoExecucao.getTreino().getId())){
            throw new IllegalArgumentException("Este exercicio não pertence a este treino");
        }

        if(!treinoExecucao.getStatus().equals(Status.EM_ANDAMENTO)){
            throw new IllegalArgumentException("Esta execução não está em andamento");
        }

        if(execucaoExercicioRepository.existsByTreinoExecucaoIdAndTreinoExercicioId(
                treinoExecucaoId,
                treinoExercicioId
        )){
            throw new IllegalArgumentException("Este exercício já foi iniciado nesta execução");
        }

        ExecucaoExercicio execucaoExercicio = new ExecucaoExercicio();

        execucaoExercicio.setTreinoExecucao(treinoExecucao);
        execucaoExercicio.setTreinoExercicio(treinoExercicio);
        execucaoExercicio.setOrdem(treinoExercicio.getOrdem());

        return execucaoExercicioRepository.save(execucaoExercicio);

    }

}
