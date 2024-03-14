package com.clinica.demo.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity; // Import the Entity class
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "odontologos")
public class Odontologo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "nombres", nullable = false, length = 30)
    private String nombres;
    @Column(name = "apellidos", nullable = false, length = 30)
    private String apellidos;
    @Column(name = "especialidad", nullable = false, length = 30)
    private String especialidad;
    @Column(name = "telefono", nullable = false, length = 10)
    private String telefono;
    @Column(name = "email", nullable = false, length = 50 , unique = true)
    private String email;

    public Odontologo() {
    }

    public Odontologo(int id, String nombres, String apellidos, String especialidad, String telefono, String email) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.especialidad = especialidad;
        this.telefono = telefono;
        this.email = email;
    }

    //getters and setters

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return this.nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return this.apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEspecialidad() {
        return this.especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }




}
