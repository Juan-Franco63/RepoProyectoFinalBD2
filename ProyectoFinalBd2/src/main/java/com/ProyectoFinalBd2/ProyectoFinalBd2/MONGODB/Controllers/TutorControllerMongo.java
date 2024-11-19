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

import com.ProyectoFinalBd2.ProyectoFinalBd2.MONGODB.Models.Tutores;
import com.ProyectoFinalBd2.ProyectoFinalBd2.MONGODB.Services.TutorServiceMongo;

@RestController
@RequestMapping("/api/tutoresMongo")
public class TutorControllerMongo {

    @Autowired
    private TutorServiceMongo tutorService;

    @GetMapping("/allTutorMongo")
    public List<Tutores> getAllTutores() {
        return tutorService.getAllTutores();
    }

    @PostMapping("/saveTutorMongo")
    public Tutores saveTutor(@RequestBody Tutores tutor) {
        return tutorService.createTutor(tutor);
    }



    // Obtener un tutor por su ID
    @GetMapping("/getTutor/{id}")
    public Tutores getTutorById(@PathVariable String id) {
        return tutorService.getTutorById(id);
    }
    // Buscar usuarios por nombre
    @GetMapping("/findByName/{name}")
    public ResponseEntity<List<Tutores>> findUsuariosByName(@PathVariable String name) {
        List<Tutores> tutores = tutorService.findTutoresByName(name);
        if (tutores.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(tutores);
    }

    // Eliminar un usuario por nombre
    @DeleteMapping("/deleteByName/{name}")
    public ResponseEntity<Void> deleteTutorByName(@PathVariable String name) {
        tutorService.deleteTutorByName(name);
        return ResponseEntity.noContent().build();
    }
    // Eliminar un usuario por su ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTutor(@PathVariable String id) {
        tutorService.deleteTutor(id);
        return ResponseEntity.noContent().build();
    }


    // Actualizar un tutor por su ID
    @PutMapping("/update/{id}")
    public Tutores updateTutor(@PathVariable String id, @RequestBody Tutores updatedTutor) {
        return tutorService.updateTutor(id, updatedTutor);
    }

    
    
}
