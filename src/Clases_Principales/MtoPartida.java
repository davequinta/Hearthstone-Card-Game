/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_Principales;


import frames.FrmVictory;
import java.util.ArrayList;
import javax.swing.JLabel;

/**
 *
 * @author DOSLAP
 */
public class MtoPartida {
    Jugador j;
    Jugador jd;
    int mana=0;
    int manatotal=mana;
    

    public MtoPartida(Jugador j1, Jugador j2) {
        this.j = j1;
        this.jd = j2;
        this.mana=0;
        this.manatotal=mana;
    }
    
    public int getMana() {
        return mana;
    }

    public int getManatotal() {
        return manatotal;
    }
    
    public void setManatotal(int manatotal) {
        this.manatotal = manatotal;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }
    
    public Jugador getJ() {
        return j;
    }

    public void setJ(Jugador j) {
        this.j = j;
    }
        Carta c = new Carta("", false, 0, "", "", "", 0, 0, 0, "0", "0", "0");
        public void pAtacar(int p1, int p2, ArrayList<Carta>   act, ArrayList<Carta> pas, JLabel l, JLabel l2, ArrayList<Boolean> seat){
        int vidap, vidaa;
         
        if(pas!=null){
            vidap = pas.get(p2).getVida()-act.get(p1).getDanio();
            vidaa = act.get(p1).getVida()-pas.get(p2).getDanio();
            System.out.println(act.get(p1));
            if(vidap <=0){
               pas.set(p2,c);
                System.out.println("Muerto");
                seat.set(p2, false);
                if(vidaa <=0){
                   act.set(p1,c);
                   System.out.println("LOL");
                   seat.set(p1, false);
               }
            }
            else if(vidaa <=0){
                   act.set(p1,c);
                   seat.set(p1, false);
                   System.out.println("LOL2");
               }
            pas.get(p2).setVida(vidap);
            act.get(p1).setVida(vidaa);
            l2.setText(Integer.toString(pas.get(p2).getVida()));
            l.setText(Integer.toString(act.get(p1).getVida()));
            System.out.println("Lo hice");
        }
    }
        
        public void atacarHeroe(int p1, ArrayList<Carta>   act, JLabel l, Jugador j, Jugador j2){
            int vida;
            vida = j.getHero().getVida()-act.get(p1).getDanio();
            if(vida<= 0){
                FrmVictory v = new FrmVictory(j2);
                v.setVisible(true);
            }
            j.getHero().setVida(vida);
            l.repaint();
            l.setText(Integer.toString(vida));
        }
        public void atacarHunter(Jugador h, JLabel vidl){
            int vida=0;
            vida= h.getHero().getVida()-2;
            if(vida <=0){
                System.out.println("Muerto");
                 h.getHero().setVida(vida);
                 vidl.setText(Integer.toString(vida));
            }
            else{
                h.getHero().setVida(vida);
                vidl.setText(Integer.toString(vida));
            }
        
        }
        
        /*
            
Cambiovid
Destruirdev
Tomarcartreducido
Cambda

Cambdavi

Aumentar
Tomarcarta
cambE

ApuntarT
ApuntarE
Cambio
Invocar

Destruirdev

Reducea
CambioT
        */
        public void hechizo(Carta c, int p1, ArrayList<Carta> car, JLabel l, ArrayList<Boolean> seat){
            if(c.getTipoEfecto().equals("Curar")|| c.getTipoEfecto().equals("CurarT")){
                int vida=car.get(p1).getVida();
                vida+=c.getVaccion();
                car.get(p1).setVida(vida);
                l.repaint();
                l.setText(Integer.toString(vida));
            }
            else if(c.getTipoEfecto().equals("Daño")|| c.getTipoEfecto().equals("DañoT") || c.getTipoEfecto().equals("Dañoa") || c.getTipoEfecto().equals("Dañodiv")){
                int vida=car.get(p1).getVida();
                vida-=c.getVaccion();
                if(vida <=0){
                    car.set(p1,c);
                System.out.println("Muerto");
                seat.set(p1, false);
                }
                car.get(p1).setVida(vida);
                l.repaint();
                l.setText(Integer.toString(vida));
            }
        }
        
        
    
    
}
