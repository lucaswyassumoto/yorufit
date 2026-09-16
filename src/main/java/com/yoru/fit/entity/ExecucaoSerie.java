package com.yoru.fit.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "execucao_serie",
        uniqueConstraints = {
        @UniqueConstraint(
                name = "uk_execucao_exercicio_numero_serie",
                columnNames = {"execucao_exercicio_id", "numero_serie"}
        )
    }
)
public class ExecucaoSerie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "execucao_exercicio_id", nullable = false)
    private ExecucaoExercicio execucaoExercicio;

    @Column(name = "numero_serie", nullable = false)
    private Integer numeroSerie;

    @Column(name = "repeticoes", nullable = false)
    private Integer repeticoes;

    @Column(name = "carga", precision = 6, scale = 2)
    private BigDecimal carga;

    @Column(name = "observacao", columnDefinition = "TEXT")
    private String observacao;


    public ExecucaoSerie(){}

    public ExecucaoSerie(Long id, ExecucaoExercicio execucaoExercicio, Integer numeroSerie, Integer repeticoes, BigDecimal carga, String observacao) {
        this.id = id;
        this.execucaoExercicio = execucaoExercicio;
        this.numeroSerie = numeroSerie;
        this.repeticoes = repeticoes;
        this.carga = carga;
        this.observacao = observacao;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ExecucaoExercicio getExecucaoExercicio() {
        return execucaoExercicio;
    }

    public void setExecucaoExercicio(ExecucaoExercicio execucaoExercicio) {
        this.execucaoExercicio = execucaoExercicio;
    }

    public Integer getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(Integer numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public Integer getRepeticoes() {
        return repeticoes;
    }

    public void setRepeticoes(Integer repeticoes) {
        this.repeticoes = repeticoes;
    }

    public BigDecimal getCarga() {
        return carga;
    }

    public void setCarga(BigDecimal carga) {
        this.carga = carga;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

}
