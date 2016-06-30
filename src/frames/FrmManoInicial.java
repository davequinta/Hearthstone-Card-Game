/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import Clases_Principales.Carta;
import Clases_Principales.Jugador;
import Clases_Principales.MtoPartida;
import Clases_Principales.Partida;
import hearthstone.FrmDibujo;
import java.awt.Image;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import javax.swing.JPanel;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author DOSLAP
 */
public class FrmManoInicial extends javax.swing.JFrame {
Jugador j, jd;
ArrayList<String> c1= new ArrayList<String>();
ArrayList<Carta> mano = new ArrayList<Carta>();
ArrayList<Carta> mano2 = new ArrayList<Carta>();
Partida j1,j2;
Timer timer;
boolean selecc1,selecc2, selecc3, selecc4; 

  boolean turno;

    public boolean isTurno() {
        return turno;
    }

    public void setTurno(boolean turno) {
        this.turno = turno;
    }
  
     
    public ArrayList<String> getC1( ) {
        return c1;
    }
    

    /**
     * Creates new form FrmManoInicial
     */
    public void setC1(ArrayList<String> c1) {
        this.c1 = c1;
    }

    public ArrayList<Carta> getMano2() {
        return mano2;
    }

    public void setMano2(ArrayList<Carta> mano2) {
        this.mano2 = mano2;
    }
    
    

    public FrmManoInicial(Jugador j, Jugador jd) {
        initComponents();
        Image icono;
        icono = new ImageIcon(getClass().getResource("/img/logo.png")).getImage();
        this.setIconImage(icono);

        this.setJ(j);
        this.setJd(jd);
        this.setLocationRelativeTo(null);
        FrmDibujo btn = new FrmDibujo("/img/confirm.png", 123, 66);
        this.pnlConf.add(btn);
        this.pnlConf.repaint();
        FrmDibujo fondo = new FrmDibujo("/img/fondo1366.jpg", 1366, 768);
        pnlFondo.add(fondo);
        pnlFondo.repaint();//Refrescar
        FrmDibujo logo1 = new FrmDibujo("/img/fondo3.png", 1366, 768);
        this.pnlPrincipal.add(logo1);
        this.pnlPrincipal.repaint();
        FrmDibujo logo = new FrmDibujo("/img/HLogo.png", 584, 110);
        this.pnlLogo.add(logo);
        this.pnlLogo.repaint();
        if(turno == false){
            ponerCartas(j);
        }
       
    }

    public Jugador getJd() {
        return jd;
    }

    public void setJd(Jugador jd) {
        this.jd = jd;
    }
    
    

    public Jugador getJ() {
        return j;
    }

    public void setJ(Jugador j) {
        this.j = j;
    }

    public ArrayList<Carta> getMano() {
        return mano;
    }

    public void setMano(ArrayList<Carta> mano) {
        this.mano = mano;
    }

    public Partida getJ1() {
        return j1;
    }

    public void setJ1(Partida j1) {
        this.j1 = j1;
    }

    public Partida getJ2() {
        return j2;
    }

    public void setJ2(Partida j2) {
        this.j2 = j2;
    }

    public boolean isSelecc1() {
        return selecc1;
    }

    public void setSelecc1(boolean selecc1) {
        this.selecc1 = selecc1;
    }

    public boolean isSelecc2() {
        return selecc2;
    }

    public void setSelecc2(boolean selecc2) {
        this.selecc2 = selecc2;
    }

    public boolean isSelecc3() {
        return selecc3;
    }

    public void setSelecc3(boolean selecc3) {
        this.selecc3 = selecc3;
    }

    public boolean isSelecc4() {
        return selecc4;
    }

    public void setSelecc4(boolean selecc4) {
        this.selecc4 = selecc4;
    }
    
    
    
    public FrmManoInicial(){
        initComponents();
    }
    public int cartaRandom(int c){
        Random  rnd = new Random();
        return (int) (rnd.nextDouble() * c + 0);
    }
    
    public void ponerCartas(Jugador j){
        int rand;
        for(int i =0; i<4; i++){
            rand= cartaRandom(j.getHero().getDeck().size()-1);
            Carta cartaMano =j.getHero().getDeck().get(rand);
            c1.add(String.valueOf(rand));
            String ruta = cartaMano.getRuta_Grande();
            if(turno ==false){
            mano.add(cartaMano);
            }
            else{
                mano2.add(cartaMano);
            }
            FrmDibujo logo4 = new FrmDibujo(ruta, 257, 355);
            if(i == 0){

            pnlCarta0.add(logo4);
            pnlCarta0.repaint();
            selecc1= true;
            }
            else if(i == 1){

            pnlCarta1.add(logo4);
            pnlCarta1.repaint();
            selecc2 = true;
            }
            else if(i == 2){

            pnlCarta2.add(logo4);
            pnlCarta2.repaint();
            selecc3 = true;
            }
            else if(i == 3){

            pnlCarta3.add(logo4);
            pnlCarta3.repaint();
            selecc4 = true;
            }

        }
    }
        
         public void cambiarCartas(int n, Jugador j){
        
        for(int i =0; i<n; i++){
            int rand=cartaRandom(j.getHero().getDeck().size()-1);
            Carta cartaMano =j.getHero().getDeck().get(rand);
            String ruta = cartaMano.getRuta_Grande();
            FrmDibujo logo4 = new FrmDibujo(ruta, 257, 355);
            
            if(selecc1 == false){
                if (turno == false){
                mano.remove(0);
                mano.add(0, cartaMano);
                }
                else{
                    mano2.remove(0);
                    mano2.add(0, cartaMano);
                }
            j.getHero().getDeck().remove(rand);
            pnlCarta0.removeAll();
            pnlCarta0.repaint();
            pnlCarta0.add(logo4);
            pnlCarta0.repaint();           
            selecc1= true;
            }
            
            else if(selecc2 == false){
             if (turno == false){
                mano.remove(1);
                mano.add(1, cartaMano);
                }
                else{
                    mano2.remove(1);
                    mano2.add(1, cartaMano);
                }
           j.getHero().getDeck().remove(rand);
            pnlCarta1.removeAll();
            pnlCarta1.repaint();
            pnlCarta1.add(logo4);
            pnlCarta1.repaint();
            selecc2 = true;
            
            }

            else if(selecc3 == false){
             if (turno == false){
                mano.remove(2);
                mano.add(2, cartaMano);
                }
                else{
                    mano2.remove(2);
                    mano2.add(2, cartaMano);
                }
            j.getHero().getDeck().remove(rand);
            pnlCarta2.removeAll();
            pnlCarta2.repaint();
            pnlCarta2.add(logo4);
            pnlCarta2.repaint();
            selecc3 = true;
            }
            
            else if(selecc4 == false){
            if (turno == false){
                mano.remove(3);
                mano.add(3, cartaMano);
                }
                else{
                    mano2.remove(3);
                    mano2.add(3, cartaMano);
                }
            j.getHero().getDeck().remove(rand);
            pnlCarta3.removeAll();
            pnlCarta2.repaint();
            pnlCarta3.add(logo4);
            pnlCarta3.repaint();
            selecc4 = true;
            }
            
        }               
  }
         

  public void tiempo(int n) {
    timer = new Timer();
    timer.schedule(new RemindTask(), n * 1000);
  }
   MtoPartida partida = new MtoPartida(j,jd); 
  
  public void tiempoAccion(){
      if(turno == false){
          turno = true;
          limpiar();
          JOptionPane.showMessageDialog(null,"Jugador 2");
          ponerCartas(jd);
      }
      else{
         
          
        FrmPartida p = new FrmPartida(j, mano, jd, mano2, partida);
       p.m=partida;
        p.setVisible(true);
        this.dispose();
      }
  }
  
  public void limpiar(){
      pnlCarta0.removeAll();
      pnlCarta0.add(pnlX1);
      pnlCarta1.removeAll();
      pnlCarta1.add(pnlX2);
      pnlCarta2.removeAll();
      pnlCarta2.add(pnlX3);
      pnlCarta3.removeAll();
      pnlCarta3.add(pnlX4);
      
      pnlX1.removeAll();
      pnlX2.removeAll();
      pnlX3.removeAll();
      pnlX4.removeAll();
      
      pnlX1.repaint();
      pnlX2.repaint();
      pnlX3.repaint();
      pnlX4.repaint();
      pnlCarta0.repaint();
      pnlCarta1.repaint();
      pnlCarta2.repaint();
      pnlCarta3.repaint();
  }
  
  class RemindTask extends TimerTask {
		public void run() {
                    tiempoAccion();			
		}
	}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlFondo = new javax.swing.JPanel();
        pnlPrincipal = new javax.swing.JPanel();
        pnlCarta0 = new javax.swing.JPanel();
        pnlX1 = new javax.swing.JPanel();
        pnlCarta1 = new javax.swing.JPanel();
        pnlX2 = new javax.swing.JPanel();
        pnlCarta2 = new javax.swing.JPanel();
        pnlX3 = new javax.swing.JPanel();
        pnlCarta3 = new javax.swing.JPanel();
        pnlX4 = new javax.swing.JPanel();
        pnlLogo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pnlConf = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hearthstone V1.0");
        setPreferredSize(new java.awt.Dimension(1366, 768));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlFondo.setOpaque(false);
        pnlFondo.setPreferredSize(new java.awt.Dimension(1366, 768));

        pnlPrincipal.setOpaque(false);

        pnlCarta0.setBackground(new java.awt.Color(0, 0, 0));
        pnlCarta0.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnlCarta0.setOpaque(false);
        pnlCarta0.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlCarta0MouseClicked(evt);
            }
        });

        pnlX1.setOpaque(false);

        javax.swing.GroupLayout pnlX1Layout = new javax.swing.GroupLayout(pnlX1);
        pnlX1.setLayout(pnlX1Layout);
        pnlX1Layout.setHorizontalGroup(
            pnlX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 217, Short.MAX_VALUE)
        );
        pnlX1Layout.setVerticalGroup(
            pnlX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlCarta0Layout = new javax.swing.GroupLayout(pnlCarta0);
        pnlCarta0.setLayout(pnlCarta0Layout);
        pnlCarta0Layout.setHorizontalGroup(
            pnlCarta0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCarta0Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlX1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlCarta0Layout.setVerticalGroup(
            pnlCarta0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCarta0Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlX1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlCarta1.setBackground(new java.awt.Color(0, 0, 0));
        pnlCarta1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnlCarta1.setOpaque(false);
        pnlCarta1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlCarta1MouseClicked(evt);
            }
        });

        pnlX2.setOpaque(false);

        javax.swing.GroupLayout pnlX2Layout = new javax.swing.GroupLayout(pnlX2);
        pnlX2.setLayout(pnlX2Layout);
        pnlX2Layout.setHorizontalGroup(
            pnlX2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 237, Short.MAX_VALUE)
        );
        pnlX2Layout.setVerticalGroup(
            pnlX2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlCarta1Layout = new javax.swing.GroupLayout(pnlCarta1);
        pnlCarta1.setLayout(pnlCarta1Layout);
        pnlCarta1Layout.setHorizontalGroup(
            pnlCarta1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCarta1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlX2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlCarta1Layout.setVerticalGroup(
            pnlCarta1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCarta1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlX2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlCarta2.setBackground(new java.awt.Color(0, 0, 0));
        pnlCarta2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnlCarta2.setOpaque(false);
        pnlCarta2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlCarta2MouseClicked(evt);
            }
        });

        pnlX3.setOpaque(false);

        javax.swing.GroupLayout pnlX3Layout = new javax.swing.GroupLayout(pnlX3);
        pnlX3.setLayout(pnlX3Layout);
        pnlX3Layout.setHorizontalGroup(
            pnlX3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 237, Short.MAX_VALUE)
        );
        pnlX3Layout.setVerticalGroup(
            pnlX3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlCarta2Layout = new javax.swing.GroupLayout(pnlCarta2);
        pnlCarta2.setLayout(pnlCarta2Layout);
        pnlCarta2Layout.setHorizontalGroup(
            pnlCarta2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCarta2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlX3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlCarta2Layout.setVerticalGroup(
            pnlCarta2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCarta2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlX3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlCarta3.setBackground(new java.awt.Color(0, 0, 0));
        pnlCarta3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnlCarta3.setOpaque(false);
        pnlCarta3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlCarta3MouseClicked(evt);
            }
        });

        pnlX4.setOpaque(false);

        javax.swing.GroupLayout pnlX4Layout = new javax.swing.GroupLayout(pnlX4);
        pnlX4.setLayout(pnlX4Layout);
        pnlX4Layout.setHorizontalGroup(
            pnlX4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 237, Short.MAX_VALUE)
        );
        pnlX4Layout.setVerticalGroup(
            pnlX4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 330, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlCarta3Layout = new javax.swing.GroupLayout(pnlCarta3);
        pnlCarta3.setLayout(pnlCarta3Layout);
        pnlCarta3Layout.setHorizontalGroup(
            pnlCarta3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCarta3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlX4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlCarta3Layout.setVerticalGroup(
            pnlCarta3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCarta3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlX4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlLogo.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Cambia o conserva tus cartas de la mano inicial");

        javax.swing.GroupLayout pnlLogoLayout = new javax.swing.GroupLayout(pnlLogo);
        pnlLogo.setLayout(pnlLogoLayout);
        pnlLogoLayout.setHorizontalGroup(
            pnlLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlLogoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );
        pnlLogoLayout.setVerticalGroup(
            pnlLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlLogoLayout.createSequentialGroup()
                .addContainerGap(89, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        pnlConf.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnlConf.setOpaque(false);
        pnlConf.setPreferredSize(new java.awt.Dimension(180, 115));
        pnlConf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlConfMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlConfLayout = new javax.swing.GroupLayout(pnlConf);
        pnlConf.setLayout(pnlConfLayout);
        pnlConfLayout.setHorizontalGroup(
            pnlConfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 126, Short.MAX_VALUE)
        );
        pnlConfLayout.setVerticalGroup(
            pnlConfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 64, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlPrincipalLayout = new javax.swing.GroupLayout(pnlPrincipal);
        pnlPrincipal.setLayout(pnlPrincipalLayout);
        pnlPrincipalLayout.setHorizontalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPrincipalLayout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(pnlCarta0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)
                        .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                                .addComponent(pnlCarta1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(63, 63, 63)
                                .addComponent(pnlCarta2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(pnlCarta3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(pnlLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlPrincipalLayout.createSequentialGroup()
                        .addGap(603, 603, 603)
                        .addComponent(pnlConf, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(109, Short.MAX_VALUE))
        );
        pnlPrincipalLayout.setVerticalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlCarta2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlCarta1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlCarta0, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlCarta3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addComponent(pnlConf, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(161, 161, 161))
        );

        javax.swing.GroupLayout pnlFondoLayout = new javax.swing.GroupLayout(pnlFondo);
        pnlFondo.setLayout(pnlFondoLayout);
        pnlFondoLayout.setHorizontalGroup(
            pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFondoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlFondoLayout.setVerticalGroup(
            pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFondoLayout.createSequentialGroup()
                .addComponent(pnlPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(pnlFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 770));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    FrmDibujo x = new FrmDibujo("/img/x.png", 217, 330);
    private void pnlCarta0MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlCarta0MouseClicked
        // TODO add your handling code here:
        if(selecc1 == true){
            selecc1= false;
            System.out.println(selecc1);
            pnlX1.add(x);
            pnlX1.repaint();
        }
        else{
            selecc1 =true;
            pnlX1.removeAll();
            pnlX1.repaint();
        }  
    }//GEN-LAST:event_pnlCarta0MouseClicked

    private void pnlCarta1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlCarta1MouseClicked
        // TODO add your handling code here:
        if(selecc2 == true){
            selecc2= false;
            pnlX2.add(x);
            pnlX2.repaint();
        }
        else{
            selecc2 =true;
            pnlX2.removeAll();
            pnlX2.repaint();
        }
    }//GEN-LAST:event_pnlCarta1MouseClicked

    private void pnlCarta2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlCarta2MouseClicked
        // TODO add your handling code here:
        if(selecc3 == true){
            selecc3= false;
            pnlX3.add(x);
            pnlX3.repaint();
        }
        else{
            selecc3 =true;
            pnlX3.removeAll();
            pnlX3.repaint();
        }
    }//GEN-LAST:event_pnlCarta2MouseClicked

    private void pnlCarta3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlCarta3MouseClicked
        // TODO add your handling code here:
        if(selecc4 == true){
            selecc4= false;
            pnlX4.add(x);
            pnlX4.repaint();
        }
        else{
            selecc4 =true;
            pnlX4.removeAll();
            pnlX4.repaint();
        }
    }//GEN-LAST:event_pnlCarta3MouseClicked

    private void pnlConfMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlConfMouseClicked
        // TODO add your handling code here:
         if(selecc1 == false||selecc2 == false || selecc3 == false || selecc4 == false){
            boolean seleccAux1 = selecc1, seleccAux2 = selecc2, seleccAux3 = selecc3, seleccAux4 = selecc4;
            int cont = 0;
            for(int i= 0; i <4; i++){
                 if(seleccAux1 == false){
                     cont++;
                     seleccAux1 =true;
                 }
                 else if(seleccAux2 == false){
                     cont++;
                     seleccAux2 =true;
                 }
                 else if(seleccAux3 == false){
                     cont++;
                     seleccAux3 =true;
                 }
                 else if(seleccAux4 == false){
                     cont++;
                     seleccAux4 =true;
                 }
            }
            if(turno == false){
                if(selecc1==true ){j.getHero().getDeck().remove(Integer.parseInt(getC1().get(0)));}
                if(selecc2==true ){j.getHero().getDeck().remove(Integer.parseInt(getC1().get(1)));}
                if(selecc3==true ){j.getHero().getDeck().remove(Integer.parseInt(getC1().get(2)));}
                if(selecc4==true ){j.getHero().getDeck().remove(Integer.parseInt(getC1().get(3)));}
                cambiarCartas(cont, j);
                tiempo(2);
                }
            else{
                
                if(selecc1==true ){jd.getHero().getDeck().remove(Integer.parseInt(getC1().get(0)));}
                if(selecc2==true ){jd.getHero().getDeck().remove(Integer.parseInt(getC1().get(1)));}
                if(selecc3==true ){jd.getHero().getDeck().remove(Integer.parseInt(getC1().get(2)));}
                if(selecc4==true ){jd.getHero().getDeck().remove(Integer.parseInt(getC1().get(3)));}
                cambiarCartas(cont, jd);
                tiempo(2);
                }
            }
        else{
            if(turno == false){            
                j.getHero().getDeck().remove(Integer.parseInt(getC1().get(0)));
                j.getHero().getDeck().remove(Integer.parseInt(getC1().get(1)));
                j.getHero().getDeck().remove(Integer.parseInt(getC1().get(2)));
                j.getHero().getDeck().remove(Integer.parseInt(getC1().get(3)));
                limpiar();
                turno = true;
                ponerCartas(jd);
                
            }
            else{
            jd.getHero().getDeck().remove(Integer.parseInt(getC1().get(0)));
            jd.getHero().getDeck().remove(Integer.parseInt(getC1().get(1)));
            jd.getHero().getDeck().remove(Integer.parseInt(getC1().get(2)));
            jd.getHero().getDeck().remove(Integer.parseInt(getC1().get(3)));
            FrmPartida p = new FrmPartida(j, mano, jd, mano2, partida );
            p.setVisible(true);
            this.dispose();
            }
        }
    }//GEN-LAST:event_pnlConfMouseClicked

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
            java.util.logging.Logger.getLogger(FrmManoInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmManoInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmManoInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmManoInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmManoInicial().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel pnlCarta0;
    private javax.swing.JPanel pnlCarta1;
    private javax.swing.JPanel pnlCarta2;
    private javax.swing.JPanel pnlCarta3;
    private javax.swing.JPanel pnlConf;
    private javax.swing.JPanel pnlFondo;
    private javax.swing.JPanel pnlLogo;
    private javax.swing.JPanel pnlPrincipal;
    private javax.swing.JPanel pnlX1;
    private javax.swing.JPanel pnlX2;
    private javax.swing.JPanel pnlX3;
    private javax.swing.JPanel pnlX4;
    // End of variables declaration//GEN-END:variables
}
