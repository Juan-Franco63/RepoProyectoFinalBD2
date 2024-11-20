package com.ProyectoFinalBd2.ProyectoFinalBd2.NEO4J.ModelsNeo;

import java.util.List;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

@Node
public class Usuario {
    @Id
    private String id;
    private String nombre;

    @Relationship(type = "INSCRITO_EN", direction = Relationship.Direction.OUTGOING)
    private List<Curso> cursos;

    @Relationship(type = "CALIFICA", direction = Relationship.Direction.OUTGOING)
    private List<Calificacion> calificacionesCursos;

    @Relationship(type = "CALIFICA_TUTOR", direction = Relationship.Direction.OUTGOING)
    private List<CalificacionTutor> calificacionesTutores;

    public Usuario() {}

    public Usuario(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    public List<Calificacion> getCalificacionesCursos() {
        return calificacionesCursos;
    }

    public void setCalificacionesCursos(List<Calificacion> calificacionesCursos) {
        this.calificacionesCursos = calificacionesCursos;
    }

    public List<CalificacionTutor> getCalificacionesTutores() {
        return calificacionesTutores;
    }

    public void setCalificacionesTutores(List<CalificacionTutor> calificacionesTutores) {
        this.calificacionesTutores = calificacionesTutores;
    }
}
