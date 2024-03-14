package com.clinica.demo.controlador;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clinica.demo.modelo.Cita;
import com.clinica.demo.repositorio.CitaRepositorio;


@RestController
@RequestMapping("/citas")

public class CitaControlador {

    @Autowired
    private CitaRepositorio citaServicio;

    // Metodos del controlador

    // metodo para agregar una cita
    @PostMapping("/agregar")
    public Cita agregarCita(@RequestBody Cita cita) {
        return citaServicio.save(cita);
    }

    // Metodo para listar todas las citas
    @GetMapping("/listar")
    public List<Cita> listarCitas() {
        return citaServicio.findAll();
    }
    
}
