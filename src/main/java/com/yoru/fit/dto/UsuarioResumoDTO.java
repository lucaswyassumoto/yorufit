package com.yoru.fit.dto;

public class UsuarioResumoDTO {

    private String nome;

    private String senha;

    private String fotoPerfil;

    public UsuarioResumoDTO(){};

    public UsuarioResumoDTO(String nome, String senha, String fotoPerfil) {
        this.nome = nome;
        this.senha = senha;
        this.fotoPerfil = fotoPerfil;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(String fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }

}
