package com.yoru.fit.entity;

import jakarta.persistence.*;

@Entity
@Table(
        name = "exercicio_equipamento",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_exercicio_equipamento",
                        columnNames = {"exercicio_id", "equipamento_id"}
                )
        }
)
public class ExercicioEquipamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "equipamento_id", nullable = false)
    private Equipamento equipamento;

    @ManyToOne
    @JoinColumn(name = "exercicio_id", nullable = false)
    private Exercicio exercicio;


    public ExercicioEquipamento(){}

    public ExercicioEquipamento(Long id, Equipamento equipamento, Exercicio exercicio) {
        this.id = id;
        this.equipamento = equipamento;
        this.exercicio = exercicio;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }

    public Exercicio getExercicio() {
        return exercicio;
    }

    public void setExercicio(Exercicio exercicio) {
        this.exercicio = exercicio;
    }


}
