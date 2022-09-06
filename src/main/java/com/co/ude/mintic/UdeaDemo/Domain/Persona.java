package com.co.ude.mintic.UdeaDemo.Domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Persona {

    private String nombre;
    private String apellido;
    private int edad;
    private int id;
    private String doc;
}
