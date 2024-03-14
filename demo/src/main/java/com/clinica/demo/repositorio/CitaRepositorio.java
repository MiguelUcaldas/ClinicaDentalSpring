package com.clinica.demo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.clinica.demo.modelo.Cita; // Importacion del modelo

@Repository
public interface CitaRepositorio extends JpaRepository<Cita, Integer>{


    
}
