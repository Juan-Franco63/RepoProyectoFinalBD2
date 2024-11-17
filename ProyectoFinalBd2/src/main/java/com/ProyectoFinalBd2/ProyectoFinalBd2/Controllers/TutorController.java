package com.ProyectoFinalBd2.ProyectoFinalBd2.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ProyectoFinalBd2.ProyectoFinalBd2.Models.Tutores;
import com.ProyectoFinalBd2.ProyectoFinalBd2.Services.TutorService;

@RestController
@RequestMapping("/api/Tutores")
public class TutorController {

    @Autowired
    private TutorService tutorService;

    @GetMapping("/tutos")
    public List<Tutores> getAllTutores() {
        return tutorService.getAllTutores();
    }

    @GetMapping("/allNeo")
    public List<Tutores> getAllTutoresNeo() {
        return tutorService.getAllTutoresNeo();
    }

    @PostMapping("/save")
    public Tutores saveTutor(Tutores tutor) {
        return tutorService.guardarTutores(tutor);
    }

    @DeleteMapping("/delete")
    public void deleteTutor(String id) {
        tutorService.eliminarTutor(id);
    }
    
}
