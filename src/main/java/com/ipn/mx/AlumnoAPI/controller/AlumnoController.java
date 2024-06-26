package com.ipn.mx.AlumnoAPI.controller;

import com.ipn.mx.AlumnoAPI.entity.Alumno;
import com.ipn.mx.AlumnoAPI.service.AlumnoService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alumnos")
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
    public ResponseEntity<Alumno> createAlumno(@Valid @RequestBody Alumno alumno) {
        return ResponseEntity.ok(alumnoService.saveAlumno(alumno));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Alumno> updateAlumno(@PathVariable Long id, @Valid @RequestBody Alumno alumno) {
        alumno.setId(id);
        return ResponseEntity.ok(alumnoService.saveAlumno(alumno));
    }

    @DeleteMapping("/{id}")
    public void deleteAlumno(@PathVariable Long id) {
        alumnoService.deleteAlumno(id);
    }
}
