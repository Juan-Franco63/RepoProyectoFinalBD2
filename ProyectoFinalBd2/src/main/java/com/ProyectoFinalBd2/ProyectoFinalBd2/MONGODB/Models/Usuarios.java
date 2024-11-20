package com.ProyectoFinalBd2.ProyectoFinalBd2.MONGODB.Models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

@Document(collection = "Usuarios")
public class Usuarios {
    @Id
    private String id;
    private String name;
    private String email;

    @JsonProperty("cursos matriculados")
    private List<String> cursosMatriculados; // Si no es relación, está bien así.

    @JsonProperty("rating_cursos")
    private List<CursoRating> ratingCursos;

    @JsonProperty("rating_tutores")
    private List<TutorRating> ratingTutores;

    

    public Usuarios() {
    }
    
    


    public Usuarios(String id, String name, String email, List<String> cursosMatriculados,
            List<CursoRating> ratingCursos, List<TutorRating> ratingTutores) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.cursosMatriculados = cursosMatriculados;
        this.ratingCursos = ratingCursos;
        this.ratingTutores = ratingTutores;
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

    public List<String> getCursosMatriculados() {
        return cursosMatriculados;
    }

    public void setCursosMatriculados(List<String> cursosMatriculados) {
        this.cursosMatriculados = cursosMatriculados;
    }

    public List<CursoRating> getRatingCursos() {
        return ratingCursos;
    }

    public void setRatingCursos(List<CursoRating> ratingCursos) {
        this.ratingCursos = ratingCursos;
    }

    public List<TutorRating> getRatingTutores() {
        return ratingTutores;
    }

    public void setRatingTutores(List<TutorRating> ratingTutores) {
        this.ratingTutores = ratingTutores;
    }

    // Clase interna para ratingCursos
    public static class CursoRating {
        @JsonProperty("curso_id")
        private String cursoId;
        private int rating;

        public CursoRating() {}

        public CursoRating(String cursoId, int rating) {
            this.cursoId = cursoId;
            this.rating = rating;
        }

        public String getCursoId() {
            return cursoId;
        }

        public void setCursoId(String cursoId) {
            this.cursoId = cursoId;
        }

        public int getRating() {
            return rating;
        }

        public void setRating(int rating) {
            this.rating = rating;
        }
    }

    // Clase interna para ratingTutores
    public static class TutorRating {
        @JsonProperty("tutor_id")
        private String tutorId;
        private int calificacion;

        public TutorRating() {}

        public TutorRating(String tutorId, int calificacion) {
            this.tutorId = tutorId;
            this.calificacion = calificacion;
        }

        public String getTutorId() {
            return tutorId;
        }

        public void setTutorId(String tutorId) {
            this.tutorId = tutorId;
        }

        public int getCalificacion() {
            return calificacion;
        }

        public void setCalificacion(int calificacion) {
            this.calificacion = calificacion;
        }
    }


    // Getters y setters para Usuario (se omiten aquí para brevedad)
}