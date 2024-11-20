package com.ProyectoFinalBd2.ProyectoFinalBd2.NEO4J.ModelsNeo;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

@RelationshipProperties
public class Calificacion {
    @Id
    @GeneratedValue
    private Long id;

    private Double puntuacion;

    @TargetNode
    private Curso curso;

    public Calificacion() {}

    public Calificacion(Double puntuacion, Curso curso) {
        this.puntuacion = puntuacion;
        this.curso = curso;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(Double puntuacion) {
        this.puntuacion = puntuacion;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
