package com.ProyectoFinalBd2.ProyectoFinalBd2.Repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ProyectoFinalBd2.ProyectoFinalBd2.Models.Cursos;

@Repository
public interface CursoRepositoryMongo extends MongoRepository<Cursos, String> {
    // Métodos específicos si es necesario
}
