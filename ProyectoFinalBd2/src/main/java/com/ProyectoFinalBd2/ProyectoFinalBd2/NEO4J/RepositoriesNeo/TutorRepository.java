package com.ProyectoFinalBd2.ProyectoFinalBd2.NEO4J.RepositoriesNeo;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import com.ProyectoFinalBd2.ProyectoFinalBd2.NEO4J.ModelsNeo.Tutor;

public interface TutorRepository extends Neo4jRepository<Tutor, String> {
    // Relacionar Tutor con Curso mediante CREA
    @Query("MATCH (t:Tutor {id: $tutorId}), (c:Curso {id: $cursoId}) " +
    "MERGE (t)-[:CREADO_POR]->(c)")
    void relacionarTutorConCurso(String tutorId, String cursoId);

}
