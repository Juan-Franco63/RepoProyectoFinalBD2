package com.ProyectoFinalBd2.ProyectoFinalBd2.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ProyectoFinalBd2.ProyectoFinalBd2.Models.Cursos;
import com.ProyectoFinalBd2.ProyectoFinalBd2.Services.CursoService;

@RestController
@RequestMapping("/api/Cursos")
public class CursoController {


    @Autowired
    private CursoService cursoService;

    @GetMapping("/allMongo")
    public List<Cursos> getAllCursos() {
        return cursoService.getAllCursos();
    }

    @GetMapping("/allNeo")
    public List<Cursos> getAllCursosNeo() {
        return cursoService.getAllCursosNeo();
    }

    @PostMapping("/save")
    public Cursos saveCurso(Cursos curso) {
        return cursoService.guardarCursos(curso);
    }

    @DeleteMapping("/delete")
    public void deleteCurso(String id) {
        cursoService.eliminarCurso(id);
    }
    
}
