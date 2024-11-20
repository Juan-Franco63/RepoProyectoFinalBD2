package com.ProyectoFinalBd2.ProyectoFinalBd2.NEO4J.ControllersNeo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ProyectoFinalBd2.ProyectoFinalBd2.NEO4J.ModelsNeo.Tutor;
import com.ProyectoFinalBd2.ProyectoFinalBd2.NEO4J.ServicesNeo.TutorService;

@RestController
@RequestMapping("/api/tutores")
public class TutorController {
    private final TutorService tutorService;

    public TutorController(TutorService tutorService) {
        this.tutorService = tutorService;
    }

    // Crear un nuevo tutor
    @PostMapping
    public Tutor crearTutor(@RequestBody Tutor tutor) {
        return tutorService.crearTutor(tutor);
    }

    // Relacionar un tutor con un curso
    @PostMapping("/{tutorId}/curso/{cursoId}")
    public void relacionarTutorConCurso(@PathVariable String tutorId, @PathVariable String cursoId) {
        tutorService.relacionarTutorConCurso(tutorId, cursoId);
    }

    // Obtener un tutor por ID
    @GetMapping("/{tutorId}")
    public Tutor obtenerTutorPorId(@PathVariable String tutorId) {
        return tutorService.obtenerTutorPorId(tutorId);
    }
}
