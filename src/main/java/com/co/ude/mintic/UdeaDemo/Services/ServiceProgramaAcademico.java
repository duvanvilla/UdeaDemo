package com.co.ude.mintic.UdeaDemo.Services;

import com.co.ude.mintic.UdeaDemo.Domain.Persona;
import com.co.ude.mintic.UdeaDemo.Repository.EntityPersona;
import com.co.ude.mintic.UdeaDemo.Repository.RepositoryPersona;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceProgramaAcademico {

    @Getter @Setter
    private String nombreProgram;

    ArrayList<Persona> listaP;

    public ServiceProgramaAcademico(ArrayList<Persona> listaP) {
        this.listaP = listaP;
    }

    @Autowired
    RepositoryPersona repositoryPersona;

    public String inscribirAlumno(Persona alumno){
        String inscripcion = "El alumno " + alumno.getNombre() + " " + alumno.getApellido()
                + " con " + alumno.getEdad() + " años, quedó inscrito al programa ";

        return inscripcion;

    }

    public ArrayList doWhile (int a){
        ArrayList <String> objTraza = new ArrayList<>();
        do {
            System.out.println("Hola mundo" + a);
            objTraza.add("Hola mundo " + String.valueOf(a));
            a++;
        } while (a<10);
        return objTraza;
    }

    // Este método realiza la lógica de recibir los valores para cada variable de Persona
    // por el endpoint del Controller y asignárselos al objPersona, cada objetoPersona es agregado a la listaP.
    // Y cada vez que se ejecute el endpoint de Controller se va a agregar
    // una persona nueva a la listaP, si los datos ingresados son correctos en cada disparo
    // se retornará un true.
    public boolean addPersona (Persona persona){
        System.out.println("--- Hace uso del método addPersona del Service");
        Persona objPersona = new Persona();
        objPersona.setNombre(persona.getNombre());
        objPersona.setApellido(persona.getApellido());
        objPersona.setEdad(persona.getEdad());
        objPersona.setId(persona.getId());
        objPersona.setDoc(persona.getDoc());

        listaP.add(objPersona);

        return Boolean.TRUE;
    }

    // Este método retorna la lista con las personas de la persona que se agregaron con la ejecución del
    // método addPersona, pero se va a retornar en el endpoint de listaPersona y crearPersona del
    // ControllerProgramaAcademico en donde es implementado este método
    public ArrayList<Persona> listar (){
        System.out.println("--- Hace uso del método listar del Service");
        return listaP;
    }

    // Este método lo utilizo para buscar una persona por el ID
    // si la encuentra devolverá a la persona que coincida con el ID
    // si no, devuelve a la persona vacía
    public Persona buscarPersona (int id){
        System.out.println("--- Hace uso del método buscarPersona del Service");
        Persona persona = null;
        for (Persona p: listaP) {
            if (p.getId() == id){
                return p;
            }
        }
        return persona;
    }

    public boolean addPersonaCC (Persona persona, String doc){
        System.out.println("--- Hace uso del método addPersona con cédula del Service");
        Persona objPersona = new Persona();
        objPersona.setNombre(persona.getNombre());
        objPersona.setApellido(persona.getApellido());
        objPersona.setEdad(persona.getEdad());
        objPersona.setId(persona.getId());
        objPersona.setDoc(doc);

        listaP.add(objPersona);

        return Boolean.TRUE;
    }

    public boolean addPersonaTI (Persona persona, String doc){
        System.out.println("--- Hace uso del método addPersona con tarjeta de identidad del Service");
        Persona objPersona = new Persona();
        objPersona.setNombre(persona.getNombre());
        objPersona.setApellido(persona.getApellido());
        objPersona.setEdad(persona.getEdad());
        objPersona.setId(persona.getId());
        objPersona.setDoc(doc);

        listaP.add(objPersona);

        return Boolean.TRUE;
    }

    public List<EntityPersona> listarTodosJPA(){
        List <EntityPersona> List = repositoryPersona.findAll(); //findAll lista todos los registro y retorna un objeto de tipo lista
        return List;
    }

    public Boolean borrarPersona(Persona persona){
        listaP.remove(persona);
        return Boolean.TRUE;
    }
}
