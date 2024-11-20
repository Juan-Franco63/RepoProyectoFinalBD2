package com.ProyectoFinalBd2.ProyectoFinalBd2.NEO4J.RepositoriesNeo;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import com.ProyectoFinalBd2.ProyectoFinalBd2.NEO4J.ModelsNeo.Curso;

@Repository
public interface CursoRepository extends Neo4jRepository<Curso, String> {
    // Métodos personalizados si los necesitas
}