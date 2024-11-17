package com.ProyectoFinalBd2.ProyectoFinalBd2.Models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.support.UUIDStringGenerator;

@Document(collection = "Cursos")
@Node("Cursos")
public class Cursos {

    @Id @GeneratedValue(UUIDStringGenerator.class)
    private String id;
    private String category;
    private int cost;
    private String name;

    @DBRef
    private Tutores tutor;  // Referencia al modelo Tutor

    private List<RatingCurso> ratings;

    

    

    public Cursos(String id, String category, int cost, String name, Tutores tutor,
            List<RatingCurso> ratings) {
        this.id = id;
        this.category = category;
        this.cost = cost;
        this.name = name;
        this.tutor = tutor;
        this.ratings = ratings;
    }



    public String getId() {
        return id;
    }



    public void setId(String id) {
        this.id = id;
    }



    public String getCategory() {
        return category;
    }



    public void setCategory(String category) {
        this.category = category;
    }



    public int getCost() {
        return cost;
    }



    public void setCost(int cost) {
        this.cost = cost;
    }



    public String getName() {
        return name;
    }



    public void setName(String name) {
        this.name = name;
    }



    public Tutores getTutor() {
        return tutor;
    }



    public void setTutor(Tutores tutor) {
        this.tutor = tutor;
    }



    public List<RatingCurso> getRatings() {
        return ratings;
    }



    public void setRatings(List<RatingCurso> ratings) {
        this.ratings = ratings;
    }



    // Clase interna para rating de usuarios en el curso
    @Node("RatingCurso")
    public static class RatingCurso {
        @Id @GeneratedValue(UUIDStringGenerator.class)
        private String usuarioId;
        private int rating;

        public RatingCurso() {}

        public RatingCurso(String usuarioId, int rating) {
            this.usuarioId = usuarioId;
            this.rating = rating;
        }

        public String getUsuarioId() {
            return usuarioId;
        }

        public void setUsuarioId(String usuarioId) {
            this.usuarioId = usuarioId;
        }

        public int getRating() {
            return rating;
        }

        public void setRating(int rating) {
            this.rating = rating;
        }
    }



    // Getters y setters para Curso (se omiten aquí para brevedad)
}
