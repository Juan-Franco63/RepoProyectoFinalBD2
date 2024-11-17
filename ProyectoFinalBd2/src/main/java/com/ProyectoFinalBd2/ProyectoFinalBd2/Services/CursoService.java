package com.ProyectoFinalBd2.ProyectoFinalBd2.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ProyectoFinalBd2.ProyectoFinalBd2.Models.Cursos;
import com.ProyectoFinalBd2.ProyectoFinalBd2.Repositories.CursoRepositoryMongo;
import com.ProyectoFinalBd2.ProyectoFinalBd2.Repositories.CursoRepositoryNeo;

@Service
public class CursoService {

    @Autowired
    @Qualifier("cursoRepositoryNeo")
    private CursoRepositoryNeo cursoRepositoryNeo; //repo Neo

    @Autowired
    @Qualifier("cursoRepositoryMongo")
    private CursoRepositoryMongo cursoRepositoryMongo; //repo Mongo

    public List<Cursos> getAllCursos() {
        return cursoRepositoryMongo.findAll();
    }

    public Optional<Cursos> getCursoById(String id){
        return cursoRepositoryMongo.findById(id);
    
    }


    public List<Cursos> getAllCursosNeo() {
        return cursoRepositoryNeo.findAll();
    }


    public Cursos guardarCursos(Cursos curso){
        Cursos savedCurso = cursoRepositoryMongo.save(curso);
        cursoRepositoryNeo.save(curso);
        return savedCurso;
    }

    public void eliminarCurso(String id){
        cursoRepositoryMongo.deleteById(id);
        cursoRepositoryNeo.deleteById(id);
    }



}
