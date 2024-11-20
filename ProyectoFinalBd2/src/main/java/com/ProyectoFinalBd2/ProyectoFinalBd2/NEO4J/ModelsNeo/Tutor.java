package com.ProyectoFinalBd2.ProyectoFinalBd2.NEO4J.ModelsNeo;

import java.util.List;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

@Node
public class Tutor {
    @Id
    private String id;
    private String nombre;

    @Relationship(type = "CREA", direction = Relationship.Direction.OUTGOING)
    private List<Curso> cursos;

    public Tutor() {}

    public Tutor(String id, String nombre) {
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
}
