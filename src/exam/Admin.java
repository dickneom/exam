/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author dickneom
 */
public abstract class Admin {
    
    protected String leerDato(String texto) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String dato = "";
        System.out.print(texto + " ");
        
        while (dato.isEmpty()) {
            dato = br.readLine();
        }
        
        return dato;
    }
    
}
