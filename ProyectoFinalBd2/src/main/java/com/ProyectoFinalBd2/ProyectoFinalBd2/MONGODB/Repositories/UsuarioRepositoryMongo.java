package com.ProyectoFinalBd2.ProyectoFinalBd2.MONGODB.Repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ProyectoFinalBd2.ProyectoFinalBd2.MONGODB.Models.Usuarios;

@Repository
public interface UsuarioRepositoryMongo extends MongoRepository<Usuarios, String> {
    List<Usuarios> findByName(String name); // Encuentra usuarios por nombre
    void deleteByName(String name);            // Elimina usuarios por nombre
}
