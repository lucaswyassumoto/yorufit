package com.yoru.fit.repository;

import com.yoru.fit.entity.Treino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TreinoRepository extends JpaRepository<Treino, Long> {

    Optional<Treino> findByNome(String nome);

}
