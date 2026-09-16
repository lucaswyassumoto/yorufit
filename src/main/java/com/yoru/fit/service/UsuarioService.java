package com.yoru.fit.service;

import com.yoru.fit.dto.UsuarioResumoDTO;
import com.yoru.fit.entity.Usuario;
import com.yoru.fit.repository.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder){
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Usuario criarUsuario(Usuario usuario){

        if(usuario.getNome() == null || usuario.getNome().isBlank()){
            throw new IllegalArgumentException("Você precisa digitar o nome de usuário");
        }

        usuario.setNome(
                usuario.getNome().trim()
        );

        if(usuario.getEmail() == null || usuario.getEmail().isBlank()){
            throw new IllegalArgumentException("Você precisa digitar um email");
        }

        usuario.setEmail(
                usuario.getEmail().trim().toLowerCase()
        );

        if(usuarioRepository.existsByEmail(usuario.getEmail())){
            throw new IllegalArgumentException("Esse email já possui um cadastro");
        }

        if(usuario.getSenha() == null || usuario.getSenha().isBlank()){
            throw new IllegalArgumentException("Você precisa digitar uma senha");
        }

        if(usuario.getSenha().length() < 8){
            throw new IllegalArgumentException("A senha precisa ter no mínimo 8 digítos");
        }

        usuario.setSenha(
                passwordEncoder.encode(usuario.getSenha().trim())
        );

        if(usuario.getDtNascimento() == null){
            throw new IllegalArgumentException("A data de nascimento é obrigatória");
        }

        if(usuario.getDtNascimento().isAfter(LocalDate.now())){
            throw new IllegalArgumentException("A data de nascimento não pode ser maior que a data atual");
        }

        if(usuario.getFotoPerfil().isBlank() || usuario.getFotoPerfil() == null){
            usuario.setFotoPerfil("/");
        }

        usuario.setDtCriacao(LocalDateTime.now());

        return usuarioRepository.save(usuario);
    }


    public Usuario editarUsuario(UsuarioResumoDTO dto, Long usuarioId){

       Usuario usuario = usuarioRepository.findById(usuarioId).orElseThrow(() ->
               new IllegalArgumentException("Usuário não encontrado"));

       if(dto.getNome() != null && !dto.getNome().isBlank()){

           String novoNome = dto.getNome().trim();

           if(novoNome.equals(usuario.getNome())) {
               throw new IllegalArgumentException("Este já é o seu nome atual");
           }

           usuario.setNome(novoNome);
       }

       if(dto.getSenha() != null && !dto.getSenha().isBlank()){

           String novaSenha = dto.getSenha().trim();

           if(passwordEncoder.matches(novaSenha, usuario.getSenha())){
                throw new IllegalArgumentException("A senha não pode ser igual a anterior");
           }

           usuario.setSenha(
                   passwordEncoder.encode(novaSenha)
           );

       }

       if(dto.getFotoPerfil() != null && !dto.getFotoPerfil().isBlank()){

           usuario.setFotoPerfil(
                   dto.getFotoPerfil().trim()
           );

       }

       return usuarioRepository.save(usuario);

    };

    public List<Usuario> listarTodos(){
        return usuarioRepository.findAll();
    }

}
