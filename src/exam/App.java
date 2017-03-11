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
    private String codUsuario;
    private Persona usuario;
    
    CancionAdmin cancionAdmin;

    public App() {
        cancionAdmin = new CancionAdmin();
        
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
                cancionAdmin.listarTodo();
                break;
            case 5:
                cancionAdmin.escuchar();
                break;
            case 6:
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
        
        codUsuario = codigo;
    }
    
    public int menu() {
        System.out.println("SISTEMA DE CANCIONES\n");
        
        System.out.println("MENU PRINCIPAL");
        System.out.println("1.- Agregar cancion");
        System.out.println("2.- Actualizar cancion");
        System.out.println("3.- Eliminar cancion");
        System.out.println("4.- Listar cancion");
        System.out.println("5.- Escuchar cancion");
        System.out.println("6.- Salir\n");
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String opcionStr = "";
        int opcion;
        System.out.print("Ingrese su opcion: ");
        while (opcionStr == null || opcionStr.isEmpty()) {
            try {
                opcionStr = br.readLine();
                opcion = Integer.parseInt(opcionStr);
                if (opcion > 0 && opcion < 7) {
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