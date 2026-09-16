package com.yoru.fit.service;

import com.yoru.fit.entity.ExecucaoExercicio;
import com.yoru.fit.entity.ExecucaoSerie;
import com.yoru.fit.enums.Status;
import com.yoru.fit.repository.ExecucaoExercicioRepository;
import com.yoru.fit.repository.ExecucaoSerieRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ExecucaoSerieService {

    private final ExecucaoSerieRepository execucaoSerieRepository;
    private final ExecucaoExercicioRepository execucaoExercicioRepository;

    public ExecucaoSerieService(ExecucaoSerieRepository execucaoSerieRepository, ExecucaoExercicioRepository execucaoExercicioRepository){
        this.execucaoSerieRepository = execucaoSerieRepository;
        this.execucaoExercicioRepository = execucaoExercicioRepository;
    }

    public ExecucaoSerie registrarSerie(ExecucaoSerie execucaoSerie, Long execucaoExercicioId, Long usuarioId){

        ExecucaoExercicio execucaoExercicio = execucaoExercicioRepository.findById(execucaoExercicioId).orElseThrow(() ->
                new IllegalArgumentException("Execução do exercicio não encontrada"));

        if(!execucaoExercicio.getTreinoExecucao().getTreino().getUsuario().getId().equals(usuarioId)){
            throw new IllegalArgumentException("Usuário não tem permissão para acessar treino");
        }

        if(!execucaoExercicio.getTreinoExecucao().getStatus().equals(Status.EM_ANDAMENTO)){
            throw new IllegalArgumentException("Essa execução não está em andamento");
        }

        if(execucaoSerie.getNumeroSerie() == null || execucaoSerie.getNumeroSerie() <= 0){
            throw new IllegalArgumentException("O número de série deve ser maior que zero");
        }

        if (execucaoSerie.getRepeticoes() == null || execucaoSerie.getRepeticoes() <= 0){
            throw new IllegalArgumentException("O número de repetições deve ser maior que zero");
        }

        if(execucaoSerie.getCarga() != null && execucaoSerie.getCarga().compareTo(BigDecimal.ZERO) < 0){
            throw new IllegalArgumentException("A carga não pode ser negativa");
        }

        if(execucaoSerieRepository
                .existsByExecucaoExercicioIdAndNumeroSerie(
                        execucaoExercicioId,
                        execucaoSerie.getNumeroSerie()
                )) {

            throw new IllegalArgumentException(
                    "Esta série já foi registrada"
            );
        }

        ExecucaoSerie novaSerie = new ExecucaoSerie();

        novaSerie.setExecucaoExercicio(execucaoExercicio);
        novaSerie.setNumeroSerie(execucaoSerie.getNumeroSerie());
        novaSerie.setRepeticoes(execucaoSerie.getRepeticoes());
        novaSerie.setCarga(execucaoSerie.getCarga());

        if(execucaoSerie.getObservacao() != null && !execucaoSerie.getObservacao().isBlank()){
            novaSerie.setObservacao(execucaoSerie.getObservacao().trim());
        }

        return execucaoSerieRepository.save(novaSerie);

    }


}
