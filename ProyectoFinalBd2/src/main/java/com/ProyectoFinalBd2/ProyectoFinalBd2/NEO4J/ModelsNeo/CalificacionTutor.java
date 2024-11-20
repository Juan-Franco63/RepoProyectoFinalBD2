package com.ProyectoFinalBd2.ProyectoFinalBd2.NEO4J.ModelsNeo;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

@RelationshipProperties
public class CalificacionTutor {
    @Id
    @GeneratedValue
    private Long id;

    private Double puntuacion;

    @TargetNode
    private Tutor tutor;

    public CalificacionTutor() {}

    public CalificacionTutor(Double puntuacion, Tutor tutor) {
        this.puntuacion = puntuacion;
        this.tutor = tutor;
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

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }
}
