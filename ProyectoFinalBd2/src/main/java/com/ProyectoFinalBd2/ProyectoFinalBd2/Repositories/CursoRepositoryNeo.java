package com.ProyectoFinalBd2.ProyectoFinalBd2.Repositories;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import com.ProyectoFinalBd2.ProyectoFinalBd2.Models.Cursos;

@Repository("cursoRepositoryNeo")
public interface CursoRepositoryNeo extends Neo4jRepository<Cursos, String> {
    // Métodos específicos si es necesario
}
