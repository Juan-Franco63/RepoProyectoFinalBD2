package com.ProyectoFinalBd2.ProyectoFinalBd2.MONGODB.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ProyectoFinalBd2.ProyectoFinalBd2.MONGODB.Models.Usuarios;
import com.ProyectoFinalBd2.ProyectoFinalBd2.MONGODB.Services.UsuarioServiceMongo;

@RestController
@RequestMapping("/api/usuariosMongo")
public class UsuarioControllerMongo {

    @Autowired
    private UsuarioServiceMongo usuarioService;

    @GetMapping("/allUserMongo")
    public List<Usuarios> getAllUsuarios() {
        return usuarioService.getAllUsuarios();
    }

    @PostMapping("/saveUserMongo")
    public Usuarios saveUsuario(@RequestBody Usuarios usuario) {
        return usuarioService.createUsuario(usuario);
    }

    // Buscar usuarios por nombre
    @GetMapping("/findByName/{name}")
    public ResponseEntity<List<Usuarios>> findUsuariosByName(@PathVariable String name) {
        List<Usuarios> usuarios = usuarioService.findUsuariosByName(name);
        if (usuarios.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuarios);
    }
    // Obtener un usuario por su ID
    @GetMapping("/findyById/{id}")
    public ResponseEntity<Usuarios> getUsuarioById(@PathVariable String id) {
        Usuarios usuario = usuarioService.getUsuarioById(id);
        if (usuario != null) {
            return ResponseEntity.ok(usuario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar un usuario por nombre
    @DeleteMapping("/deleteByName/{name}")
    public ResponseEntity<Void> deleteUsuarioByName(@PathVariable String name) {
        usuarioService.deleteUsuarioByName(name);
        return ResponseEntity.noContent().build();
    }
        // Eliminar un usuario por su ID
        @DeleteMapping("/delete/{id}")
        public ResponseEntity<Void> deleteUsuario(@PathVariable String id) {
            usuarioService.deleteUsuario(id);
            return ResponseEntity.noContent().build();
        }

    // Actualizar un usuario por su ID
    @PutMapping("/update/{id}")
    public ResponseEntity<Usuarios> updateUsuario(@PathVariable String id, @RequestBody Usuarios updatedUsuario) {
        Usuarios updated = usuarioService.updateUsuario(id, updatedUsuario);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}




