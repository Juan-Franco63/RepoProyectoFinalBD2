package com.ProyectoFinalBd2.ProyectoFinalBd2.MONGODB.Models;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

@Document(collection = "Tutores")
public class Tutores {
    @Id
    private String id;
    private String name;
    private String email;
    private List<String> cursos;

    @JsonProperty("ratings")
    private List<UsuarioRating> ratingUsuarios;

    // Constructor por defecto con inicialización
    public Tutores() {
        this.cursos = new ArrayList<>(); // Inicializar lista de cursos
        this.ratingUsuarios = new ArrayList<>(); // Inicializar lista de ratings
    }

    // Constructor con parámetros
    public Tutores(String id, String name, String email, List<String> cursos, List<UsuarioRating> ratingUsuarios) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.cursos = cursos != null ? cursos : new ArrayList<>();
        this.ratingUsuarios = ratingUsuarios != null ? ratingUsuarios : new ArrayList<>();
    }

    // Getters y Setters
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

    public List<String> getCursos() {
        return cursos;
    }

    public void setCursos(List<String> cursos) {
        this.cursos = cursos;
    }

    public List<UsuarioRating> getRatingUsuarios() {
        return ratingUsuarios;
    }

    public void setRatingUsuarios(List<UsuarioRating> ratingUsuarios) {
        this.ratingUsuarios = ratingUsuarios;
    }

    // Clase interna para guardar el rating de los usuarios hacia los tutores
    public static class UsuarioRating {
        @JsonProperty("usuario_id")
        private String usuarioId;
        private int calificacion;

        public UsuarioRating() {}

        public UsuarioRating(String usuarioId, int calificacion) {
            this.usuarioId = usuarioId;
            this.calificacion = calificacion;
        }

        public String getUsuarioId() {
            return usuarioId;
        }

        public void setUsuarioId(String usuarioId) {
            this.usuarioId = usuarioId;
        }

        public int getCalificacion() {
            return calificacion;
        }

        public void setCalificacion(int calificacion) {
            this.calificacion = calificacion;
        }
    }
}
