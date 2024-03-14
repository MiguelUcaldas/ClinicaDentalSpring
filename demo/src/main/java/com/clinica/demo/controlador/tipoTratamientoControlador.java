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
import com.clinica.demo.modelo.tipoTratamiento;
import com.clinica.demo.repositorio.tipoTratamientoRepositorio;


@RestController
@RequestMapping("/tipoTratamiento")

public class tipoTratamientoControlador {
    
        @Autowired
        private tipoTratamientoRepositorio tipoTratamientoServicio;

        // Metodos del controlador

        // metodo para agregar un tipo de tratamiento
        @PostMapping("/agregar")
        public tipoTratamiento agregarTipoTratamiento(@RequestBody tipoTratamiento tipoTratamiento) {
            return tipoTratamientoServicio.save(tipoTratamiento);
        }

        // Metodo para listar todos los tipos de tratamiento
        @GetMapping("/listar")
        public List<tipoTratamiento> listarTipoTratamiento() {
            return tipoTratamientoServicio.findAll();
        }

        //actualizar un tipo de tratamiento por id 

        @PutMapping("/actualizar/{id}")
        public tipoTratamiento actualizarTipoTratamiento(@PathVariable int id, @RequestBody tipoTratamiento tipoTratamiento) {
            tipoTratamiento tipoTratamientoExistente = tipoTratamientoServicio.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("No existe el tipo de tratamiento con el id: " + id));
            tipoTratamientoExistente.setNombre(tipoTratamiento.getNombre());
            tipoTratamientoExistente.setDescripcion(tipoTratamiento.getDescripcion());
            tipoTratamientoExistente.setCosto(tipoTratamiento.getCosto());
            // Actualizar otros campos según sea necesario
            return tipoTratamientoServicio.save(tipoTratamientoExistente);
        }

        //eliminar un tipo de tratamiento por id
        @DeleteMapping("/eliminar/{id}")
        public void eliminarTipoTratamiento(@PathVariable int id) {
            tipoTratamiento tipoTratamientoExistente = tipoTratamientoServicio.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("No existe el tipo de tratamiento con el id: " + id));
            tipoTratamientoServicio.delete(tipoTratamientoExistente);
        }


        

    
}
