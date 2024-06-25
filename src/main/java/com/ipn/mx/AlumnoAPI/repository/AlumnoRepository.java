package com.ipn.mx.AlumnoAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ipn.mx.AlumnoAPI.entity.Alumno;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
}
