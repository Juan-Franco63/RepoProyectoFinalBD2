package com.ProyectoFinalBd2.ProyectoFinalBd2.Repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ProyectoFinalBd2.ProyectoFinalBd2.Models.Tutores;

@Repository("tutorRepositoryMongo")
public interface TutorRepositoryMongo extends MongoRepository<Tutores, String> {
    // Métodos específicos si es necesario

    
}
