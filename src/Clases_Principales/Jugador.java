/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_Principales;

import java.util.ArrayList;

/**
 *
 * @author Dave
 */
public class Jugador implements java.io.Serializable  {
    private String nombreUsuario = null;
    private String contrasena;
    public Heroe hero;

    public Heroe getHero() {
        return hero;
    }

    public void setHero(Heroe hero) {
        this.hero = hero;
    }
    
   
    
    public Jugador(String nombreUsuario, String contrasena){
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
    }
    

    /**
     * @return the nombreUsuario
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    /**
     * @param nombreUsuario the nombreUsuario to set
     */
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    /**
     * @return the contrasena
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * @param contrasena the contrasena to set
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     * @return the mazo
     */
   
}
