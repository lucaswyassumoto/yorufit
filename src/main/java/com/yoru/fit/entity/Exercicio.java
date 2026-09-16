package com.yoru.fit.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "exercicio")
public class Exercicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome", unique = true, nullable = false)
    private String nome;

    @Column(name = "descricao", nullable = false, columnDefinition = "TEXT")
    private String descricao;

    @Column(name = "instrucoes", nullable = false, columnDefinition = "TEXT")
    private String instrucoes;

    @Column(name = "video_url", columnDefinition = "TEXT")
    private String videoUrl;

    @Column(name = "imagem_url", columnDefinition = "TEXT")
    private String imagemUrl;


    public Exercicio(){}

    public Exercicio(Long id, String nome, String descricao, String instrucoes, String videoUrl, String imagemUrl) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.instrucoes = instrucoes;
        this.videoUrl = videoUrl;
        this.imagemUrl = imagemUrl;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getInstrucoes() {
        return instrucoes;
    }

    public void setInstrucoes(String instrucoes) {
        this.instrucoes = instrucoes;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getImagemUrl() {
        return imagemUrl;
    }

    public void setImagemUrl(String imagemUrl) {
        this.imagemUrl = imagemUrl;
    }


}
