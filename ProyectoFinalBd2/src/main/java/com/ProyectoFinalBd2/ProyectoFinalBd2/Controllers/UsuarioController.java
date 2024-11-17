package com.ProyectoFinalBd2.ProyectoFinalBd2.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ProyectoFinalBd2.ProyectoFinalBd2.Models.Usuarios;
import com.ProyectoFinalBd2.ProyectoFinalBd2.Services.UsuarioService;


@RestController
@RequestMapping("/api/Usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/allMongo")
    public List<Usuarios> getAllUsuarios() {
        return usuarioService.getAllUsuarios();
    }

    @GetMapping("/allNeo")
    public List<Usuarios> getAllUsuariosNeo() {
        return usuarioService.getAllUsuariosNeo();
    }

    @PostMapping("/save")
    public Usuarios saveUsuario(@RequestBody Usuarios usuario) {
        System.out.println("Usuario recibido desde el JSON: " + usuario);
        return usuarioService.guardarUsuarios(usuario);
    }
    

    @DeleteMapping("/delete")
    public void deleteUsuario(String id) {
        usuarioService.eliminarUsuario(id);
    }
    
}
