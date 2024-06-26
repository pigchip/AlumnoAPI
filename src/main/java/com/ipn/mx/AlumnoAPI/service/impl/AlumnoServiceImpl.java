package com.ipn.mx.AlumnoAPI.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ipn.mx.AlumnoAPI.entity.Alumno;
import com.ipn.mx.AlumnoAPI.repository.AlumnoRepository;
import com.ipn.mx.AlumnoAPI.service.AlumnoService;

import java.util.List;
import java.util.Optional;

@Service
public class AlumnoServiceImpl implements AlumnoService {
    @Autowired
    private AlumnoRepository alumnoRepository;

    @Override
    public List<Alumno> getAllAlumnos() {
        return alumnoRepository.findAll();
    }

    @Override
    public Alumno getAlumnoById(Long id) {
        Optional<Alumno> optionalAlumno = alumnoRepository.findById(id);
        if (optionalAlumno.isPresent()) {
            return optionalAlumno.get();
        } else {
            throw new RuntimeException("Alumno no encontrado con id: " + id);
        }
    }

    @Override
    public Alumno saveAlumno(Alumno alumno) {
        return alumnoRepository.save(alumno);
    }

    @Override
    public void deleteAlumno(Long id) {
        if (alumnoRepository.existsById(id)) {
            alumnoRepository.deleteById(id);
        } else {
            throw new RuntimeException("Alumno no encontrado con id: " + id);
        }
    }
}
