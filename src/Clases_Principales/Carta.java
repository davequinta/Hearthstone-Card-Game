/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_Principales;

/**
 *
 * @author DOSLAP
 */
public class Carta implements java.io.Serializable   {
    private String nombre;
    private int costoMana;
    private String claseCarta;
    private String tipoEfecto;
    private boolean hechizo;
    private String efecto;
    private int danio;
    private int vida;
    private int vaccion;
    private String ruta_Oval;
    private String ruta_Grande;
    private String ruta_Mano;
    private boolean playable = true;
    private boolean spell = false;
    Carta(){
    }

    public String getTipoEfecto() {
        return tipoEfecto;
    }

    public void setTipoEfecto(String tipoEfecto) {
        this.tipoEfecto = tipoEfecto;
    }

    public boolean isHechizo() {
        return hechizo;
    }

    public void setHechizo(boolean hechizo) {
        this.hechizo = hechizo;
    }

    public String getEfecto() {
        return efecto;
    }

    public void setEfecto(String efecto) {
        this.efecto = efecto;
    }

    public int getDanio() {
        return danio;
    }

    public void setDanio(int danio) {
        this.danio = danio;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getVaccion() {
        return vaccion;
    }

    public void setVaccion(int vaccion) {
        this.vaccion = vaccion;
    }

    public String getRuta_Oval() {
        return ruta_Oval;
    }

    public void setRuta_Oval(String ruta_Oval) {
        this.ruta_Oval = ruta_Oval;
    }

    public String getRuta_Grande() {
        return ruta_Grande;
    }

    public void setRuta_Grande(String ruta_Grande) {
        this.ruta_Grande = ruta_Grande;
    }

    public String getRuta_Mano() {
        return ruta_Mano;
    }

    public void setRuta_Mano(String ruta_Mano) {
        this.ruta_Mano = ruta_Mano;
    }
    
    public Carta(String nombre, boolean hechizo ,int costoMana, String claseCarta, String tipoEfecto, String efecto, int danio, int vida, int vaccion, String ruta_Oval, String ruta_Grande, String ruta_Mano) {
        this.nombre = nombre;
        this.hechizo = hechizo;
        this.costoMana = costoMana;
        this.claseCarta = claseCarta;
        this.tipoEfecto = tipoEfecto;
        this.efecto = efecto;
        this.danio = danio;
        this.vida = vida;
        this.vaccion = vaccion;
        this.ruta_Oval = ruta_Oval;
        this.ruta_Grande = ruta_Grande;
        this.ruta_Mano = ruta_Mano;
    }
    

    public Carta(String nombre, String claseCarta) {
        this.nombre = nombre;
        this.claseCarta = claseCarta;
        
    }
    


    public boolean isPlayable() {
        return playable;
    }

    public void setPlayable(boolean playable) {
        this.playable = playable;
    }

    public boolean isSpell() {
        return spell;
    }

    public void setSpell(boolean spell) {
        this.spell = spell;
    }
    
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the costoMana
     */
    public int getCostoMana() {
        return costoMana;
    }

    /**
     * @param costoMana the costoMana to set
     */
    public void setCostoMana(int costoMana) {
        this.costoMana = costoMana;
    }

    /**
     * @return the claseCarta
     */
    public String getClaseCarta() {
        return claseCarta;
    }

    /**
     * @param claseCarta the claseCarta to set
     */
    public void setClaseCarta(String claseCarta) {
        this.claseCarta = claseCarta;
    }

    /**
     * @return the descripcion
     */
   

    /**
     * @return the rutaImg
     */
    
    /*
    public void restarMana(Jugador j){
        int mana = j.getMana();
        if(mana >= costoMana){
            mana-=costoMana;
            j.setMana(mana);
        }
        else{
            System.out.println("Mana insuficiente");
        }
    }
    */
    public void desaparecerCarta(){
    }

    
}
