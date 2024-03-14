package com.clinica.demo.repositorio;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.clinica.demo.modelo.Paciente; // Importacion del modelo

@Repository
public interface PacienteRepositorio extends JpaRepository<Paciente, Integer>{


    
}
