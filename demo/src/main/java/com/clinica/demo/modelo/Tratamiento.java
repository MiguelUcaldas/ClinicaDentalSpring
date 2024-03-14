package com.clinica.demo.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity; // Import the Entity class
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tratamiento")

public class Tratamiento {
    
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        @Column(name = "nombre", nullable = false, length = 30)
        private String nombre;
        @Column(name = "descripcion", nullable = false, length = 30)
        private String descripcion;
        @Column(name = "costo", nullable = false, length = 30)
        private String costo;
        //tipo de tratamiento relacionado con la entidad tipoTratamiento
        @Column(name = "tipoTratamiento", nullable = false, length = 30)
        private tipoTratamiento tipoTratamiento;

    
        //constructors

        public Tratamiento() {
        }

        public Tratamiento(int id, String nombre, String descripcion, String costo, tipoTratamiento tipoTratamiento) {
            this.id = id;
            this.nombre = nombre;
            this.descripcion = descripcion;
            this.costo = costo;
            this.tipoTratamiento = tipoTratamiento;
        }

        //getters and setters

        public int getId() {
            return this.id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNombre() {
            return this.nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getDescripcion() {
            return this.descripcion;
        }

        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }

        public String getCosto() {
            return this.costo;
        }

        public void setCosto(String costo) {
            this.costo = costo;
        }

        public tipoTratamiento getTipoTratamiento() {
            return this.tipoTratamiento;
        }

        public void setTipoTratamiento(tipoTratamiento tipoTratamiento) {
            this.tipoTratamiento = tipoTratamiento;
        }


}
