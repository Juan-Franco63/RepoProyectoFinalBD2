package com.ProyectoFinalBd2.ProyectoFinalBd2.MONGODB.Models;

public class CursoConPocosAsistentesYBajaCalificacion {
    private String cursoId;
    private int countAsistentes;
    private double avgRating;

    public CursoConPocosAsistentesYBajaCalificacion() {}

    public CursoConPocosAsistentesYBajaCalificacion(String cursoId, int countAsistentes, double avgRating) {
        this.cursoId = cursoId;
        this.countAsistentes = countAsistentes;
        this.avgRating = avgRating;
    }

    public String getCursoId() {
        return cursoId;
    }

    public void setCursoId(String cursoId) {
        this.cursoId = cursoId;
    }

    public int getCountAsistentes() {
        return countAsistentes;
    }

    public void setCountAsistentes(int countAsistentes) {
        this.countAsistentes = countAsistentes;
    }

    public double getAvgRating() {
        return avgRating;
    }

    public void setAvgRating(double avgRating) {
        this.avgRating = avgRating;
    }
}
