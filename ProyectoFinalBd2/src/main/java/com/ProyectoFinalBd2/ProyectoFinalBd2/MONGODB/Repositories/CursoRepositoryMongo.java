package com.ProyectoFinalBd2.ProyectoFinalBd2.MONGODB.Repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.ProyectoFinalBd2.ProyectoFinalBd2.MONGODB.Models.Cursos;

@Repository
public interface CursoRepositoryMongo extends MongoRepository<Cursos, String> {
    List<Cursos> findByCategory(String category); // Buscar cursos por categoría
    List<Cursos> findByTutorId(String tutorId);   // Buscar cursos por ID del tutor

    // Consulta custom: Buscar cursos de una categoría (excluyendo un curso específico) y ordenar por calificación
    @Query(value = "{ 'category': ?0, '_id': { $ne: ?1 } }", sort = "{ 'ratings.rating': -1 }")
    List<Cursos> findTopCursosSimilares(String category, String excludeCursoId);
}
