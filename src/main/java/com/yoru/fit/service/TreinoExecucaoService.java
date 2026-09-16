package com.yoru.fit.service;

import com.yoru.fit.entity.Treino;
import com.yoru.fit.entity.TreinoExecucao;
import com.yoru.fit.enums.Status;
import com.yoru.fit.repository.TreinoExecucaoRepository;
import com.yoru.fit.repository.TreinoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class TreinoExecucaoService {

    private final TreinoExecucaoRepository treinoExecucaoRepository;
    private final TreinoRepository treinoRepository;

    public TreinoExecucaoService(TreinoExecucaoRepository treinoExecucaoRepository, TreinoRepository treinoRepository) {
        this.treinoExecucaoRepository = treinoExecucaoRepository;
        this.treinoRepository = treinoRepository;
    }

    public TreinoExecucao iniciarExecucao(Long treinoId, Long usuarioId){

        Treino treino = treinoRepository.findById(treinoId).orElseThrow(() ->
                new IllegalArgumentException("Treino não encontrado"));

        if(!treino.getUsuario().getId().equals(usuarioId)){
            throw new IllegalArgumentException("Este treino não pertence a esse usuário");
        }

        if(treinoExecucaoRepository.existsByTreinoUsuarioIdAndStatus(
                usuarioId,
                Status.EM_ANDAMENTO
        )){
            throw new IllegalArgumentException("Você já possui um treino em andamento");
        }

        TreinoExecucao treinoExecucao = new TreinoExecucao();

        treinoExecucao.setTreino(treino);
        treinoExecucao.setDtInicio(LocalDateTime.now());
        treinoExecucao.setStatus(Status.EM_ANDAMENTO);

        return treinoExecucaoRepository.save(treinoExecucao);

    }

    public TreinoExecucao finalizarExecucao(Long treinoExecucaoId, Long usuarioId){

        TreinoExecucao treinoExecucao = treinoExecucaoRepository.findById(treinoExecucaoId).orElseThrow(() ->
                new IllegalArgumentException("Execução de treino não encontrada"));

        if(!treinoExecucao.getTreino().getUsuario().getId().equals(usuarioId)){
            throw new IllegalArgumentException("Usuário não pode finalizar este treino em andamento");
        }

        if(!treinoExecucao.getStatus().equals(Status.EM_ANDAMENTO)){
            throw new IllegalArgumentException("Este treino não foi iniciado");
        }

        treinoExecucao.setDtFim(LocalDateTime.now());
        treinoExecucao.setStatus(Status.CONCLUIDO);

        return treinoExecucaoRepository.save(treinoExecucao);

    }

}
