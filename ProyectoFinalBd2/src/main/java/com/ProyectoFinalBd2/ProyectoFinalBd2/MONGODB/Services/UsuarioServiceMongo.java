package com.ProyectoFinalBd2.ProyectoFinalBd2.MONGODB.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProyectoFinalBd2.ProyectoFinalBd2.MONGODB.Models.Usuarios;
import com.ProyectoFinalBd2.ProyectoFinalBd2.MONGODB.Repositories.UsuarioRepositoryMongo;

@Service

public class UsuarioServiceMongo {

    @Autowired
    private UsuarioRepositoryMongo usuarioRepository;


    // Obtener todos los usuarios
    public List<Usuarios> getAllUsuarios() {
        return usuarioRepository.findAll();
    }
        
    // Crear un nuevo usuario
    public Usuarios createUsuario(Usuarios usuario) {
        return usuarioRepository.save(usuario);
    }

    // Buscar usuarios por nombre
    public List<Usuarios> findUsuariosByName(String name) {
        return usuarioRepository.findByName(name);
    }

    // Obtener un usuario por su ID
    public Usuarios getUsuarioById(String id) {
        return usuarioRepository.findById(id).orElse(null);
    }
    
    // Eliminar un usuario por nombre
    public void deleteUsuarioByName(String name) {
        usuarioRepository.deleteByName(name);
    }
        
    // Eliminar un usuario por su ID
    public void deleteUsuario(String id) {
        usuarioRepository.deleteById(id);
    }

    // Actualizar un usuario por su ID
    public Usuarios updateUsuario(String id, Usuarios updatedUsuario) {
        return usuarioRepository.findById(id).map(usuario -> {
            usuario.setName(updatedUsuario.getName());
            usuario.setEmail(updatedUsuario.getEmail());
            usuario.setCursosMatriculados(updatedUsuario.getCursosMatriculados());
            usuario.setRatingCursos(updatedUsuario.getRatingCursos());
            usuario.setRatingTutores(updatedUsuario.getRatingTutores());
            return usuarioRepository.save(usuario);
        }).orElse(null);
    }



}