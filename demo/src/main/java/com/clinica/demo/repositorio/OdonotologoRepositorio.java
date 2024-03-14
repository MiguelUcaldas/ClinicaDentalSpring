package com.clinica.demo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.clinica.demo.modelo.Odontologo; // Importacion del modelo

@Repository
public interface OdonotologoRepositorio extends JpaRepository<Odontologo, Integer>{


    
}
