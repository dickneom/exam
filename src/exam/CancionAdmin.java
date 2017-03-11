/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dickneom
 */
public class CancionAdmin extends Admin implements IntAdmin {
    public Canciones canciones;

    public CancionAdmin() {
        canciones = new Canciones();
        canciones.llenar();
    }
    
    @Override
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
    
    @Override
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
    
    @Override
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
    
    
    public void listarTodo() {
        System.out.println("\nID - NOMBRE - APELLIDO - ALBUM - ARTISTA - DURACION - ESCUCHADA - GRATIS?");
        for (int i = 0; i < canciones.size(); i++) {
            Cancion cancion = canciones.get(i);
            
            System.out.println(cancion);
        }
    }
    
    public void listarTodo(Persona usuario) {
        System.out.println("\nID - NOMBRE - APELLIDO - ALBUM - ARTISTA - DURACION - ESCUCHADA - GRATIS?");
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
                if (cancion.isGratis() || usuario.isPremium()) {
                    System.out.println("Escuchando cancion: " + cancion.getNombre());
                    int indice = canciones.buscarIndice(id);
                    cancion.setContador(cancion.getContador() + 1);
                    canciones.set(indice, cancion);
                } else {
                    System.out.println("CANCION SOLO PARA CUENTAS PREMIUM.");
                }
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
    
    public void listarPorArtista(Persona usuario) {
        Canciones cs = new Canciones();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String artista = "";
        while (artista == null || artista.isEmpty()) {
            System.out.print("Ingrese el nombre del artista: ");
            try {
                artista = br.readLine();
            } catch (IOException ex) {
            } finally {
            }
        }
        
        for (Cancion cancion : canciones) {
            System.out.println("Comparando: " + cancion.getArtista() + " - " + artista);
            if (cancion.getArtista().equals(artista)) {
                cs.add(cancion);
            }
        }
        
        if (cs.size() > 0) {
            listar(cs, usuario);
        } else {
            System.out.println("NO SE ENCONTRO CANCIONES");
        }
    }
    
    public void listarPorAlbum(Persona usuario) {
        Canciones cs = new Canciones();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String album = "";
        while (album == null || album.isEmpty()) {
            System.out.print("Ingrese el nombre del album: ");
            try {
                album = br.readLine();
            } catch (IOException ex) {
            } finally {
            }
        }
        
        for (Cancion cancion : canciones) {
            if (cancion.getAlbum().equals(album)) {
                cs.add(cancion);
            }
        }
        
        if (cs.size() > 0) {
            listar(cs, usuario);
        } else {
            System.out.println("NO SE ENCONTRO CANCIONES");
        }
    }
    
    public void listar(Canciones cs, Persona usuario) {
        System.out.println("\nLISTA DE CANCIONES");
        System.out.println("ID - NOMBRE - APELLIDO - ALBUM - ARTISTA - DURACION - ESCUCHADA - GRATIS?");
        for (int i = 0; i < cs.size(); i++) {
            Cancion cancion = cs.get(i);
            
            if (cancion.isGratis() || usuario.isPremium()) {
                System.out.println(cancion);
            }
        }
    }
}
