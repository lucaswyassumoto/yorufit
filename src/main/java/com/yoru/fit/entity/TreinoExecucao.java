package com.yoru.fit.entity;

import com.yoru.fit.enums.Status;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;

@Entity
@Table(name = "treino_execucao")
public class TreinoExecucao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "treino_id", nullable = false)
    private Treino treino;

    @Column(name = "dt_inicio")
    private LocalDateTime dtInicio;

    @Column(name = "dt_fim")
    private LocalDateTime dtFim;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    @JdbcTypeCode(SqlTypes.NAMED_ENUM)
    private Status status;


    public TreinoExecucao(){}

    public TreinoExecucao(Long id, Treino treino, LocalDateTime dtInicio, LocalDateTime dtFim, Status status) {
        this.id = id;
        this.treino = treino;
        this.dtInicio = dtInicio;
        this.dtFim = dtFim;
        this.status = status;
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

    public LocalDateTime getDtInicio() {
        return dtInicio;
    }

    public void setDtInicio(LocalDateTime dtInicio) {
        this.dtInicio = dtInicio;
    }

    public LocalDateTime getDtFim() {
        return dtFim;
    }

    public void setDtFim(LocalDateTime dtFim) {
        this.dtFim = dtFim;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

}
