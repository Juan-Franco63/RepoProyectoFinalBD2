package com.ProyectoFinalBd2.ProyectoFinalBd2.Models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.support.UUIDStringGenerator;

@Document(collection = "Tutores")
@Node("Tutores")
public class Tutores {

    @Id @GeneratedValue(UUIDStringGenerator.class)
    private String id;
    private String name;
    private String email;

    @DBRef
    private List<Cursos> cursos;  // Referencia a los cursos impartidos por el tutor

    private List<RatingTutor> ratings;  // Rating dado por usuarios

    


    


    public Tutores(String id, String name, String email, List<Cursos> cursos,
            List<RatingTutor> ratings) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.cursos = cursos;
        this.ratings = ratings;
    }



    public String getId() {
        return id;
    }



    public void setId(String id) {
        this.id = id;
    }



    public String getName() {
        return name;
    }



    public void setName(String name) {
        this.name = name;
    }



    public String getEmail() {
        return email;
    }



    public void setEmail(String email) {
        this.email = email;
    }



    public List<Cursos> getCursos() {
        return cursos;
    }



    public void setCursos(List<Cursos> cursos) {
        this.cursos = cursos;
    }



    public List<RatingTutor> getRatings() {
        return ratings;
    }



    public void setRatings(List<RatingTutor> ratings) {
        this.ratings = ratings;
    }



    // Clase interna para rating de usuarios al tutor
    @Node("RatingTutor")
    public static class RatingTutor {
        @Id @GeneratedValue(UUIDStringGenerator.class)
        private String usuarioId;
        private int rating;

        public RatingTutor() {}

        public RatingTutor(String usuarioId, int rating) {
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


    // Getters y setters para Tutor (se omiten aquí para brevedad)
}
