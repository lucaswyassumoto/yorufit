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

    @PostMapping
    public Usuario criar(@RequestBody Usuario usuario){
        return usuarioService.criarUsuario(usuario);
    }

    @PutMapping("/{usuarioId}")
    public Usuario editar(@RequestBody UsuarioResumoDTO dto, @PathVariable Long usuarioId){
        return usuarioService.editarUsuario(dto, usuarioId);
    }

    @GetMapping
    public List<Usuario> listar(){
        return usuarioService.listarTodos();
    }

}
