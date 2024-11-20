package com.ProyectoFinalBd2.ProyectoFinalBd2.NEO4J.ControllersNeo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ProyectoFinalBd2.ProyectoFinalBd2.NEO4J.ModelsNeo.Usuario;
import com.ProyectoFinalBd2.ProyectoFinalBd2.NEO4J.ServicesNeo.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    // Crear un nuevo usuario
    @PostMapping
    public Usuario crearUsuario(@RequestBody Usuario usuario) {
        return usuarioService.crearUsuario(usuario);
    }

    // Inscribir un usuario en un curso
    @PostMapping("/{usuarioId}/inscribir/{cursoId}")
    public void inscribirUsuarioEnCurso(@PathVariable String usuarioId, @PathVariable String cursoId) {
        usuarioService.inscribirUsuarioEnCurso(usuarioId, cursoId);
    }

    // Calificar un curso
    @PostMapping("/{usuarioId}/calificar/{cursoId}")
    public void calificarCurso(@PathVariable String usuarioId, @PathVariable String cursoId, @RequestParam Double puntuacion) {
        usuarioService.calificarCurso(usuarioId, cursoId, puntuacion);
    }

    // Calificar un tutor
    @PostMapping("/{usuarioId}/calificar-tutor/{tutorId}")
    public void calificarTutor(@PathVariable String usuarioId, @PathVariable String tutorId, @RequestParam Double puntuacion) {
        usuarioService.calificarTutor(usuarioId, tutorId, puntuacion);
    }

    // Obtener un usuario por ID
    @GetMapping("/{usuarioId}")
    public Usuario obtenerUsuarioPorId(@PathVariable String usuarioId) {
        return usuarioService.obtenerUsuarioPorId(usuarioId);
    }
}
