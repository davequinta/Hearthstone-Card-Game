/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import Clases_Principales.*;
import hearthstone.FrmDibujo;
import java.applet.AudioClip;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author Dave
 */
public class FrmChoose extends javax.swing.JFrame {
public Jugador j1=null;
public Jugador j2=null;
public ArrayList<Carta> deck=null;
public ArrayList<Carta> deckd=null;
boolean bandera = false;


    

    /**
     * Creates new form FrmChoose
     */
    public FrmChoose() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        AudioClip sonido;
        sonido = java.applet.Applet.newAudioClip(getClass().getResource("/sounds/login.wav"));
        sonido.play();
        Image icono;
        icono = new ImageIcon(getClass().getResource("/img/logo.png")).getImage();
        this.setIconImage(icono);
        
        FrmDibujo fondo = new FrmDibujo("/img/fondo_choose.png", 1366, 768);
        this.pnlFondo.add(fondo);
        this.pnlFondo.repaint();
        FrmDibujo deck1 = new FrmDibujo("/img/hunter_deck1.png", 212, 200);
        this.pnlDeck1.add(deck1);
        this.pnlDeck1.repaint();
       
        FrmDibujo deck2 = new FrmDibujo("/img/hunter_deck2.png", 212, 200);
        this.pnlDeck2.add(deck2);
        this.pnlDeck2.repaint();
        
        FrmDibujo deck3 = new FrmDibujo("/img/paladin_deck1.png", 212, 200);
        this.pnlDeck3.add(deck3);
        this.pnlDeck3.repaint();
        
        FrmDibujo deck4 = new FrmDibujo("/img/paladin_deck2.png", 212, 200);
        this.pnlDeck4.add(deck4);
        this.pnlDeck4.repaint();
      
     
    }
   
    private void cleanSelected(){
        this.pnlSelected1.removeAll();
        this.pnlSelected1.repaint();
        this.pnlSelected2.removeAll();
        this.pnlSelected2.repaint();
        this.pnlSelected3.removeAll();
        this.pnlSelected3.repaint();
        this.pnlSelected4.removeAll();
        this.pnlSelected4.repaint();
    }
    
    private void selected(int opc){
        Heroe h = new Heroe();
        
        if(opc == 1 || opc ==2){
            h.setNombre_hero("Rexxar");
            h.setTipo_heroe("Hunter");
            h.setPoder_hero("Disparomortal");

        }
        else{
            h.setNombre_hero("Uther");
            h.setTipo_heroe("Paladin");
            h.setPoder_hero("Invocamini");
            
          
        }
        
        switch(opc){
            case 1: 
                 FrmDibujo selected1 = new FrmDibujo("/img/hunter_deck2Slc.png", 187, 96);
                 this.pnlSelected1.add(selected1);
                 this.pnlSelected1.repaint();
                 deck = Admin.consultCartas("MilerHunter");
                 if(!bandera){
                     lblDeck1.setText("Miller Lite");
                 }
                 else{
                      lblDeck2.setText("Miller Lite");
                 }
            
                 break;
            case 2:
               
                FrmDibujo selected2 = new FrmDibujo("/img/hunter_deck1Slc.png", 187, 96);
                this.pnlSelected2.add(selected2);
                this.pnlSelected2.repaint();
                
                deck = Admin.consultCartas("BasicHunter");
                if(!bandera){
                     lblDeck1.setText("Basic Hunter");
                 }
                 else{
                      lblDeck2.setText("Basic Hunter");
                 }
              
                 break;
            case 3:
                FrmDibujo selected3 = new FrmDibujo("/img/paladin_deck2Slc.png", 187, 96);
                this.pnlSelected3.add(selected3);
                this.pnlSelected3.repaint();
                 
                deck = Admin.consultCartas("ClassicPaladin");
                if(!bandera){
                     lblDeck1.setText("Classic Paladin");
                 }
                 else{
                      lblDeck2.setText("Classic Paladin");
                 }
                
                break;
            case 4:
                FrmDibujo selected4 = new FrmDibujo("/img/paladin_deck1Slc.png", 187, 96);
                this.pnlSelected4.add(selected4);
                this.pnlSelected4.repaint();
                
                deck = Admin.consultCartas("JusticePaladin");
              
                if(!bandera){
                     lblDeck1.setText("Justice & Honor");
                 }
                 else{
                      lblDeck2.setText("Justice & Honor");
                 }
                break;
            default:
                System.out.println("Error...");

        }
        h.setDeck(deck);
        if (!bandera){
          j1.setHero(h);  
        }else{
          j2.setHero(h);  
        }
        
        
        
    }
    
    private void btnPlay(){
        FrmDibujo btn = new FrmDibujo("/img/btnPlay.png", 179, 173);
        this.pnlPlay.add(btn);
        this.pnlPlay.repaint();
    }
    private void paintPaladin(){
        lblHeroe.setText("Uther");
        this.pnlHeroe.removeAll();
        FrmDibujo hero = new FrmDibujo("/img/paladin2.gif", 260, 300);
        this.pnlHeroe.add(hero);
        this.pnlHeroe.repaint();
        btnPlay();
    }
    private void paintHunter(){
        lblHeroe.setText("Rexxar");
        this.pnlHeroe.removeAll();
        FrmDibujo hero = new FrmDibujo("/img/hunter2.gif", 260, 300);
        this.pnlHeroe.add(hero);
        this.pnlHeroe.repaint();
        btnPlay();
    }
    public void setNplayers(Jugador j1, Jugador j2){
        lblPlayer1.setText(j1.getNombreUsuario()+":");
        lblPlayer2.setText(j2.getNombreUsuario()+":");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlFondo = new javax.swing.JPanel();
        pnlHeroe = new javax.swing.JPanel();
        pnlDeck1 = new javax.swing.JPanel();
        pnlSelected2 = new javax.swing.JPanel();
        pnlDeck2 = new javax.swing.JPanel();
        pnlDeck3 = new javax.swing.JPanel();
        pnlSelected4 = new javax.swing.JPanel();
        pnlDeck4 = new javax.swing.JPanel();
        pnlSelected3 = new javax.swing.JPanel();
        lblHeroe = new javax.swing.JLabel();
        pnlPlay = new javax.swing.JPanel();
        pnlSelected1 = new javax.swing.JPanel();
        pnlDeckView = new javax.swing.JPanel();
        lblPlayer1 = new javax.swing.JLabel();
        lblDeck2 = new javax.swing.JLabel();
        lblPlayer2 = new javax.swing.JLabel();
        lblDeck1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hearthstone LITE V1.1");
        setPreferredSize(new java.awt.Dimension(1366, 768));
        setResizable(false);

        pnlFondo.setBackground(new java.awt.Color(102, 204, 255));
        pnlFondo.setPreferredSize(new java.awt.Dimension(1366, 768));

        pnlHeroe.setBackground(new java.awt.Color(255, 51, 51));
        pnlHeroe.setOpaque(false);
        pnlHeroe.setPreferredSize(new java.awt.Dimension(260, 300));

        javax.swing.GroupLayout pnlHeroeLayout = new javax.swing.GroupLayout(pnlHeroe);
        pnlHeroe.setLayout(pnlHeroeLayout);
        pnlHeroeLayout.setHorizontalGroup(
            pnlHeroeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 288, Short.MAX_VALUE)
        );
        pnlHeroeLayout.setVerticalGroup(
            pnlHeroeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 295, Short.MAX_VALUE)
        );

        pnlDeck1.setBackground(new java.awt.Color(255, 0, 102));
        pnlDeck1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnlDeck1.setOpaque(false);
        pnlDeck1.setPreferredSize(new java.awt.Dimension(212, 200));
        pnlDeck1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlDeck1MouseClicked(evt);
            }
        });

        pnlSelected2.setOpaque(false);

        javax.swing.GroupLayout pnlSelected2Layout = new javax.swing.GroupLayout(pnlSelected2);
        pnlSelected2.setLayout(pnlSelected2Layout);
        pnlSelected2Layout.setHorizontalGroup(
            pnlSelected2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 187, Short.MAX_VALUE)
        );
        pnlSelected2Layout.setVerticalGroup(
            pnlSelected2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 86, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlDeck1Layout = new javax.swing.GroupLayout(pnlDeck1);
        pnlDeck1.setLayout(pnlDeck1Layout);
        pnlDeck1Layout.setHorizontalGroup(
            pnlDeck1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDeck1Layout.createSequentialGroup()
                .addGap(0, 25, Short.MAX_VALUE)
                .addComponent(pnlSelected2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlDeck1Layout.setVerticalGroup(
            pnlDeck1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDeck1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(pnlSelected2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(80, Short.MAX_VALUE))
        );

        pnlDeck2.setBackground(new java.awt.Color(255, 0, 102));
        pnlDeck2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnlDeck2.setOpaque(false);
        pnlDeck2.setPreferredSize(new java.awt.Dimension(212, 200));
        pnlDeck2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlDeck2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlDeck2Layout = new javax.swing.GroupLayout(pnlDeck2);
        pnlDeck2.setLayout(pnlDeck2Layout);
        pnlDeck2Layout.setHorizontalGroup(
            pnlDeck2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 212, Short.MAX_VALUE)
        );
        pnlDeck2Layout.setVerticalGroup(
            pnlDeck2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );

        pnlDeck3.setBackground(new java.awt.Color(255, 0, 102));
        pnlDeck3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnlDeck3.setOpaque(false);
        pnlDeck3.setPreferredSize(new java.awt.Dimension(212, 200));
        pnlDeck3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlDeck3MouseClicked(evt);
            }
        });

        pnlSelected4.setOpaque(false);

        javax.swing.GroupLayout pnlSelected4Layout = new javax.swing.GroupLayout(pnlSelected4);
        pnlSelected4.setLayout(pnlSelected4Layout);
        pnlSelected4Layout.setHorizontalGroup(
            pnlSelected4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 187, Short.MAX_VALUE)
        );
        pnlSelected4Layout.setVerticalGroup(
            pnlSelected4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 97, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlDeck3Layout = new javax.swing.GroupLayout(pnlDeck3);
        pnlDeck3.setLayout(pnlDeck3Layout);
        pnlDeck3Layout.setHorizontalGroup(
            pnlDeck3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDeck3Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(pnlSelected4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlDeck3Layout.setVerticalGroup(
            pnlDeck3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDeck3Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(pnlSelected4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(67, Short.MAX_VALUE))
        );

        pnlDeck4.setBackground(new java.awt.Color(255, 0, 102));
        pnlDeck4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnlDeck4.setOpaque(false);
        pnlDeck4.setPreferredSize(new java.awt.Dimension(212, 200));
        pnlDeck4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlDeck4MouseClicked(evt);
            }
        });

        pnlSelected3.setOpaque(false);

        javax.swing.GroupLayout pnlSelected3Layout = new javax.swing.GroupLayout(pnlSelected3);
        pnlSelected3.setLayout(pnlSelected3Layout);
        pnlSelected3Layout.setHorizontalGroup(
            pnlSelected3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 192, Short.MAX_VALUE)
        );
        pnlSelected3Layout.setVerticalGroup(
            pnlSelected3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 86, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlDeck4Layout = new javax.swing.GroupLayout(pnlDeck4);
        pnlDeck4.setLayout(pnlDeck4Layout);
        pnlDeck4Layout.setHorizontalGroup(
            pnlDeck4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDeck4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlSelected3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlDeck4Layout.setVerticalGroup(
            pnlDeck4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDeck4Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(pnlSelected3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(83, Short.MAX_VALUE))
        );

        lblHeroe.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblHeroe.setForeground(new java.awt.Color(255, 255, 255));
        lblHeroe.setText("          ");

        pnlPlay.setBackground(new java.awt.Color(0, 204, 51));
        pnlPlay.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnlPlay.setOpaque(false);
        pnlPlay.setPreferredSize(new java.awt.Dimension(179, 173));
        pnlPlay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlPlayMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlPlayLayout = new javax.swing.GroupLayout(pnlPlay);
        pnlPlay.setLayout(pnlPlayLayout);
        pnlPlayLayout.setHorizontalGroup(
            pnlPlayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 179, Short.MAX_VALUE)
        );
        pnlPlayLayout.setVerticalGroup(
            pnlPlayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 173, Short.MAX_VALUE)
        );

        pnlSelected1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnlSelected1.setOpaque(false);

        javax.swing.GroupLayout pnlSelected1Layout = new javax.swing.GroupLayout(pnlSelected1);
        pnlSelected1.setLayout(pnlSelected1Layout);
        pnlSelected1Layout.setHorizontalGroup(
            pnlSelected1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 196, Short.MAX_VALUE)
        );
        pnlSelected1Layout.setVerticalGroup(
            pnlSelected1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 97, Short.MAX_VALUE)
        );

        pnlDeckView.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnlDeckView.setOpaque(false);
        pnlDeckView.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlDeckViewMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlDeckViewLayout = new javax.swing.GroupLayout(pnlDeckView);
        pnlDeckView.setLayout(pnlDeckViewLayout);
        pnlDeckViewLayout.setHorizontalGroup(
            pnlDeckViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 237, Short.MAX_VALUE)
        );
        pnlDeckViewLayout.setVerticalGroup(
            pnlDeckViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 35, Short.MAX_VALUE)
        );

        lblPlayer1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblPlayer1.setForeground(new java.awt.Color(255, 255, 255));
        lblPlayer1.setText("Player 1:");

        lblDeck2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblDeck2.setForeground(new java.awt.Color(255, 255, 255));
        lblDeck2.setText("                               ");

        lblPlayer2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblPlayer2.setForeground(new java.awt.Color(255, 255, 255));
        lblPlayer2.setText("Player 2:");

        lblDeck1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblDeck1.setForeground(new java.awt.Color(255, 255, 255));
        lblDeck1.setText("                               ");

        javax.swing.GroupLayout pnlFondoLayout = new javax.swing.GroupLayout(pnlFondo);
        pnlFondo.setLayout(pnlFondoLayout);
        pnlFondoLayout.setHorizontalGroup(
            pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFondoLayout.createSequentialGroup()
                .addContainerGap(287, Short.MAX_VALUE)
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFondoLayout.createSequentialGroup()
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlFondoLayout.createSequentialGroup()
                                .addComponent(pnlDeck4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(52, 52, 52))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFondoLayout.createSequentialGroup()
                                .addComponent(pnlSelected1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60)))
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnlDeck3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnlDeck1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFondoLayout.createSequentialGroup()
                        .addComponent(pnlDeckView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(127, 127, 127)))
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFondoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 151, Short.MAX_VALUE)
                        .addComponent(pnlPlay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(273, 273, 273))
                    .addGroup(pnlFondoLayout.createSequentialGroup()
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnlFondoLayout.createSequentialGroup()
                                .addGap(210, 210, 210)
                                .addComponent(lblHeroe))
                            .addGroup(pnlFondoLayout.createSequentialGroup()
                                .addGap(97, 97, 97)
                                .addComponent(pnlHeroe, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlFondoLayout.createSequentialGroup()
                                .addGap(120, 120, 120)
                                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblPlayer2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblPlayer1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblDeck2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblDeck1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlFondoLayout.createSequentialGroup()
                    .addGap(284, 284, 284)
                    .addComponent(pnlDeck2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(870, Short.MAX_VALUE)))
        );
        pnlFondoLayout.setVerticalGroup(
            pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFondoLayout.createSequentialGroup()
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlFondoLayout.createSequentialGroup()
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlFondoLayout.createSequentialGroup()
                                .addGap(128, 128, 128)
                                .addComponent(pnlDeck1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlFondoLayout.createSequentialGroup()
                                .addGap(158, 158, 158)
                                .addComponent(pnlSelected1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(70, 70, 70)
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnlDeck3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnlDeck4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(76, 76, 76)
                        .addComponent(pnlDeckView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlFondoLayout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPlayer1)
                            .addComponent(lblDeck1))
                        .addGap(18, 18, 18)
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPlayer2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblDeck2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pnlHeroe, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblHeroe)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnlPlay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(91, Short.MAX_VALUE))
            .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlFondoLayout.createSequentialGroup()
                    .addGap(129, 129, 129)
                    .addComponent(pnlDeck2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(439, Short.MAX_VALUE)))
        );

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
                .addComponent(pnlFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pnlDeck2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlDeck2MouseClicked
        // TODO add your handling code here:
        //Miller LITE
        paintHunter();
        cleanSelected();
        selected(1);
        
        
    }//GEN-LAST:event_pnlDeck2MouseClicked

    private void pnlDeck1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlDeck1MouseClicked
        // TODO add your handling code here:
        //Basic Hunter
         paintHunter();
         cleanSelected();
         selected(2);
    }//GEN-LAST:event_pnlDeck1MouseClicked

    private void pnlDeck4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlDeck4MouseClicked
        // TODO add your handling code here:
        //Classic Paladin
        paintPaladin();
        cleanSelected();
        selected(3);
    }//GEN-LAST:event_pnlDeck4MouseClicked

    private void pnlDeck3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlDeck3MouseClicked
        // TODO add your handling code here:
        //Justice & honor
         paintPaladin();
         cleanSelected();
         selected(4);
    }//GEN-LAST:event_pnlDeck3MouseClicked

    private void pnlPlayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlPlayMouseClicked
        // TODO add your handling code here:
        
        /*System.out.println(j1.getNombreUsuario());
        System.out.println(j1.getHero().getNombre_hero());
        System.out.println(j1.getHero().getDeck().size());
        for(Carta e: j1.getHero().getDeck()){
                System.out.println(e.getNombre());
        }*/
        
        //
        //obj.setVisible(true);
        //this.dispose();
        
        if(bandera==false){
           
            bandera=true;
            cleanSelected();
            this.pnlPlay.removeAll();
            this.pnlPlay.repaint();
            this.pnlHeroe.removeAll();
            this.pnlHeroe.repaint();
          
            lblHeroe.setText("");
            
            
        }else{
            FrmManoInicial obj= new FrmManoInicial(j1,j2);
          
            obj.setVisible(true);
            this.dispose();
            
        }
        
    }//GEN-LAST:event_pnlPlayMouseClicked

    private void pnlDeckViewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlDeckViewMouseClicked
        // TODO add your handling code here:
      FrmDeckView obj = new FrmDeckView();
      obj.fc=this;
      obj.setVisible(true);
      this.dispose();
        
    }//GEN-LAST:event_pnlDeckViewMouseClicked

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
            java.util.logging.Logger.getLogger(FrmChoose.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmChoose.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmChoose.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmChoose.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmChoose().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblDeck1;
    private javax.swing.JLabel lblDeck2;
    private javax.swing.JLabel lblHeroe;
    private javax.swing.JLabel lblPlayer1;
    private javax.swing.JLabel lblPlayer2;
    private javax.swing.JPanel pnlDeck1;
    private javax.swing.JPanel pnlDeck2;
    private javax.swing.JPanel pnlDeck3;
    private javax.swing.JPanel pnlDeck4;
    private javax.swing.JPanel pnlDeckView;
    private javax.swing.JPanel pnlFondo;
    private javax.swing.JPanel pnlHeroe;
    private javax.swing.JPanel pnlPlay;
    private javax.swing.JPanel pnlSelected1;
    private javax.swing.JPanel pnlSelected2;
    private javax.swing.JPanel pnlSelected3;
    private javax.swing.JPanel pnlSelected4;
    // End of variables declaration//GEN-END:variables
}
