package com.clinica.demo.controlador;


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

import com.clinica.demo.excepciones.ResourceNotFoundException;
import com.clinica.demo.modelo.Paciente;
import com.clinica.demo.repositorio.PacienteRepositorio;


@RestController
@RequestMapping("/pacientes")

public class PacienteControlador {

    @Autowired
    private PacienteRepositorio pacienteServicio;


    // metodos crud para el controlador

    // metodo para agregar un paciente
    @PostMapping("/agregar")
    public Paciente agregarPaciente(@RequestBody Paciente paciente) {
        return pacienteServicio.save(paciente);
    }

    // Metodo para listar todos los pacientes
    @GetMapping("/listar")
    public List<Paciente> listarPacientes() {
        return pacienteServicio.findAll();
    }

    //actualizar un paciente por id
    @PutMapping("/actualizar/{id}")
    public Paciente actualizarPaciente(@PathVariable int id, @RequestBody Paciente paciente) {
        Paciente pacienteExistente = pacienteServicio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el paciente con el id: " + id));
        pacienteExistente.setNombres(paciente.getNombres());
        pacienteExistente.setApellidos(paciente.getApellidos());
        pacienteExistente.setEmail(paciente.getEmail());
        pacienteExistente.setDireccion(paciente.getDireccion());
        pacienteExistente.setTelefono(paciente.getTelefono());
        
        // Actualizar otros campos según sea necesario
        return pacienteServicio.save(pacienteExistente);
    }

    //eliminar un paciente por id
    @DeleteMapping("/eliminar/{id}")
    public void eliminarPaciente(@PathVariable int id) {
        Paciente pacienteExistente = pacienteServicio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el paciente con el id: " + id));
        pacienteServicio.deleteById(id);
    }

    //buscar paciente por id
    @GetMapping("/buscar/{id}")
    public ResponseEntity<Paciente> buscarPaciente(@PathVariable int id) {
        Paciente paciente = pacienteServicio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el paciente con el id: " + id));
        return ResponseEntity.ok(paciente);
    }

    


    
}
