package com.yoru.fit.entity;

import jakarta.persistence.*;

@Entity
@Table(
        name = "execucao_exercicio",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_treino_execucao_ordem",
                        columnNames = {"treino_execucao_id", "ordem"}
                )
        }
)
public class ExecucaoExercicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "treino_execucao_id", nullable = false)
    private TreinoExecucao treinoExecucao;

    @ManyToOne
    @JoinColumn(name = "treino_exercicio_id", nullable = false)
    private TreinoExercicio treinoExercicio;

    @Column(name = "ordem", nullable = false)
    private Integer ordem;


    public ExecucaoExercicio(){}

    public ExecucaoExercicio(Long id, TreinoExecucao treinoExecucao, TreinoExercicio treinoExercicio, Integer ordem) {
        this.id = id;
        this.treinoExecucao = treinoExecucao;
        this.treinoExercicio = treinoExercicio;
        this.ordem = ordem;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TreinoExecucao getTreinoExecucao() {
        return treinoExecucao;
    }

    public void setTreinoExecucao(TreinoExecucao treinoExecucao) {
        this.treinoExecucao = treinoExecucao;
    }

    public TreinoExercicio getTreinoExercicio() {
        return treinoExercicio;
    }

    public void setTreinoExercicio(TreinoExercicio treinoExercicio) {
        this.treinoExercicio = treinoExercicio;
    }

    public Integer getOrdem() {
        return ordem;
    }

    public void setOrdem(Integer ordem) {
        this.ordem = ordem;
    }

}
