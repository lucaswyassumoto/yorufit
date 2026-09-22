package com.yoru.fit.repository;

import com.yoru.fit.entity.RegiaoCorporal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegiaoCorporalRepository extends JpaRepository<RegiaoCorporal, Long> {

    Optional<RegiaoCorporal> findByNome(String nome);

    boolean existsByNome(String nome);

    boolean existsByNomeAndIdNot(String nome, Long regiaoCorporalId);

}
