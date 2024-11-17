package com.ProyectoFinalBd2.ProyectoFinalBd2.Repositories;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import com.ProyectoFinalBd2.ProyectoFinalBd2.Models.Tutores;

@Repository
public interface TutorRepositorioNeo extends Neo4jRepository<Tutores, String> {
    // Métodos específicos si es necesario
}
