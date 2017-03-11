/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exam;

/**
 *
 * @author dickneom
 */
public class Exam {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CancionAdmin ca = new CancionAdmin();
        
        ca.agregar();
        
        ca.listarTodo();
    }
    
}
