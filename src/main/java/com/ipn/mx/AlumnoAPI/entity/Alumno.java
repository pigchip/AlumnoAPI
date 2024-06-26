package com.ipn.mx.AlumnoAPI.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "El nombre no puede estar en blanco")
    @Size(min = 2, max = 50, message = "El nombre debe tener entre 2 y 50 caracteres")
    private String nombre;

    @Column(nullable = false)
    @NotBlank(message = "El apellido paterno no puede estar en blanco")
    @Size(min = 2, max = 50, message = "El apellido paterno debe tener entre 2 y 50 caracteres")
    private String paterno;

    @Column(nullable = false)
    @NotBlank(message = "El apellido materno no puede estar en blanco")
    @Size(min = 2, max = 50, message = "El apellido materno debe tener entre 2 y 50 caracteres")
    private String materno;

    @Column(nullable = false)
    @NotBlank(message = "El correo electrónico no puede estar en blanco")
    @Email(message = "El correo electrónico debe tener un formato válido")
    @Size(max = 100, message = "El correo electrónico no debe tener más de 100 caracteres")
    private String email;
}
