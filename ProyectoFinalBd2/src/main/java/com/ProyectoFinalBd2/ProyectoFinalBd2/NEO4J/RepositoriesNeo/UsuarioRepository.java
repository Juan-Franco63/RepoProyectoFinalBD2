package com.ProyectoFinalBd2.ProyectoFinalBd2.NEO4J.RepositoriesNeo;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import com.ProyectoFinalBd2.ProyectoFinalBd2.NEO4J.ModelsNeo.Usuario;

public interface UsuarioRepository extends Neo4jRepository<Usuario, String> {
    // Relacionar Usuario con Curso mediante INSCRITO_EN
    @Query("MATCH (u:Usuario {id: $usuarioId}), (c:Curso {id: $cursoId}) " +
           "MERGE (u)-[:INSCRITO_EN]->(c)")
    void inscribirUsuarioEnCurso(String usuarioId, String cursoId);

    // Calificar un Curso
    @Query("MATCH (u:Usuario {id: $usuarioId}), (c:Curso {id: $cursoId}) " +
           "MERGE (u)-[r:CALIFICA {puntuacion: $puntuacion}]->(c)")
    void calificarCurso(String usuarioId, String cursoId, Double puntuacion);

    // Calificar un Tutor
    @Query("MATCH (u:Usuario {id: $usuarioId}), (t:Tutor {id: $tutorId}) " +
           "MERGE (u)-[r:CALIFICA_TUTOR {puntuacion: $puntuacion}]->(t)")
    void calificarTutor(String usuarioId, String tutorId, Double puntuacion);
}
