package com.ProyectoFinalBd2.ProyectoFinalBd2.NEO4J.ControllersNeo;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ProyectoFinalBd2.ProyectoFinalBd2.NEO4J.ModelsNeo.Curso;
import com.ProyectoFinalBd2.ProyectoFinalBd2.NEO4J.ServicesNeo.CursoService;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {
    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    // Crear un nuevo curso
    @PostMapping
    public Curso crearCurso(@RequestBody Curso curso) {
        return cursoService.crearCurso(curso);
    }

    // Obtener un curso por ID
    @GetMapping("/{cursoId}")
    public Curso obtenerCursoPorId(@PathVariable String cursoId) {
        return cursoService.obtenerCursoPorId(cursoId);
    }

    // Obtener todos los cursos
    @GetMapping
    public Iterable<Curso> obtenerTodosLosCursos() {
        return cursoService.obtenerTodosLosCursos();
    }

    @GetMapping("/recomendados-similares")
    public List<Curso> recomendarCursosSimilares(@RequestParam String nombre) {
    return cursoService.recomendarCursosSimilares(nombre);
    }

    @GetMapping("/recomendados-populares")
    public List<Curso> recomendarCursosMasPopulares() {
    return cursoService.recomendarCursosMasPopulares();
    
    }
    @GetMapping("/recomendados-pocos-asistentes")
    public List<Curso> recomendarCursosConPocosAsistentesYBajaCalificacion() {
        return cursoService.recomendarCursosConPocosAsistentesYBajaCalificacion();
    }
    


}