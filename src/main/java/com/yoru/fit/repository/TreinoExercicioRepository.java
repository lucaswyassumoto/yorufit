package com.yoru.fit.repository;

import com.yoru.fit.entity.TreinoExercicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreinoExercicioRepository extends JpaRepository<TreinoExercicio, Long> {

    boolean existsByTreinoIdAndOrdem(Long treinoId, Integer ordem);

}
