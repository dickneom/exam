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
    
    public void agregar() {
        Cancion cancion = editar(null);
        cancion.setId(proximoId());
        canciones.add(cancion);
    }
    
    private int proximoId() {
        int id = -1;
        for (Cancion cancion : canciones) {
            id = cancion.getId() > id ? cancion.getId() : id;
        }
        
        return id + 1;
    }
    
    public void actualizar() {
        try {
            String idCancionStr = leerDato("Id de la cancion a editar:");
            int id = Integer.parseInt(idCancionStr);
            Cancion cancion = canciones.buscarPorId(id);
            if (cancion != null) {
                cancion = editar(cancion);
                int indice = canciones.buscarIndice(id);
                canciones.set(indice, cancion);
            } else {
                System.out.println("CANCION NO ENCONTRADA.");
            }
        } catch (IOException | NumberFormatException ex) {
            Logger.getLogger(CancionAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void eliminar() {
        try {
            String idCancionStr = leerDato("Id de la cancion a eliminar:");
            int id = Integer.parseInt(idCancionStr);
            Cancion cancion = canciones.buscarPorId(id);
            if (cancion != null) {
                int indice = canciones.buscarIndice(id);
                canciones.remove(indice);
            } else {
                System.out.println("CANCION NO ENCONTRADA.");
            }
        } catch (Exception ex) {
            Logger.getLogger(CancionAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void listarTodo(Persona usuario) {
        for (int i = 0; i < canciones.size(); i++) {
            Cancion cancion = canciones.get(i);
            
            if (cancion.isGratis() || usuario.isPremium()) {
                System.out.println(cancion);
            }
        }
    }
    
    public void escuchar(Persona usuario) {
        try {
            String idCancionStr = leerDato("Id de la cancion a escuchar:");
            int id = Integer.parseInt(idCancionStr);
            Cancion cancion = canciones.buscarPorId(id);
            if (cancion != null) {
                if (cancion.isGratis() || usuario.isPremium())
                System.out.println("Escuchando cancion: " + cancion.getNombre());
                int indice = canciones.buscarIndice(id);
                cancion.setContador(cancion.getContador() + 1);
                canciones.set(indice, cancion);
            } else {
                System.out.println("CANCION NO ENCONTRADA.");
            }
        } catch (IOException | NumberFormatException ex) {
            Logger.getLogger(CancionAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private Cancion editar(Cancion cancion) {

        if (cancion == null) {
            cancion = new Cancion();
            cancion.setContador(0);
        } else {
            System.out.println("DATOS ANTERIORES");
            System.out.println("Nombre: " + cancion.getNombre());
            System.out.println("Album: " + cancion.getAlbum());
            System.out.println("Artista: " + cancion.getArtista());
            System.out.println("Duración: " + cancion.getDuracion());
            System.out.println("Gratis: " + (cancion.isGratis() ? "SI" : "NO"));
        }
        
        try {
            cancion.setNombre(leerDato("Nombre:"));
            cancion.setAlbum(leerDato("Album:"));
            cancion.setArtista(leerDato("Artista:"));
            cancion.setDuracion(Integer.parseInt(leerDato("Duración:")));
            cancion.setGratis("S".equals(leerDato("Gratis [S/N]:")));
        } catch (IOException ex) {
            Logger.getLogger(CancionAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return cancion;
    }
    
    public void validar(Cancion cancion) {
        
    }
}
