package com.ProyectoFinalBd2.ProyectoFinalBd2.NEO4J.RepositoriesNeo;

import java.util.List;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import com.ProyectoFinalBd2.ProyectoFinalBd2.NEO4J.ModelsNeo.Curso;

@Repository
public interface CursoRepository extends Neo4jRepository<Curso, String> {

    @Query("MATCH (c:Curso {nombre: $nombre}) " +
    "MATCH (similar:Curso) " +
    "WHERE c.categoria = similar.categoria AND c.nombre <> similar.nombre " +
    "RETURN similar ORDER BY similar.calificacion DESC LIMIT 5")
List<Curso> recomendarCursosSimilares(String nombre);


    @Query("MATCH (c:Curso)<-[r:INSCRITO_EN]-() " +
       "RETURN c, COUNT(r) AS asistentes " +
       "ORDER BY asistentes DESC LIMIT 5")
List<Curso> recomendarCursosMasPopulares();


@Query("MATCH (c:Curso)<-[r:INSCRITO_EN]-() " +
       "WITH c, COUNT(r) AS asistentes " +
       "WHERE asistentes < 5 AND c.calificacion < 3.0 " +
       "RETURN c ORDER BY c.calificacion ASC, asistentes ASC")
List<Curso> recomendarCursosConPocosAsistentesYBajaCalificacion();

}