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
public class CancionAdmin extends Admin {
    public Canciones canciones;

    public CancionAdmin() {
        canciones = new Canciones();
    }
    
    
    public Cancion editar(Cancion cancion) {

        if (cancion == null) {
            cancion = new Cancion();
        } else {
            System.out.println("DATOS ANTERIORES");
            System.out.println("Nombre: " + cancion.getNombre());
            System.out.println("Albun: " + cancion.getAlbum());
            System.out.println("Artista: " + cancion.getArtista());
            System.out.println("Duración: " + cancion.getDuracion());
        }
        
        try {
            cancion.setNombre(leerDato("Nombre:"));
            cancion.setAlbum(leerDato("Album:"));
            cancion.setArtista(leerDato("Artista:"));
            cancion.setDuracion(Integer.parseInt(leerDato("Duracion:")));
            cancion.setContador(0);
        } catch (IOException ex) {
            Logger.getLogger(CancionAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return cancion;
    }
    
    public void validar(Cancion cancion) {
        
    }
    
    public void agregar() {
        Cancion cancion = editar(null);
        canciones.add(cancion);
    }
    
    public void actualizar(int indice) {
        Cancion cancion = buscar(indice);
        cancion = editar(cancion);
        canciones.set(cancion.getId(), cancion);
    }
    
    public void eliminar(int indice) {
        canciones.remove(indice);
    }
    
    public Cancion buscar(int indice) {
        Cancion cancion = canciones.get(indice);
        cancion.setId(indice);
        return cancion;
    }
    
    
    
    public void buscarNombre() {
        
    }
    
    public void buscarAlbum() {
        
    }
    
    public void listarTodo() {
        for (Cancion cancion : canciones) {
            System.out.println(cancion);
        }
        
    }
    
    public void mostrarUno(int id) {
        
    }
    
}
