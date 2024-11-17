package com.ProyectoFinalBd2.ProyectoFinalBd2.Repositories;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import com.ProyectoFinalBd2.ProyectoFinalBd2.Models.Usuarios;

@Repository("usuarioRepositorioNeo")
public interface UsuarioRepositorioNeo extends Neo4jRepository<Usuarios, String> {
    // Métodos específicos si es necesario
}
