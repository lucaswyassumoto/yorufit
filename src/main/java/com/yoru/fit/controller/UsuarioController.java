package com.yoru.fit.controller;

import com.yoru.fit.dto.UsuarioResumoDTO;
import com.yoru.fit.entity.Usuario;
import com.yoru.fit.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/cadastrar")
    public Usuario criar(@RequestBody Usuario usuario){
        return usuarioService.criarUsuario(usuario);
    }

    @PutMapping("/editar-usuario")
    public Usuario editar(@RequestBody UsuarioResumoDTO dto, @RequestParam Long usuarioId){
        return usuarioService.editarUsuario(dto, usuarioId);
    }

    @GetMapping("/buscar-usuarios")
    public List<Usuario> listar(){
        return usuarioService.listarTodos();
    }


}
