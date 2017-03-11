/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exam;

import java.util.LinkedList;

/**
 *
 * @author dickneom
 */
public class Personas extends LinkedList<Persona> {

    public Personas() {
        add(new Persona(1, "111", "NOMBRE 1", "APELLIDO 1", 11, "aaa@email.com", true));
        add(new Persona(2, "222", "NOMBRE 2", "APELLIDO 2", 11, "bbb@email.com", false));
        add(new Persona(3, "333", "NOMBRE 3", "APELLIDO 3", 11, "ccc@email.com", false));
        add(new Persona(4, "444", "NOMBRE 4", "APELLIDO 4", 11, "ddd@email.com", true));
        add(new Persona(5, "555", "NOMBRE 5", "APELLIDO 5", 11, "eee@email.com", false));
        add(new Persona(6, "666", "NOMBRE 6", "APELLIDO 6", 11, "fff@email.com", true));
    }
    
    // Busca el indice de una persona dado su id
    public int buscarIndice(int id) {
        for (int i = 0; i < size(); i++) {
            Persona persona = get(i);
            
            if (persona.getId() == id) {
                return i;
            }
        }
        
        return -1;
    }
    
    // busca una persona dado su id
    public Persona buscarPorId(int id) {
        for (int i = 0; i < size(); i++) {
            Persona persona = get(i);
            
            if (persona.getId() == id) {
                return persona;
            }
        }
        
        return null;
    }
}
