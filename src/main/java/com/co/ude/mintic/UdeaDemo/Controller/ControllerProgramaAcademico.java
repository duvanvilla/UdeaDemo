package com.co.ude.mintic.UdeaDemo.Controller;

import com.co.ude.mintic.UdeaDemo.Domain.Persona;
import com.co.ude.mintic.UdeaDemo.Services.ServiceProgramaAcademico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.StreamingHttpOutputMessage;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping (value = "/persona")
public class ControllerProgramaAcademico {

    /*
    1. Creo un nuevo servicio, instanciando el servicio
    ServiceProgramaAcademico que está creado en la carpeta Services.
    La anotación @Autowired requiere que la clase que se va anotar
    esté anotada por un @Service o por un @Component
    */
    @Autowired // este hace las veces del new
    ServiceProgramaAcademico serviceProgramaAcademico;

    /*
    2. Creo un método que sea accesible desde un web browser,
    para ello utilizo la anotación GetMapping en la que indico
    la ruta y el tipo de archivo que producirá para mostrar
    la información.

    3. Genero un método, en este caso le puse el nombre de
    callServicePrograma, en el que voy a generar un objeto de la clase
    Persona y a su vez le voy a dar valor a cada uno de sus atributos
    y por último le pido que me retorne el método de Services
    inscribirAlumno con los datos ingresados.
     */
    @GetMapping (path = "/udea/mintic/program", produces = "application/json")
    public ResponseEntity <String> callServicePrograma(){
        Persona alumno = new Persona();
        alumno.setNombre("Duvan");
        alumno.setApellido("Villa");
        alumno.setEdad(29);
        String salida = serviceProgramaAcademico.inscribirAlumno(alumno);
        return new ResponseEntity<>(salida, HttpStatus.NOT_FOUND);

    }

    @GetMapping (path = "/udea/mintic/doWhile", produces = "application/json")
    public ArrayList doWhileController(){
        ArrayList<String> salida = new ArrayList<>();
        salida = serviceProgramaAcademico.doWhile(7);
        return salida;
    }

    // Este endpoint retorna la lista con la, o las personas agregadas
    // usando el método addPersona y posteriormente el método listar,
    // ambos están en ServiceProgramaAcadémico
    @GetMapping (path = "/udea/mintic/listaPersonas", produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList <Persona> listaPersonas (){
        System.out.println("- Ingresó al método listaPersonas del Controller");
        return serviceProgramaAcademico.listar();
    }

    // Este endpoint guarda en la variable booleana salida un true porque es lo que retorna el método, eso depende
    @PostMapping (path = "/udea/mintic/crearPersonas", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <Persona> crearPersona (@RequestBody Persona persona){
        System.out.println("- Ingresó al método crearPersonas Controller");
        boolean salida = serviceProgramaAcademico.addPersona(persona);
        if (salida == true){
            return new ResponseEntity("Persona agregada correctamente", HttpStatus.OK);
        } else {
            return new ResponseEntity("Error de Ejecución," +
                    "uno o varios atributos no se ingresaron correctamente ", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Buscar persona por ID
    @GetMapping (path = "/udea/mintic/buscarPersona/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <Persona> buscarPersona (@PathVariable int id){ //Entre paréntesis debe ir el dato que va requerir
        System.out.println("- Ingresó al método buscarPersona del Controller");
        Persona p = serviceProgramaAcademico.buscarPersona(id);
        if (p != null){
            return new ResponseEntity<>(p, HttpStatus.OK);
        } else {
            return new ResponseEntity("La persona por el id #" + id + " no existe", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping (path = "/udea/mintic/crearPersona/{doc}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <Persona> crearPersonaCondicional (@RequestBody Persona persona, @PathVariable String doc){
        System.out.println("- Ingresó al método crearPersona con tipo de documento del Controller");
        switch (doc){
            case "CC":
                serviceProgramaAcademico.addPersonaCC(persona, doc);
                break;
            case "TI":
                serviceProgramaAcademico.addPersonaTI(persona, doc);
                break;
            default:
                return new ResponseEntity("Error de ejecución", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Persona>(persona, HttpStatus.OK);
    }

    /*
    Este método buscará una persona por el ID ingresado en la variable id,
    si lo encuentra reemplazará el valor guardado en la variable nombre por el nombreModificado
    En conclusión: Busca y actualiza una variable
     */
    @PutMapping (path = "/udea/mintic/actualizarPersona", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <Persona> actualizarPersona(@RequestParam int id, String nombreModificado){
        System.out.println("- Ingresó al método actualizarPersona con ID y nuevo nombre del Controller");
        Persona p = serviceProgramaAcademico.buscarPersona(id);
        p.setNombre(nombreModificado);
        return new ResponseEntity<Persona>(p, HttpStatus.OK);
    }

    @PatchMapping (path = "/udea/mintic/actualizarPersonaParcial", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <String> actualizarPersonaParcial (){
        System.out.println("- Ingresó al método actualizarPersonaParcial del Controller");
        String retorno = "Actualizar Persona Parcial";
        return new ResponseEntity<String>(retorno, HttpStatus.OK);
    }
}
