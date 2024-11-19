package com.ProyectoFinalBd2.ProyectoFinalBd2.MONGODB.Repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ProyectoFinalBd2.ProyectoFinalBd2.MONGODB.Models.Tutores;

@Repository
public interface TutorRepositoryMongo extends MongoRepository<Tutores, String> {
    List<Tutores> findByName(String name); // Encuentra tutores por nombre
    void deleteByName(String name);        // Elimina tutores por nombre
}

