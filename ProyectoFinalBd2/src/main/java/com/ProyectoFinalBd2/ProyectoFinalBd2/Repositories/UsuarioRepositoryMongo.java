package com.ProyectoFinalBd2.ProyectoFinalBd2.Repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ProyectoFinalBd2.ProyectoFinalBd2.Models.Usuarios;

@Repository("usuarioRepositorioMongo")
public interface UsuarioRepositoryMongo extends MongoRepository<Usuarios, String> {
    // Métodos específicos si es necesario
}

