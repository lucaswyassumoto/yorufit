package com.yoru.fit.service;

import com.yoru.fit.entity.Treino;
import com.yoru.fit.entity.Usuario;
import com.yoru.fit.repository.TreinoRepository;
import com.yoru.fit.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TreinoService {

    private TreinoRepository treinoRepository;

    private UsuarioRepository usuarioRepository;

    public TreinoService(TreinoRepository treinoRepository, UsuarioRepository usuarioRepository){
        this.treinoRepository = treinoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public Treino buscarTreino(Long treinoId){

        return treinoRepository.findById(treinoId).orElseThrow(() ->
                new IllegalArgumentException("Treino não encontrado"));

    }

    public Treino criarTreino(Treino treino, Long usuarioId){

        Usuario usuario = usuarioRepository.findById(usuarioId).orElseThrow(() ->
                new IllegalArgumentException("Usuário não encontrado"));

        if(treino.getNome() == null || treino.getNome().isBlank()){
            throw new IllegalArgumentException("Você precisa digitar um nome");
        }

        treino.setNome(
                treino.getNome().trim()
        );

        treino.setUsuario(usuario);

        treino.setDescricao(treino.getDescricao().trim());

        treino.setDtCriacao(LocalDateTime.now());

        return treinoRepository.save(treino);

    }

    public Treino editarTreino(Treino treino, Long usuarioId){

        Treino treinoBanco = treinoRepository.findById(treino.getId()).orElseThrow(() ->
                new IllegalArgumentException("Treino não encontrado"));

        if(!treinoBanco.getUsuario().getId().equals(usuarioId)){
            throw new IllegalArgumentException("Você não pode editar esse treino");
        }

        if(treino.getNome() != null && !treino.getNome().isBlank()){
            treinoBanco.setNome(
                    treino.getNome().trim()
            );
        }

        if(treino.getDescricao() != null && !treino.getDescricao().isBlank()){
            treinoBanco.setDescricao(
                    treino.getDescricao().trim()
            );
        }

        return treinoRepository.save(treinoBanco);

    }

}
