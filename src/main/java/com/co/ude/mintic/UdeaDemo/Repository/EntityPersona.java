package com.co.ude.mintic.UdeaDemo.Repository;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table (name = "persona")
public class EntityPersona {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    @Column (name = "nombre")
    private String nombre;

    @Column (name = "apellido")
    private String apellido;

    @Column (name = "documento")
    private int edad;

}
