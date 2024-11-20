package com.ProyectoFinalBd2.ProyectoFinalBd2.NEO4J.ServicesNeo;

import org.springframework.stereotype.Service;

import com.ProyectoFinalBd2.ProyectoFinalBd2.NEO4J.ModelsNeo.Curso;
import com.ProyectoFinalBd2.ProyectoFinalBd2.NEO4J.RepositoriesNeo.CursoRepository;

@Service
public class CursoService {
    private final CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    // Crear un curso
    public Curso crearCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    // Obtener un curso por ID
    public Curso obtenerCursoPorId(String cursoId) {
        return cursoRepository.findById(cursoId).orElse(null);
    }

    // Obtener todos los cursos
    public Iterable<Curso> obtenerTodosLosCursos() {
        return cursoRepository.findAll();
    }
}
