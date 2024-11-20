package com.ProyectoFinalBd2.ProyectoFinalBd2.MONGODB.Repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ProyectoFinalBd2.ProyectoFinalBd2.MONGODB.Models.CursoPopular;
import com.ProyectoFinalBd2.ProyectoFinalBd2.MONGODB.Models.Usuarios;

@Repository
public interface UsuarioRepositoryMongo extends MongoRepository<Usuarios, String> {

    // Encuentra usuarios por nombre
    List<Usuarios> findByName(String name);

    // Elimina usuarios por nombre
    void deleteByName(String name);

    // Agregación para contar los cursos más populares
    @Aggregation(pipeline = {
        "{ $unwind: '$cursosMatriculados' }", // Descompone el array cursosMatriculados
        "{ $group: { _id: '$cursosMatriculados', count: { $sum: 1 } } }", // Agrupa y cuenta
        "{ $sort: { count: -1 } }" // Ordena por número de inscritos en orden descendente
    })
    List<CursoPopular> findCursosConMasAsistentes();
}
