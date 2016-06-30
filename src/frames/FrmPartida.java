/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import Clases_Principales.*;
import hearthstone.FrmDibujo;
import java.awt.Panel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author David
 */
public class FrmPartida extends javax.swing.JFrame {
    
    MtoPartida m=null;
    Jugador j;
    Jugador jd;
    boolean turnoj1;
    int l1, l2;

    public boolean isTurnoj1() {
        return turnoj1;
    }

    public void setTurnoj1(boolean turnoj1) {
        this.turnoj1 = turnoj1;
    }
    //ArrayList<String> posCampo= new ArrayList<String>();
    ArrayList<Carta> manod = new ArrayList<Carta>();
    ArrayList<Carta> mano = new ArrayList<Carta>();
    ArrayList<Carta> campo = new ArrayList<Carta>();
    ArrayList<Carta> campod = new ArrayList<Carta>();
    JPanel general;
    ArrayList<Boolean> seats = new ArrayList<Boolean>();
    ArrayList<Boolean> atacar = new ArrayList<Boolean>();
    Boolean heropow=false;
    int largo = 0;
    int valCar = 12;
    JLabel lact, lvid;
    int p1, p2;
    Carta c= new Carta("Protector Argenta",false,2,"paladin","Gritobatalla","Escudodivino",2,2,0,"/img_cards/cartasPaladinOval/EX1_362.png","/img_cards/cartasPaladinG/EX1_362.png","/img_cards/cartasPaladin/EX1_362.png");
    public ArrayList<Boolean> getAtacar() {
        return atacar;
    }

    public void setAtacar(ArrayList<Boolean> atacar) {
        this.atacar = atacar;
    }

    public int getL1() {
        return l1;
    }

    public void setL1(int l1) {
        this.l1 = l1;
    }

    public int getL2() {
        return l2;
    }

    public void setL2(int l2) {
        this.l2 = l2;
    }
    
    public ArrayList<Carta> getCampod() {
        return campod;
    }

    public void setCampod(ArrayList<Carta> campod) {
        this.campod = campod;
    }
    
    public JLabel getLact() {
        return lact;
    }

    public void setLact(JLabel lact) {
        this.lact = lact;
    }

    public JLabel getLvid() {
        return lvid;
    }

    public void setLvid(JLabel lvid) {
        this.lvid = lvid;
    }

    public int getP1() {
        return p1;
    }

    public void setP1(int p1) {
        this.p1 = p1;
    }

    public int getP2() {
        return p2;
    }

    public void setP2(int p2) {
        this.p2 = p2;
    }
    
    public Jugador getJd() {
        return jd;
    }

    public void setJd(Jugador jd) {
        this.jd = jd;
    }

    public ArrayList<Carta> getManod() {
        return manod;
    }

    public void setManod(ArrayList<Carta> manod) {
        this.manod = manod;
    }
    
    public Boolean getHeropow() {
        return heropow;
    }

    public void setHeropow(Boolean heropow) {
        this.heropow = heropow;
    }

    public ArrayList<Boolean> getSeats() {
        return seats;
    }

    public void setSeats(ArrayList<Boolean> seats) {
        this.seats = seats;
    }
     

    public JPanel getGeneral() {
        return general;
    }

    public void setGeneral(JPanel general) {
        this.general = general;
    }
    
    public int getValCar() {
        return valCar;
    }

    public void setValCar(int valCar) {
        this.valCar = valCar;
    }

    public ArrayList<Carta> getCampo() {
        return campo;
    }

    public void setCampo(ArrayList<Carta> campo) {
        this.campo = campo;
    }

    public FrmPartida() {
        initComponents();
    }

    public int getLargo() {
        return largo;
    }

    public void setLargo(int largo) {
        this.largo = largo;
    }

   

    public FrmPartida(Jugador j, ArrayList<Carta> mano,Jugador jd, ArrayList<Carta> manod, MtoPartida m) {
        this.m = m;
        this.j = j;
        this.mano = mano;
        this.jd = jd;
        this.manod= manod;
        initComponents();
        setTurnoj1(true);
        for(int i=0;i<18;i++ ){
        seats.add(new Boolean(false));
        atacar.add(new Boolean(false));
        }
        for(int h=0;h<9;h++){
         Carta c = new Carta("", false, 0, "", "", "", 0, 0, 0, "0", "vacio", "0");
         campo.add(c);
        }
        for(int k=0;k<18;k++){
         Carta c = new Carta("", false, 0, "", "", "", 0, 0, 0, "0", "vacio", "0");
         campod.add(c);
        }
        FrmDibujo fondo = new FrmDibujo("/img/fondiu.png", 1376, 768);
        pnlFondo.add(fondo);
        pnlFondo.repaint();
        lblvidh1.setText(String.valueOf(j.getHero().getVida()));
        lblvidh2.setText(String.valueOf(jd.getHero().getVida()));
        lblnick.setText(j.getNombreUsuario());
        nick2.setText(jd.getNombreUsuario()); 
        flph1.flipAnimate();
        confirmarHero();
        zoomMano(0, pnl1);
        
    }
    
    public void confirmarHero(){
        if(j.getHero().getNombre_hero().equals("Uther")){
            
            paintPaladin(1);
            
            if(jd.getHero().getNombre_hero().equals("Uther")){
                paintPaladin(2);
                iniciarTurnod(jd,manod);
                iniciarTurno(j,mano);
            }
            else{
                paintHunter(2);
                iniciarTurnod(jd,manod);
                iniciarTurno(j,mano);
            }
        }
        else{
             paintHunter(1);
             
             if(jd.getHero().getNombre_hero().equals("Uther")){
                paintPaladin(2);
                iniciarTurnod(jd,manod);
                iniciarTurno(j,mano);
            }
            else{
                paintHunter(2);
                iniciarTurnod(jd,manod);
                iniciarTurno(j,mano);
            }
        }
    }
    
    private void paintPaladin(int a){
    
    if(a==1){
        this.pnlheroe1.removeAll();
        FrmDibujo hero = new FrmDibujo("/img/paladinmini.gif", 125, 143);
        this.pnlheroe1.add(hero);
        this.pnlheroe1.repaint();
        //this.pnlheropow.removeAll();
        //FrmDibujo pow = new FrmDibujo("/img/palpower.png", 102, 102);
        //this.pnlheropow.add(pow);
        //this.pnlheropow.repaint();
          flph1.setName2("/img/palpower.png");
          flph1.repaint();
    }
    else{
        this.pnlheroe2.removeAll();
        FrmDibujo hero = new FrmDibujo("/img/paladinmini.gif", 125, 143);
        this.pnlheroe2.add(hero);
        this.pnlheroe2.repaint();
        //this.pnlheropow2.removeAll();
        //FrmDibujo pow = new FrmDibujo("/img/palpower.png", 102, 102);
        //this.pnlheropow2.add(pow);
        //this.pnlheropow2.repaint();
        flph2.setName2("/img/palpower.png");
          flph2.repaint();
    }
        
    }
private void paintHunter(int a){
    if(a==1){
        this.pnlheroe1.removeAll();
        FrmDibujo hero = new FrmDibujo("/img/huntermini.gif", 125, 143);
        this.pnlheroe1.add(hero);
        this.pnlheroe1.repaint();
       // this.pnlheropow.removeAll();
        //FrmDibujo pow = new FrmDibujo("/img/huntpower.png", 102, 102);
       // this.pnlheropow.add(pow);
        //this.pnlheropow.repaint();
        flph1.setName2("/img/huntpower.png");
          flph1.repaint();
    }
    else{
        this.pnlheroe2.removeAll();
        FrmDibujo hero = new FrmDibujo("/img/huntermini.gif", 125, 143);
        this.pnlheroe2.add(hero);
        this.pnlheroe2.repaint();
        //this.pnlheropow2.removeAll();
        //FrmDibujo pow = new FrmDibujo("/img/huntpower.png", 102, 102);
        //this.pnlheropow2.add(pow);
        //this.pnlheropow2.repaint();
        flph2.setName2("/img/huntpower.png");
          flph2.repaint();
    }

    }
    public void zoomMano(int n, JPanel p){
         if (n < getLargo()){
               
                if(isTurnoj1()==true){
                pnlZoom.removeAll();
                pnlZoom.repaint();
                FrmDibujo heropow = new FrmDibujo(mano.get(n).getRuta_Grande(), 250, 340);
                pnlZoom.add(heropow);
                }
                else if(isTurnoj1() == false){
                    pnlZoom.removeAll();
                    pnlZoom.repaint();
                    FrmDibujo heropowe = new FrmDibujo(manod.get(n).getRuta_Grande(), 250, 340);
                    pnlZoom.add(heropowe);
                }           
         }
    }
    
    public void zoomCampo(int n, int seat ,JPanel p){
        System.out.println("Pos: "+n );
        //System.out.println("panel: "+p);
         if (n < 18 && seats.get(seat)==true){
                pnlZoom.removeAll();
                pnlZoom.repaint();
                FrmDibujo heropowa = new FrmDibujo(campod.get(n).getRuta_Grande(), 250, 340);
                pnlZoom.add(heropowa);
         }
    }
    
    public void zoomCampod(int n, int seat ,JPanel p){
        //System.out.println("panel: "+p);
         if (n < 18 && seats.get(seat)==true){
                pnlZoom.removeAll();
                pnlZoom.repaint();
                //System.out.println(campo.get(n).getNombre()+" "+seats.get(seat));
                FrmDibujo heropow = new FrmDibujo(campo.get(n).getRuta_Grande(), 250, 340);
                pnlZoom.add(heropow);
         }
    }
    
    public void atacarTurno(int n){
        for (int i = n; i <(n+7); i++){
            if(seats.get(i)==true){
                atacar.set(i, true);
            }
        }
        
    }
    
    public void limpiarZoom(){
            pnlZoom.removeAll();
            pnlZoom.repaint();
    }
    public int cartaRandom(int c){
        Random  rnd = new Random();
        return (int) (rnd.nextDouble() * c + 0);
    }
    
    public Carta getCarta(Jugador j){
        if(j.getHero().getDeck().size()-1 >=0){
        int rc= cartaRandom(j.getHero().getDeck().size()-1);
        Carta cartaMano =j.getHero().getDeck().get(rc);

        j.getHero().getDeck().remove(rc);

        lbldeckcant.setText(String.valueOf(j.getHero().getDeck().size()) );
        return  cartaMano;
        }
        else{
            return null;
        }
    }
    
     String img = "/img/cardback.png";
    public void iniciarTurno(Jugador j, ArrayList<Carta> mano){
        setHeropow(false);
        if(getLargo()<=10){
        mano.add(getCarta(j));
        }
        else{
            Carta c = getCarta(j);
            System.out.println(c.getNombre());
            c=null;
            System.out.println("IZI PIZI");
            
        }
        System.out.println(isTurnoj1());
        setLargo(this.mano.size());
        setL2(this.mano.size());
        if (m.getManatotal()<10){
        m.setManatotal(m.getManatotal()+1);    
        m.setMana(m.getManatotal());
        }
        m.setMana(m.getManatotal());
        lblman1.setText(String.valueOf(m.getMana()));
        lblman2.setText(String.valueOf(m.getManatotal()));
        
        
        //System.out.println(j.getHero().getDeck().get(0));
        atacarTurno(0);//Esto
        ponerCartasManod(img);
        ponerCartasMano();
    }
    
    public void ponerCartasManod(String img) {
        System.out.println("Sirvo");
         Limpmano2();
         for (int i = 0; i < getL1(); i++) {

            FrmDibujo fondo = new FrmDibujo(img, 90, 129);
            //FrmDibujo fondo2 = new FrmDibujo(manod.get(i).getRuta_Grande(), 250, 340);
            if (i == 0) {
                pnlUno.add(fondo);
                pnlUno.repaint();
              //  pnlhuehue.add(fondo2);
               // pnlhuehue.repaint();

            } else if (i == 1) {
                pnlDos.add(fondo);
                pnlDos.repaint();

            } else if (i == 2) {
                pnlTres.add(fondo);
                pnlTres.repaint();

            } else if (i == 3) {
                pnlCuatro.add(fondo);
                pnlCuatro.repaint();

            } else if (i == 4) {
                pnlCinco.add(fondo);
                pnlCinco.repaint();

            } else if (i == 5) {
                pnlSeis.add(fondo);
                pnlSeis.repaint();

            } else if (i == 6) {
                pnlSiete.add(fondo);
                pnlSiete.repaint();

            } else if (i == 7) {
                pnlOcho.add(fondo);
                pnlOcho.repaint();

            } else if (i == 8) {
                pnlNueve.add(fondo);
                pnlNueve.repaint();

            } else if (i == 9) {
                pnlDiez.add(fondo);
                pnlDiez.repaint();

            }
        }
    }
    
    public void ponerCartasMano(String img) {
        System.out.println("Sirvo");
         Limpmano();
         for (int i = 0; i < getL2(); i++) {

            FrmDibujo fondo = new FrmDibujo(img, 90, 129);
            //FrmDibujo fondo2 = new FrmDibujo(manod.get(i).getRuta_Grande(), 250, 340);
            if (i == 0) {
                pnl1.add(fondo);
                pnl1.repaint();
              //  pnlhuehue.add(fondo2);
               // pnlhuehue.repaint();

            } else if (i == 1) {
                pnl2.add(fondo);
                pnl2.repaint();

            } else if (i == 2) {
                pnl3.add(fondo);
                pnl3.repaint();

            } else if (i == 3) {
                pnl4.add(fondo);
                pnl4.repaint();

            } else if (i == 4) {
                pnl5.add(fondo);
                pnl5.repaint();

            } else if (i == 5) {
                pnl6.add(fondo);
                pnl6.repaint();

            } else if (i == 6) {
                pnl7.add(fondo);
                pnl7.repaint();

            } else if (i == 7) {
                pnl8.add(fondo);
                pnl8.repaint();

            } else if (i == 8) {
                pnl9.add(fondo);
                pnl9.repaint();

            } else if (i == 9) {
                pnl10.add(fondo);
                pnl10.repaint();

            }
        }
    }
    
    public void Limpmano(){
            pnl1.removeAll();
            pnl1.repaint();
            pnl2.removeAll();
            pnl2.repaint();
            pnl3.removeAll();
            pnl3.repaint();
            pnl4.removeAll();
            pnl4.repaint();
            pnl5.removeAll();
            pnl5.repaint();
            pnl6.removeAll();
            pnl6.repaint();
            pnl7.removeAll();
            pnl7.repaint();
            pnl8.removeAll();
            pnl8.repaint();
            pnl9.removeAll();
            pnl9.repaint();
            pnl10.removeAll();
            pnl10.repaint();
    }
    public void Limpmano2(){
        pnlUno.removeAll();
            pnlUno.repaint();
            pnlDos.removeAll();
            pnlDos.repaint();
            pnlTres.removeAll();
            pnlTres.repaint();
            pnlCuatro.removeAll();
            pnlCuatro.repaint();
            pnlCinco.removeAll();
            pnlCinco.repaint();
            pnlSeis.removeAll();
            pnlSeis.repaint();
            pnlSiete.removeAll();
            pnlSiete.repaint();
            pnlOcho.removeAll();
            pnlOcho.repaint();
            pnlNueve.removeAll();
            pnlNueve.repaint();
            pnlDiez.removeAll();
            pnlDiez.repaint();
    }
    public void ponerCartasMano() {
        Limpmano();
        for (int i = 0; i < getLargo(); i++) {
            FrmDibujo fondo = new FrmDibujo(mano.get(i).getRuta_Mano(), 90, 129);
            if (i == 0) {
                pnl1.add(fondo);
                pnl1.repaint();

            } else if (i == 1) {
                pnl2.add(fondo);
                pnl2.repaint();

            } else if (i == 2) {

                pnl3.add(fondo);
                pnl3.repaint();

            } else if (i == 3) {
                
                pnl4.add(fondo);
                pnl4.repaint();

            } else if (i == 4) {
                
                pnl5.add(fondo);
                pnl5.repaint();

            } else if (i == 5) {
               
                pnl6.add(fondo);
                pnl6.repaint();

            } else if (i == 6) {
                
                pnl7.add(fondo);
                pnl7.repaint();

            } else if (i == 7) {
               
                pnl8.add(fondo);
                pnl8.repaint();

            } else if (i == 8) {

                pnl9.add(fondo);
                pnl9.repaint();

            } else if (i == 9) {
                pnl10.add(fondo);
                pnl10.repaint();

            }
        }
    }

     public Carta getCartad(Jugador jd){
        if(jd.getHero().getDeck().size()-1 >=0){
        int rc= cartaRandom(jd.getHero().getDeck().size()-1);
        Carta cartaManod =jd.getHero().getDeck().get(rc);

        jd.getHero().getDeck().remove(rc);

        lbldeckcantd.setText(String.valueOf(jd.getHero().getDeck().size()) );
        return  cartaManod;
        }
        return null;
    }
    public void iniciarTurnod(Jugador jd, ArrayList<Carta> manod){
        setHeropow(false);
        if(getLargo() <= 10){
            try{
            manod.add(getCartad(jd));
            }
            catch(NullPointerException ex){
               int vidah= jd.getHero().getVida()-1;
               jd.getHero().setVida(vidah);
            }
        }
        else{
            System.out.println("Izi Pizi");
        }
        setLargo(this.manod.size());
        setL1(this.manod.size());
        m.setMana(m.getManatotal());
        man1lbl.setText(String.valueOf(m.getMana()));
        man2lbl.setText(String.valueOf(m.getManatotal()));
        //lblvidh.setText(String.valueOf(jd.getHero().getVida()));
        //System.out.println(j.getHero().getDeck().get(0));
        ponerCartasManod();
        atacarTurno(7);
        ponerCartasMano(img);
    }
    
    public void ponerCartasManod() {
        Limpmano2();
        for (int i = 0; i < getLargo(); i++) {

            FrmDibujo fondo = new FrmDibujo(manod.get(i).getRuta_Mano(), 90, 129);
            //FrmDibujo fondo2 = new FrmDibujo(manod.get(i).getRuta_Grande(), 250, 340);
            if (i == 0) {
                pnlUno.add(fondo);
                pnlUno.repaint();
              //  pnlhuehue.add(fondo2);
               // pnlhuehue.repaint();

            } else if (i == 1) {
                pnlDos.add(fondo);
                pnlDos.repaint();

            } else if (i == 2) {
                pnlTres.add(fondo);
                pnlTres.repaint();

            } else if (i == 3) {
                pnlCuatro.add(fondo);
                pnlCuatro.repaint();

            } else if (i == 4) {
                pnlCinco.add(fondo);
                pnlCinco.repaint();

            } else if (i == 5) {
                pnlSeis.add(fondo);
                pnlSeis.repaint();

            } else if (i == 6) {
                pnlSiete.add(fondo);
                pnlSiete.repaint();

            } else if (i == 7) {
                pnlOcho.add(fondo);
                pnlOcho.repaint();

            } else if (i == 8) {
                pnlNueve.add(fondo);
                pnlNueve.repaint();

            } else if (i == 9) {
                pnlDiez.add(fondo);
                pnlDiez.repaint();

            }
        }
    }

    
    
    public ArrayList<Carta> getMano() {
        return mano;
    }

    public void setMano(ArrayList<Carta> mano) {
        this.mano = mano;
    }

 public void cambTurno(){
    if(isTurnoj1()==true){
        setTurnoj1(false);
        iniciarTurnod(jd, manod);
        JOptionPane.showMessageDialog(null,"Turno de: "+jd.getNombreUsuario(),"Cambio de Turno",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("src/img/confirm.png"));
        
    
    }
    else{
        setTurnoj1(true);
        iniciarTurno(j, mano);
       JOptionPane.showMessageDialog(null,"Turno de: "+j.getNombreUsuario(),"Cambio de Turno",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("src/img/confirm.png"));
    }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlFondo = new javax.swing.JPanel();
        lblmanc = new javax.swing.JLabel();
        lblman2 = new javax.swing.JLabel();
        lblman1 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        pnlc1 = new javax.swing.JPanel();
        lblda1 = new javax.swing.JLabel();
        lblvid1 = new javax.swing.JLabel();
        pnlc2 = new javax.swing.JPanel();
        lblda2 = new javax.swing.JLabel();
        lblvid2 = new javax.swing.JLabel();
        pnlc3 = new javax.swing.JPanel();
        lblda3 = new javax.swing.JLabel();
        lblvid3 = new javax.swing.JLabel();
        pnlc4 = new javax.swing.JPanel();
        lblda4 = new javax.swing.JLabel();
        lblvid4 = new javax.swing.JLabel();
        pnlc5 = new javax.swing.JPanel();
        lblda5 = new javax.swing.JLabel();
        lblvid5 = new javax.swing.JLabel();
        pnlc6 = new javax.swing.JPanel();
        lblvid6 = new javax.swing.JLabel();
        lblda6 = new javax.swing.JLabel();
        pnlc7 = new javax.swing.JPanel();
        lblvid7 = new javax.swing.JLabel();
        lblda7 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        pnl2 = new javax.swing.JPanel();
        pnl3 = new javax.swing.JPanel();
        pnl4 = new javax.swing.JPanel();
        pnl5 = new javax.swing.JPanel();
        pnl7 = new javax.swing.JPanel();
        pnl8 = new javax.swing.JPanel();
        pnl1 = new javax.swing.JPanel();
        pnl9 = new javax.swing.JPanel();
        pnl10 = new javax.swing.JPanel();
        pnlheroe1 = new javax.swing.JPanel();
        pnl6 = new javax.swing.JPanel();
        flph1 = new frames.JFlip();
        jPanel18 = new javax.swing.JPanel();
        pnlce1 = new javax.swing.JPanel();
        lblvid8 = new javax.swing.JLabel();
        lblda8 = new javax.swing.JLabel();
        pnlce2 = new javax.swing.JPanel();
        lblvid9 = new javax.swing.JLabel();
        lblda9 = new javax.swing.JLabel();
        pnlce3 = new javax.swing.JPanel();
        lblvid10 = new javax.swing.JLabel();
        lblda10 = new javax.swing.JLabel();
        pnlce4 = new javax.swing.JPanel();
        lblvid11 = new javax.swing.JLabel();
        lblda11 = new javax.swing.JLabel();
        pnlce5 = new javax.swing.JPanel();
        lblda12 = new javax.swing.JLabel();
        lblvid12 = new javax.swing.JLabel();
        pnlce6 = new javax.swing.JPanel();
        lblda13 = new javax.swing.JLabel();
        lblvid13 = new javax.swing.JLabel();
        pnlce7 = new javax.swing.JPanel();
        lblvid14 = new javax.swing.JLabel();
        lblda14 = new javax.swing.JLabel();
        jPanel26 = new javax.swing.JPanel();
        pnlheroe2 = new javax.swing.JPanel();
        pnlCinco = new javax.swing.JPanel();
        pnlSeis = new javax.swing.JPanel();
        pnlSiete = new javax.swing.JPanel();
        pnlOcho = new javax.swing.JPanel();
        pnlNueve = new javax.swing.JPanel();
        pnlCuatro = new javax.swing.JPanel();
        pnlTres = new javax.swing.JPanel();
        pnlDos = new javax.swing.JPanel();
        pnlUno = new javax.swing.JPanel();
        pnlDiez = new javax.swing.JPanel();
        flph2 = new frames.JFlip();
        lblnick = new javax.swing.JLabel();
        pnlMana = new javax.swing.JPanel();
        pnlZoom = new javax.swing.JPanel();
        lbldeckcant = new javax.swing.JLabel();
        nick2 = new javax.swing.JLabel();
        lblmanc1 = new javax.swing.JLabel();
        man1lbl = new javax.swing.JLabel();
        man2lbl = new javax.swing.JLabel();
        lbldeckcantd = new javax.swing.JLabel();
        lblterminar = new javax.swing.JLabel();
        lblvidh1 = new javax.swing.JLabel();
        lblvidh2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        pnlFondo.setForeground(new java.awt.Color(255, 255, 255));
        pnlFondo.setPreferredSize(new java.awt.Dimension(1366, 768));
        pnlFondo.setLayout(null);

        lblmanc.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblmanc.setForeground(new java.awt.Color(255, 255, 255));
        lblmanc.setText("/");
        pnlFondo.add(lblmanc);
        lblmanc.setBounds(1170, 320, 30, 40);

        lblman2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblman2.setForeground(new java.awt.Color(255, 255, 255));
        lblman2.setText("Var2");
        pnlFondo.add(lblman2);
        lblman2.setBounds(1140, 570, 60, 40);

        lblman1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblman1.setForeground(new java.awt.Color(255, 255, 255));
        lblman1.setText("Var");
        pnlFondo.add(lblman1);
        lblman1.setBounds(1050, 570, 60, 40);

        jPanel7.setOpaque(false);

        pnlc1.setBackground(new java.awt.Color(255, 255, 255));
        pnlc1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        pnlc1.setForeground(new java.awt.Color(255, 255, 255));
        pnlc1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlc1.setOpaque(false);
        pnlc1.setPreferredSize(new java.awt.Dimension(90, 129));
        pnlc1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlc1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlc1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlc1MouseExited(evt);
            }
        });

        lblda1.setBackground(new java.awt.Color(255, 255, 255));
        lblda1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lblda1.setText(" ");

        lblvid1.setBackground(new java.awt.Color(255, 255, 255));
        lblvid1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lblvid1.setText(" ");

        javax.swing.GroupLayout pnlc1Layout = new javax.swing.GroupLayout(pnlc1);
        pnlc1.setLayout(pnlc1Layout);
        pnlc1Layout.setHorizontalGroup(
            pnlc1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlc1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblda1, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                .addGap(38, 38, 38)
                .addComponent(lblvid1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlc1Layout.setVerticalGroup(
            pnlc1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlc1Layout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addGroup(pnlc1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblda1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblvid1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pnlc2.setBackground(new java.awt.Color(255, 255, 255));
        pnlc2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        pnlc2.setForeground(new java.awt.Color(255, 255, 255));
        pnlc2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlc2.setOpaque(false);
        pnlc2.setPreferredSize(new java.awt.Dimension(90, 129));
        pnlc2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlc2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlc2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlc2MouseExited(evt);
            }
        });

        lblda2.setBackground(new java.awt.Color(255, 255, 255));
        lblda2.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lblda2.setText(" ");

        lblvid2.setBackground(new java.awt.Color(255, 255, 255));
        lblvid2.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lblvid2.setText(" ");

        javax.swing.GroupLayout pnlc2Layout = new javax.swing.GroupLayout(pnlc2);
        pnlc2.setLayout(pnlc2Layout);
        pnlc2Layout.setHorizontalGroup(
            pnlc2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlc2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblda2, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                .addGap(38, 38, 38)
                .addComponent(lblvid2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        pnlc2Layout.setVerticalGroup(
            pnlc2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlc2Layout.createSequentialGroup()
                .addGap(0, 107, Short.MAX_VALUE)
                .addGroup(pnlc2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblda2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblvid2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pnlc3.setBackground(new java.awt.Color(255, 255, 255));
        pnlc3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        pnlc3.setForeground(new java.awt.Color(255, 255, 255));
        pnlc3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlc3.setOpaque(false);
        pnlc3.setPreferredSize(new java.awt.Dimension(90, 129));
        pnlc3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlc3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlc3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlc3MouseExited(evt);
            }
        });

        lblda3.setBackground(new java.awt.Color(255, 255, 255));
        lblda3.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lblda3.setText(" ");

        lblvid3.setBackground(new java.awt.Color(255, 255, 255));
        lblvid3.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lblvid3.setText(" ");

        javax.swing.GroupLayout pnlc3Layout = new javax.swing.GroupLayout(pnlc3);
        pnlc3.setLayout(pnlc3Layout);
        pnlc3Layout.setHorizontalGroup(
            pnlc3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlc3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblda3, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                .addGap(38, 38, 38)
                .addComponent(lblvid3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        pnlc3Layout.setVerticalGroup(
            pnlc3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlc3Layout.createSequentialGroup()
                .addGap(0, 107, Short.MAX_VALUE)
                .addGroup(pnlc3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblda3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblvid3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pnlc4.setBackground(new java.awt.Color(255, 255, 255));
        pnlc4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        pnlc4.setForeground(new java.awt.Color(255, 255, 255));
        pnlc4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlc4.setOpaque(false);
        pnlc4.setPreferredSize(new java.awt.Dimension(90, 129));
        pnlc4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlc4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlc4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlc4MouseExited(evt);
            }
        });

        lblda4.setBackground(new java.awt.Color(255, 255, 255));
        lblda4.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lblda4.setText(" ");

        lblvid4.setBackground(new java.awt.Color(255, 255, 255));
        lblvid4.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lblvid4.setText(" ");

        javax.swing.GroupLayout pnlc4Layout = new javax.swing.GroupLayout(pnlc4);
        pnlc4.setLayout(pnlc4Layout);
        pnlc4Layout.setHorizontalGroup(
            pnlc4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlc4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblda4, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                .addGap(38, 38, 38)
                .addComponent(lblvid4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        pnlc4Layout.setVerticalGroup(
            pnlc4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlc4Layout.createSequentialGroup()
                .addGap(0, 107, Short.MAX_VALUE)
                .addGroup(pnlc4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblda4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblvid4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pnlc5.setBackground(new java.awt.Color(255, 255, 255));
        pnlc5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        pnlc5.setForeground(new java.awt.Color(255, 255, 255));
        pnlc5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlc5.setOpaque(false);
        pnlc5.setPreferredSize(new java.awt.Dimension(90, 129));
        pnlc5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlc5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlc5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlc5MouseExited(evt);
            }
        });

        lblda5.setBackground(new java.awt.Color(255, 255, 255));
        lblda5.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lblda5.setText(" ");

        lblvid5.setBackground(new java.awt.Color(255, 255, 255));
        lblvid5.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lblvid5.setText(" ");

        javax.swing.GroupLayout pnlc5Layout = new javax.swing.GroupLayout(pnlc5);
        pnlc5.setLayout(pnlc5Layout);
        pnlc5Layout.setHorizontalGroup(
            pnlc5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlc5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblda5, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                .addGap(38, 38, 38)
                .addComponent(lblvid5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        pnlc5Layout.setVerticalGroup(
            pnlc5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlc5Layout.createSequentialGroup()
                .addGap(0, 107, Short.MAX_VALUE)
                .addGroup(pnlc5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblda5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblvid5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pnlc6.setBackground(new java.awt.Color(255, 255, 255));
        pnlc6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        pnlc6.setForeground(new java.awt.Color(255, 255, 255));
        pnlc6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlc6.setOpaque(false);
        pnlc6.setPreferredSize(new java.awt.Dimension(90, 129));
        pnlc6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlc6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlc6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlc6MouseExited(evt);
            }
        });

        lblvid6.setBackground(new java.awt.Color(255, 255, 255));
        lblvid6.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lblvid6.setText(" ");

        lblda6.setBackground(new java.awt.Color(255, 255, 255));
        lblda6.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lblda6.setText(" ");

        javax.swing.GroupLayout pnlc6Layout = new javax.swing.GroupLayout(pnlc6);
        pnlc6.setLayout(pnlc6Layout);
        pnlc6Layout.setHorizontalGroup(
            pnlc6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlc6Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(lblda6, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                .addGap(38, 38, 38)
                .addComponent(lblvid6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        pnlc6Layout.setVerticalGroup(
            pnlc6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlc6Layout.createSequentialGroup()
                .addGap(0, 107, Short.MAX_VALUE)
                .addGroup(pnlc6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblda6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblvid6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pnlc7.setBackground(new java.awt.Color(255, 255, 255));
        pnlc7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        pnlc7.setForeground(new java.awt.Color(255, 255, 255));
        pnlc7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlc7.setOpaque(false);
        pnlc7.setPreferredSize(new java.awt.Dimension(90, 129));
        pnlc7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlc7MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlc7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlc7MouseExited(evt);
            }
        });

        lblvid7.setBackground(new java.awt.Color(255, 255, 255));
        lblvid7.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lblvid7.setText(" ");

        lblda7.setBackground(new java.awt.Color(255, 255, 255));
        lblda7.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lblda7.setText(" ");

        javax.swing.GroupLayout pnlc7Layout = new javax.swing.GroupLayout(pnlc7);
        pnlc7.setLayout(pnlc7Layout);
        pnlc7Layout.setHorizontalGroup(
            pnlc7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlc7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblda7, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                .addGap(38, 38, 38)
                .addComponent(lblvid7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        pnlc7Layout.setVerticalGroup(
            pnlc7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlc7Layout.createSequentialGroup()
                .addGap(0, 107, Short.MAX_VALUE)
                .addGroup(pnlc7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblda7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblvid7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(pnlc1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlc2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlc3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlc4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlc5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlc6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlc7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(pnlc7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnlc1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnlc2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnlc3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnlc4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnlc5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnlc6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pnlFondo.add(jPanel7);
        jPanel7.setBounds(330, 440, 710, 150);

        jPanel8.setOpaque(false);

        pnl2.setBackground(new java.awt.Color(255, 255, 255));
        pnl2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        pnl2.setForeground(new java.awt.Color(255, 255, 255));
        pnl2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnl2.setOpaque(false);
        pnl2.setPreferredSize(new java.awt.Dimension(90, 129));
        pnl2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnl2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnl2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnl2MouseExited(evt);
            }
        });

        javax.swing.GroupLayout pnl2Layout = new javax.swing.GroupLayout(pnl2);
        pnl2.setLayout(pnl2Layout);
        pnl2Layout.setHorizontalGroup(
            pnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 88, Short.MAX_VALUE)
        );
        pnl2Layout.setVerticalGroup(
            pnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 127, Short.MAX_VALUE)
        );

        pnl3.setBackground(new java.awt.Color(255, 255, 255));
        pnl3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        pnl3.setForeground(new java.awt.Color(255, 255, 255));
        pnl3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnl3.setOpaque(false);
        pnl3.setPreferredSize(new java.awt.Dimension(90, 129));
        pnl3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnl3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnl3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnl3MouseExited(evt);
            }
        });
        pnl3.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                pnl3CaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
            }
        });

        javax.swing.GroupLayout pnl3Layout = new javax.swing.GroupLayout(pnl3);
        pnl3.setLayout(pnl3Layout);
        pnl3Layout.setHorizontalGroup(
            pnl3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 88, Short.MAX_VALUE)
        );
        pnl3Layout.setVerticalGroup(
            pnl3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 127, Short.MAX_VALUE)
        );

        pnl4.setBackground(new java.awt.Color(255, 255, 255));
        pnl4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        pnl4.setForeground(new java.awt.Color(255, 255, 255));
        pnl4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnl4.setOpaque(false);
        pnl4.setPreferredSize(new java.awt.Dimension(90, 129));
        pnl4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnl4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnl4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnl4MouseExited(evt);
            }
        });

        javax.swing.GroupLayout pnl4Layout = new javax.swing.GroupLayout(pnl4);
        pnl4.setLayout(pnl4Layout);
        pnl4Layout.setHorizontalGroup(
            pnl4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 88, Short.MAX_VALUE)
        );
        pnl4Layout.setVerticalGroup(
            pnl4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 127, Short.MAX_VALUE)
        );

        pnl5.setBackground(new java.awt.Color(255, 255, 255));
        pnl5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        pnl5.setForeground(new java.awt.Color(255, 255, 255));
        pnl5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnl5.setOpaque(false);
        pnl5.setPreferredSize(new java.awt.Dimension(90, 129));
        pnl5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnl5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnl5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnl5MouseExited(evt);
            }
        });

        javax.swing.GroupLayout pnl5Layout = new javax.swing.GroupLayout(pnl5);
        pnl5.setLayout(pnl5Layout);
        pnl5Layout.setHorizontalGroup(
            pnl5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 88, Short.MAX_VALUE)
        );
        pnl5Layout.setVerticalGroup(
            pnl5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 127, Short.MAX_VALUE)
        );

        pnl7.setBackground(new java.awt.Color(255, 255, 255));
        pnl7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        pnl7.setForeground(new java.awt.Color(255, 255, 255));
        pnl7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnl7.setOpaque(false);
        pnl7.setPreferredSize(new java.awt.Dimension(90, 129));
        pnl7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnl7MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnl7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnl7MouseExited(evt);
            }
        });

        javax.swing.GroupLayout pnl7Layout = new javax.swing.GroupLayout(pnl7);
        pnl7.setLayout(pnl7Layout);
        pnl7Layout.setHorizontalGroup(
            pnl7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 88, Short.MAX_VALUE)
        );
        pnl7Layout.setVerticalGroup(
            pnl7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 127, Short.MAX_VALUE)
        );

        pnl8.setBackground(new java.awt.Color(255, 255, 255));
        pnl8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        pnl8.setForeground(new java.awt.Color(255, 255, 255));
        pnl8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnl8.setOpaque(false);
        pnl8.setPreferredSize(new java.awt.Dimension(90, 129));
        pnl8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnl8MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnl8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnl8MouseExited(evt);
            }
        });

        javax.swing.GroupLayout pnl8Layout = new javax.swing.GroupLayout(pnl8);
        pnl8.setLayout(pnl8Layout);
        pnl8Layout.setHorizontalGroup(
            pnl8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 88, Short.MAX_VALUE)
        );
        pnl8Layout.setVerticalGroup(
            pnl8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 127, Short.MAX_VALUE)
        );

        pnl1.setBackground(new java.awt.Color(255, 255, 255));
        pnl1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        pnl1.setForeground(new java.awt.Color(255, 255, 255));
        pnl1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnl1.setOpaque(false);
        pnl1.setPreferredSize(new java.awt.Dimension(90, 129));
        pnl1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnl1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnl1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnl1MouseExited(evt);
            }
        });

        javax.swing.GroupLayout pnl1Layout = new javax.swing.GroupLayout(pnl1);
        pnl1.setLayout(pnl1Layout);
        pnl1Layout.setHorizontalGroup(
            pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 88, Short.MAX_VALUE)
        );
        pnl1Layout.setVerticalGroup(
            pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 127, Short.MAX_VALUE)
        );

        pnl9.setBackground(new java.awt.Color(255, 255, 255));
        pnl9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        pnl9.setForeground(new java.awt.Color(255, 255, 255));
        pnl9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnl9.setOpaque(false);
        pnl9.setPreferredSize(new java.awt.Dimension(90, 129));
        pnl9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnl9MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnl9MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnl9MouseExited(evt);
            }
        });

        javax.swing.GroupLayout pnl9Layout = new javax.swing.GroupLayout(pnl9);
        pnl9.setLayout(pnl9Layout);
        pnl9Layout.setHorizontalGroup(
            pnl9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 88, Short.MAX_VALUE)
        );
        pnl9Layout.setVerticalGroup(
            pnl9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 127, Short.MAX_VALUE)
        );

        pnl10.setBackground(new java.awt.Color(255, 255, 255));
        pnl10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        pnl10.setForeground(new java.awt.Color(255, 255, 255));
        pnl10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnl10.setOpaque(false);
        pnl10.setPreferredSize(new java.awt.Dimension(90, 129));
        pnl10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnl10MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnl10MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnl10MouseExited(evt);
            }
        });

        javax.swing.GroupLayout pnl10Layout = new javax.swing.GroupLayout(pnl10);
        pnl10.setLayout(pnl10Layout);
        pnl10Layout.setHorizontalGroup(
            pnl10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 88, Short.MAX_VALUE)
        );
        pnl10Layout.setVerticalGroup(
            pnl10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 127, Short.MAX_VALUE)
        );

        pnlheroe1.setOpaque(false);
        pnlheroe1.setPreferredSize(new java.awt.Dimension(125, 143));
        pnlheroe1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlheroe1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlheroe1Layout = new javax.swing.GroupLayout(pnlheroe1);
        pnlheroe1.setLayout(pnlheroe1Layout);
        pnlheroe1Layout.setHorizontalGroup(
            pnlheroe1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 125, Short.MAX_VALUE)
        );
        pnlheroe1Layout.setVerticalGroup(
            pnlheroe1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 143, Short.MAX_VALUE)
        );

        pnl6.setBackground(new java.awt.Color(255, 255, 255));
        pnl6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        pnl6.setForeground(new java.awt.Color(255, 255, 255));
        pnl6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnl6.setOpaque(false);
        pnl6.setPreferredSize(new java.awt.Dimension(90, 129));
        pnl6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnl6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnl6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnl6MouseExited(evt);
            }
        });

        javax.swing.GroupLayout pnl6Layout = new javax.swing.GroupLayout(pnl6);
        pnl6.setLayout(pnl6Layout);
        pnl6Layout.setHorizontalGroup(
            pnl6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 88, Short.MAX_VALUE)
        );
        pnl6Layout.setVerticalGroup(
            pnl6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 127, Short.MAX_VALUE)
        );

        flph1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                flph1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(pnl1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnl2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnl3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnl4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnl5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnl6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(pnl7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnl8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnl9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnl10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(flph1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnlheroe1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnl6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnl2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnl1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnl3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnl4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnl5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnl7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnl8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnl9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnl10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlheroe1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(flph1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlFondo.add(jPanel8);
        jPanel8.setBounds(0, 600, 1360, 160);

        jPanel18.setOpaque(false);

        pnlce1.setBackground(new java.awt.Color(255, 255, 255));
        pnlce1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        pnlce1.setForeground(new java.awt.Color(255, 255, 255));
        pnlce1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlce1.setOpaque(false);
        pnlce1.setPreferredSize(new java.awt.Dimension(90, 129));
        pnlce1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlce1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlce1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlce1MouseExited(evt);
            }
        });

        lblvid8.setBackground(new java.awt.Color(255, 255, 255));
        lblvid8.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lblvid8.setText(" ");

        lblda8.setBackground(new java.awt.Color(255, 255, 255));
        lblda8.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lblda8.setText(" ");

        javax.swing.GroupLayout pnlce1Layout = new javax.swing.GroupLayout(pnlce1);
        pnlce1.setLayout(pnlce1Layout);
        pnlce1Layout.setHorizontalGroup(
            pnlce1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlce1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblda8, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(lblvid8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlce1Layout.setVerticalGroup(
            pnlce1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlce1Layout.createSequentialGroup()
                .addGap(0, 107, Short.MAX_VALUE)
                .addGroup(pnlce1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblda8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblvid8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pnlce2.setBackground(new java.awt.Color(255, 255, 255));
        pnlce2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        pnlce2.setForeground(new java.awt.Color(255, 255, 255));
        pnlce2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlce2.setOpaque(false);
        pnlce2.setPreferredSize(new java.awt.Dimension(90, 129));
        pnlce2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlce2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlce2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlce2MouseExited(evt);
            }
        });

        lblvid9.setBackground(new java.awt.Color(255, 255, 255));
        lblvid9.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lblvid9.setText(" ");

        lblda9.setBackground(new java.awt.Color(255, 255, 255));
        lblda9.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lblda9.setText(" ");

        javax.swing.GroupLayout pnlce2Layout = new javax.swing.GroupLayout(pnlce2);
        pnlce2.setLayout(pnlce2Layout);
        pnlce2Layout.setHorizontalGroup(
            pnlce2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlce2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblda9, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(lblvid9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlce2Layout.setVerticalGroup(
            pnlce2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlce2Layout.createSequentialGroup()
                .addGap(0, 107, Short.MAX_VALUE)
                .addGroup(pnlce2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblda9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblvid9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pnlce3.setBackground(new java.awt.Color(255, 255, 255));
        pnlce3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        pnlce3.setForeground(new java.awt.Color(255, 255, 255));
        pnlce3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlce3.setOpaque(false);
        pnlce3.setPreferredSize(new java.awt.Dimension(90, 129));
        pnlce3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlce3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlce3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlce3MouseExited(evt);
            }
        });

        lblvid10.setBackground(new java.awt.Color(255, 255, 255));
        lblvid10.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lblvid10.setText(" ");

        lblda10.setBackground(new java.awt.Color(255, 255, 255));
        lblda10.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lblda10.setText(" ");

        javax.swing.GroupLayout pnlce3Layout = new javax.swing.GroupLayout(pnlce3);
        pnlce3.setLayout(pnlce3Layout);
        pnlce3Layout.setHorizontalGroup(
            pnlce3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlce3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblda10, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(lblvid10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlce3Layout.setVerticalGroup(
            pnlce3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlce3Layout.createSequentialGroup()
                .addGap(0, 107, Short.MAX_VALUE)
                .addGroup(pnlce3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblda10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblvid10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pnlce4.setBackground(new java.awt.Color(255, 255, 255));
        pnlce4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        pnlce4.setForeground(new java.awt.Color(255, 255, 255));
        pnlce4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlce4.setOpaque(false);
        pnlce4.setPreferredSize(new java.awt.Dimension(90, 129));
        pnlce4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlce4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlce4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlce4MouseExited(evt);
            }
        });

        lblvid11.setBackground(new java.awt.Color(255, 255, 255));
        lblvid11.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lblvid11.setText(" ");

        lblda11.setBackground(new java.awt.Color(255, 255, 255));
        lblda11.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lblda11.setText(" ");

        javax.swing.GroupLayout pnlce4Layout = new javax.swing.GroupLayout(pnlce4);
        pnlce4.setLayout(pnlce4Layout);
        pnlce4Layout.setHorizontalGroup(
            pnlce4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlce4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblda11, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(lblvid11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlce4Layout.setVerticalGroup(
            pnlce4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlce4Layout.createSequentialGroup()
                .addGap(0, 107, Short.MAX_VALUE)
                .addGroup(pnlce4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblda11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblvid11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pnlce5.setBackground(new java.awt.Color(255, 255, 255));
        pnlce5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        pnlce5.setForeground(new java.awt.Color(255, 255, 255));
        pnlce5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlce5.setOpaque(false);
        pnlce5.setPreferredSize(new java.awt.Dimension(90, 129));
        pnlce5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlce5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlce5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlce5MouseExited(evt);
            }
        });

        lblda12.setBackground(new java.awt.Color(255, 255, 255));
        lblda12.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lblda12.setText(" ");

        lblvid12.setBackground(new java.awt.Color(255, 255, 255));
        lblvid12.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lblvid12.setText(" ");

        javax.swing.GroupLayout pnlce5Layout = new javax.swing.GroupLayout(pnlce5);
        pnlce5.setLayout(pnlce5Layout);
        pnlce5Layout.setHorizontalGroup(
            pnlce5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlce5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblda12, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(lblvid12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlce5Layout.setVerticalGroup(
            pnlce5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlce5Layout.createSequentialGroup()
                .addGap(0, 107, Short.MAX_VALUE)
                .addGroup(pnlce5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblda12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblvid12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pnlce6.setBackground(new java.awt.Color(255, 255, 255));
        pnlce6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        pnlce6.setForeground(new java.awt.Color(255, 255, 255));
        pnlce6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlce6.setOpaque(false);
        pnlce6.setPreferredSize(new java.awt.Dimension(90, 129));
        pnlce6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlce6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlce6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlce6MouseExited(evt);
            }
        });

        lblda13.setBackground(new java.awt.Color(255, 255, 255));
        lblda13.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lblda13.setText(" ");

        lblvid13.setBackground(new java.awt.Color(255, 255, 255));
        lblvid13.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lblvid13.setText(" ");

        javax.swing.GroupLayout pnlce6Layout = new javax.swing.GroupLayout(pnlce6);
        pnlce6.setLayout(pnlce6Layout);
        pnlce6Layout.setHorizontalGroup(
            pnlce6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlce6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblda13, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(lblvid13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlce6Layout.setVerticalGroup(
            pnlce6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlce6Layout.createSequentialGroup()
                .addGap(0, 107, Short.MAX_VALUE)
                .addGroup(pnlce6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblda13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblvid13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pnlce7.setBackground(new java.awt.Color(255, 255, 255));
        pnlce7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        pnlce7.setForeground(new java.awt.Color(255, 255, 255));
        pnlce7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlce7.setOpaque(false);
        pnlce7.setPreferredSize(new java.awt.Dimension(90, 129));
        pnlce7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlce7MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlce7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlce7MouseExited(evt);
            }
        });

        lblvid14.setBackground(new java.awt.Color(255, 255, 255));
        lblvid14.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lblvid14.setText(" ");

        lblda14.setBackground(new java.awt.Color(255, 255, 255));
        lblda14.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lblda14.setText(" ");

        javax.swing.GroupLayout pnlce7Layout = new javax.swing.GroupLayout(pnlce7);
        pnlce7.setLayout(pnlce7Layout);
        pnlce7Layout.setHorizontalGroup(
            pnlce7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlce7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblda14, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(lblvid14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlce7Layout.setVerticalGroup(
            pnlce7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlce7Layout.createSequentialGroup()
                .addGap(0, 107, Short.MAX_VALUE)
                .addGroup(pnlce7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblda14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblvid14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlce1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlce2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlce3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlce4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlce5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlce6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlce7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlce1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlce2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlce3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlce4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlce5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlce6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlce7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlFondo.add(jPanel18);
        jPanel18.setBounds(320, 290, 721, 150);

        jPanel26.setOpaque(false);
        jPanel26.setPreferredSize(new java.awt.Dimension(869, 150));

        pnlheroe2.setOpaque(false);
        pnlheroe2.setPreferredSize(new java.awt.Dimension(125, 143));
        pnlheroe2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlheroe2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlheroe2Layout = new javax.swing.GroupLayout(pnlheroe2);
        pnlheroe2.setLayout(pnlheroe2Layout);
        pnlheroe2Layout.setHorizontalGroup(
            pnlheroe2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 125, Short.MAX_VALUE)
        );
        pnlheroe2Layout.setVerticalGroup(
            pnlheroe2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 143, Short.MAX_VALUE)
        );

        pnlCinco.setBackground(new java.awt.Color(255, 255, 255));
        pnlCinco.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        pnlCinco.setForeground(new java.awt.Color(255, 255, 255));
        pnlCinco.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlCinco.setOpaque(false);
        pnlCinco.setPreferredSize(new java.awt.Dimension(90, 129));
        pnlCinco.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlCincoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlCincoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlCincoMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pnlCincoLayout = new javax.swing.GroupLayout(pnlCinco);
        pnlCinco.setLayout(pnlCincoLayout);
        pnlCincoLayout.setHorizontalGroup(
            pnlCincoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 90, Short.MAX_VALUE)
        );
        pnlCincoLayout.setVerticalGroup(
            pnlCincoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 141, Short.MAX_VALUE)
        );

        pnlSeis.setBackground(new java.awt.Color(255, 255, 255));
        pnlSeis.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        pnlSeis.setForeground(new java.awt.Color(255, 255, 255));
        pnlSeis.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlSeis.setOpaque(false);
        pnlSeis.setPreferredSize(new java.awt.Dimension(90, 129));
        pnlSeis.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlSeisMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlSeisMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlSeisMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pnlSeisLayout = new javax.swing.GroupLayout(pnlSeis);
        pnlSeis.setLayout(pnlSeisLayout);
        pnlSeisLayout.setHorizontalGroup(
            pnlSeisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 90, Short.MAX_VALUE)
        );
        pnlSeisLayout.setVerticalGroup(
            pnlSeisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pnlSiete.setBackground(new java.awt.Color(255, 255, 255));
        pnlSiete.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        pnlSiete.setForeground(new java.awt.Color(255, 255, 255));
        pnlSiete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlSiete.setOpaque(false);
        pnlSiete.setPreferredSize(new java.awt.Dimension(90, 129));
        pnlSiete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlSieteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlSieteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlSieteMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pnlSieteLayout = new javax.swing.GroupLayout(pnlSiete);
        pnlSiete.setLayout(pnlSieteLayout);
        pnlSieteLayout.setHorizontalGroup(
            pnlSieteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 90, Short.MAX_VALUE)
        );
        pnlSieteLayout.setVerticalGroup(
            pnlSieteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pnlOcho.setBackground(new java.awt.Color(255, 255, 255));
        pnlOcho.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        pnlOcho.setForeground(new java.awt.Color(255, 255, 255));
        pnlOcho.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlOcho.setOpaque(false);
        pnlOcho.setPreferredSize(new java.awt.Dimension(90, 129));
        pnlOcho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlOchoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlOchoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlOchoMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pnlOchoLayout = new javax.swing.GroupLayout(pnlOcho);
        pnlOcho.setLayout(pnlOchoLayout);
        pnlOchoLayout.setHorizontalGroup(
            pnlOchoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 90, Short.MAX_VALUE)
        );
        pnlOchoLayout.setVerticalGroup(
            pnlOchoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pnlNueve.setBackground(new java.awt.Color(255, 255, 255));
        pnlNueve.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        pnlNueve.setForeground(new java.awt.Color(255, 255, 255));
        pnlNueve.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlNueve.setOpaque(false);
        pnlNueve.setPreferredSize(new java.awt.Dimension(90, 129));
        pnlNueve.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlNueveMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlNueveMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlNueveMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pnlNueveLayout = new javax.swing.GroupLayout(pnlNueve);
        pnlNueve.setLayout(pnlNueveLayout);
        pnlNueveLayout.setHorizontalGroup(
            pnlNueveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 90, Short.MAX_VALUE)
        );
        pnlNueveLayout.setVerticalGroup(
            pnlNueveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pnlCuatro.setBackground(new java.awt.Color(255, 255, 255));
        pnlCuatro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        pnlCuatro.setForeground(new java.awt.Color(255, 255, 255));
        pnlCuatro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlCuatro.setOpaque(false);
        pnlCuatro.setPreferredSize(new java.awt.Dimension(90, 129));
        pnlCuatro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlCuatroMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlCuatroMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlCuatroMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pnlCuatroLayout = new javax.swing.GroupLayout(pnlCuatro);
        pnlCuatro.setLayout(pnlCuatroLayout);
        pnlCuatroLayout.setHorizontalGroup(
            pnlCuatroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 90, Short.MAX_VALUE)
        );
        pnlCuatroLayout.setVerticalGroup(
            pnlCuatroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pnlTres.setBackground(new java.awt.Color(255, 255, 255));
        pnlTres.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        pnlTres.setForeground(new java.awt.Color(255, 255, 255));
        pnlTres.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlTres.setOpaque(false);
        pnlTres.setPreferredSize(new java.awt.Dimension(90, 129));
        pnlTres.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlTresMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlTresMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlTresMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pnlTresLayout = new javax.swing.GroupLayout(pnlTres);
        pnlTres.setLayout(pnlTresLayout);
        pnlTresLayout.setHorizontalGroup(
            pnlTresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 90, Short.MAX_VALUE)
        );
        pnlTresLayout.setVerticalGroup(
            pnlTresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pnlDos.setBackground(new java.awt.Color(255, 255, 255));
        pnlDos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        pnlDos.setForeground(new java.awt.Color(255, 255, 255));
        pnlDos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlDos.setOpaque(false);
        pnlDos.setPreferredSize(new java.awt.Dimension(90, 129));
        pnlDos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlDosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlDosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlDosMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pnlDosLayout = new javax.swing.GroupLayout(pnlDos);
        pnlDos.setLayout(pnlDosLayout);
        pnlDosLayout.setHorizontalGroup(
            pnlDosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 90, Short.MAX_VALUE)
        );
        pnlDosLayout.setVerticalGroup(
            pnlDosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pnlUno.setBackground(new java.awt.Color(255, 255, 255));
        pnlUno.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        pnlUno.setForeground(new java.awt.Color(255, 255, 255));
        pnlUno.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlUno.setOpaque(false);
        pnlUno.setPreferredSize(new java.awt.Dimension(90, 129));
        pnlUno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlUnoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlUnoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlUnoMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pnlUnoLayout = new javax.swing.GroupLayout(pnlUno);
        pnlUno.setLayout(pnlUnoLayout);
        pnlUnoLayout.setHorizontalGroup(
            pnlUnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 90, Short.MAX_VALUE)
        );
        pnlUnoLayout.setVerticalGroup(
            pnlUnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pnlDiez.setBackground(new java.awt.Color(255, 255, 255));
        pnlDiez.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        pnlDiez.setForeground(new java.awt.Color(255, 255, 255));
        pnlDiez.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlDiez.setOpaque(false);
        pnlDiez.setPreferredSize(new java.awt.Dimension(90, 129));
        pnlDiez.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlDiezMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlDiezMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlDiezMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pnlDiezLayout = new javax.swing.GroupLayout(pnlDiez);
        pnlDiez.setLayout(pnlDiezLayout);
        pnlDiezLayout.setHorizontalGroup(
            pnlDiezLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 90, Short.MAX_VALUE)
        );
        pnlDiezLayout.setVerticalGroup(
            pnlDiezLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        flph2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                flph2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(pnlUno, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlDos, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlTres, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlCuatro, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlCinco, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlSeis, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlSiete, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlOcho, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlNueve, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlDiez, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(flph2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnlheroe2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(pnlheroe2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnlDiez, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                    .addComponent(pnlUno, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                    .addComponent(pnlDos, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                    .addComponent(pnlTres, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                    .addComponent(pnlCuatro, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                    .addComponent(pnlNueve, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                    .addComponent(pnlOcho, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                    .addComponent(pnlSiete, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                    .addComponent(pnlSeis, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addComponent(pnlCinco, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel26Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(flph2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        pnlFondo.add(jPanel26);
        jPanel26.setBounds(0, 100, 1370, 160);

        lblnick.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblnick.setForeground(new java.awt.Color(255, 255, 255));
        lblnick.setText("Jugador");
        pnlFondo.add(lblnick);
        lblnick.setBounds(1250, 570, 79, 30);

        pnlMana.setOpaque(false);
        pnlMana.setPreferredSize(new java.awt.Dimension(50, 50));

        javax.swing.GroupLayout pnlManaLayout = new javax.swing.GroupLayout(pnlMana);
        pnlMana.setLayout(pnlManaLayout);
        pnlManaLayout.setHorizontalGroup(
            pnlManaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        pnlManaLayout.setVerticalGroup(
            pnlManaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        pnlFondo.add(pnlMana);
        pnlMana.setBounds(1270, 690, 50, 60);

        pnlZoom.setOpaque(false);
        pnlZoom.setPreferredSize(new java.awt.Dimension(257, 355));

        javax.swing.GroupLayout pnlZoomLayout = new javax.swing.GroupLayout(pnlZoom);
        pnlZoom.setLayout(pnlZoomLayout);
        pnlZoomLayout.setHorizontalGroup(
            pnlZoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
        );
        pnlZoomLayout.setVerticalGroup(
            pnlZoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 340, Short.MAX_VALUE)
        );

        pnlFondo.add(pnlZoom);
        pnlZoom.setBounds(20, 260, 250, 340);

        lbldeckcant.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbldeckcant.setForeground(new java.awt.Color(255, 255, 255));
        lbldeckcant.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbldeckcant.setText("N");
        pnlFondo.add(lbldeckcant);
        lbldeckcant.setBounds(1200, 560, 40, 50);

        nick2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        nick2.setForeground(new java.awt.Color(255, 255, 255));
        nick2.setText("User 2");
        pnlFondo.add(nick2);
        nick2.setBounds(1280, 320, 60, 22);

        lblmanc1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblmanc1.setForeground(new java.awt.Color(255, 255, 255));
        lblmanc1.setText("/");
        pnlFondo.add(lblmanc1);
        lblmanc1.setBounds(1110, 570, 30, 40);

        man1lbl.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        man1lbl.setForeground(new java.awt.Color(255, 255, 255));
        man1lbl.setText("jLabel1");
        pnlFondo.add(man1lbl);
        man1lbl.setBounds(1090, 330, 70, 22);

        man2lbl.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        man2lbl.setForeground(new java.awt.Color(255, 255, 255));
        man2lbl.setText("jLabel2");
        pnlFondo.add(man2lbl);
        man2lbl.setBounds(1190, 330, 70, 22);

        lbldeckcantd.setText("jLabel1");
        pnlFondo.add(lbldeckcantd);
        lbldeckcantd.setBounds(1170, 370, 34, 14);

        lblterminar.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblterminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/end.png"))); // NOI18N
        lblterminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblterminarMouseClicked(evt);
            }
        });
        pnlFondo.add(lblterminar);
        lblterminar.setBounds(1164, 419, 140, 70);

        lblvidh1.setBackground(new java.awt.Color(255, 255, 255));
        lblvidh1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblvidh1.setForeground(new java.awt.Color(255, 255, 255));
        lblvidh1.setText("Vidh");
        pnlFondo.add(lblvidh1);
        lblvidh1.setBounds(1270, 540, 60, 29);

        lblvidh2.setBackground(new java.awt.Color(255, 255, 255));
        lblvidh2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblvidh2.setForeground(new java.awt.Color(255, 255, 255));
        lblvidh2.setText("Vidh");
        pnlFondo.add(lblvidh2);
        lblvidh2.setBounds(1280, 270, 60, 29);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlFondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlFondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pnl10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl10MouseClicked
        if(isTurnoj1()==true){
        setValCar(9);
        setGeneral(pnl10);
        }
    
        
    }//GEN-LAST:event_pnl10MouseClicked

    private void pnl9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl9MouseClicked
        if(isTurnoj1()==true){
        setValCar(8);
        setGeneral(pnl9);
        }
        
    }//GEN-LAST:event_pnl9MouseClicked

    private void pnl1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl1MouseClicked
       if(isTurnoj1()==true){
        setValCar(0);
        setGeneral(pnl1);
        }
      
    }//GEN-LAST:event_pnl1MouseClicked

    private void pnl8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl8MouseClicked
        if(isTurnoj1()==true){
        setValCar(7);
        setGeneral(pnl8);
        }
    }//GEN-LAST:event_pnl8MouseClicked

    private void pnl7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl7MouseClicked
        if(isTurnoj1()==true){
        setValCar(6);
        setGeneral(pnl7);
        }
    }//GEN-LAST:event_pnl7MouseClicked

    private void pnl6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl6MouseClicked
       if(isTurnoj1()==true){
        setValCar(5);
        setGeneral(pnl6);
        }
    }//GEN-LAST:event_pnl6MouseClicked

    private void pnl5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl5MouseClicked
        if(isTurnoj1()==true){
        setValCar(4);
        setGeneral(pnl5);
        }
    }//GEN-LAST:event_pnl5MouseClicked

    private void pnl4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl4MouseClicked
       if(isTurnoj1()==true){
        setValCar(3);
        setGeneral(pnl4);
        }
    }//GEN-LAST:event_pnl4MouseClicked

    private void pnl3CaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_pnl3CaretPositionChanged

    }//GEN-LAST:event_pnl3CaretPositionChanged

    private void pnl3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl3MouseClicked
       if(isTurnoj1()==true){
        setValCar(2);
        setGeneral(pnl3);
        }
    }//GEN-LAST:event_pnl3MouseClicked

    private void pnl2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl2MouseClicked
     if(isTurnoj1()==true){
        setValCar(1);
        setGeneral(pnl2);
        }
        
    }//GEN-LAST:event_pnl2MouseClicked

    private void pnlc7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlc7MouseClicked
        if(isTurnoj1()==true){ 
        if (getValCar() < getLargo() && m.getMana() >= mano.get(getValCar()).getCostoMana()  && mano.get(getValCar()).isHechizo() ==false && seats.get(6)==false) {
            seats.set(6,true);
            atacar.set(6,false);
            //posCampo.add(6, Integer.toString(getValCar()));
            campo.set(6, mano.get(getValCar())) ;
            //System.out.println(campo.get(6).getNombre());
            mano.remove(getValCar());
            FrmDibujo fondo = new FrmDibujo(campo.get(6).getRuta_Oval(), 90, 129);
            m.setMana(m.getMana()-campo.get(6).getCostoMana());
            lblman1.setText(String.valueOf(m.getMana()));
                this.getGeneral().removeAll();
                this.getGeneral().repaint();
                this.lblda7.setText(String.valueOf(campo.get(6).getDanio()));
                this.lblvid7.setText(String.valueOf(campo.get(6).getVida()));
                this.pnlc7.add(fondo);
                this.pnlc7.repaint();
                setLargo(this.mano.size());
                setL2(this.mano.size());
                ponerCartasMano();
                setValCar(22);
                }
       
        if(getValCar()==10 && m.getMana() >= c.getCostoMana() && seats.get(6)==false){
                System.out.println("power");
                seats.set(6,true);
                //posCampo.add(6, Integer.toString(getValCar()));
                campo.set(6,c) ;
                FrmDibujo heropow = new FrmDibujo(campo.get(6).getRuta_Oval(), 90, 129);
                m.setMana(m.getMana()-campo.get(6).getCostoMana());
                lblman1.setText(String.valueOf(m.getMana()));
                this.lblda7.setText(String.valueOf(campo.get(6).getDanio()));
                this.lblvid7.setText(String.valueOf(campo.get(6).getVida()));
                this.pnlc7.add(heropow);
                this.pnlc7.repaint();
                setValCar(22);
                }
        else{
            this.setLact(lblvid7);
            this.setLvid(lblda7);
            this.setP1(6);
            this.setGeneral(pnlc7);
            System.out.println("Los mande");
            
            }
        }
        else{
            //Comprobacion
            System.out.println(atacar.get(p1));
            if(atacar.get(getP1()) ==true){
               atacar.add(getP1(), false); 
               m.pAtacar(getP1(), 6, getCampod(), getCampo(), getLact(), this.lblvid7, seats);
            if(seats.get(6)==false){//Este
                pnlc7.removeAll();
                pnlc7.repaint();
                pnlc7.add(lblda7);
                lblda7.setText("");
                pnlc7.add(lblvid7);
                lblvid7.setText("");
                
                if(seats.get(p1)==false){
                     getGeneral().removeAll();
                     getGeneral().repaint();
                     getGeneral().add(getLact());
                     getLact().setText("");
                     getGeneral().add(getLvid());
                     getLvid().setText("");
                }
                System.out.println("lol2");
            }    
            else if(seats.get(p1)==false){
                System.out.println("lol");
                    getGeneral().removeAll();
                    getGeneral().repaint();
                    getGeneral().add(getLact());
                    getLact().setText("");
                    getGeneral().add(getLvid());
                    getLvid().setText("");
                }
            
            else{
                general.repaint();
                pnlc7.repaint();
            }
            }
        }
    }//GEN-LAST:event_pnlc7MouseClicked

    private void pnlc6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlc6MouseClicked
        if(isTurnoj1()==true){  
        if (getValCar() < getLargo() && m.getMana() >= mano.get(getValCar()).getCostoMana()  && mano.get(getValCar()).isHechizo() ==false && seats.get(5)==false) {
            seats.set(5,true);
            atacar.set(5,false);
            //posCampo.add(5, Integer.toString(getValCar()));
            campo.set(5,mano.get(getValCar())) ;
            System.out.println(campo.get(5).getNombre());
            mano.remove(getValCar());
            FrmDibujo fondo = new FrmDibujo(campo.get(5).getRuta_Oval(), 90, 129);
            m.setMana(m.getMana()-campo.get(5).getCostoMana());
            lblman1.setText(String.valueOf(m.getMana()));
                this.getGeneral().removeAll();
                this.getGeneral().repaint();
                this.lblda6.setText(String.valueOf(campo.get(5).getDanio()));
                this.lblvid6.setText(String.valueOf(campo.get(5).getVida()));
                this.pnlc6.add(fondo);
                this.pnlc6.repaint();
                setL2(this.mano.size());
                setLargo(this.mano.size());
                ponerCartasMano();
                setValCar(22);
                }
       
        if(getValCar()==10 && m.getMana() >= c.getCostoMana() && seats.get(5)==false){
                System.out.println("power");
                seats.set(5,true);
                atacar.set(5,false);
                //posCampo.add(5, Integer.toString(getValCar()));
                campo.set(5,c) ;
                FrmDibujo heropow = new FrmDibujo(campo.get(5).getRuta_Oval(), 90, 129);
                m.setMana(m.getMana()-campo.get(5).getCostoMana());
                lblman1.setText(String.valueOf(m.getMana()));
                this.lblda6.setText(String.valueOf(campo.get(5).getDanio()));
                this.lblvid6.setText(String.valueOf(campo.get(5).getVida()));
                this.pnlc6.add(heropow);
                this.pnlc6.repaint();
                setValCar(22);
                }
        else{
            this.setLact(lblvid6);
            this.setLvid(lblda6);
            this.setP1(5);
            this.setGeneral(pnlc6);
            System.out.println("Los mande");
            
            }
        }
        else{
            //Comprobacion
            System.out.println(atacar.get(p1));
            if(atacar.get(getP1()) ==true){
               atacar.add(getP1(), false); 
               m.pAtacar(getP1(), 5, getCampod(), getCampo(), getLact(), this.lblvid6, seats);
            if(seats.get(5)==false){//Este
                pnlc6.removeAll();
                pnlc6.repaint();
                pnlc6.add(lblda6);
                lblda6.setText("");
                pnlc6.add(lblvid6);
                lblvid6.setText("");
                
                if(seats.get(p1)==false){
                     getGeneral().removeAll();
                     getGeneral().repaint();
                     getGeneral().add(getLact());
                     getLact().setText("");
                     getGeneral().add(getLvid());
                     getLvid().setText("");
                }
                System.out.println("lol2");
            }    
            else if(seats.get(p1)==false){
                System.out.println("lol");
                    getGeneral().removeAll();
                    getGeneral().repaint();
                    getGeneral().add(getLact());
                    getLact().setText("");
                    getGeneral().add(getLvid());
                    getLvid().setText("");
                }
            
            else{
                general.repaint();
                pnlc6.repaint();
            }
            }
        }
    }//GEN-LAST:event_pnlc6MouseClicked

    private void pnlc5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlc5MouseClicked
       if(isTurnoj1()==true){   
        if (getValCar() < getLargo() && m.getMana() >= mano.get(getValCar()).getCostoMana()  && mano.get(getValCar()).isHechizo() ==false && seats.get(4)==false) {
            seats.set(4,true);
            atacar.set(4,false);
            //posCampo.add(4, Integer.toString(getValCar()));
            campo.set(4,mano.get(getValCar())) ;
            //System.out.println(campo.get(4).getNombre());
            mano.remove(getValCar());
            FrmDibujo fondo = new FrmDibujo(campo.get(4).getRuta_Oval(), 90, 129);
            m.setMana(m.getMana()-campo.get(4).getCostoMana());
            lblman1.setText(String.valueOf(m.getMana()));
                this.getGeneral().removeAll();
                this.getGeneral().repaint();
                this.lblda5.setText(String.valueOf(campo.get(4).getDanio()));
                this.lblvid5.setText(String.valueOf(campo.get(4).getVida()));
                this.pnlc5.add(fondo);
                this.pnlc5.repaint();
                setL2(this.mano.size());
                setLargo(this.mano.size());
                ponerCartasMano();
                setValCar(22);
                }
       
        if(getValCar()==10 && m.getMana() >= c.getCostoMana() && seats.get(4)==false){
                System.out.println("power");
                seats.set(4,true);
                //posCampo.add(4, Integer.toString(getValCar()));
                campo.set(4,c) ;
                FrmDibujo heropow = new FrmDibujo(campo.get(4).getRuta_Oval(), 90, 129);
                m.setMana(m.getMana()-campo.get(4).getCostoMana());
                lblman1.setText(String.valueOf(m.getMana()));
                this.lblda5.setText(String.valueOf(campo.get(4).getDanio()));
                this.lblvid5.setText(String.valueOf(campo.get(4).getVida()));
                this.pnlc5.add(heropow);
                this.pnlc5.repaint();
                setValCar(22);
                }
        else{
            this.setLact(lblvid5);
            this.setLvid(lblda5);
            this.setP1(4);
            this.setGeneral(pnlc5);
            System.out.println("Los mande");
            
            }
       }
       else{
            //Comprobacion
            System.out.println(atacar.get(p1));
            if(atacar.get(getP1()) ==true){
               atacar.set(getP1(), false); 
               m.pAtacar(getP1(), 4, getCampod(), getCampo(), getLact(), this.lblvid5, seats);
            if(seats.get(4)==false){//Este
                pnlc5.removeAll();
                pnlc5.repaint();
                pnlc5.add(lblda5);
                lblda5.setText("");
                pnlc5.add(lblvid5);
                lblvid5.setText("");
                
                if(seats.get(p1)==false){
                     getGeneral().removeAll();
                     getGeneral().repaint();
                     getGeneral().add(getLact());
                     getLact().setText("");
                     getGeneral().add(getLvid());
                     getLvid().setText("");
                }
                System.out.println("lol2");
            }    
            else if(seats.get(p1)==false){
                System.out.println("lol");
                    getGeneral().removeAll();
                    getGeneral().repaint();
                    getGeneral().add(getLact());
                    getLact().setText("");
                    getGeneral().add(getLvid());
                    getLvid().setText("");
                }
            
            else{
                general.repaint();
                pnlc5.repaint();
            }
            }
        }
    }//GEN-LAST:event_pnlc5MouseClicked

    private void pnlc4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlc4MouseClicked
       if(isTurnoj1()==true){ 
        if (getValCar() < getLargo() && m.getMana() >= mano.get(getValCar()).getCostoMana()  && mano.get(getValCar()).isHechizo() ==false && seats.get(3)==false) {
            seats.set(3,true);
            atacar.set(3,false);
            //posCampo.add(3, Integer.toString(getValCar()));
            campo.set(3,mano.get(getValCar())) ;
            mano.remove(getValCar());
            //System.out.println(campo.get(3).getNombre());
            FrmDibujo fondo = new FrmDibujo(campo.get(3).getRuta_Oval(), 90, 129);
            m.setMana(m.getMana()-campo.get(3).getCostoMana());
            lblman1.setText(String.valueOf(m.getMana()));
                this.getGeneral().removeAll();
                this.getGeneral().repaint();
                this.lblda4.setText(String.valueOf(campo.get(3).getDanio()));
                this.lblvid4.setText(String.valueOf(campo.get(3).getVida()));
                this.pnlc4.add(fondo);
                this.pnlc4.repaint();
                setL2(this.mano.size());
                setLargo(this.mano.size());
                ponerCartasMano();
                setValCar(22);
                }
       
        if(getValCar()==10 && m.getMana() >= c.getCostoMana() && seats.get(3)==false){
                System.out.println("power");
                seats.set(3,true);
                //posCampo.add(3, Integer.toString(getValCar()));
                campo.set(3,c) ;
                FrmDibujo heropow = new FrmDibujo(campo.get(3).getRuta_Oval(), 90, 129);
                m.setMana(m.getMana()-campo.get(3).getCostoMana());
                lblman1.setText(String.valueOf(m.getMana()));
                this.lblda4.setText(String.valueOf(campo.get(3).getDanio()));
                this.lblvid4.setText(String.valueOf(campo.get(3).getVida()));
                this.pnlc4.add(heropow);
                this.pnlc4.repaint();
                setValCar(22);
                }
        else{
            this.setLact(lblvid4);
            this.setLvid(lblda4);
            this.setP1(3);
            this.setGeneral(pnlc4);
            System.out.println("Los mande");
            
            }
       }
       else{
            //Comprobacion
            System.out.println(atacar.get(p1));
            if(atacar.get(getP1()) ==true){
               atacar.add(getP1(), false); 
               m.pAtacar(getP1(), 3, getCampod(), getCampo(), getLact(), this.lblvid4, seats);
            if(seats.get(3)==false){//Este
                pnlc4.removeAll();
                pnlc4.repaint();
                pnlc4.add(lblda4);
                lblda4.setText("");
                pnlc4.add(lblvid4);
                lblvid4.setText("");
                
                if(seats.get(p1)==false){
                     getGeneral().removeAll();
                     getGeneral().repaint();
                     getGeneral().add(getLact());
                     getLact().setText("");
                     getGeneral().add(getLvid());
                     getLvid().setText("");
                }
                System.out.println("lol2");
            }    
            else if(seats.get(p1)==false){
                System.out.println("lol");
                    getGeneral().removeAll();
                    getGeneral().repaint();
                    getGeneral().add(getLact());
                    getLact().setText("");
                    getGeneral().add(getLvid());
                    getLvid().setText("");
                }
            
            else{
                general.repaint();
                pnlc4.repaint();
            }
            }
        }
    }//GEN-LAST:event_pnlc4MouseClicked

    private void pnlc3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlc3MouseClicked
        if(isTurnoj1()==true){ 
        if (getValCar() < getLargo() && m.getMana() >= mano.get(getValCar()).getCostoMana()  && mano.get(getValCar()).isHechizo() ==false && seats.get(2)==false) {
            seats.set(2,true);
            atacar.set(2,false);
            //posCampo.add(2, Integer.toString(getValCar()));
            campo.set(2,mano.get(getValCar())) ;
            mano.remove(getValCar());
            //System.out.println(campo.get(2).getNombre());
            FrmDibujo fondo = new FrmDibujo(campo.get(2).getRuta_Oval(), 90, 129);
            m.setMana(m.getMana()-campo.get(2).getCostoMana());
            lblman1.setText(String.valueOf(m.getMana()));
                this.getGeneral().removeAll();
                this.getGeneral().repaint();
                this.lblda3.setText(String.valueOf(campo.get(2).getDanio()));
                this.lblvid3.setText(String.valueOf(campo.get(2).getVida()));
                this.pnlc3.add(fondo);
                this.pnlc3.repaint();
                setL2(this.mano.size());
                setLargo(this.mano.size());
                ponerCartasMano();
                setValCar(22);
                }
       
        if(getValCar()==10 && m.getMana() >= c.getCostoMana() && seats.get(2)==false){
                System.out.println("power");
                seats.set(2,true);
                //posCampo.add(2, Integer.toString(getValCar()));
                campo.set(2,c) ;
                FrmDibujo heropow = new FrmDibujo(campo.get(2).getRuta_Oval(), 90, 129);
                m.setMana(m.getMana()-campo.get(2).getCostoMana());
                lblman1.setText(String.valueOf(m.getMana()));
                this.lblda3.setText(String.valueOf(campo.get(2).getDanio()));
                this.lblvid3.setText(String.valueOf(campo.get(2).getVida()));
                this.pnlc3.add(heropow);
                this.pnlc3.repaint();
                setValCar(22);
                }
        else{
            this.setLact(lblvid3);
            this.setLvid(lblda3);
            this.setP1(2);
            this.setGeneral(pnlc3);
            System.out.println("Los mande");
            
            }
        }
        else{
            //Comprobacion
            System.out.println(atacar.get(p1));
            if(atacar.get(getP1()) ==true){
               atacar.add(getP1(), false); 
               m.pAtacar(getP1(), 2, getCampod(), getCampo(), getLact(), this.lblvid3, seats);
            if(seats.get(2)==false){//Este
                pnlc3.removeAll();
                pnlc3.repaint();
                pnlc3.add(lblda3);
                lblda3.setText("");
                pnlc3.add(lblvid3);
                lblvid3.setText("");
                
                if(seats.get(p1)==false){
                     getGeneral().removeAll();
                     getGeneral().repaint();
                     getGeneral().add(getLact());
                     getLact().setText("");
                     getGeneral().add(getLvid());
                     getLvid().setText("");
                }
                System.out.println("lol2");
            }    
            else if(seats.get(p1)==false){
                System.out.println("lol");
                    getGeneral().removeAll();
                    getGeneral().repaint();
                    getGeneral().add(getLact());
                    getLact().setText("");
                    getGeneral().add(getLvid());
                    getLvid().setText("");
                }
            
            else{
                general.repaint();
                pnlc3.repaint();
            }
            }
        }
        
    }//GEN-LAST:event_pnlc3MouseClicked

    private void pnlc2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlc2MouseClicked
         if(isTurnoj1()==true){ 
             if (getValCar() < getLargo() && m.getMana() >= mano.get(getValCar()).getCostoMana()  && mano.get(getValCar()).isHechizo() ==false && seats.get(1)==false) {
            seats.set(1,true);
            atacar.set(1,false);
            ////posCampo.add(1, Integer.toString(getValCar()));
            campo.set(1,mano.get(getValCar()));
            mano.remove(getValCar());
            //System.out.println(campo.get(1).getNombre());
            FrmDibujo fondo = new FrmDibujo(campo.get(1).getRuta_Oval(), 90, 129);
            m.setMana(m.getMana()-campo.get(1).getCostoMana());
            lblman1.setText(String.valueOf(m.getMana()));
                this.getGeneral().removeAll();
                this.getGeneral().repaint();
                this.lblda2.setText(String.valueOf(campo.get(1).getDanio()));
                this.lblvid2.setText(String.valueOf(campo.get(1).getVida()));
                this.pnlc2.add(fondo);
                this.pnlc2.repaint();
                setL2(this.mano.size());
                setLargo(this.mano.size());
                 System.out.println(campo.get(1).getNombre()+" "+seats.get(1));
                ponerCartasMano();
                setValCar(22);
                }
       
        if(getValCar()==10 && m.getMana() >= c.getCostoMana() && seats.get(1)==false){
                System.out.println("power");
                seats.set(1,true);
                ////posCampo.add(1, Integer.toString(getValCar()));
                campo.set(1,c) ;
                FrmDibujo heropow = new FrmDibujo(campo.get(1).getRuta_Oval(), 90, 129);
                m.setMana(m.getMana()-campo.get(1).getCostoMana());
                lblman1.setText(String.valueOf(m.getMana()));
                this.lblda2.setText(String.valueOf(campo.get(1).getDanio()));
                this.lblvid2.setText(String.valueOf(campo.get(1).getVida()));
                this.pnlc2.add(heropow);
                this.pnlc2.repaint();
                setValCar(22);
                }
        else{
            this.setLact(lblvid2);
            this.setLvid(lblda2);
            this.setP1(1);
            this.setGeneral(pnlc2);
            System.out.println("Los mande");
            
            }
         }
         else{
            //Comprobacion
            System.out.println(atacar.get(p1));
            if(atacar.get(getP1()) ==true){
               atacar.add(getP1(), false); 
               m.pAtacar(getP1(), 1, getCampod(), getCampo(), getLact(), this.lblvid2, seats);
            if(seats.get(1)==false){//Este
                pnlc2.removeAll();
                pnlc2.repaint();
                pnlc2.add(lblda2);
                lblda2.setText("");
                pnlc2.add(lblvid2);
                lblvid2.setText("");
                
                if(seats.get(p1)==false){
                     getGeneral().removeAll();
                     getGeneral().repaint();
                     getGeneral().add(getLact());
                     getLact().setText("");
                     getGeneral().add(getLvid());
                     getLvid().setText("");
                }
                System.out.println("lol2");
            }    
            else if(seats.get(p1)==false){
                System.out.println("lol");
                    getGeneral().removeAll();
                    getGeneral().repaint();
                    getGeneral().add(getLact());
                    getLact().setText("");
                    getGeneral().add(getLvid());
                    getLvid().setText("");
                }
            
            else{
                general.repaint();
                pnlc2.repaint();
            }
            }
        }
    }//GEN-LAST:event_pnlc2MouseClicked

    private void pnlc1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlc1MouseClicked
        if(isTurnoj1()==true){ 
            
            if (getValCar() < getLargo() && m.getMana() >= mano.get(getValCar()).getCostoMana()  && mano.get(getValCar()).isHechizo() ==false && seats.get(0)==false) {
            seats.set(0,true);
            atacar.set(0,false);
           // //posCampo.add(0, Integer.toString(getValCar()));
            campo.set(0,mano.get(getValCar())) ;
            
            mano.remove(getValCar());
            FrmDibujo fondo = new FrmDibujo(campo.get(0).getRuta_Oval(), 90, 129);
            m.setMana(m.getMana()-campo.get(0).getCostoMana());
            lblman1.setText(String.valueOf(m.getMana()));
                this.getGeneral().removeAll();
                this.getGeneral().repaint();
                this.lblda1.setText(String.valueOf(campo.get(0).getDanio()));
                this.lblvid1.setText(String.valueOf(campo.get(0).getVida()));
                this.pnlc1.add(fondo);
                this.pnlc1.repaint();
                setL2(this.mano.size());
                setLargo(this.mano.size());
                ponerCartasMano();
                setValCar(22);
                }
       
        if(getValCar()==10 && m.getMana() >= c.getCostoMana() && seats.get(0)==false){
                System.out.println("power");
                seats.set(0,true);
                campo.set(0,c) ;
                //posCampo.add(0, Integer.toString(getValCar()));
                FrmDibujo heropow = new FrmDibujo(campo.get(0).getRuta_Oval(), 90, 129);
                m.setMana(m.getMana()-campo.get(0).getCostoMana());
                lblman1.setText(String.valueOf(m.getMana()));
                this.lblda1.setText(String.valueOf(campo.get(0).getDanio()));
                this.lblvid1.setText(String.valueOf(campo.get(0).getVida()));
                this.pnlc1.add(heropow);
                this.pnlc1.repaint();
                setValCar(22);
                }
        else{
            this.setLact(lblvid1);
            this.setLvid(lblda1);
            this.setP1(0);
            this.setGeneral(pnlc1);
            System.out.println("Los mande");
            }
        }
        else{
            //Comprobacion
            System.out.println(atacar.get(p1));
            if(atacar.get(getP1()) ==true){
               atacar.add(getP1(), false); 
               m.pAtacar(getP1(), 0, getCampod(), getCampo(), getLact(), this.lblvid1, seats);
            if(seats.get(0)==false){//Este
                pnlc1.removeAll();
                pnlc1.repaint();
                pnlc1.add(lblda1);
                lblda1.setText("");
                pnlc1.add(lblvid1);
                lblvid1.setText("");
                
                if(seats.get(p1)==false){
                     getGeneral().removeAll();
                     getGeneral().repaint();
                     getGeneral().add(getLact());
                     getLact().setText("");
                     getGeneral().add(getLvid());
                     getLvid().setText("");
                }
                System.out.println("lol2");
            }    
            else if(seats.get(p1)==false){
                System.out.println("lol");
                    getGeneral().removeAll();
                    getGeneral().repaint();
                    getGeneral().add(getLact());
                    getLact().setText("");
                    getGeneral().add(getLvid());
                    getLvid().setText("");
                }
            
            else{
                general.repaint();
                pnlc1.repaint();
            }
            }
        }
    }//GEN-LAST:event_pnlc1MouseClicked

    private void pnlUnoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlUnoMouseClicked
        if(isTurnoj1()==false){
        setValCar(0);
        setGeneral(pnlUno);
        }
        
        
    }//GEN-LAST:event_pnlUnoMouseClicked

    private void pnlce1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlce1MouseClicked
        if(isTurnoj1()==false){ 
            if (getValCar() < getLargo() && m.getMana() >= manod.get(getValCar()).getCostoMana()  && manod.get(getValCar()).isHechizo() ==false && seats.get(7)==false) {
            seats.set(7,true);
            //Asiganamos falso al atacar cuando lo asignmos por defecto
            atacar.set(7,false);
            //posCampo.add(7, Integer.toString(getValCar()));
            campod.set(7,manod.get(getValCar()));
            manod.remove(getValCar());
            FrmDibujo fondo = new FrmDibujo(campod.get(7).getRuta_Oval(), 90, 129);
            m.setMana(m.getMana()-campod.get(7).getCostoMana());
            man1lbl.setText(String.valueOf(m.getMana()));
                this.getGeneral().removeAll();
                this.getGeneral().repaint();
                this.lblda8.setText(String.valueOf(campod.get(7).getDanio()));
                this.lblvid8.setText(String.valueOf(campod.get(7).getVida()));
                this.pnlce1.add(fondo);
                this.pnlce1.repaint();
                setL1(this.manod.size());
                setLargo(this.manod.size());
                ponerCartasManod();
                setValCar(22);
                
                }
       
       if(getValCar()==10 && m.getMana() >= c.getCostoMana() && seats.get(7)==false){
                System.out.println("power");
                seats.set(7,true);
                //posCampo.add(11, Integer.toString(getValCar()));
                campod.set(7,c) ;
                FrmDibujo heropow = new FrmDibujo(campod.get(7).getRuta_Oval(), 90, 129);
                m.setMana(m.getMana()-campod.get(7).getCostoMana());
                man1lbl.setText(String.valueOf(m.getMana()));
                this.lblda8.setText(String.valueOf(campod.get(7).getDanio()));
                this.lblvid8.setText(String.valueOf(campod.get(7).getVida()));
                this.pnlce1.add(heropow);
                this.pnlce1.repaint();
                setValCar(22);
                }
        
        else{
           this.setLact(lblvid8);
            this.setLvid(lblda8);
            this.setP1(7);
            this.setGeneral(pnlce1);
            System.out.println("Los mande");
            }
        }
        else{
            //Comprobacion
            System.out.println(atacar.get(p1));
            if(atacar.get(getP1()) ==true){
               atacar.add(getP1(), false); 
               m.pAtacar(getP1(), 7, getCampo(), getCampod(), getLact(), this.lblvid8, seats);
            if(seats.get(7)==false){//Este
                pnlce1.removeAll();
                pnlce1.repaint();
                pnlce1.add(lblda8);
                lblda8.setText("");
                pnlce1.add(lblvid8);
                lblvid8.setText("");
                
                if(seats.get(p1)==false){
                     getGeneral().removeAll();
                     getGeneral().repaint();
                     getGeneral().add(getLact());
                     getLact().setText("");
                     getGeneral().add(getLvid());
                     getLvid().setText("");
                }
                System.out.println("lol2");
            }    
            else if(seats.get(p1)==false){
                System.out.println("lol");
                    getGeneral().removeAll();
                    getGeneral().repaint();
                    getGeneral().add(getLact());
                    getLact().setText("");
                    getGeneral().add(getLvid());
                    getLvid().setText("");
                }
            
            else{
                general.repaint();
                pnlce1.repaint();
            }
            }
        }
           
        
       
    }//GEN-LAST:event_pnlce1MouseClicked

    private void lblterminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblterminarMouseClicked
      flph1.flipAnimate();
      flph2.flipAnimate();
        cambTurno();
    }//GEN-LAST:event_lblterminarMouseClicked

    private void pnlDosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlDosMouseClicked
        if(isTurnoj1()==false){
        setValCar(1);
        setGeneral(pnlDos);
        }
       
    }//GEN-LAST:event_pnlDosMouseClicked

    private void pnlTresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlTresMouseClicked
       if(isTurnoj1()==false){
        setValCar(2);
        setGeneral(pnlTres);
        }
      
    }//GEN-LAST:event_pnlTresMouseClicked

    private void pnlCuatroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlCuatroMouseClicked
       if(isTurnoj1()==false){
        setValCar(3);
        setGeneral(pnlCuatro);
        }
    }//GEN-LAST:event_pnlCuatroMouseClicked

    private void pnlCincoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlCincoMouseClicked
       if(isTurnoj1()==false){
        setValCar(4);
        setGeneral(pnlCinco);
        }
    }//GEN-LAST:event_pnlCincoMouseClicked

    private void pnlSeisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlSeisMouseClicked
      if(isTurnoj1()==false){
        setValCar(5);
        setGeneral(pnlSeis);
        }
    }//GEN-LAST:event_pnlSeisMouseClicked

    private void pnlSieteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlSieteMouseClicked
       if(isTurnoj1()==false){
        setValCar(6);
        setGeneral(pnlSiete);
        }
    }//GEN-LAST:event_pnlSieteMouseClicked

    private void pnlOchoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlOchoMouseClicked
        if(isTurnoj1()==false){
        setValCar(7);
        setGeneral(pnlOcho);
        }
    }//GEN-LAST:event_pnlOchoMouseClicked

    private void pnlNueveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlNueveMouseClicked
       if(isTurnoj1()==false){
        setValCar(8);
        setGeneral(pnlNueve);
        }
    }//GEN-LAST:event_pnlNueveMouseClicked

    private void pnlDiezMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlDiezMouseClicked
      if(isTurnoj1()==false){
        setValCar(9);
        setGeneral(pnlDiez);
        }
    }//GEN-LAST:event_pnlDiezMouseClicked

    private void pnlce2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlce2MouseClicked
       if(isTurnoj1()==false){ 
            if (getValCar() < getLargo() && m.getMana() >= manod.get(getValCar()).getCostoMana()  && manod.get(getValCar()).isHechizo() ==false && seats.get(8)==false) {
            seats.set(8,true);
            //posCampo.add(8, Integer.toString(getValCar()));
            //posCampo.get(8));
            atacar.set(8,false);
            campod.set(8,manod.get(getValCar())) ;
            manod.remove(getValCar());
            FrmDibujo fondo = new FrmDibujo(campod.get(8).getRuta_Oval(), 90, 129);
            m.setMana(m.getMana()-campod.get(8).getCostoMana());
            man1lbl.setText(String.valueOf(m.getMana()));
                this.getGeneral().removeAll();
                this.getGeneral().repaint();
                this.lblda9.setText(String.valueOf(campod.get(8).getDanio()));
                this.lblvid9.setText(String.valueOf(campod.get(8).getVida()));
                this.pnlce2.add(fondo);
                this.pnlce2.repaint();
                setL1(this.manod.size());
                setLargo(this.manod.size());
                ponerCartasManod();
                setValCar(22);
                }
       
      if(getValCar()==10 && m.getMana() >= c.getCostoMana() && seats.get(8)==false){
                System.out.println("power");
                seats.set(8,true);
                //posCampo.add(11, Integer.toString(getValCar()));
                campod.set(8,c) ;
                FrmDibujo heropow = new FrmDibujo(campod.get(8).getRuta_Oval(), 90, 129);
                m.setMana(m.getMana()-campod.get(getValCar()).getCostoMana());
                man1lbl.setText(String.valueOf(m.getMana()));
                this.lblda9.setText(String.valueOf(campod.get(8).getDanio()));
                this.lblvid9.setText(String.valueOf(campod.get(8).getVida()));
                this.pnlce2.add(heropow);
                this.pnlce2.repaint();
                setValCar(22);
                }
        else{
                this.setLact(lblvid9);
            this.setLvid(lblda9);
            this.setP1(8);
            this.setGeneral(pnlce2);
            System.out.println("Los mande");
            }
        }
       else{
            //Comprobacion
            System.out.println(atacar.get(p1));
            if(atacar.get(getP1()) ==true){
               atacar.add(getP1(), false); 
               m.pAtacar(getP1(), 8, getCampo(), getCampod(), getLact(), this.lblvid9, seats);
            if(seats.get(8)==false){//Este
                pnlce2.removeAll();
                pnlce2.repaint();
                pnlce2.add(lblda9);
                lblda9.setText("");
                pnlce2.add(lblvid9);
                lblvid9.setText("");
                
                if(seats.get(p1)==false){
                     getGeneral().removeAll();
                     getGeneral().repaint();
                     getGeneral().add(getLact());
                     getLact().setText("");
                     getGeneral().add(getLvid());
                     getLvid().setText("");
                }
                System.out.println("lol2");
            }    
            else if(seats.get(p1)==false){
                System.out.println("lol");
                    getGeneral().removeAll();
                    getGeneral().repaint();
                    getGeneral().add(getLact());
                    getLact().setText("");
                    getGeneral().add(getLvid());
                    getLvid().setText("");
                }
            
            else{
                general.repaint();
                pnlce2.repaint();
            }
            }
        }
    }//GEN-LAST:event_pnlce2MouseClicked

    private void pnlce3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlce3MouseClicked
        if(isTurnoj1()==false){ 
            if (getValCar() < getLargo() && m.getMana() >= manod.get(getValCar()).getCostoMana()  && manod.get(getValCar()).isHechizo() ==false && seats.get(9)==false) {
            seats.set(9,true);
            atacar.set(9,false);
            //posCampo.add(9, Integer.toString(getValCar()));
            campod.set(9,manod.get(getValCar())) ;
            manod.remove(getValCar());
            FrmDibujo fondo = new FrmDibujo(campod.get(9).getRuta_Oval(), 90, 129);
            m.setMana(m.getMana()-campod.get(9).getCostoMana());
            man1lbl.setText(String.valueOf(m.getMana()));
                this.getGeneral().removeAll();
                this.getGeneral().repaint();
                this.lblda10.setText(String.valueOf(campod.get(9).getDanio()));
                this.lblvid10.setText(String.valueOf(campod.get(9).getVida()));
                this.pnlce3.add(fondo);
                this.pnlce3.repaint();
                setL1(this.manod.size());
                setLargo(this.manod.size());
                ponerCartasManod();
                setValCar(22);
                }
       
        if(getValCar()==10 && m.getMana() >= c.getCostoMana() && seats.get(9)==false){
                System.out.println("power");
                seats.set(9,true);
                //posCampo.add(9, Integer.toString(getValCar()));
                campod.set(9,c) ;
                FrmDibujo heropow = new FrmDibujo(campod.get(9).getRuta_Oval(), 90, 129);
                m.setMana(m.getMana()-campod.get(9).getCostoMana());
                man1lbl.setText(String.valueOf(m.getMana()));
                this.lblda10.setText(String.valueOf(campod.get(9).getDanio()));
                this.lblvid10.setText(String.valueOf(campod.get(9).getVida()));
                this.pnlce3.add(heropow);
                this.pnlce3.repaint();
                setValCar(22);
                }
        else{
            this.setLact(lblvid10);
            this.setLvid(lblda10);
            this.setP1(9);
            this.setGeneral(pnlce3);
            System.out.println("Los mande");
            }
        }
        else{
            //Comprobacion
            System.out.println(atacar.get(p1));
            if(atacar.get(getP1()) ==true){
               atacar.add(getP1(), false); 
               m.pAtacar(getP1(), 9, getCampo(), getCampod(), getLact(), this.lblvid10, seats);
            if(seats.get(9)==false){//Este
                pnlce3.removeAll();
                pnlce3.repaint();
                pnlce3.add(lblda10);
                lblda10.setText("");
                pnlce3.add(lblvid10);
                lblvid10.setText("");
                
                if(seats.get(p1)==false){
                     getGeneral().removeAll();
                     getGeneral().repaint();
                     getGeneral().add(getLact());
                     getLact().setText("");
                     getGeneral().add(getLvid());
                     getLvid().setText("");
                }
                System.out.println("lol2");
            }    
            else if(seats.get(p1)==false){
                System.out.println("lol");
                    getGeneral().removeAll();
                    getGeneral().repaint();
                    getGeneral().add(getLact());
                    getLact().setText("");
                    getGeneral().add(getLvid());
                    getLvid().setText("");
                }
            
            else{
                general.repaint();
                pnlce3.repaint();
            }
            }
        }
    }//GEN-LAST:event_pnlce3MouseClicked

    private void pnlce4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlce4MouseClicked
    if(isTurnoj1()==false){ 
            if (getValCar() < getLargo() && m.getMana() >= manod.get(getValCar()).getCostoMana()  && manod.get(getValCar()).isHechizo() ==false && seats.get(10)==false) {
            seats.set(10,true);
            atacar.set(10,false);
            //posCampo.add(10, Integer.toString(getValCar()));
            campod.set(10,manod.get(getValCar())) ;
            manod.remove(getValCar());
            FrmDibujo fondo = new FrmDibujo(campod.get(10).getRuta_Oval(), 90, 129);
            m.setMana(m.getMana()-campod.get(10).getCostoMana());
            man1lbl.setText(String.valueOf(m.getMana()));
                this.getGeneral().removeAll();
                this.getGeneral().repaint();
                this.lblda11.setText(String.valueOf(campod.get(10).getDanio()));
                this.lblvid11.setText(String.valueOf(campod.get(10).getVida()));
                this.pnlce4.add(fondo);
                this.pnlce4.repaint();
                setL1(this.manod.size());
                setLargo(this.manod.size());
                ponerCartasManod();
                setValCar(22);
                }
       
        if(getValCar()==10 && m.getMana() >= c.getCostoMana() && seats.get(10)==false){
                System.out.println("power");
                seats.set(10,true);
                //posCampo.add(11, Integer.toString(getValCar()));
                campod.set(10,c) ;
                FrmDibujo heropow = new FrmDibujo(campod.get(10).getRuta_Oval(), 90, 129);
                m.setMana(m.getMana()-campod.get(10).getCostoMana());
                man1lbl.setText(String.valueOf(m.getMana()));
                this.lblda11.setText(String.valueOf(campod.get(10).getDanio()));
                this.lblvid11.setText(String.valueOf(campod.get(10).getVida()));
                this.pnlce4.add(heropow);
                this.pnlce4.repaint();
                setValCar(22);
                }
        else{
            this.setLact(lblvid11);
            this.setLvid(lblda11);
            this.setP1(9);
            this.setGeneral(pnlce4);
            System.out.println("Los mande");
            }
        }
        else{
            //Comprobacion
            System.out.println(atacar.get(p1));
            if(atacar.get(getP1()) ==true){
               atacar.add(getP1(), false); 
               m.pAtacar(getP1(), 10, getCampo(), getCampod(), getLact(), this.lblvid11, seats);
            if(seats.get(10)==false){//Este
                pnlce4.removeAll();
                pnlce4.repaint();
                pnlce4.add(lblda8);
                lblda11.setText("");
                pnlce4.add(lblvid8);
                lblvid11.setText("");
                
                if(seats.get(p1)==false){
                     getGeneral().removeAll();
                     getGeneral().repaint();
                     getGeneral().add(getLact());
                     getLact().setText("");
                     getGeneral().add(getLvid());
                     getLvid().setText("");
                }
                System.out.println("lol2");
            }    
            else if(seats.get(p1)==false){
                System.out.println("lol");
                    getGeneral().removeAll();
                    getGeneral().repaint();
                    getGeneral().add(getLact());
                    getLact().setText("");
                    getGeneral().add(getLvid());
                    getLvid().setText("");
                }
            
            else{
                general.repaint();
                pnlce4.repaint();
            }
            }
        }
    }//GEN-LAST:event_pnlce4MouseClicked

    private void pnlce5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlce5MouseClicked
       if(isTurnoj1()==false){ 
            if (getValCar() < getLargo() && m.getMana() >= manod.get(getValCar()).getCostoMana()  && manod.get(getValCar()).isHechizo() ==false && seats.get(11)==false) {
            seats.set(11,true);
            atacar.set(11,false);
            //posCampo.add(11, Integer.toString(getValCar()));
            campod.set(11,manod.get(getValCar())) ;
            manod.remove(getValCar());
            FrmDibujo fondo = new FrmDibujo(campod.get(11).getRuta_Oval(), 90, 129);
            m.setMana(m.getMana()-campod.get(11).getCostoMana());
            man1lbl.setText(String.valueOf(m.getMana()));
                this.getGeneral().removeAll();
                this.getGeneral().repaint();
                this.lblda12.setText(String.valueOf(campod.get(11).getDanio()));
                this.lblvid12.setText(String.valueOf(campod.get(11).getVida()));
                this.pnlce5.add(fondo);
                this.pnlce5.repaint();
                setL1(this.manod.size());
                setLargo(this.manod.size());
                ponerCartasManod();
                setValCar(22);
                }
       
        if(getValCar()==10 && m.getMana() >= c.getCostoMana() && seats.get(11)==false){
                System.out.println("power");
                seats.set(11,true);
                //posCampo.add(11, Integer.toString(getValCar()));
                campod.set(11,c) ;
                FrmDibujo heropow = new FrmDibujo(campod.get(11).getRuta_Oval(), 90, 129);
                m.setMana(m.getMana()-campod.get(11).getCostoMana());
                man1lbl.setText(String.valueOf(m.getMana()));
                this.lblda12.setText(String.valueOf(campod.get(11).getDanio()));
                this.lblvid12.setText(String.valueOf(campod.get(11).getVida()));
                this.pnlce5.add(heropow);
                this.pnlce5.repaint();
                setValCar(22);
                }
        else{
            this.setLact(lblvid12);
            this.setLvid(lblda12);
            this.setP1(11);
            this.setGeneral(pnlce5);
            System.out.println("Los mande");
            }
        }
       else{
            //Comprobacion
            System.out.println(atacar.get(p1));
            if(atacar.get(getP1()) ==true){
               atacar.add(getP1(), false); 
               m.pAtacar(getP1(), 11, getCampo(), getCampod(), getLact(), this.lblvid12, seats);
            if(seats.get(11)==false){//Este
                pnlce5.removeAll();
                pnlce5.repaint();
                pnlce5.add(lblda12);
                lblda12.setText("");
                pnlce5.add(lblvid12);
                lblvid12.setText("");
                
                if(seats.get(p1)==false){
                     getGeneral().removeAll();
                     getGeneral().repaint();
                     getGeneral().add(getLact());
                     getLact().setText("");
                     getGeneral().add(getLvid());
                     getLvid().setText("");
                }
                System.out.println("lol2");
            }    
            else if(seats.get(p1)==false){
                System.out.println("lol");
                    getGeneral().removeAll();
                    getGeneral().repaint();
                    getGeneral().add(getLact());
                    getLact().setText("");
                    getGeneral().add(getLvid());
                    getLvid().setText("");
                }
            
            else{
                general.repaint();
                pnlce5.repaint();
            }
            }
        }
    }//GEN-LAST:event_pnlce5MouseClicked

    private void pnlce6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlce6MouseClicked
       if(isTurnoj1()==false){ 
            if (getValCar() < getLargo() && m.getMana() >= manod.get(getValCar()).getCostoMana()  && manod.get(getValCar()).isHechizo() ==false && seats.get(12)==false) {
            seats.set(12,true);
            atacar.set(12,false);
            //posCampo.add(12, Integer.toString(getValCar()));
            campod.set(12,manod.get(getValCar())) ;
            manod.remove(getValCar());
            FrmDibujo fondo = new FrmDibujo(campod.get(12).getRuta_Oval(), 90, 129);
            m.setMana(m.getMana()-campod.get(12).getCostoMana());
            man1lbl.setText(String.valueOf(m.getMana()));
                this.getGeneral().removeAll();
                this.getGeneral().repaint();
                this.lblda13.setText(String.valueOf(campod.get(12).getDanio()));
                this.lblvid13.setText(String.valueOf(campod.get(12).getVida()));
                this.pnlce6.add(fondo);
                this.pnlce6.repaint();
                setL1(this.manod.size());
                setLargo(this.manod.size());
                ponerCartasManod();
                setValCar(22);
                }
       
         if(getValCar()==10 && m.getMana() >= c.getCostoMana() && seats.get(12)==false){
                System.out.println("power");
                seats.set(12,true);
                //posCampo.add(11, Integer.toString(getValCar()));
                campod.set(12,c) ;
                FrmDibujo heropow = new FrmDibujo(campod.get(12).getRuta_Oval(), 90, 129);
                m.setMana(m.getMana()-campod.get(12).getCostoMana());
                man1lbl.setText(String.valueOf(m.getMana()));
                this.lblda13.setText(String.valueOf(campod.get(12).getDanio()));
                this.lblvid13.setText(String.valueOf(campod.get(12).getVida()));
                this.pnlce6.add(heropow);
                this.pnlce6.repaint();
                setValCar(22);
                }
        else{
             this.setLact(lblvid13);
            this.setLvid(lblda13);
            this.setP1(12);
            this.setGeneral(pnlce6);
            System.out.println("Los mande");
            }
        }
       else{
            //Comprobacion
            System.out.println(atacar.get(p1));
            if(atacar.get(getP1()) ==true){
               atacar.add(getP1(), false); 
               m.pAtacar(getP1(), 12, getCampo(), getCampod(), getLact(), this.lblvid13, seats);
            if(seats.get(12)==false){//Este
                pnlce6.removeAll();
                pnlce6.repaint();
                pnlce6.add(lblda13);
                lblda13.setText("");
                pnlce6.add(lblvid13);
                lblvid13.setText("");
                
                if(seats.get(p1)==false){
                     getGeneral().removeAll();
                     getGeneral().repaint();
                     getGeneral().add(getLact());
                     getLact().setText("");
                     getGeneral().add(getLvid());
                     getLvid().setText("");
                }
                System.out.println("lol2");
            }    
            else if(seats.get(p1)==false){
                System.out.println("lol");
                    getGeneral().removeAll();
                    getGeneral().repaint();
                    getGeneral().add(getLact());
                    getLact().setText("");
                    getGeneral().add(getLvid());
                    getLvid().setText("");
                }
            
            else{
                general.repaint();
                pnlce6.repaint();
            }
            }
        }
    }//GEN-LAST:event_pnlce6MouseClicked

    private void pnlce7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlce7MouseClicked
        if(isTurnoj1()==false){
            if (getValCar() < getLargo() && m.getMana() >= manod.get(getValCar()).getCostoMana()  && manod.get(getValCar()).isHechizo() ==false && seats.get(13)==false) {
            seats.set(13,true);
            atacar.set(13,false);
            //posCampo.add(13, Integer.toString(getValCar()));
            campod.set(13,manod.get(getValCar())) ;
            manod.remove(getValCar());
            FrmDibujo fondo = new FrmDibujo(campod.get(13).getRuta_Oval(), 90, 129);
            m.setMana(m.getMana()-campod.get(13).getCostoMana());
            man1lbl.setText(String.valueOf(m.getMana()));
            this.getGeneral().removeAll();
            this.getGeneral().repaint();
            this.lblda14.setText(String.valueOf(campod.get(13).getDanio()));
            this.lblvid14.setText(String.valueOf(campod.get(13).getVida()));
            this.pnlce7.add(fondo);
            this.pnlce7.repaint();
            setL1(this.manod.size());
            setLargo(this.manod.size());
            ponerCartasManod();
            setValCar(22);
                }
       
         if(getValCar()==10 && m.getMana() >= c.getCostoMana() && seats.get(13)==false){
                System.out.println("power");
                seats.set(13,true);
                //posCampo.add(11, Integer.toString(getValCar()));
                campod.set(13,c) ;
                FrmDibujo heropow = new FrmDibujo(campod.get(13).getRuta_Oval(), 90, 129);
                m.setMana(m.getMana()-campod.get(13).getCostoMana());
                man1lbl.setText(String.valueOf(m.getMana()));
                this.lblda14.setText(String.valueOf(campod.get(13).getDanio()));
                this.lblvid14.setText(String.valueOf(campod.get(13).getVida()));
                this.pnlce7.add(heropow);
                this.pnlce7.repaint();
                setValCar(22);
                }
        else{
             this.setLact(lblvid14);
            this.setLvid(lblda14);
            this.setP1(13);
            this.setGeneral(pnlce7);
            System.out.println("Los mande");
            }
        }
        else{
            //Comprobacion
            System.out.println(atacar.get(p1));
            if(atacar.get(getP1()) ==true){
               atacar.add(getP1(), false); 
               m.pAtacar(getP1(), 13, getCampo(), getCampod(), getLact(), this.lblvid14, seats);
            if(seats.get(13)==false){//Este
                pnlce7.removeAll();
                pnlce7.repaint();
                pnlce7.add(lblda14);
                lblda14.setText("");
                pnlce7.add(lblvid14);
                lblvid14.setText("");
                
                if(seats.get(p1)==false){
                     getGeneral().removeAll();
                     getGeneral().repaint();
                     getGeneral().add(getLact());
                     getLact().setText("");
                     getGeneral().add(getLvid());
                     getLvid().setText("");
                }
                System.out.println("lol2");
            }    
            else if(seats.get(p1)==false){
                System.out.println("lol");
                    getGeneral().removeAll();
                    getGeneral().repaint();
                    getGeneral().add(getLact());
                    getLact().setText("");
                    getGeneral().add(getLvid());
                    getLvid().setText("");
                }
            
            else{
                general.repaint();
                pnlce7.repaint();
            }
            }
        }
    }//GEN-LAST:event_pnlce7MouseClicked

    private void pnlUnoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlUnoMouseExited

        limpiarZoom();
    }//GEN-LAST:event_pnlUnoMouseExited

    private void pnlUnoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlUnoMouseEntered
        // TODO add your handling code here:
        if(isTurnoj1()==false){
        zoomMano(0, pnlUno);
        }
    
    }//GEN-LAST:event_pnlUnoMouseEntered

    private void pnl1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl1MouseEntered
        if(isTurnoj1()==true){
        zoomMano(0, pnl1);
        }
    
        
    }//GEN-LAST:event_pnl1MouseEntered

    private void pnl2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl2MouseEntered
        if(isTurnoj1()==true){
        zoomMano(1, pnl2);
        }
     
    }//GEN-LAST:event_pnl2MouseEntered

    private void pnl7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl7MouseEntered
        if(isTurnoj1()==true){
        zoomMano(6, pnl7);
        }
      
    }//GEN-LAST:event_pnl7MouseEntered

    private void pnl3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl3MouseEntered
        if(isTurnoj1()==true){
        zoomMano(2, pnl3);
        }
     
    }//GEN-LAST:event_pnl3MouseEntered

    private void pnl4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl4MouseEntered
        if(isTurnoj1()==true){
        zoomMano(3, pnl4);
        }
       
    }//GEN-LAST:event_pnl4MouseEntered

    private void pnl5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl5MouseEntered
        if(isTurnoj1()==true){
        zoomMano(4, pnl5);
        }
    
    }//GEN-LAST:event_pnl5MouseEntered

    private void pnl6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl6MouseEntered
        if(isTurnoj1()==true){
        zoomMano(5, pnl6);
        }
   
    }//GEN-LAST:event_pnl6MouseEntered

    private void pnlDosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlDosMouseEntered
        // TODO add your handling code here:
        if(isTurnoj1()==false){
        zoomMano(1, pnlDos);
        }
      
    }//GEN-LAST:event_pnlDosMouseEntered

    private void pnlTresMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlTresMouseEntered
        // TODO add your handling code here:
        if(isTurnoj1()==false){
        zoomMano(2, pnlTres);
        }
     
    }//GEN-LAST:event_pnlTresMouseEntered

    private void pnlCuatroMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlCuatroMouseEntered
        // TODO add your handling code here:
        if(isTurnoj1()==false){
        zoomMano(3, pnlCuatro);
        }
    
    }//GEN-LAST:event_pnlCuatroMouseEntered

    private void pnlCincoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlCincoMouseEntered
        // TODO add your handling code here:
        if(isTurnoj1()==false){
        zoomMano(4, pnlCinco);
        }
    
    }//GEN-LAST:event_pnlCincoMouseEntered

    private void pnlSeisMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlSeisMouseEntered
        // TODO add your handling code here:
        if(isTurnoj1()==false){
        zoomMano(5, pnlSeis);
        }
      
    }//GEN-LAST:event_pnlSeisMouseEntered

    private void pnlSieteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlSieteMouseEntered
        // TODO add your handling code here:
        if(isTurnoj1()==false){
        zoomMano(6, pnlSiete);
        }
    
    }//GEN-LAST:event_pnlSieteMouseEntered

    private void pnlOchoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlOchoMouseEntered
        // TODO add your handling code here:
        if(isTurnoj1()==false){
        zoomMano(7, pnlOcho);
        }
     
    }//GEN-LAST:event_pnlOchoMouseEntered

    private void pnlNueveMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlNueveMouseEntered
        // TODO add your handling code here:
        if(isTurnoj1()==false){
        zoomMano(8, pnlNueve);
        }
     
    }//GEN-LAST:event_pnlNueveMouseEntered

    private void pnlDiezMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlDiezMouseEntered
        // TODO add your handling code here:
        if(isTurnoj1()==false){
        zoomMano(9, pnlDiez);
        }
      
    }//GEN-LAST:event_pnlDiezMouseEntered

    private void pnl8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl8MouseEntered
        // TODO add your handling code here:
        if(isTurnoj1()==true){
        zoomMano(7, pnl8);
        }
    
    }//GEN-LAST:event_pnl8MouseEntered

    private void pnl9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl9MouseEntered
        // TODO add your handling code here:
        if(isTurnoj1()==true){
        zoomMano(8, pnl9);
        }
      
    }//GEN-LAST:event_pnl9MouseEntered

    private void pnl10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl10MouseEntered
        // TODO add your handling code here:
        if(isTurnoj1()==true){
        zoomMano(9, pnl10);
        }
       
    }//GEN-LAST:event_pnl10MouseEntered

    private void pnlDosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlDosMouseExited
        // TODO add your handling code here:
         limpiarZoom();
    }//GEN-LAST:event_pnlDosMouseExited

    private void pnlTresMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlTresMouseExited
        // TODO add your handling code here:
        limpiarZoom();
    }//GEN-LAST:event_pnlTresMouseExited

    private void pnlCuatroMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlCuatroMouseExited
        // TODO add your handling code here:
        limpiarZoom();
    }//GEN-LAST:event_pnlCuatroMouseExited

    private void pnlCincoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlCincoMouseExited
        // TODO add your handling code here:
        limpiarZoom();
    }//GEN-LAST:event_pnlCincoMouseExited

    private void pnlSeisMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlSeisMouseExited
        // TODO add your handling code here:
        limpiarZoom();
    }//GEN-LAST:event_pnlSeisMouseExited

    private void pnlSieteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlSieteMouseExited
        // TODO add your handling code here:
        limpiarZoom();
    }//GEN-LAST:event_pnlSieteMouseExited

    private void pnlOchoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlOchoMouseExited
        // TODO add your handling code here:
        limpiarZoom();
    }//GEN-LAST:event_pnlOchoMouseExited

    private void pnlNueveMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlNueveMouseExited
        // TODO add your handling code here:
        limpiarZoom();
    }//GEN-LAST:event_pnlNueveMouseExited

    private void pnlDiezMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlDiezMouseExited
        // TODO add your handling code here:
        limpiarZoom();
    }//GEN-LAST:event_pnlDiezMouseExited

    private void pnl1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl1MouseExited
        // TODO add your handling code here:
        limpiarZoom();
    }//GEN-LAST:event_pnl1MouseExited

    private void pnl2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl2MouseExited
        // TODO add your handling code here:
        limpiarZoom();
    }//GEN-LAST:event_pnl2MouseExited

    private void pnl3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl3MouseExited
        // TODO add your handling code here:
        limpiarZoom();
    }//GEN-LAST:event_pnl3MouseExited

    private void pnl4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl4MouseExited
        // TODO add your handling code here:
        limpiarZoom();
    }//GEN-LAST:event_pnl4MouseExited

    private void pnl5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl5MouseExited
        // TODO add your handling code here:
        limpiarZoom();
    }//GEN-LAST:event_pnl5MouseExited

    private void pnl6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl6MouseExited
        // TODO add your handling code here:
        limpiarZoom();
    }//GEN-LAST:event_pnl6MouseExited

    private void pnl7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl7MouseExited
        // TODO add your handling code here:
        limpiarZoom();
    }//GEN-LAST:event_pnl7MouseExited

    private void pnl8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl8MouseExited
        // TODO add your handling code here:
        limpiarZoom();
    }//GEN-LAST:event_pnl8MouseExited

    private void pnl9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl9MouseExited
        // TODO add your handling code here:
        limpiarZoom();
    }//GEN-LAST:event_pnl9MouseExited

    private void pnl10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl10MouseExited
        // TODO add your handling code here:
        limpiarZoom();
    }//GEN-LAST:event_pnl10MouseExited

    private void pnlce1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlce1MouseEntered
        // TODO add your handling code here:
        zoomCampo(7,7, pnlce1);
    }//GEN-LAST:event_pnlce1MouseEntered

    private void pnlce2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlce2MouseEntered
        // TODO add your handling code here:
        zoomCampo(8,8, pnlce2);
    }//GEN-LAST:event_pnlce2MouseEntered

    private void pnlce3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlce3MouseEntered
        // TODO add your handling code here:
        zoomCampo(9,9, pnlce3);
    }//GEN-LAST:event_pnlce3MouseEntered

    private void pnlce4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlce4MouseEntered
        // TODO add your handling code here:
        zoomCampo(10,10, pnlce4);
    }//GEN-LAST:event_pnlce4MouseEntered

    private void pnlce5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlce5MouseEntered
        // TODO add your handling code here:
        zoomCampo(11,11, pnlce5);
    }//GEN-LAST:event_pnlce5MouseEntered

    private void pnlce6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlce6MouseEntered
        // TODO add your handling code here:
        zoomCampo(12,12, pnlce6);
    }//GEN-LAST:event_pnlce6MouseEntered

    private void pnlce7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlce7MouseEntered
        // TODO add your handling code here:
        zoomCampo(13,13, pnlce7);
    }//GEN-LAST:event_pnlce7MouseEntered

    private void pnlc1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlc1MouseEntered
        // TODO add your handling code here:
        zoomCampod(0, 0, pnlc1);
        System.out.println(campo.get(0).getRuta_Grande());
    }//GEN-LAST:event_pnlc1MouseEntered

    private void pnlc2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlc2MouseEntered
        // TODO add your handling code here:
        zoomCampod(1,1, pnlc2);
        System.out.println(campo.get(1).getRuta_Grande());
    }//GEN-LAST:event_pnlc2MouseEntered

    private void pnlc3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlc3MouseEntered
        // TODO add your handling code here:
        zoomCampod(2,2, pnlc3);
        System.out.println(campo.get(2).getRuta_Grande());
    }//GEN-LAST:event_pnlc3MouseEntered

    private void pnlc4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlc4MouseEntered
        // TODO add your handling code here:
        zoomCampod(3,3, pnlc4);
        System.out.println(campo.get(3).getRuta_Grande());
    }//GEN-LAST:event_pnlc4MouseEntered

    private void pnlc5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlc5MouseEntered
        // TODO add your handling code here:
        zoomCampod(4,4, pnlc5);
        for(int i =0; i<6;i++){
            System.out.println("POSICIONES: "+i+"    "+campo.get(i).getRuta_Grande());
        }
        
    }//GEN-LAST:event_pnlc5MouseEntered

    private void pnlc6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlc6MouseEntered
        // TODO add your handling code here:
        zoomCampod(5,5, pnlc6);
        System.out.println(campo.get(5).getRuta_Grande());
    }//GEN-LAST:event_pnlc6MouseEntered

    private void pnlc7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlc7MouseEntered
        // TODO add your handling code here:
        zoomCampod(6,6, pnlc7);
        System.out.println(campo.get(6).getRuta_Grande());
    }//GEN-LAST:event_pnlc7MouseEntered

    private void pnlce1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlce1MouseExited
        // TODO add your handling code here:
       limpiarZoom();
    }//GEN-LAST:event_pnlce1MouseExited

    private void pnlce2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlce2MouseExited
        // TODO add your handling code here:
        limpiarZoom();
    }//GEN-LAST:event_pnlce2MouseExited

    private void pnlce3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlce3MouseExited
        // TODO add your handling code here:
        limpiarZoom();
    }//GEN-LAST:event_pnlce3MouseExited

    private void pnlce4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlce4MouseExited
        // TODO add your handling code here:
        limpiarZoom();
    }//GEN-LAST:event_pnlce4MouseExited

    private void pnlce5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlce5MouseExited
        // TODO add your handling code here:
        limpiarZoom();
    }//GEN-LAST:event_pnlce5MouseExited

    private void pnlce6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlce6MouseExited
        // TODO add your handling code here:
        limpiarZoom();
    }//GEN-LAST:event_pnlce6MouseExited

    private void pnlce7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlce7MouseExited
        // TODO add your handling code here:
        limpiarZoom();
    }//GEN-LAST:event_pnlce7MouseExited

    private void pnlc1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlc1MouseExited
        // TODO add your handling code here:
        limpiarZoom();
    }//GEN-LAST:event_pnlc1MouseExited

    private void pnlc2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlc2MouseExited
        // TODO add your handling code here:
        limpiarZoom();
    }//GEN-LAST:event_pnlc2MouseExited

    private void pnlc3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlc3MouseExited
        // TODO add your handling code here:
        limpiarZoom();
    }//GEN-LAST:event_pnlc3MouseExited

    private void pnlc4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlc4MouseExited
        // TODO add your handling code here:
        limpiarZoom();
    }//GEN-LAST:event_pnlc4MouseExited

    private void pnlc5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlc5MouseExited
        // TODO add your handling code here:
        limpiarZoom();
    }//GEN-LAST:event_pnlc5MouseExited

    private void pnlc6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlc6MouseExited
        // TODO add your handling code here:
        limpiarZoom();
    }//GEN-LAST:event_pnlc6MouseExited

    private void pnlc7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlc7MouseExited
        // TODO add your handling code here:
        limpiarZoom();
    }//GEN-LAST:event_pnlc7MouseExited

    private void pnlheroe2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlheroe2MouseClicked
        if(atacar.get(getP1()) ==true){
        atacar.set(getP1(), false);
        m.atacarHeroe(p1, getCampo(), lblvidh2, jd, j);
        }
        
    }//GEN-LAST:event_pnlheroe2MouseClicked

    private void pnlheroe1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlheroe1MouseClicked
        if(atacar.get(getP1()) ==true){
        atacar.set(getP1(), false);
        m.atacarHeroe(p1, getCampod(), lblvidh1, j, jd);
        }
        
    }//GEN-LAST:event_pnlheroe1MouseClicked

    private void flph2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_flph2MouseClicked
        // TODO add your handling code here:
        if(isTurnoj1()==false){ 
        if(jd.getHero().getNombre_hero().equals("Uther") && getHeropow()==false){
           setHeropow(true); 
           setValCar(10);
           System.out.println("10");
        }
        else if(jd.getHero().getNombre_hero().equals("Rexxar") && getHeropow()==false && m.getMana()>=2){
          m.atacarHunter(j,  lblvidh1);
          setHeropow(true);
          m.setMana(m.getMana()-2);
        }
        }
    }//GEN-LAST:event_flph2MouseClicked

    private void flph1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_flph1MouseClicked
        // TODO add your handling code here:
          if(isTurnoj1()==true){ 
        if(j.getHero().getNombre_hero().equals("Uther") && getHeropow()==false){
           setHeropow(true); 
           setValCar(10);
           System.out.println("10");
        }
        else if(j.getHero().getNombre_hero().equals("Rexxar") && getHeropow()==false && m.getMana()>=2){
          m.atacarHunter(jd,  lblvidh2);
          setHeropow(true);
          m.setMana(m.getMana()-2);
        }
        }
    }//GEN-LAST:event_flph1MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmPartida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPartida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPartida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPartida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPartida().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private frames.JFlip flph1;
    private frames.JFlip flph2;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JLabel lblda1;
    private javax.swing.JLabel lblda10;
    private javax.swing.JLabel lblda11;
    private javax.swing.JLabel lblda12;
    private javax.swing.JLabel lblda13;
    private javax.swing.JLabel lblda14;
    private javax.swing.JLabel lblda2;
    private javax.swing.JLabel lblda3;
    private javax.swing.JLabel lblda4;
    private javax.swing.JLabel lblda5;
    private javax.swing.JLabel lblda6;
    private javax.swing.JLabel lblda7;
    private javax.swing.JLabel lblda8;
    private javax.swing.JLabel lblda9;
    private javax.swing.JLabel lbldeckcant;
    private javax.swing.JLabel lbldeckcantd;
    private javax.swing.JLabel lblman1;
    private javax.swing.JLabel lblman2;
    private javax.swing.JLabel lblmanc;
    private javax.swing.JLabel lblmanc1;
    private javax.swing.JLabel lblnick;
    private javax.swing.JLabel lblterminar;
    private javax.swing.JLabel lblvid1;
    private javax.swing.JLabel lblvid10;
    private javax.swing.JLabel lblvid11;
    private javax.swing.JLabel lblvid12;
    private javax.swing.JLabel lblvid13;
    private javax.swing.JLabel lblvid14;
    private javax.swing.JLabel lblvid2;
    private javax.swing.JLabel lblvid3;
    private javax.swing.JLabel lblvid4;
    private javax.swing.JLabel lblvid5;
    private javax.swing.JLabel lblvid6;
    private javax.swing.JLabel lblvid7;
    private javax.swing.JLabel lblvid8;
    private javax.swing.JLabel lblvid9;
    private javax.swing.JLabel lblvidh1;
    private javax.swing.JLabel lblvidh2;
    private javax.swing.JLabel man1lbl;
    private javax.swing.JLabel man2lbl;
    private javax.swing.JLabel nick2;
    private javax.swing.JPanel pnl1;
    public javax.swing.JPanel pnl10;
    public javax.swing.JPanel pnl2;
    private javax.swing.JPanel pnl3;
    private javax.swing.JPanel pnl4;
    private javax.swing.JPanel pnl5;
    private javax.swing.JPanel pnl6;
    private javax.swing.JPanel pnl7;
    private javax.swing.JPanel pnl8;
    private javax.swing.JPanel pnl9;
    private javax.swing.JPanel pnlCinco;
    private javax.swing.JPanel pnlCuatro;
    private javax.swing.JPanel pnlDiez;
    private javax.swing.JPanel pnlDos;
    private javax.swing.JPanel pnlFondo;
    private javax.swing.JPanel pnlMana;
    private javax.swing.JPanel pnlNueve;
    private javax.swing.JPanel pnlOcho;
    private javax.swing.JPanel pnlSeis;
    private javax.swing.JPanel pnlSiete;
    private javax.swing.JPanel pnlTres;
    private javax.swing.JPanel pnlUno;
    private javax.swing.JPanel pnlZoom;
    public javax.swing.JPanel pnlc1;
    public javax.swing.JPanel pnlc2;
    public javax.swing.JPanel pnlc3;
    public javax.swing.JPanel pnlc4;
    public javax.swing.JPanel pnlc5;
    public javax.swing.JPanel pnlc6;
    public javax.swing.JPanel pnlc7;
    private javax.swing.JPanel pnlce1;
    private javax.swing.JPanel pnlce2;
    private javax.swing.JPanel pnlce3;
    private javax.swing.JPanel pnlce4;
    private javax.swing.JPanel pnlce5;
    private javax.swing.JPanel pnlce6;
    private javax.swing.JPanel pnlce7;
    private javax.swing.JPanel pnlheroe1;
    private javax.swing.JPanel pnlheroe2;
    // End of variables declaration//GEN-END:variables
}
