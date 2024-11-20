package com.ProyectoFinalBd2.ProyectoFinalBd2.NEO4J.ServicesNeo;

import org.springframework.stereotype.Service;

import com.ProyectoFinalBd2.ProyectoFinalBd2.NEO4J.ModelsNeo.Tutor;
import com.ProyectoFinalBd2.ProyectoFinalBd2.NEO4J.RepositoriesNeo.TutorRepository;

@Service
public class TutorService {
    private final TutorRepository tutorRepository;

    public TutorService(TutorRepository tutorRepository) {
        this.tutorRepository = tutorRepository;
    }

    // Crear un tutor
    public Tutor crearTutor(Tutor tutor) {
        return tutorRepository.save(tutor);
    }

    // Relacionar un tutor con un curso
    public void relacionarTutorConCurso(String tutorId, String cursoId) {
        tutorRepository.relacionarTutorConCurso(tutorId, cursoId);
    }

    // Obtener un tutor por ID
    public Tutor obtenerTutorPorId(String tutorId) {
        return tutorRepository.findById(tutorId).orElse(null);
    }
}
