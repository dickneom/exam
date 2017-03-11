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
public class Cancion extends Objeto {
    private String nombre;
    private String album;
    private String artista;
    private int duracion;
    private int contador;
    private boolean gratis;

    public Cancion() {
        super();
    }

    public Cancion(int id, String nombre, String album, String artista, int duracion, int contador, boolean gratis) {
        this();
        this.id = id;
        this.nombre = nombre;
        this.album = album;
        this.artista = artista;
        this.duracion = duracion;
        this.contador = contador;
        this.gratis = gratis;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public boolean isGratis() {
        return gratis;
    }

    public void setGratis(boolean gratis) {
        this.gratis = gratis;
    }
    
    @Override
    public String toString() {
        return id + " - " + nombre + " - " + album + " - " + artista + " - " + String.valueOf(duracion) + " - " + String.valueOf(contador);
    }

}
