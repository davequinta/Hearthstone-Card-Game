/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_Principales;

import hearthstone.Hearthstone;
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

/**
 *
 * @author David
 */
public class Admin {
    public static boolean verifyUser(String name, String pass){
        ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
        Jugador j = null;
        
         try {
          
           ObjectInputStream reader= new ObjectInputStream(new FileInputStream("Players.txt"));
            while(true){
                   j = (Jugador) reader.readObject();
                   if((j.getNombreUsuario().equals(name))&&(j.getContrasena().equals(pass))){
                       return true;
                   }
            
            }
            
        }catch (EOFException ex) {
          //End of File
        } catch (FileNotFoundException ex) {
            System.out.println("Error: " +ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error: " +ex.getMessage());
        } catch (ClassNotFoundException ex) {
           System.out.println("Error: " +ex.getMessage());
        }
        
        return false;
    }
    
    public static ArrayList<Carta> consultCartas(String name){
        ArrayList<Carta> deck = new ArrayList<Carta>();
         try {
          
           ObjectInputStream reader= new ObjectInputStream(new FileInputStream(name+".txt"));
            while(true){
                  Carta e = (Carta) reader.readObject();
                  deck.add(e);
            
            }
            
        }catch (EOFException ex) {
          //End of File
        } catch (FileNotFoundException ex) {
            System.out.println("Error: " +ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error: " +ex.getMessage());
        } catch (ClassNotFoundException ex) {
           System.out.println("Error: " +ex.getMessage());
        }
    
        return deck;
       
    }
    public static ArrayList<Jugador> consultUser(){
        
        ArrayList<Jugador> players = new ArrayList<>();
         try {
          
           ObjectInputStream reader= new ObjectInputStream(new FileInputStream("Players.txt"));
            while(true){
                  Jugador e = (Jugador) reader.readObject();
                  players.add(e);
            
            }
            
        }catch (EOFException ex) {
          //End of File
        } catch (FileNotFoundException ex) {
            System.out.println("Error: " +ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error: " +ex.getMessage());
        } catch (ClassNotFoundException ex) {
           System.out.println("Error: " +ex.getMessage());
        }
    
        return players;
    }
    public static boolean verifyNewUser(String name){
       ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores = Admin.consultUser();
        
        for(Jugador e: jugadores){
            if(e.getNombreUsuario().toLowerCase().equals(name.toLowerCase())){
                return false;
            }
        }
        return true;
    }
    public static void createUser(String name, String pass){
        Jugador j = new Jugador(name,pass);
        ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
        jugadores = Admin.consultUser();
        jugadores.add(j);
        
          
        try {
            ObjectOutputStream save = new ObjectOutputStream(new FileOutputStream("Players.txt"));
            for(Jugador p: jugadores){
                save.writeObject(p);
            }
        } catch (IOException ex) {
            System.out.println("Error: "+ ex.getMessage());
        }
        
        
    
    }
    
    
    
}
