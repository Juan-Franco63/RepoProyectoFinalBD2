package com.ProyectoFinalBd2.ProyectoFinalBd2.NEO4J.ModelsNeo;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

@Node
public class Curso {
    @Id
    private String id;
    private String nombre;
    private String categoria;
    private Double calificacion;

    @Relationship(type = "CREADO_POR", direction = Relationship.Direction.OUTGOING)
    private Tutor tutor;

    public Curso() {}

    public Curso(String id, String nombre, String categoria, Double calificacion) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.calificacion = calificacion;
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Double calificacion) {
        this.calificacion = calificacion;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }
}
