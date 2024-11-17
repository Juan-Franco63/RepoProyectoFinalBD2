package com.ProyectoFinalBd2.ProyectoFinalBd2.Services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ProyectoFinalBd2.ProyectoFinalBd2.Models.Usuarios;
import com.ProyectoFinalBd2.ProyectoFinalBd2.Repositories.UsuarioRepositorioNeo;
import com.ProyectoFinalBd2.ProyectoFinalBd2.Repositories.UsuarioRepositoryMongo;

@Service
public class UsuarioService {

    @Autowired
    @Qualifier("usuarioRepositorioNeo")
    private UsuarioRepositorioNeo usuarioRepositorioNeo; // Repo de Neo

    @Autowired
    @Qualifier("usuarioRepositorioMongo")
    private UsuarioRepositoryMongo usuarioRepositorioMongo; // Repo de Mongo

    public List<Usuarios> getAllUsuarios() {
        return usuarioRepositorioMongo.findAll();
    }
    public Optional<Usuarios> getUsuarioById(String id){
        return usuarioRepositorioMongo.findById(id);
    }


    public List<Usuarios> getAllUsuariosNeo() {
        return usuarioRepositorioNeo.findAll();
    }

    public Usuarios guardarUsuarios(Usuarios usuario) {
        System.out.println("Guardando usuario en MongoDB: " + usuario);
        Usuarios savedUsuario = usuarioRepositorioMongo.save(usuario);
    
        // Validar listas antes de guardar en Neo4j
        if (usuario.getRatingCursos() == null) {
            usuario.setRatingCursos(List.of());
        }
        if (usuario.getRatingTutores() == null) {
            usuario.setRatingTutores(List.of());
        }
    
        System.out.println("Guardando usuario en Neo4j: " + usuario);
        Usuarios savedNeoUsuario = usuarioRepositorioNeo.save(usuario);
        System.out.println("Usuario guardado en Neo4j: " + savedNeoUsuario);
    
        return savedUsuario;
    }
    
    

    public void eliminarUsuario(String id){
        usuarioRepositorioMongo.deleteById(id);
        usuarioRepositorioNeo.deleteById(id);
    }
}
