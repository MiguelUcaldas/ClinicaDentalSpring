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
import com.clinica.demo.modelo.Odontologo;
import com.clinica.demo.repositorio.OdonotologoRepositorio;


@RestController
@RequestMapping("/odontologos")
public class OdontologoControlador {

    @Autowired
    private OdonotologoRepositorio odontologoServicio;

    // Metodos del controlador

    // metodo para agregar un odontologo
    @PostMapping("/agregar")
    public Odontologo agregarOdontologo(@RequestBody Odontologo odontologo) {
        return odontologoServicio.save(odontologo);
    }


    // Metodo para listar todos los odontologos
    @GetMapping("/listar")
    public List<Odontologo> listarOdontologos() {
        return odontologoServicio.findAll();
    }

    //actualizar un odontologo por id
    @PutMapping("/actualizar/{id}")
    public Odontologo actualizarOdontologo(@PathVariable int id, @RequestBody Odontologo odontologo) {
        Odontologo odontologoExistente = odontologoServicio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el odontologo con el id: " + id));
        odontologoExistente.setNombres(odontologo.getNombres());
        odontologoExistente.setApellidos(odontologo.getApellidos());
        odontologoExistente.setEmail(odontologo.getEmail());
        odontologoExistente.setEspecialidad(odontologo.getEspecialidad());
        odontologoExistente.setTelefono(odontologo.getTelefono());
        
        // Actualizar otros campos según sea necesario
        return odontologoServicio.save(odontologoExistente);
    }

    //eliminar un odontologo por id
    @DeleteMapping("/eliminar/{id}")
    public void eliminarOdontologo(@PathVariable int id) {
        Odontologo odontologoExistente = odontologoServicio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el odontologo con el id: " + id));
        odontologoServicio.deleteById(id);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Odontologo> obtenerOdontologoPorId(@PathVariable int id) {
        try {
            Odontologo odontologo = odontologoServicio.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("No existe el odontologo con el id: " + id));
            return ResponseEntity.ok(odontologo);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }


}