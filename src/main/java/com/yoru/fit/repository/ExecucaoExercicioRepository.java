package com.yoru.fit.repository;

import com.yoru.fit.entity.ExecucaoExercicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExecucaoExercicioRepository extends JpaRepository<ExecucaoExercicio, Long> {

    boolean existsByTreinoExecucaoIdAndOrdem(Long treinoExecucaoId, Integer ordem);

    boolean existsByTreinoExecucaoIdAndTreinoExercicioId(
            Long treinoExecucaoId,
            Long treinoExercicioId
    );

}
