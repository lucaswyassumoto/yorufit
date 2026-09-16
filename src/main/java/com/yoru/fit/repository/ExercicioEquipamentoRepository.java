package com.yoru.fit.repository;

import com.yoru.fit.entity.ExercicioEquipamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExercicioEquipamentoRepository extends JpaRepository<ExercicioEquipamento, Long> {



}
