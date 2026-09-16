package com.yoru.fit.repository;

import com.yoru.fit.entity.TreinoExecucao;
import com.yoru.fit.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreinoExecucaoRepository extends JpaRepository<TreinoExecucao, Long> {

    boolean existsByTreinoUsuarioIdAndStatus(Long usuarioId, Status status);

}
