package com.ProyectoFinalBd2.ProyectoFinalBd2.MONGODB.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ProyectoFinalBd2.ProyectoFinalBd2.MONGODB.Models.Cursos;
import com.ProyectoFinalBd2.ProyectoFinalBd2.MONGODB.Services.CursoServiceMongo;

@RestController
@RequestMapping("/api/cursosMongo")
public class CursoControllerMongo {

    @Autowired
    private CursoServiceMongo cursoService;

    // Obtener todos los cursos
    @GetMapping("/  ")
    public List<Cursos> getAllCursos() {
        return cursoService.getAllCursos();
    }

    // Crear un curso
    @PostMapping("/saveCursoMongo")
    public ResponseEntity<Cursos> createCurso(@RequestBody Cursos curso) {
        return ResponseEntity.ok(cursoService.createCurso(curso));
    }

    // Buscar cursos por categoría
    @GetMapping("/findBycategoria/{category}")
    public List<Cursos> getCursosByCategory(@PathVariable String category) {
        return cursoService.findCursosByCategory(category);
    }

    // Buscar cursos por ID del tutor
    @GetMapping("/finbByTutorId/{tutorId}")
    public List<Cursos> getCursosByTutorId(@PathVariable String tutorId) {
        return cursoService.findCursosByTutorId(tutorId);
    }

    // Obtener un curso por ID
    @GetMapping("/findById/{id}")
    public ResponseEntity<Cursos> getCursoById(@PathVariable String id) {
        Cursos curso = cursoService.getCursoById(id);
        return curso != null ? ResponseEntity.ok(curso) : ResponseEntity.notFound().build();
    }

    // Actualizar un curso
    @PutMapping("/updateById/{id}")
    public ResponseEntity<Cursos> updateCurso(@PathVariable String id, @RequestBody Cursos updatedCurso) {
        Cursos curso = cursoService.updateCurso(id, updatedCurso);
        return curso != null ? ResponseEntity.ok(curso) : ResponseEntity.notFound().build();
    }

    // Eliminar un curso por ID
    @DeleteMapping("/DeleteById/{id}")
    public ResponseEntity<Void> deleteCursoById(@PathVariable String id) {
        cursoService.deleteCursoById(id);
        return ResponseEntity.noContent().build();
    }
}
