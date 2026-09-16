package com.yoru.fit.repository;

import com.yoru.fit.entity.ExercicioMusculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExercicioMusculoRepository extends JpaRepository<ExercicioMusculo, Long> {



}
