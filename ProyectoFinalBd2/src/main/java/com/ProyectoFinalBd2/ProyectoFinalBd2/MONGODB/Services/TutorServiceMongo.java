package com.ProyectoFinalBd2.ProyectoFinalBd2.MONGODB.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProyectoFinalBd2.ProyectoFinalBd2.MONGODB.Models.Tutores;
import com.ProyectoFinalBd2.ProyectoFinalBd2.MONGODB.Repositories.TutorRepositoryMongo;

@Service
public class TutorServiceMongo {

    @Autowired
    private TutorRepositoryMongo tutorRepository;

    // Obtener todos los tutores
    public List<Tutores> getAllTutores() {
        return tutorRepository.findAll();
    }

    // Crear un nuevo tutor
    public Tutores createTutor(Tutores tutor) {
        return tutorRepository.save(tutor);
    }

    // Buscar tutores por nombre
    public List<Tutores> findTutoresByName(String name) {
        return tutorRepository.findByName(name);
    }


    // Obtener un tutor por su ID
    public Tutores getTutorById(String id) {
        return tutorRepository.findById(id).orElse(null);
    }

    // Eliminar un tutor por nombre
    public void deleteTutorByName(String name) {
        tutorRepository.deleteByName(name);
    }

    // Eliminar un tutor por su ID
    public void deleteTutor(String id) {
        tutorRepository.deleteById(id);
    }

    // Actualizar un tutor por su ID
    public Tutores updateTutor(String id, Tutores updatedTutor) {
        return tutorRepository.findById(id).map(tutor -> {
            tutor.setName(updatedTutor.getName());
            tutor.setEmail(updatedTutor.getEmail());
            tutor.setCursos(updatedTutor.getCursos());
            tutor.setRatingUsuarios(updatedTutor.getRatingUsuarios());
            return tutorRepository.save(tutor);
        }).orElse(null);
    }
    
}
