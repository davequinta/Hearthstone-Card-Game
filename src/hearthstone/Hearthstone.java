/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hearthstone;
import Clases_Principales.*;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author César
 */
public class Hearthstone{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     Jugador j1 = new Jugador("Cesar","Pizza123");
     Jugador j2 = new Jugador("Emilio","HailHydra@@");
     Jugador j3 = new Jugador("Marvin","JohnNieve1234");
     Jugador j4 = new Jugador("Dave","1234");
     
     ArrayList<Jugador> jugadores = new ArrayList();
     jugadores.add(j1);
     jugadores.add(j2);
     jugadores.add(j3);
     jugadores.add(j4);
     
          
        try {
            ObjectOutputStream save = new ObjectOutputStream(new FileOutputStream("Players.txt"));
            for(Jugador p: jugadores){
                save.writeObject(p);
            }
        } catch (IOException ex) {
            Logger.getLogger(Hearthstone.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    /*
    Carta c1= new Carta("Comandante de la ciudadela",false,2,"neutral","Constante","CantHabilidad",2,3,0,"/img_cards/cartasNeutralesOval/AT_080.png","/img_cards/cartasNeutralesG/AT_080.png","/img_cards/cartasNeutrales/AT_080.png");
    Carta c2= new Carta("Saboteador",false,3,"neutral","Gritobatalla","CostoEnemyHab",4,3,0,"/img_cards/cartasNeutralesOval/AT_086.png","/img_cards/cartasNeutralesG/AT_086.png","/img_cards/cartasNeutrales/AT_086.png");
    Carta c3= new Carta("Jinete argenta",false,3,"neutral","Constante","Carga",2,1,0,"/img_cards/cartasNeutralesOval/AT_087.png","/img_cards/cartasNeutralesG/AT_087.png","/img_cards/cartasNeutrales/AT_087.png");
    Carta c4= new Carta("Foribundo Helado",false,3,"neutral","Vacio","Vacio",5,2,0,"/img_cards/cartasNeutralesOval/AT_092.png","/img_cards/cartasNeutralesG/AT_092.png","/img_cards/cartasNeutrales/AT_092.png");
    Carta c5= new Carta("Snobold Gelido",false,4,"neutral","Constante","Dañohechizo",2,6,1,"/img_cards/cartasNeutralesOval/AT_093.png","/img_cards/cartasNeutralesG/AT_093.png","/img_cards/cartasNeutrales/AT_093.png");
    Carta c6= new Carta("Malabarista de llamas",false,2,"neutral","Gritobatalla","DañoRandom",2,3,1,"/img_cards/cartasNeutralesOval/AT_094.png","/img_cards/cartasNeutralesG/AT_094.png","/img_cards/cartasNeutrales/AT_094.png");
    Carta c7= new Carta("Luchador de la fosa",false,5,"neutral","Vacio","Vacio",5,6,0,"/img_cards/cartasNeutralesOval/AT_101.png","/img_cards/cartasNeutralesG/AT_101.png","/img_cards/cartasNeutrales/AT_101.png");
    Carta c8= new Carta("Jormungar Capturado",false,7,"neutral","Vacio","Vacio",5,9,0,"/img_cards/cartasNeutralesOval/AT_102.png","/img_cards/cartasNeutralesG/AT_102.png","/img_cards/cartasNeutrales/AT_102.png");
    Carta c9= new Carta("Entrenador de Esgrima",false,3,"neutral","Gritobatalla","ReduccionCostoHab",2,2,2,"/img_cards/cartasNeutralesOval/AT_115.png","/img_cards/cartasNeutralesG/AT_115.png","/img_cards/cartasNeutrales/AT_115.png");
    Carta c10= new Carta("Igualdad",true,2,"paladin","Cambio","Cambiovid",0,1,1,"/img_cards/cartasPaladinOval/EX1_619.png","/img_cards/cartasPaladinG/EX1_619.png","/img_cards/cartasPaladin/EX1_619.png");
    Carta c11= new Carta("Lacayo de villadorada",false,1,"neutral","Constante","Provocar",1,2,0,"/img_cards/cartasNeutralesOval/CS1_042.png","/img_cards/cartasNeutralesG/CS1_042.png","/img_cards/cartasNeutrales/CS1_042.png");
    Carta c12= new Carta("Trepador del pantano",false,5,"neutral","Constante","Provocar",3,6,0,"/img_cards/cartasNeutralesOval/CS1_069.png","/img_cards/cartasNeutralesG/CS1_069.png","/img_cards/cartasNeutrales/CS1_069.png");
    Carta c72= new Carta("Sello de campeones",true,3,"paladin","Aumento","Dañodiv",0,1,3,"/img_cards/cartasPaladinOval/AT_074.png","/img_cards/cartasPaladinG/AT_074.png","/img_cards/cartasPaladin/AT_074.png");
    Carta c73= new Carta("Instructor de cablleros de guerra",false,3,"paladin","Constante","Aumentodaño",2,4,1,"/img_cards/cartasPaladinOval/AT_075.png","/img_cards/cartasPaladinG/AT_075.png","/img_cards/cartasPaladin/AT_075.png");
    Carta c74= new Carta("Entrar en el coliseo",true,6,"paladin","Destruir","Destruirdev",0,1,0,"/img_cards/cartasPaladinOval/AT_078.png","/img_cards/cartasPaladinG/AT_078.png","/img_cards/cartasPaladin/AT_078.png");
    Carta c75= new Carta("Eadrick el puro",false,7,"paladin","Gritobatalla","Cambdaño",3,7,1,"/img_cards/cartasPaladinOval/AT_081.png","/img_cards/cartasPaladinG/AT_081.png","/img_cards/cartasPaladin/AT_081.png");
    Carta c76= new Carta("Vigilia solemne",true,5,"paladin","Tomarcarta","Tomarcartreducido",0,1,0,"/img_cards/cartasPaladinOval/BRM_001.png","/img_cards/cartasPaladinG/BRM_001.png","/img_cards/cartasPaladin/BRM_001.png");
    Carta c77= new Carta("Consorte Dragon",false,5,"paladin","Gritobatalla","reducircost",5,5,2,"/img_cards/cartasPaladinOval/BRM_018.png","/img_cards/cartasPaladinG/BRM_018.png","/img_cards/cartasPaladin/BRM_018.png");
    Carta c78= new Carta("Bendicion de Poderio",true,1,"paladin","CambE","Cambda",0,1,3,"/img_cards/cartasPaladinOval/CS2_087.png","/img_cards/cartasPaladinG/CS2_087.png","/img_cards/cartasPaladin/CS2_087.png");
    Carta c79= new Carta("Guardian de reyes",false,7,"paladin","Gritobatalla","Curarh",5,6,6,"/img_cards/cartasPaladinOval/CS2_088.png","/img_cards/cartasPaladinG/CS2_088.png","/img_cards/cartasPaladin/CS2_088.png");
    Carta c80= new Carta("Luz sagrada",true,2,"paladin","Curar","CurarT",0,1,6,"/img_cards/cartasPaladinOval/CS2_089.png","/img_cards/cartasPaladinG/CS2_089.png","/img_cards/cartasPaladin/CS2_089.png");
    Carta c81= new Carta("Bendicion de reyes",true,4,"paladin","CambE","Cambdavi",0,1,4,"/img_cards/cartasPaladinOval/CS2_092.png","/img_cards/cartasPaladinG/CS2_092.png","/img_cards/cartasPaladin/CS2_092.png");
    Carta c82= new Carta("Consagracion",true,4,"paladin","Daño","Dañoa",0,1,2,"/img_cards/cartasPaladinOval/CS2_093.png","/img_cards/cartasPaladinG/CS2_093.png","/img_cards/cartasPaladin/CS2_093.png");
    Carta c83= new Carta("Imposición de manos",true,8,"paladin","CurarT","Curatomacart",0,1,8,"/img_cards/cartasPaladinOval/EX1_354.png","/img_cards/cartasPaladinG/EX1_354.png","/img_cards/cartasPaladin/EX1_354.png");
    Carta c84= new Carta("Campeon bendito",true,5,"paladin","Aumento","Dupdaño",0,1,0,"/img_cards/cartasPaladinOval/EX1_355.png","/img_cards/cartasPaladinG/EX1_355.png","/img_cards/cartasPaladin/EX1_355.png");
    Carta c85= new Carta("Humildad",true,1,"paladin","Reducir","Reduceda",0,1,1,"/img_cards/cartasPaladinOval/EX1_360.png","/img_cards/cartasPaladinG/EX1_360.png","/img_cards/cartasPaladin/EX1_360.png");
    Carta c86= new Carta("Protector Argenta",false,2,"paladin","Gritobatalla","Escudodivino",2,2,0,"/img_cards/cartasPaladinOval/EX1_362.png","/img_cards/cartasPaladinG/EX1_362.png","/img_cards/cartasPaladin/EX1_362.png");
    Carta c87= new Carta("Mano de proteccion",true,1,"paladin","Aumento","Escudodivino",0,1,0,"/img_cards/cartasPaladinOval/EX1_371.png","/img_cards/cartasPaladinG/EX1_371.png","/img_cards/cartasPaladin/EX1_371.png");
    Carta c88= new Carta("Pacificador Aldor",false,3,"paladin","Reducir","Reduceda",3,3,1,"/img_cards/cartasPaladinOval/EX1_382.png","/img_cards/cartasPaladinG/EX1_382.png","/img_cards/cartasPaladin/EX1_382.png");
    Carta c89= new Carta("Colera vengativa",true,6,"paladin","Daño","Dañorand",0,1,8,"/img_cards/cartasPaladinOval/EX1_384.png","/img_cards/cartasPaladinG/EX1_384.png","/img_cards/cartasPaladin/EX1_384.png");
    Carta c90= new Carta("Igualdad",true,2,"paladin","Cambio","Cambiovid",0,1,1,"/img_cards/cartasPaladinOval/EX1_619.png","/img_cards/cartasPaladinG/EX1_619.png","/img_cards/cartasPaladin/EX1_619.png");
     
     ArrayList<Carta> cards = new ArrayList<>();
     cards.add(c1);
     cards.add(c2);
     cards.add(c3);
     cards.add(c4);
     cards.add(c5);
     cards.add(c6);
     cards.add(c7);
     cards.add(c8);
     cards.add(c9);
     cards.add(c10);
     cards.add(c11);
     cards.add(c12);
     cards.add(c72);
     cards.add(c73);
     cards.add(c74);
     cards.add(c75);
     cards.add(c76);
     cards.add(c77);
     cards.add(c78);
     cards.add(c79);
     cards.add(c80);
     cards.add(c81);
     cards.add(c82);
     cards.add(c83);
     cards.add(c84);
     cards.add(c85);
     cards.add(c86);
     cards.add(c87);
     cards.add(c88);
     cards.add(c89);
     cards.add(c90);
     
  
          
        try {
            ObjectOutputStream save = new ObjectOutputStream(new FileOutputStream("BasicPaladin.txt"));
            for(Carta c: cards){
                save.writeObject(c);
            }
        } catch (IOException ex) {
            Logger.getLogger(Hearthstone.class.getName()).log(Level.SEVERE, null, ex);
        }
           
      */  
      /*  ArrayList<Carta> cd = new ArrayList<Carta>();
        cd = Admin.consultCartas("BasicPaladin");
        for(Carta c: cd){
            System.out.println(c.getNombre());
        }*/
        
    /*    
     Carta c12 = new Carta("Houndmaster","Paladin");
     Carta c13 = new Carta("Timber Wolf","Paladin");
     Carta c14 = new Carta("Brave Archer","Paladin");
     Carta c15 = new Carta("Carrion Grub","Paladin");
     Carta c16 = new Carta("Desert Camel","Paladin");
     Carta c17 = new Carta("Fiery Bat","Paladin");
     Carta c18 = new Carta("King's Elekk","Paladin");
     Carta c19 = new Carta("Scavenging Hyena","Paladin");
     Carta c20 = new Carta("Starving Buzzard","Paladin");
     Carta c21 = new Carta("Tundra Rhino","Paladin");
     Carta c22 = new Carta("Princess Huhuran","Paladin");
    
     ArrayList<Carta> cards2 = new ArrayList<>();
     cards2.add(c12);
     cards2.add(c13);
     cards2.add(c14);
     cards2.add(c15);
     cards2.add(c16);
     cards2.add(c17);
     cards2.add(c18);
     cards2.add(c19);
     cards2.add(c20);
     cards2.add(c21);
     cards2.add(c22);
     
     try {
            ObjectOutputStream save = new ObjectOutputStream(new FileOutputStream("Test_Deck2.txt"));
            for(Carta c: cards2){
                save.writeObject(c);
            }
        } catch (IOException ex) {
            Logger.getLogger(Hearthstone.class.getName()).log(Level.SEVERE, null, ex);
        }
     */
        
    }
           

}
