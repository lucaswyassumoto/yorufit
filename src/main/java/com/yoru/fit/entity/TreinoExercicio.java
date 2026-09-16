package com.yoru.fit.entity;

import jakarta.persistence.*;

@Entity
@Table(
        name = "treino_exercicio",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_treino_ordem",
                        columnNames = {"treino_id", "ordem"}
                )
        }
)
public class TreinoExercicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "treino_id", nullable = false)
    private Treino treino;

    @ManyToOne
    @JoinColumn(name = "exercicio_id", nullable = false)
    private Exercicio exercicio;

    @Column(name = "ordem", nullable = false)
    private Integer ordem;

    @Column(name = "series", nullable = false)
    private Integer series;

    @Column(name = "repeticoes", nullable = false)
    private Integer repeticoes;

    @Column(name = "descanso", nullable = false)
    private Integer descanso;

    @Column(name = "observacao", columnDefinition = "TEXT")
    private String observacao;


    public TreinoExercicio(){}

    public TreinoExercicio(Long id, Treino treino, Exercicio exercicio, Integer ordem, Integer series, Integer repeticoes, Integer descanso, String observacao) {
        this.id = id;
        this.treino = treino;
        this.exercicio = exercicio;
        this.ordem = ordem;
        this.series = series;
        this.repeticoes = repeticoes;
        this.descanso = descanso;
        this.observacao = observacao;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Treino getTreino() {
        return treino;
    }

    public void setTreino(Treino treino) {
        this.treino = treino;
    }

    public Exercicio getExercicio() {
        return exercicio;
    }

    public void setExercicio(Exercicio exercicio) {
        this.exercicio = exercicio;
    }

    public Integer getOrdem() {
        return ordem;
    }

    public void setOrdem(Integer ordem) {
        this.ordem = ordem;
    }

    public Integer getSeries() {
        return series;
    }

    public void setSeries(Integer series) {
        this.series = series;
    }

    public Integer getRepeticoes() {
        return repeticoes;
    }

    public void setRepeticoes(Integer repeticoes) {
        this.repeticoes = repeticoes;
    }

    public Integer getDescanso() {
        return descanso;
    }

    public void setDescanso(Integer descanso) {
        this.descanso = descanso;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

}
