package com.ProyectoFinalBd2.ProyectoFinalBd2.NEO4J.ServicesNeo;

import org.springframework.stereotype.Service;

import com.ProyectoFinalBd2.ProyectoFinalBd2.NEO4J.ModelsNeo.Usuario;
import com.ProyectoFinalBd2.ProyectoFinalBd2.NEO4J.RepositoriesNeo.UsuarioRepository;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    // Crear un usuario
    public Usuario crearUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // Inscribir un usuario en un curso
    public void inscribirUsuarioEnCurso(String usuarioId, String cursoId) {
        usuarioRepository.inscribirUsuarioEnCurso(usuarioId, cursoId);
    }

    // Calificar un curso
    public void calificarCurso(String usuarioId, String cursoId, Double puntuacion) {
        usuarioRepository.calificarCurso(usuarioId, cursoId, puntuacion);
    }

    // Calificar un tutor
    public void calificarTutor(String usuarioId, String tutorId, Double puntuacion) {
        usuarioRepository.calificarTutor(usuarioId, tutorId, puntuacion);
    }

    // Obtener un usuario por ID
    public Usuario obtenerUsuarioPorId(String usuarioId) {
        return usuarioRepository.findById(usuarioId).orElse(null);
    }
}
