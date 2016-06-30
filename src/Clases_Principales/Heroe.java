/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_Principales;

import java.util.ArrayList;

/**
 *
 * @author DOSLAP
 */
public class Heroe {
    int Id_hero;
    int vida = 30;
    String Nombre_hero, Poder_hero, Rut_Img_Hero;
    ArrayList<Carta> deck;
    String Tipo_heroe;
    int mana=0;

    public String getTipo_heroe() {
        return Tipo_heroe;
    }

    public void setTipo_heroe(String Tipo_heroe) {
        this.Tipo_heroe = Tipo_heroe;
    }
    

    public ArrayList<Carta> getDeck() {
        return deck;
    }

    public void setDeck(ArrayList<Carta> deck) {
        this.deck = deck;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }
    
    
    
    public Heroe(int Id_hero, String Nombre_hero, String Rut_Img_Hero){
    this.Id_hero= Id_hero;
    this.Nombre_hero= Nombre_hero;
    this.Rut_Img_Hero=Rut_Img_Hero;
    }
    
    public Heroe(){
 }

    public int getId_hero() {
        return Id_hero;
    }

    public void setId_hero(int Id_hero) {
        this.Id_hero = Id_hero;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public String getNombre_hero() {
        return Nombre_hero;
    }

    public void setNombre_hero(String Nombre_hero) {
        this.Nombre_hero = Nombre_hero;
    }

    public String getRut_Img_Hero() {
        return Rut_Img_Hero;
    }

    public void setRut_Img_Hero(String Rut_Img_Hero) {
        this.Rut_Img_Hero = Rut_Img_Hero;
    }

public String getPoder_hero() {
        return Poder_hero;
    }

    public void setPoder_hero(String Poder_hero) {
        this.Poder_hero = Poder_hero;
    }
    
    public void restarVida(int dano){
        vida-=dano;
    }
    
    public void ejecutarPoder(){
    }
}
