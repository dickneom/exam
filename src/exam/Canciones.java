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
public class Canciones extends LinkedList<Cancion> {

    public Canciones() {
        add(new Cancion("Cancion 1", "Album 1", "Artista 1", 180, 0));
        add(new Cancion("Cancion 2", "Album 2", "Artista 2", 280, 0));
        add(new Cancion("Cancion 3", "Album 1", "Artista 1", 250, 0));
        add(new Cancion("Cancion 4", "Album 3", "Artista 3", 300, 0));
        add(new Cancion("Cancion 5", "Album 1", "Artista 1", 330, 0));
        add(new Cancion("Cancion 6", "Album 2", "Artista 2", 270, 0));
        add(new Cancion("Cancion 7", "Album 3", "Artista 3", 250, 0));
        add(new Cancion("Cancion 8", "Album 1", "Artista 1", 190, 0));
        add(new Cancion("Cancion 9", "Album 5", "Artista 5", 220, 0));
        add(new Cancion("Cancion 10", "Album 1", "Artista 1", 235, 0));
        add(new Cancion("Cancion 11", "Album 2", "Artista 2", 240, 0));
        add(new Cancion("Cancion 12", "Album 3", "Artista 3", 255, 0));
        add(new Cancion("Cancion 13", "Album 5", "Artista 5", 290, 0));
        add(new Cancion("Cancion 14", "Album 2", "Artista 2", 350, 0));
        add(new Cancion("Cancion 15", "Album 2", "Artista 2", 225, 0));
    }
}
