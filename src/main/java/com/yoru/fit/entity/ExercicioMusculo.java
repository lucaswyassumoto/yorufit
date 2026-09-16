package com.yoru.fit.entity;

import com.yoru.fit.enums.Tipo;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Entity
@Table(
        name = "exercicio_musculo",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_exercicio_musculo",
                        columnNames = {"exercicio_id", "musculo_id"}
                )
        }
)
public class ExercicioMusculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "exercicio_id", nullable = false)
    private Exercicio exercicio;

    @ManyToOne
    @JoinColumn(name = "musculo_id", nullable = false)
    private Musculo musculo;

    @Enumerated(EnumType.STRING)
    @JdbcTypeCode(SqlTypes.NAMED_ENUM)
    @Column(name = "tipo", nullable = false)
    private Tipo tipo;


    public ExercicioMusculo(){}

    public ExercicioMusculo(Long id, Exercicio exercicio, Musculo musculo, Tipo tipo) {
        this.id = id;
        this.exercicio = exercicio;
        this.musculo = musculo;
        this.tipo = tipo;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Exercicio getExercicio() {
        return exercicio;
    }

    public void setExercicio(Exercicio exercicio) {
        this.exercicio = exercicio;
    }

    public Musculo getMusculo() {
        return musculo;
    }

    public void setMusculo(Musculo musculo) {
        this.musculo = musculo;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

}