package com.clinica.demo.repositorio;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.clinica.demo.modelo.Tratamiento; // Importacion del modelo

@Repository
public interface TratamientoRepositorio extends JpaRepository<Tratamiento, Integer>{


    
}