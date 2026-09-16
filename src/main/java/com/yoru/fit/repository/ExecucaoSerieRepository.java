package com.yoru.fit.repository;

import com.yoru.fit.entity.ExecucaoSerie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExecucaoSerieRepository extends JpaRepository<ExecucaoSerie, Long> {

    boolean existsByExecucaoExercicioIdAndNumeroSerie(
            Long execucaoExercicioId,
            Integer numeroSerie
    );

}
