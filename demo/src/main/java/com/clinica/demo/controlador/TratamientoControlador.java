package com.clinica.demo.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clinica.demo.excepciones.ResourceNotFoundException;
import com.clinica.demo.repositorio.TratamientoRepositorio;
import com.clinica.demo.modelo.Tratamiento; // Add this import statement
@RestController
@RequestMapping("/tratamiento")
public class TratamientoControlador {

    @Autowired
    private TratamientoRepositorio tratamientoServicio;

    // Metodos del controlador

    // metodo para agregar un tipo de tratamiento
    @PostMapping("/agregar")
    public Tratamiento agregarTipoTratamiento(@RequestBody Tratamiento Tratamiento) {
        return tratamientoServicio.save(Tratamiento);
    }

    // Metodo para listar todos los tipos de tratamiento
    @GetMapping("/listar")
    public List<Tratamiento> TipoTratamiento() {
        return tratamientoServicio.findAll();
    }

    //actualizar un tipo de tratamiento por id 

    @PutMapping("/actualizar/{id}")
    public Tratamiento actualizarTipoTratamiento(@PathVariable int id, @RequestBody Tratamiento tratamiento) {
        Tratamiento tratamientoExistente = tratamientoServicio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el tipo de tratamiento con el id: " + id));
        tratamientoExistente.setNombre(tratamiento.getNombre());
        tratamientoExistente.setDescripcion(tratamiento.getDescripcion());
        tratamientoExistente.setCosto(tratamiento.getCosto());
        // Actualizar otros campos según sea necesario
        return tratamientoServicio.save(tratamientoExistente);
    }

    //eliminar un tipo de tratamiento por id

    @DeleteMapping("/eliminar/{id}")
    public void eliminarTipoTratamiento(@PathVariable int id) {
        tratamientoServicio.deleteById(id);
    }

    
}
