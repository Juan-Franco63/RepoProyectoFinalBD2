package com.ProyectoFinalBd2.ProyectoFinalBd2.MONGODB.Models;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

@Document(collection = "Cursos")
public class Cursos {
    @Id
    private String id;

    private String category;
    private double cost;
    private String name;

    @JsonProperty("tutor_id")
    private String tutorId;

    @JsonProperty("ratings")
    private List<UsuarioRating> ratings;

    public Cursos() {
        this.ratings = new ArrayList<>();
    }

    public Cursos(String id, String category, double cost, String name, String tutorId, List<UsuarioRating> ratings) {
        this.id = id;
        this.category = category;
        this.cost = cost;
        this.name = name;
        this.tutorId = tutorId;
        this.ratings = ratings;
    }

    // Getters y Setters
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

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTutorId() {
        return tutorId;
    }

    public void setTutorId(String tutorId) {
        this.tutorId = tutorId;
    }

    public List<UsuarioRating> getRatings() {
        return ratings;
    }

    public void setRatings(List<UsuarioRating> ratings) {
        this.ratings = ratings;
    }

    // Clase interna para los ratings
    public static class UsuarioRating {
        @JsonProperty("usuario_id")
        private String usuarioId;
        private int rating;

        public UsuarioRating() {}

        public UsuarioRating(String usuarioId, int rating) {
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
}
