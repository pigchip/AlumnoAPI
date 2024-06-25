package com.ipn.mx.AlumnoAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ipn.mx.AlumnoAPI.entity.Alumno;
import com.ipn.mx.AlumnoAPI.service.AlumnoService;

import java.util.List;

@RestController
@RequestMapping("/api/alumnos")
@CrossOrigin(origins = "*")
public class AlumnoController {
    @Autowired
    private AlumnoService alumnoService;

    @GetMapping
    public List<Alumno> getAllAlumnos() {
        return alumnoService.getAllAlumnos();
    }

    @GetMapping("/{id}")
    public Alumno getAlumnoById(@PathVariable Long id) {
        return alumnoService.getAlumnoById(id);
    }

    @PostMapping
    public Alumno createAlumno(@RequestBody Alumno alumno) {
        return alumnoService.saveAlumno(alumno);
    }

    @PutMapping("/{id}")
    public Alumno updateAlumno(@PathVariable Long id, @RequestBody Alumno alumno) {
        alumno.setId(id);
        return alumnoService.saveAlumno(alumno);
    }

    @DeleteMapping("/{id}")
    public void deleteAlumno(@PathVariable Long id) {
        alumnoService.deleteAlumno(id);
    }
}
