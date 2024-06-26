package com.ipn.mx.AlumnoAPI.service;

import com.ipn.mx.AlumnoAPI.entity.Alumno;
import java.util.List;

public interface AlumnoService {
    List<Alumno> getAllAlumnos();
    Alumno getAlumnoById(Long id);
    Alumno saveAlumno(Alumno alumno);
    void deleteAlumno(Long id);
}
