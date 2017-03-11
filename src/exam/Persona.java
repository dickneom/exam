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
public class Persona extends Objeto {
    public String cedula;
    public String nombre;
    public String apellido;
    public int edad;
    public String email;
    public boolean premium;

    public Persona() {
        super();
    }

    public Persona(int id, String cedula, String nombre, String apellido, int edad, String email, boolean premium) {
        this();
        this.id = id;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.email = email;
        this.premium = premium;
    }
    
    

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isPremium() {
        return premium;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }
    
    @Override
    public String toString() {
        return id + " - " + cedula + " - " + nombre + " - " + " apellido " + " - " + edad + " - " + email + " - " + (premium ? "SI" : "NO");
    }
}
