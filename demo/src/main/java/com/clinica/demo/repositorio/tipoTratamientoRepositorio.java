package com.clinica.demo.repositorio;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.clinica.demo.modelo.tipoTratamiento; // Importacion del modelo

@Repository
public interface tipoTratamientoRepositorio extends JpaRepository<tipoTratamiento, Integer>{


    
}