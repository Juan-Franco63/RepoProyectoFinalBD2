package com.ProyectoFinalBd2.ProyectoFinalBd2.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ProyectoFinalBd2.ProyectoFinalBd2.Models.Tutores;
import com.ProyectoFinalBd2.ProyectoFinalBd2.Repositories.TutorRepositorioNeo;
import com.ProyectoFinalBd2.ProyectoFinalBd2.Repositories.TutorRepositoryMongo;

@Service
public class TutorService {

    @Autowired
    @Qualifier("tutorRepositorioNeo")
    private TutorRepositorioNeo tutorRepositorioNeo; //Repo neo

    @Autowired
    @Qualifier("tutorRepositoryMongo")
    private TutorRepositoryMongo tutorRepositoryMongo; //Repo mongo


    public List<Tutores> getAllTutores() {
        return tutorRepositoryMongo.findAll();
    }


    public List<Tutores> getAllTutoresNeo() {
        return tutorRepositorioNeo.findAll();
    }

    public Tutores getTutorById(String id){
        return tutorRepositoryMongo.findById(id).get();
    }


    public Tutores guardarTutores(Tutores tutor){
        Tutores savedTutor = tutorRepositoryMongo.save(tutor);
        tutorRepositorioNeo.save(tutor);
        return savedTutor;
    }

    public void eliminarTutor(String id){
        tutorRepositoryMongo.deleteById(id);
        tutorRepositorioNeo.deleteById(id);
    }




    
}
