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
public class App {
    private Persona usuario;
    
    private CancionAdmin cancionAdmin;
    private PersonaAdmin personaAdmin;

    public App() {
        cancionAdmin = new CancionAdmin();
        personaAdmin = new PersonaAdmin();
        
        ingresar();
        
        boolean continuar = true;
        while (continuar) {
            int opcion = menu();

            continuar = opciones(opcion);
        }
    }
    
    public boolean opciones(int opcion) {
        boolean continuar = true;
        switch (opcion) {
            case 1:
                cancionAdmin.agregar();
                break;
            case 2:
                cancionAdmin.actualizar();
                break;
            case 3:
                cancionAdmin.eliminar();
                break;
            case 4:
                cancionAdmin.listarTodo(usuario);
                break;
            case 5:
                cancionAdmin.escuchar(usuario);
                break;
            case 6:
                personaAdmin.agregar();
                break;
            case 7:
                personaAdmin.actualizar();
                break;
            case 8:
                personaAdmin.eliminar();
                break;
            case 9:
                personaAdmin.listarTodo();
                break;
            case 10:
                personaAdmin.pagar();
                break;
            case 11:
                cancionAdmin.listarPorArtista(usuario);
                break;
            case 12:
                cancionAdmin.listarPorAlbum(usuario);
                break;
            case 13:
                continuar = false;
                break;
        }
        
        return continuar;
    }
    
    public void ingresar() {
        System.out.println("BIENVENIDO AL SISTEMA DE CANCIONES\n");
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String codigo = "";
        while (codigo.isEmpty()) {
            System.out.print("Ingrese su codigo: ");
            try {
                codigo = br.readLine();
            } catch (IOException ex) {
                Logger.getLogger(Exam.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        usuario = personaAdmin.buscarPorCodigo(codigo);
    }
    
    public int menu() {
        System.out.println("\nSISTEMA DE CANCIONES");
        System.out.println("Usuario: " + usuario.getNombre());
        System.out.println("");
        
        System.out.println("MENU PRINCIPAL");
        System.out.println("1.- Agregar cancion");
        System.out.println("2.- Actualizar cancion");
        System.out.println("3.- Eliminar cancion");
        System.out.println("4.- Listar cancion");
        System.out.println("5.- Escuchar cancion");
        System.out.println("6.- Agregar usuario");
        System.out.println("7.- Actualizar usuario");
        System.out.println("8.- Eliminar usuario");
        System.out.println("9.- Listar usuario");
        System.out.println("10.- Pagar");
        System.out.println("11.- Listar canciones por Artista");
        System.out.println("12.- Listar canciones por Album");
        System.out.println("13.- Salir\n");
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String opcionStr = "";
        int opcion;
        System.out.print("Ingrese su opcion: ");
        while (opcionStr == null || opcionStr.isEmpty()) {
            try {
                opcionStr = br.readLine();
                opcion = Integer.parseInt(opcionStr);
                if (opcion > 0 && opcion < 14) {
                    return opcion;
                }
            } catch (Exception ex) {
            } finally {
                opcionStr = null;
            }
            
            System.out.print("Error. Vuelva a ingrese su opcion: ");
        }
        
        return -1;
    }
}
