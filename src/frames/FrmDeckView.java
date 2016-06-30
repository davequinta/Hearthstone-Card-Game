/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import Clases_Principales.Admin;
import Clases_Principales.Carta;
import hearthstone.FrmDibujo;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author Dave
 */
public class FrmDeckView extends javax.swing.JFrame {
    //public int opc=1;
    FrmChoose fc;
    ArrayList<Carta> d1 = Admin.consultCartas("MilerHunter");
    ArrayList<Carta> d2 = Admin.consultCartas("BasicHunter");
    ArrayList<Carta> d3 = Admin.consultCartas("ClassicPaladin");
    ArrayList<Carta> d4 = Admin.consultCartas("JusticePaladin");
    /*
    public void setOpc(int opc) {
        this.opc = opc;
    }
    */
    
    /**
     * Creates new form FrmDeckView
     */
    public FrmDeckView() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        
        Image icono;
        icono = new ImageIcon(getClass().getResource("/img/logo.png")).getImage();
        this.setIconImage(icono);
        
        FrmDibujo fondo = new FrmDibujo("/img/fondo_deckview.png", 1366, 768);
        this.pnlFondo.add(fondo);
        this.pnlFondo.repaint();
        selected(1);
        
   
         
    }
    private void cleanPanels(){
       this.pnlSelect1.removeAll();
       this.pnlSelect1.repaint();
       this.pnlSelect2.removeAll();
       this.pnlSelect2.repaint();
       this.pnlSelect3.removeAll();
       this.pnlSelect3.repaint();
       this.pnlSelect4.removeAll();
       this.pnlSelect4.repaint();
       this.pnlCard1.removeAll();
       this.pnlCard1.repaint();
       this.pnlCard2.removeAll();
       this.pnlCard2.repaint(); 
       this.pnlCard3.removeAll();
       this.pnlCard3.repaint();
       this.pnlCard4.removeAll();
       this.pnlCard4.repaint();
       this.pnlCard6.removeAll();
       this.pnlCard6.repaint();
       this.pnlCard7.removeAll();
       this.pnlCard7.repaint();
       this.pnlCard8.removeAll();
       this.pnlCard8.repaint();
       this.pnlCard9.removeAll();
       this.pnlCard9.repaint();
       this.pnlCard10.removeAll();
       this.pnlCard10.repaint();
       this.pnlCard11.removeAll();
       this.pnlCard11.repaint();
       this.pnlCard12.removeAll();
       this.pnlCard12.repaint();
       this.pnlCard13.removeAll();
       this.pnlCard13.repaint();
       this.pnlCard14.removeAll();
       this.pnlCard14.repaint();
       this.pnlCard15.removeAll();
       this.pnlCard15.repaint();
       this.pnlCard16.removeAll();
       this.pnlCard16.repaint();
       this.pnlCard17.removeAll();
       this.pnlCard17.repaint();
       this.pnlCard18.removeAll();
       this.pnlCard18.repaint();
       this.pnlCard19.removeAll();
       this.pnlCard19.repaint();
       this.pnlCard20.removeAll();
       this.pnlCard20.repaint();
       this.pnlCard21.removeAll();
       this.pnlCard21.repaint();
       this.pnlCard22.removeAll();
       this.pnlCard22.repaint();
       this.pnlCard23.removeAll();
       this.pnlCard23.repaint();
       this.pnlCard24.removeAll();
       this.pnlCard24.repaint();
       this.pnlCard25.removeAll();
       this.pnlCard25.repaint();
       this.pnlCard26.removeAll();
       this.pnlCard26.repaint();
       this.pnlCard27.removeAll();
       this.pnlCard27.repaint();
       this.pnlCard28.removeAll();
       this.pnlCard28.repaint();
       this.pnlCard29.removeAll();
       this.pnlCard29.repaint();
       this.pnlCard30.removeAll();
       this.pnlCard30.repaint();
       this.pnlCard31.removeAll();
       this.pnlCard31.repaint();
    }
    
    private void selected(int opc){
        
        if(opc==1 || opc==2){
                lblHeroe.setText("Uther");
            }
        else{
                lblHeroe.setText("Rexxar");
        }
        
        
        switch(opc){
            case 1:
                FrmDibujo selected1 = new FrmDibujo("/img/paladin_deck2Slc.png",180,87);
                this.pnlSelect1.add(selected1);
                this.pnlSelect1.repaint();
                fillCards(d3);
                 pnlContenedor.setSelectedIndex(0);
                 
                break;
            case 2:
                FrmDibujo selected2 = new FrmDibujo("/img/paladin_deck1Slc.png",180,87);
                this.pnlSelect2.add(selected2);
                this.pnlSelect2.repaint();
                fillCards(d4);
                 pnlContenedor.setSelectedIndex(0);
                break;
            case 3:
                FrmDibujo selected3 = new FrmDibujo("/img/hunter_deck2Slc.png",180,82);
                this.pnlSelect3.add(selected3);
                this.pnlSelect3.repaint();
                fillCards(d1);
                pnlContenedor.setSelectedIndex(0);
                break;
            case 4:
                FrmDibujo selected4 = new FrmDibujo("/img/hunter_deck1Slc.png",180,82);
                this.pnlSelect4.add(selected4);
                this.pnlSelect4.repaint();
                pnlContenedor.setSelectedIndex(0);
                fillCards(d2);
                break;
                
            default:
                System.out.println("Error-------");
                
            
    
        }
    }
    
    private void fillCards(ArrayList<Carta> deck){
      
        
        FrmDibujo c1 = new FrmDibujo(deck.get(0).getRuta_Grande(), 160, 245);
        this.pnlCard1.add(c1);
        this.pnlCard1.repaint();
        
        FrmDibujo c2 = new FrmDibujo(deck.get(1).getRuta_Grande(), 160, 245);
        this.pnlCard2.add(c2);
        this.pnlCard2.repaint();
        
        FrmDibujo c3 = new FrmDibujo(deck.get(2).getRuta_Grande(), 160, 245);
        this.pnlCard3.add(c3);
        this.pnlCard3.repaint();
        
        FrmDibujo c4 = new FrmDibujo(deck.get(3).getRuta_Grande(), 160, 245);
        this.pnlCard4.add(c4);
        this.pnlCard4.repaint();
        
        FrmDibujo c6 = new FrmDibujo(deck.get(4).getRuta_Grande(), 160, 245);
        this.pnlCard6.add(c6);
        this.pnlCard6.repaint();
        
        FrmDibujo c7 = new FrmDibujo(deck.get(5).getRuta_Grande(), 160, 245);
        this.pnlCard7.add(c7);
        this.pnlCard7.repaint();
        
        FrmDibujo c8 = new FrmDibujo(deck.get(6).getRuta_Grande(), 160, 245);
        this.pnlCard8.add(c8);
        this.pnlCard8.repaint();
        
        FrmDibujo c9 = new FrmDibujo(deck.get(7).getRuta_Grande(), 160, 245);
        this.pnlCard9.add(c9);
        this.pnlCard9.repaint();
        
        FrmDibujo c10 = new FrmDibujo(deck.get(8).getRuta_Grande(), 160, 245);
        this.pnlCard10.add(c10);
        this.pnlCard10.repaint();
        
        FrmDibujo c11 = new FrmDibujo(deck.get(9).getRuta_Grande(), 160, 245);
        this.pnlCard11.add(c11);
        this.pnlCard11.repaint();
        
        FrmDibujo c12 = new FrmDibujo(deck.get(10).getRuta_Grande(), 160, 245);
        this.pnlCard12.add(c12);
        this.pnlCard12.repaint();
        
        FrmDibujo c13 = new FrmDibujo(deck.get(11).getRuta_Grande(), 160, 245);
        this.pnlCard13.add(c13);
        this.pnlCard13.repaint();
        
        FrmDibujo c14 = new FrmDibujo(deck.get(12).getRuta_Grande(), 160, 245);
        this.pnlCard14.add(c14);
        this.pnlCard14.repaint();
        
        FrmDibujo c15 = new FrmDibujo(deck.get(13).getRuta_Grande(), 160, 245);
        this.pnlCard15.add(c15);
        this.pnlCard15.repaint();
        
        FrmDibujo c16 = new FrmDibujo(deck.get(14).getRuta_Grande(), 160, 245);
        this.pnlCard16.add(c16);
        this.pnlCard16.repaint();
        
        FrmDibujo c17 = new FrmDibujo(deck.get(15).getRuta_Grande(), 160, 245);
        this.pnlCard17.add(c17);
        this.pnlCard17.repaint();
        
        FrmDibujo c18 = new FrmDibujo(deck.get(16).getRuta_Grande(), 160, 245);
        this.pnlCard18.add(c18);
        this.pnlCard18.repaint();
        
        FrmDibujo c19 = new FrmDibujo(deck.get(17).getRuta_Grande(), 160, 245);
        this.pnlCard19.add(c19);
        this.pnlCard19.repaint();
        
        FrmDibujo c20 = new FrmDibujo(deck.get(18).getRuta_Grande(), 160, 245);
        this.pnlCard20.add(c20);
        this.pnlCard20.repaint();
        
        FrmDibujo c21 = new FrmDibujo(deck.get(19).getRuta_Grande(), 160, 245);
        this.pnlCard21.add(c21);
        this.pnlCard21.repaint();
        
        FrmDibujo c22 = new FrmDibujo(deck.get(20).getRuta_Grande(), 160, 245);
        this.pnlCard22.add(c22);
        this.pnlCard22.repaint();
        
        FrmDibujo c23 = new FrmDibujo(deck.get(21).getRuta_Grande(), 160, 245);
        this.pnlCard23.add(c23);
        this.pnlCard23.repaint();
        
        FrmDibujo c24 = new FrmDibujo(deck.get(22).getRuta_Grande(), 160, 245);
        this.pnlCard24.add(c24);
        this.pnlCard24.repaint();
        
        FrmDibujo c25 = new FrmDibujo(deck.get(23).getRuta_Grande(), 160, 245);
        this.pnlCard25.add(c25);
        this.pnlCard25.repaint();
        
        FrmDibujo c26 = new FrmDibujo(deck.get(24).getRuta_Grande(), 160, 245);
        this.pnlCard26.add(c26);
        this.pnlCard26.repaint();
        
        FrmDibujo c27 = new FrmDibujo(deck.get(25).getRuta_Grande(), 160, 245);
        this.pnlCard27.add(c27);
        this.pnlCard27.repaint();
        
        FrmDibujo c28 = new FrmDibujo(deck.get(26).getRuta_Grande(), 160, 245);
        this.pnlCard28.add(c28);
        this.pnlCard28.repaint();
        
        FrmDibujo c29 = new FrmDibujo(deck.get(27).getRuta_Grande(), 160, 245);
        this.pnlCard29.add(c29);
        this.pnlCard29.repaint();
        
        FrmDibujo c30 = new FrmDibujo(deck.get(28).getRuta_Grande(), 160, 245);
        this.pnlCard30.add(c30);
        this.pnlCard30.repaint();
        
        FrmDibujo c31 = new FrmDibujo(deck.get(29).getRuta_Grande(), 160, 245);
        this.pnlCard31.add(c31);
        this.pnlCard31.repaint();
        
        
    
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
        pnlContenedor = new javax.swing.JTabbedPane();
        pnlPage1 = new javax.swing.JPanel();
        pnlCard1 = new javax.swing.JPanel();
        pnlCard2 = new javax.swing.JPanel();
        pnlCard3 = new javax.swing.JPanel();
        pnlCard4 = new javax.swing.JPanel();
        pnlCard6 = new javax.swing.JPanel();
        pnlCard7 = new javax.swing.JPanel();
        pnlCard8 = new javax.swing.JPanel();
        pnlCard9 = new javax.swing.JPanel();
        pnlPage2 = new javax.swing.JPanel();
        pnlCard10 = new javax.swing.JPanel();
        pnlCard11 = new javax.swing.JPanel();
        pnlCard12 = new javax.swing.JPanel();
        pnlCard13 = new javax.swing.JPanel();
        pnlCard14 = new javax.swing.JPanel();
        pnlCard15 = new javax.swing.JPanel();
        pnlCard16 = new javax.swing.JPanel();
        pnlCard17 = new javax.swing.JPanel();
        pnlPage3 = new javax.swing.JPanel();
        pnlCard18 = new javax.swing.JPanel();
        pnlCard19 = new javax.swing.JPanel();
        pnlCard20 = new javax.swing.JPanel();
        pnlCard21 = new javax.swing.JPanel();
        pnlCard22 = new javax.swing.JPanel();
        pnlCard23 = new javax.swing.JPanel();
        pnlCard24 = new javax.swing.JPanel();
        pnlCard25 = new javax.swing.JPanel();
        pnlPage4 = new javax.swing.JPanel();
        pnlCard26 = new javax.swing.JPanel();
        pnlCard27 = new javax.swing.JPanel();
        pnlCard28 = new javax.swing.JPanel();
        pnlCard29 = new javax.swing.JPanel();
        pnlCard30 = new javax.swing.JPanel();
        pnlCard31 = new javax.swing.JPanel();
        pnlSelect1 = new javax.swing.JPanel();
        pnlSelect4 = new javax.swing.JPanel();
        pnlSelect2 = new javax.swing.JPanel();
        pnlSelect3 = new javax.swing.JPanel();
        pnlBack = new javax.swing.JPanel();
        lblHeroe = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hearthstone V 1.1");
        setPreferredSize(new java.awt.Dimension(1366, 795));
        setResizable(false);

        pnlFondo.setBackground(new java.awt.Color(0, 204, 204));
        pnlFondo.setPreferredSize(new java.awt.Dimension(1366, 800));

        pnlContenedor.setPreferredSize(new java.awt.Dimension(700, 700));

        pnlPage1.setOpaque(false);

        pnlCard1.setBackground(new java.awt.Color(51, 51, 255));
        pnlCard1.setOpaque(false);

        javax.swing.GroupLayout pnlCard1Layout = new javax.swing.GroupLayout(pnlCard1);
        pnlCard1.setLayout(pnlCard1Layout);
        pnlCard1Layout.setHorizontalGroup(
            pnlCard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 156, Short.MAX_VALUE)
        );
        pnlCard1Layout.setVerticalGroup(
            pnlCard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pnlCard2.setBackground(new java.awt.Color(51, 51, 255));
        pnlCard2.setOpaque(false);

        javax.swing.GroupLayout pnlCard2Layout = new javax.swing.GroupLayout(pnlCard2);
        pnlCard2.setLayout(pnlCard2Layout);
        pnlCard2Layout.setHorizontalGroup(
            pnlCard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 156, Short.MAX_VALUE)
        );
        pnlCard2Layout.setVerticalGroup(
            pnlCard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 234, Short.MAX_VALUE)
        );

        pnlCard3.setBackground(new java.awt.Color(51, 51, 255));
        pnlCard3.setOpaque(false);

        javax.swing.GroupLayout pnlCard3Layout = new javax.swing.GroupLayout(pnlCard3);
        pnlCard3.setLayout(pnlCard3Layout);
        pnlCard3Layout.setHorizontalGroup(
            pnlCard3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 156, Short.MAX_VALUE)
        );
        pnlCard3Layout.setVerticalGroup(
            pnlCard3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pnlCard4.setBackground(new java.awt.Color(51, 51, 255));
        pnlCard4.setOpaque(false);

        javax.swing.GroupLayout pnlCard4Layout = new javax.swing.GroupLayout(pnlCard4);
        pnlCard4.setLayout(pnlCard4Layout);
        pnlCard4Layout.setHorizontalGroup(
            pnlCard4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 156, Short.MAX_VALUE)
        );
        pnlCard4Layout.setVerticalGroup(
            pnlCard4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 234, Short.MAX_VALUE)
        );

        pnlCard6.setBackground(new java.awt.Color(51, 51, 255));
        pnlCard6.setOpaque(false);

        javax.swing.GroupLayout pnlCard6Layout = new javax.swing.GroupLayout(pnlCard6);
        pnlCard6.setLayout(pnlCard6Layout);
        pnlCard6Layout.setHorizontalGroup(
            pnlCard6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 156, Short.MAX_VALUE)
        );
        pnlCard6Layout.setVerticalGroup(
            pnlCard6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 234, Short.MAX_VALUE)
        );

        pnlCard7.setBackground(new java.awt.Color(51, 51, 255));
        pnlCard7.setOpaque(false);

        javax.swing.GroupLayout pnlCard7Layout = new javax.swing.GroupLayout(pnlCard7);
        pnlCard7.setLayout(pnlCard7Layout);
        pnlCard7Layout.setHorizontalGroup(
            pnlCard7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 156, Short.MAX_VALUE)
        );
        pnlCard7Layout.setVerticalGroup(
            pnlCard7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pnlCard8.setBackground(new java.awt.Color(51, 51, 255));
        pnlCard8.setOpaque(false);

        javax.swing.GroupLayout pnlCard8Layout = new javax.swing.GroupLayout(pnlCard8);
        pnlCard8.setLayout(pnlCard8Layout);
        pnlCard8Layout.setHorizontalGroup(
            pnlCard8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 156, Short.MAX_VALUE)
        );
        pnlCard8Layout.setVerticalGroup(
            pnlCard8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pnlCard9.setBackground(new java.awt.Color(51, 51, 255));
        pnlCard9.setOpaque(false);

        javax.swing.GroupLayout pnlCard9Layout = new javax.swing.GroupLayout(pnlCard9);
        pnlCard9.setLayout(pnlCard9Layout);
        pnlCard9Layout.setHorizontalGroup(
            pnlCard9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 156, Short.MAX_VALUE)
        );
        pnlCard9Layout.setVerticalGroup(
            pnlCard9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 234, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlPage1Layout = new javax.swing.GroupLayout(pnlPage1);
        pnlPage1.setLayout(pnlPage1Layout);
        pnlPage1Layout.setHorizontalGroup(
            pnlPage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPage1Layout.createSequentialGroup()
                .addGroup(pnlPage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlPage1Layout.createSequentialGroup()
                        .addComponent(pnlCard6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pnlCard7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pnlCard8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(pnlCard9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlPage1Layout.createSequentialGroup()
                        .addComponent(pnlCard1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pnlCard3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pnlCard2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(pnlCard4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlPage1Layout.setVerticalGroup(
            pnlPage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPage1Layout.createSequentialGroup()
                .addGroup(pnlPage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(pnlCard2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnlCard3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnlCard1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(pnlCard4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlPage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(pnlCard8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnlCard7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnlCard6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnlCard9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        pnlContenedor.addTab("Page 1", pnlPage1);

        pnlPage2.setOpaque(false);

        pnlCard10.setBackground(new java.awt.Color(51, 51, 255));
        pnlCard10.setOpaque(false);

        javax.swing.GroupLayout pnlCard10Layout = new javax.swing.GroupLayout(pnlCard10);
        pnlCard10.setLayout(pnlCard10Layout);
        pnlCard10Layout.setHorizontalGroup(
            pnlCard10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 156, Short.MAX_VALUE)
        );
        pnlCard10Layout.setVerticalGroup(
            pnlCard10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 234, Short.MAX_VALUE)
        );

        pnlCard11.setBackground(new java.awt.Color(51, 51, 255));
        pnlCard11.setOpaque(false);

        javax.swing.GroupLayout pnlCard11Layout = new javax.swing.GroupLayout(pnlCard11);
        pnlCard11.setLayout(pnlCard11Layout);
        pnlCard11Layout.setHorizontalGroup(
            pnlCard11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 156, Short.MAX_VALUE)
        );
        pnlCard11Layout.setVerticalGroup(
            pnlCard11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pnlCard12.setBackground(new java.awt.Color(51, 51, 255));
        pnlCard12.setOpaque(false);

        javax.swing.GroupLayout pnlCard12Layout = new javax.swing.GroupLayout(pnlCard12);
        pnlCard12.setLayout(pnlCard12Layout);
        pnlCard12Layout.setHorizontalGroup(
            pnlCard12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 156, Short.MAX_VALUE)
        );
        pnlCard12Layout.setVerticalGroup(
            pnlCard12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pnlCard13.setBackground(new java.awt.Color(51, 51, 255));
        pnlCard13.setOpaque(false);

        javax.swing.GroupLayout pnlCard13Layout = new javax.swing.GroupLayout(pnlCard13);
        pnlCard13.setLayout(pnlCard13Layout);
        pnlCard13Layout.setHorizontalGroup(
            pnlCard13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 156, Short.MAX_VALUE)
        );
        pnlCard13Layout.setVerticalGroup(
            pnlCard13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 234, Short.MAX_VALUE)
        );

        pnlCard14.setBackground(new java.awt.Color(51, 51, 255));
        pnlCard14.setOpaque(false);

        javax.swing.GroupLayout pnlCard14Layout = new javax.swing.GroupLayout(pnlCard14);
        pnlCard14.setLayout(pnlCard14Layout);
        pnlCard14Layout.setHorizontalGroup(
            pnlCard14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 156, Short.MAX_VALUE)
        );
        pnlCard14Layout.setVerticalGroup(
            pnlCard14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 234, Short.MAX_VALUE)
        );

        pnlCard15.setBackground(new java.awt.Color(51, 51, 255));
        pnlCard15.setOpaque(false);

        javax.swing.GroupLayout pnlCard15Layout = new javax.swing.GroupLayout(pnlCard15);
        pnlCard15.setLayout(pnlCard15Layout);
        pnlCard15Layout.setHorizontalGroup(
            pnlCard15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 156, Short.MAX_VALUE)
        );
        pnlCard15Layout.setVerticalGroup(
            pnlCard15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pnlCard16.setBackground(new java.awt.Color(51, 51, 255));
        pnlCard16.setOpaque(false);

        javax.swing.GroupLayout pnlCard16Layout = new javax.swing.GroupLayout(pnlCard16);
        pnlCard16.setLayout(pnlCard16Layout);
        pnlCard16Layout.setHorizontalGroup(
            pnlCard16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 156, Short.MAX_VALUE)
        );
        pnlCard16Layout.setVerticalGroup(
            pnlCard16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pnlCard17.setBackground(new java.awt.Color(51, 51, 255));
        pnlCard17.setOpaque(false);

        javax.swing.GroupLayout pnlCard17Layout = new javax.swing.GroupLayout(pnlCard17);
        pnlCard17.setLayout(pnlCard17Layout);
        pnlCard17Layout.setHorizontalGroup(
            pnlCard17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 156, Short.MAX_VALUE)
        );
        pnlCard17Layout.setVerticalGroup(
            pnlCard17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 234, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlPage2Layout = new javax.swing.GroupLayout(pnlPage2);
        pnlPage2.setLayout(pnlPage2Layout);
        pnlPage2Layout.setHorizontalGroup(
            pnlPage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPage2Layout.createSequentialGroup()
                .addGroup(pnlPage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPage2Layout.createSequentialGroup()
                        .addComponent(pnlCard14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pnlCard15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pnlCard16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(pnlCard17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPage2Layout.createSequentialGroup()
                        .addComponent(pnlCard10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pnlCard11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pnlCard12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(pnlCard13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 9, Short.MAX_VALUE))
        );
        pnlPage2Layout.setVerticalGroup(
            pnlPage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPage2Layout.createSequentialGroup()
                .addGroup(pnlPage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(pnlCard12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnlCard11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnlCard10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnlCard13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlPage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(pnlCard16, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnlCard15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnlCard14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnlCard17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        pnlContenedor.addTab("Page 2", pnlPage2);

        pnlPage3.setOpaque(false);

        pnlCard18.setBackground(new java.awt.Color(51, 51, 255));
        pnlCard18.setOpaque(false);

        javax.swing.GroupLayout pnlCard18Layout = new javax.swing.GroupLayout(pnlCard18);
        pnlCard18.setLayout(pnlCard18Layout);
        pnlCard18Layout.setHorizontalGroup(
            pnlCard18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 156, Short.MAX_VALUE)
        );
        pnlCard18Layout.setVerticalGroup(
            pnlCard18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 234, Short.MAX_VALUE)
        );

        pnlCard19.setBackground(new java.awt.Color(51, 51, 255));
        pnlCard19.setOpaque(false);

        javax.swing.GroupLayout pnlCard19Layout = new javax.swing.GroupLayout(pnlCard19);
        pnlCard19.setLayout(pnlCard19Layout);
        pnlCard19Layout.setHorizontalGroup(
            pnlCard19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 156, Short.MAX_VALUE)
        );
        pnlCard19Layout.setVerticalGroup(
            pnlCard19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pnlCard20.setBackground(new java.awt.Color(51, 51, 255));
        pnlCard20.setOpaque(false);

        javax.swing.GroupLayout pnlCard20Layout = new javax.swing.GroupLayout(pnlCard20);
        pnlCard20.setLayout(pnlCard20Layout);
        pnlCard20Layout.setHorizontalGroup(
            pnlCard20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 156, Short.MAX_VALUE)
        );
        pnlCard20Layout.setVerticalGroup(
            pnlCard20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pnlCard21.setBackground(new java.awt.Color(51, 51, 255));
        pnlCard21.setOpaque(false);

        javax.swing.GroupLayout pnlCard21Layout = new javax.swing.GroupLayout(pnlCard21);
        pnlCard21.setLayout(pnlCard21Layout);
        pnlCard21Layout.setHorizontalGroup(
            pnlCard21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 156, Short.MAX_VALUE)
        );
        pnlCard21Layout.setVerticalGroup(
            pnlCard21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 234, Short.MAX_VALUE)
        );

        pnlCard22.setBackground(new java.awt.Color(51, 51, 255));
        pnlCard22.setOpaque(false);

        javax.swing.GroupLayout pnlCard22Layout = new javax.swing.GroupLayout(pnlCard22);
        pnlCard22.setLayout(pnlCard22Layout);
        pnlCard22Layout.setHorizontalGroup(
            pnlCard22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 156, Short.MAX_VALUE)
        );
        pnlCard22Layout.setVerticalGroup(
            pnlCard22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 234, Short.MAX_VALUE)
        );

        pnlCard23.setBackground(new java.awt.Color(51, 51, 255));
        pnlCard23.setOpaque(false);

        javax.swing.GroupLayout pnlCard23Layout = new javax.swing.GroupLayout(pnlCard23);
        pnlCard23.setLayout(pnlCard23Layout);
        pnlCard23Layout.setHorizontalGroup(
            pnlCard23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 156, Short.MAX_VALUE)
        );
        pnlCard23Layout.setVerticalGroup(
            pnlCard23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pnlCard24.setBackground(new java.awt.Color(51, 51, 255));
        pnlCard24.setOpaque(false);

        javax.swing.GroupLayout pnlCard24Layout = new javax.swing.GroupLayout(pnlCard24);
        pnlCard24.setLayout(pnlCard24Layout);
        pnlCard24Layout.setHorizontalGroup(
            pnlCard24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 156, Short.MAX_VALUE)
        );
        pnlCard24Layout.setVerticalGroup(
            pnlCard24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pnlCard25.setBackground(new java.awt.Color(51, 51, 255));
        pnlCard25.setOpaque(false);

        javax.swing.GroupLayout pnlCard25Layout = new javax.swing.GroupLayout(pnlCard25);
        pnlCard25.setLayout(pnlCard25Layout);
        pnlCard25Layout.setHorizontalGroup(
            pnlCard25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 156, Short.MAX_VALUE)
        );
        pnlCard25Layout.setVerticalGroup(
            pnlCard25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 234, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlPage3Layout = new javax.swing.GroupLayout(pnlPage3);
        pnlPage3.setLayout(pnlPage3Layout);
        pnlPage3Layout.setHorizontalGroup(
            pnlPage3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPage3Layout.createSequentialGroup()
                .addGroup(pnlPage3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPage3Layout.createSequentialGroup()
                        .addComponent(pnlCard22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pnlCard23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pnlCard24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(pnlCard25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPage3Layout.createSequentialGroup()
                        .addComponent(pnlCard18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pnlCard19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pnlCard20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(pnlCard21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 9, Short.MAX_VALUE))
        );
        pnlPage3Layout.setVerticalGroup(
            pnlPage3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPage3Layout.createSequentialGroup()
                .addGroup(pnlPage3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPage3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(pnlCard20, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnlCard19, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnlCard18, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnlCard21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlPage3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPage3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(pnlCard24, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnlCard23, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnlCard22, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnlCard25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        pnlContenedor.addTab("Page 3", pnlPage3);

        pnlPage4.setOpaque(false);

        pnlCard26.setBackground(new java.awt.Color(51, 51, 255));
        pnlCard26.setOpaque(false);

        javax.swing.GroupLayout pnlCard26Layout = new javax.swing.GroupLayout(pnlCard26);
        pnlCard26.setLayout(pnlCard26Layout);
        pnlCard26Layout.setHorizontalGroup(
            pnlCard26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 156, Short.MAX_VALUE)
        );
        pnlCard26Layout.setVerticalGroup(
            pnlCard26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 234, Short.MAX_VALUE)
        );

        pnlCard27.setBackground(new java.awt.Color(51, 51, 255));
        pnlCard27.setOpaque(false);

        javax.swing.GroupLayout pnlCard27Layout = new javax.swing.GroupLayout(pnlCard27);
        pnlCard27.setLayout(pnlCard27Layout);
        pnlCard27Layout.setHorizontalGroup(
            pnlCard27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 156, Short.MAX_VALUE)
        );
        pnlCard27Layout.setVerticalGroup(
            pnlCard27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pnlCard28.setBackground(new java.awt.Color(51, 51, 255));
        pnlCard28.setOpaque(false);

        javax.swing.GroupLayout pnlCard28Layout = new javax.swing.GroupLayout(pnlCard28);
        pnlCard28.setLayout(pnlCard28Layout);
        pnlCard28Layout.setHorizontalGroup(
            pnlCard28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 156, Short.MAX_VALUE)
        );
        pnlCard28Layout.setVerticalGroup(
            pnlCard28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pnlCard29.setBackground(new java.awt.Color(51, 51, 255));
        pnlCard29.setOpaque(false);

        javax.swing.GroupLayout pnlCard29Layout = new javax.swing.GroupLayout(pnlCard29);
        pnlCard29.setLayout(pnlCard29Layout);
        pnlCard29Layout.setHorizontalGroup(
            pnlCard29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 156, Short.MAX_VALUE)
        );
        pnlCard29Layout.setVerticalGroup(
            pnlCard29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 234, Short.MAX_VALUE)
        );

        pnlCard30.setBackground(new java.awt.Color(51, 51, 255));
        pnlCard30.setOpaque(false);

        javax.swing.GroupLayout pnlCard30Layout = new javax.swing.GroupLayout(pnlCard30);
        pnlCard30.setLayout(pnlCard30Layout);
        pnlCard30Layout.setHorizontalGroup(
            pnlCard30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 156, Short.MAX_VALUE)
        );
        pnlCard30Layout.setVerticalGroup(
            pnlCard30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 234, Short.MAX_VALUE)
        );

        pnlCard31.setBackground(new java.awt.Color(51, 51, 255));
        pnlCard31.setOpaque(false);

        javax.swing.GroupLayout pnlCard31Layout = new javax.swing.GroupLayout(pnlCard31);
        pnlCard31.setLayout(pnlCard31Layout);
        pnlCard31Layout.setHorizontalGroup(
            pnlCard31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 156, Short.MAX_VALUE)
        );
        pnlCard31Layout.setVerticalGroup(
            pnlCard31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlPage4Layout = new javax.swing.GroupLayout(pnlPage4);
        pnlPage4.setLayout(pnlPage4Layout);
        pnlPage4Layout.setHorizontalGroup(
            pnlPage4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPage4Layout.createSequentialGroup()
                .addGroup(pnlPage4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPage4Layout.createSequentialGroup()
                        .addComponent(pnlCard30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pnlCard31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(356, 356, 356))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPage4Layout.createSequentialGroup()
                        .addComponent(pnlCard26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pnlCard27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pnlCard28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(pnlCard29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 9, Short.MAX_VALUE))
        );
        pnlPage4Layout.setVerticalGroup(
            pnlPage4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPage4Layout.createSequentialGroup()
                .addGroup(pnlPage4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPage4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(pnlCard28, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnlCard27, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnlCard26, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnlCard29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlPage4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(pnlCard31, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlCard30, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        pnlContenedor.addTab("Page 4", pnlPage4);

        pnlSelect1.setBackground(new java.awt.Color(0, 0, 255));
        pnlSelect1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnlSelect1.setOpaque(false);
        pnlSelect1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlSelect1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlSelect1Layout = new javax.swing.GroupLayout(pnlSelect1);
        pnlSelect1.setLayout(pnlSelect1Layout);
        pnlSelect1Layout.setHorizontalGroup(
            pnlSelect1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 177, Short.MAX_VALUE)
        );
        pnlSelect1Layout.setVerticalGroup(
            pnlSelect1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 76, Short.MAX_VALUE)
        );

        pnlSelect4.setBackground(new java.awt.Color(0, 0, 255));
        pnlSelect4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnlSelect4.setOpaque(false);
        pnlSelect4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlSelect4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlSelect4Layout = new javax.swing.GroupLayout(pnlSelect4);
        pnlSelect4.setLayout(pnlSelect4Layout);
        pnlSelect4Layout.setHorizontalGroup(
            pnlSelect4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 177, Short.MAX_VALUE)
        );
        pnlSelect4Layout.setVerticalGroup(
            pnlSelect4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 76, Short.MAX_VALUE)
        );

        pnlSelect2.setBackground(new java.awt.Color(0, 0, 255));
        pnlSelect2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnlSelect2.setOpaque(false);
        pnlSelect2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlSelect2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlSelect2Layout = new javax.swing.GroupLayout(pnlSelect2);
        pnlSelect2.setLayout(pnlSelect2Layout);
        pnlSelect2Layout.setHorizontalGroup(
            pnlSelect2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 177, Short.MAX_VALUE)
        );
        pnlSelect2Layout.setVerticalGroup(
            pnlSelect2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 76, Short.MAX_VALUE)
        );

        pnlSelect3.setBackground(new java.awt.Color(0, 0, 255));
        pnlSelect3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnlSelect3.setOpaque(false);
        pnlSelect3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlSelect3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlSelect3Layout = new javax.swing.GroupLayout(pnlSelect3);
        pnlSelect3.setLayout(pnlSelect3Layout);
        pnlSelect3Layout.setHorizontalGroup(
            pnlSelect3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 177, Short.MAX_VALUE)
        );
        pnlSelect3Layout.setVerticalGroup(
            pnlSelect3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 76, Short.MAX_VALUE)
        );

        pnlBack.setOpaque(false);
        pnlBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlBackMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlBackLayout = new javax.swing.GroupLayout(pnlBack);
        pnlBack.setLayout(pnlBackLayout);
        pnlBackLayout.setHorizontalGroup(
            pnlBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        pnlBackLayout.setVerticalGroup(
            pnlBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 42, Short.MAX_VALUE)
        );

        lblHeroe.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblHeroe.setText("Heroe");

        javax.swing.GroupLayout pnlFondoLayout = new javax.swing.GroupLayout(pnlFondo);
        pnlFondo.setLayout(pnlFondoLayout);
        pnlFondoLayout.setHorizontalGroup(
            pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFondoLayout.createSequentialGroup()
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFondoLayout.createSequentialGroup()
                        .addGap(516, 516, 516)
                        .addComponent(lblHeroe))
                    .addGroup(pnlFondoLayout.createSequentialGroup()
                        .addGap(194, 194, 194)
                        .addComponent(pnlContenedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(69, 69, 69)
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlSelect1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlSelect3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlSelect4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlSelect2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(226, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFondoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlBack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(187, 187, 187))
        );
        pnlFondoLayout.setVerticalGroup(
            pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFondoLayout.createSequentialGroup()
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFondoLayout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(pnlSelect1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(pnlSelect2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(pnlSelect3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(pnlSelect4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFondoLayout.createSequentialGroup()
                        .addContainerGap(84, Short.MAX_VALUE)
                        .addComponent(lblHeroe)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pnlContenedor, javax.swing.GroupLayout.PREFERRED_SIZE, 565, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(pnlBack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
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
                .addComponent(pnlFondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pnlSelect1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlSelect1MouseClicked
        // TODO add your handling code here:
        cleanPanels();
        selected(1);
    }//GEN-LAST:event_pnlSelect1MouseClicked

    private void pnlSelect2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlSelect2MouseClicked
        // TODO add your handling code here:
        cleanPanels();
        selected(2);
    }//GEN-LAST:event_pnlSelect2MouseClicked

    private void pnlSelect3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlSelect3MouseClicked
        // TODO add your handling code here:
        cleanPanels();
        selected(3);
    }//GEN-LAST:event_pnlSelect3MouseClicked

    private void pnlSelect4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlSelect4MouseClicked
        // TODO add your handling code here:
        cleanPanels();
        selected(4);
    }//GEN-LAST:event_pnlSelect4MouseClicked

    private void pnlBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlBackMouseClicked
        // TODO add your handling code here:
        fc.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_pnlBackMouseClicked

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
            java.util.logging.Logger.getLogger(FrmDeckView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmDeckView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmDeckView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmDeckView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmDeckView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblHeroe;
    private javax.swing.JPanel pnlBack;
    private javax.swing.JPanel pnlCard1;
    private javax.swing.JPanel pnlCard10;
    private javax.swing.JPanel pnlCard11;
    private javax.swing.JPanel pnlCard12;
    private javax.swing.JPanel pnlCard13;
    private javax.swing.JPanel pnlCard14;
    private javax.swing.JPanel pnlCard15;
    private javax.swing.JPanel pnlCard16;
    private javax.swing.JPanel pnlCard17;
    private javax.swing.JPanel pnlCard18;
    private javax.swing.JPanel pnlCard19;
    private javax.swing.JPanel pnlCard2;
    private javax.swing.JPanel pnlCard20;
    private javax.swing.JPanel pnlCard21;
    private javax.swing.JPanel pnlCard22;
    private javax.swing.JPanel pnlCard23;
    private javax.swing.JPanel pnlCard24;
    private javax.swing.JPanel pnlCard25;
    private javax.swing.JPanel pnlCard26;
    private javax.swing.JPanel pnlCard27;
    private javax.swing.JPanel pnlCard28;
    private javax.swing.JPanel pnlCard29;
    private javax.swing.JPanel pnlCard3;
    private javax.swing.JPanel pnlCard30;
    private javax.swing.JPanel pnlCard31;
    private javax.swing.JPanel pnlCard4;
    private javax.swing.JPanel pnlCard6;
    private javax.swing.JPanel pnlCard7;
    private javax.swing.JPanel pnlCard8;
    private javax.swing.JPanel pnlCard9;
    private javax.swing.JTabbedPane pnlContenedor;
    private javax.swing.JPanel pnlFondo;
    private javax.swing.JPanel pnlPage1;
    private javax.swing.JPanel pnlPage2;
    private javax.swing.JPanel pnlPage3;
    private javax.swing.JPanel pnlPage4;
    private javax.swing.JPanel pnlSelect1;
    private javax.swing.JPanel pnlSelect2;
    private javax.swing.JPanel pnlSelect3;
    private javax.swing.JPanel pnlSelect4;
    // End of variables declaration//GEN-END:variables
}
