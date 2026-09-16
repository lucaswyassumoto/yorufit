package com.yoru.fit.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "musculo")
public class Musculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome", unique = true, nullable = false)
    private String nome;

    @Column(name = "descricao", columnDefinition = "TEXT", nullable = false)
    private String descricao;

    @Column(name = "imagem_url", columnDefinition = "TEXT")
    private String imagemUrl;

    @ManyToOne
    @JoinColumn(name = "regiao_corporal", nullable = false)
    private RegiaoCorporal regiaoCorporal;


    public Musculo(){}

    public Musculo(Long id, String nome, String descricao, String imagemUrl, RegiaoCorporal regiaoCorporal) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.imagemUrl = imagemUrl;
        this.regiaoCorporal = regiaoCorporal;
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

    public String getImagemUrl() {
        return imagemUrl;
    }

    public void setImagemUrl(String imagemUrl) {
        this.imagemUrl = imagemUrl;
    }

    public RegiaoCorporal getRegiaoCorporal() {
        return regiaoCorporal;
    }

    public void setRegiaoCorporal(RegiaoCorporal regiaoCorporal) {
        this.regiaoCorporal = regiaoCorporal;
    }

}
