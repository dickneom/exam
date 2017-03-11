/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exam;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dickneom
 */
public class PersonaAdmin extends Admin {
    public Personas personas;

    public PersonaAdmin() {
        personas = new Personas();
    }
    
    public void agregar() {
        Persona persona = editar(null);
        persona.setId(proximoId());
        personas.add(persona);
    }
    
    private int proximoId() {
        int id = -1;
        for (Persona persona : personas) {
            id = persona.getId() > id ? persona.getId() : id;
        }
        
        return id + 1;
    }
    
    public void actualizar() {
        try {
            String idPersonaStr = leerDato("Id de la persona a editar:");
            int id = Integer.parseInt(idPersonaStr);
            Persona persona = personas.buscarPorId(id);
            if (persona != null) {
                persona = editar(persona);
                int indice = personas.buscarIndice(id);
                personas.set(indice, persona);
            } else {
                System.out.println("PERSONA NO ENCONTRADA.");
            }
        } catch (Exception ex) {
            Logger.getLogger(PersonaAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void eliminar() {
        try {
            String idPersonaStr = leerDato("Id de la persona a eliminar:");
            int id = Integer.parseInt(idPersonaStr);
            Persona persona = personas.buscarPorId(id);
            if (persona != null) {
                int indice = personas.buscarIndice(id);
                personas.remove(indice);
            } else {
                System.out.println("PERSONA NO ENCONTRADA.");
            }
        } catch (Exception ex) {
            Logger.getLogger(PersonaAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void listarTodo() {
        for (int i = 0; i < personas.size(); i++) {
            Persona persona = personas.get(i);
            
            System.out.println(i + " - " + persona);
        }
    }
    
    public void pagar() {
        try {
            String idCancionStr = leerDato("Id de la persona que va a pagar:");
            int id = Integer.parseInt(idCancionStr);
            Persona persona = personas.buscarPorId(id);
            if (persona != null) {
                System.out.println("Pago recibido: " + persona.getNombre());
                int indice = personas.buscarIndice(id);
                persona.setPremium(true);
                personas.set(indice, persona);
            } else {
                System.out.println("PERSONA NO ENCONTRADA.");
            }
        } catch (Exception ex) {
            Logger.getLogger(PersonaAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private Persona editar(Persona persona) {

        if (persona == null) {
            persona = new Persona();
            persona.setPremium(false);
        } else {
            System.out.println("DATOS ANTERIORES");
            System.out.println("Cedula: " + persona.getCedula());
            System.out.println("Nombre: " + persona.getNombre());
            System.out.println("Apellido: " + persona.getApellido());
            System.out.println("Edad: " + persona.getEdad());
            System.out.println("Email: " + persona.getEmail());
        }
        
        try {
            persona.setCedula(leerDato("Cedula:"));
            persona.setNombre(leerDato("Nombre:"));
            persona.setApellido(leerDato("Apellido:"));
            persona.setEdad(Integer.parseInt(leerDato("Edad:")));
            persona.setEmail(leerDato("Email:"));
        } catch (IOException ex) {
            Logger.getLogger(PersonaAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return persona;
    }
    
    public void validar(Cancion cancion) {
        
    }
}
