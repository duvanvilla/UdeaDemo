package com.co.ude.mintic.UdeaDemo.Repository;

import lombok.Data;

import javax.persistence.*;

@Data // Encapsulamiento: Anotación para encapsular los datos para así poder obtener y modificarlos (getters and setters)
@Entity // Comportamiento: Anotación para definir que esta clase se comporte como una entity class
@Table (name = "persona") // Definición: La clase va a ser una tabla
public class EntityPersona {
    // Esta es la primera columna y se va a comportar como PrimaryKey
    @Id // Esta es la anotación para definir esta columna como PK (PrimaryKey)
    @GeneratedValue (strategy = GenerationType.AUTO) // Los valores de este campo se van a generar de manera automática
    private Long id; // Para JPA no sirven los tipos de dato primitivo, sólo sirven los de tipo Object

    // El resto de las columnas se definen con la anotación @Column
    @Column (name = "nombre")
    private String nombre;

    @Column (name = "apellido")
    private String apellido;

    @Column (name = "edad")
    private int edad;

    @Column (name = "doc")
    private String doc;

}
