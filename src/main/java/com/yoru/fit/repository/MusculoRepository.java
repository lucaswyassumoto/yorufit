package com.yoru.fit.repository;

import com.yoru.fit.entity.Musculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MusculoRepository extends JpaRepository<Musculo, Long> {

    Optional<Musculo> findByNome(String nome);

    boolean existsByNome(String nome);

    boolean existsByNomeAndNotId(String nome, Long musculoId);

}
