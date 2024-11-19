package com.ProyectoFinalBd2.ProyectoFinalBd2.MONGODB.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProyectoFinalBd2.ProyectoFinalBd2.MONGODB.Models.Cursos;
import com.ProyectoFinalBd2.ProyectoFinalBd2.MONGODB.Repositories.CursoRepositoryMongo;

@Service
public class CursoServiceMongo {

    @Autowired
    private CursoRepositoryMongo cursoRepository;

    // Obtener todos los cursos
    public List<Cursos> getAllCursos() {
        return cursoRepository.findAll();
    }

    // Crear un curso
    public Cursos createCurso(Cursos curso) {
        return cursoRepository.save(curso);
    }

    // Buscar cursos por categoría
    public List<Cursos> findCursosByCategory(String category) {
        return cursoRepository.findByCategory(category);
    }

    // Buscar cursos por ID del tutor
    public List<Cursos> findCursosByTutorId(String tutorId) {
        return cursoRepository.findByTutorId(tutorId);
    }

    // Obtener un curso por su ID
    public Cursos getCursoById(String id) {
        return cursoRepository.findById(id).orElse(null);
    }

    // Eliminar un curso por su ID
    public void deleteCursoById(String id) {
        cursoRepository.deleteById(id);
    }

    // Actualizar un curso
    public Cursos updateCurso(String id, Cursos updatedCurso) {
        return cursoRepository.findById(id).map(curso -> {
            curso.setCategory(updatedCurso.getCategory());
            curso.setCost(updatedCurso.getCost());
            curso.setName(updatedCurso.getName());
            curso.setTutorId(updatedCurso.getTutorId());
            curso.setRatings(updatedCurso.getRatings());
            return cursoRepository.save(curso);
        }).orElse(null);
    }
}
