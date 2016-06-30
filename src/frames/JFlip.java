package frames;
import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.GeneralPath;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.Timer;
/**
 
 */
public class JFlip extends JComponent implements MouseListener {
    String ruta;
    private Timer timer                     =       null;    
    private boolean inTransition            =       false;
    private int speed                       =       4;//velocidad de flip en milisegundos
    private int displacement                =       2;//desplazamiento en pixeles
    private boolean isFront                 =       true;
    private boolean inward                  =       true;//sentido del desplazamiento
    //iconos por defecto
    private Icon iconBack               =       new ImageIcon(getClass().getResource("/img/hpower_disabled.png"));
    private Icon iconFront               =       new ImageIcon(getClass().getResource("/img/hpower_disabled.png"));
    private Image image                     =       ((ImageIcon)iconFront).getImage();
    //variables de desplazamiento
    private int displacementHorizontal      =       0;    
    private float displacementLeft          =       0;       
    private float displacementRight         =       0;    
    //tamaño por defecto
    private Dimension dimension             =       new Dimension(102,102);
    String name="";
    String name2="";
    
    /**Constructor de clase*/
    public JFlip(){
        super();
        setSize(dimension);
        setPreferredSize(dimension);        
        setVisible(true);        
        addMouseListener(JFlip.this);        
    }
    
    @Override
    public void paintComponent(Graphics g){         
        Graphics2D g2 =(Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);            
        g2.setStroke(new BasicStroke( 0f ));
        //coordenas de imagen
        GeneralPath p = new GeneralPath();
            p.moveTo(displacementHorizontal, displacementLeft);//esquina A
            p.lineTo(getWidth()-displacementHorizontal-1, displacementRight);//esquina B
            p.lineTo(getWidth()-displacementHorizontal-1, getHeight()-displacementRight-1);//esquina D
            p.lineTo( displacementHorizontal, getHeight()-displacementLeft-1  );//esquina C
            p.closePath();
        Shape shp = p;
        g2.setClip(shp);
        g2.drawImage(image, 0, 0,getWidth() - displacementHorizontal,getHeight(), null);        
        g2.setClip(null);
        g2.draw(shp);
        g.dispose(); 
    }

    /**
     * Metodo que realiza los cambios en las variables de desplazamiento
     * @return Void
     */
    public void flipAnimate(){
        inTransition = !inTransition;
        //declaramos un evento para modificar el desplazamiento vertical y horizontal
        ActionListener animation = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                if(inward){   
                    displacementHorizontal += displacement;   
                    displacementRight += (displacementRight>=getHeight()/2)?0:displacement/(getSize().getWidth()/getSize().getHeight()+1f);                                        
                }else{
                    displacementHorizontal -= displacement;                                        
                    displacementLeft -=displacement/(getSize().getWidth()/getSize().getHeight()+1f);                                        
                }
                //repinta graficos
                repaint();
                
                //si se llego al medio del componente -> cambia de sentido
                if(displacementHorizontal >= getWidth()/2){ 
                    inward = false;
                    displacementLeft = displacementRight;                    
                    displacementRight=0;                    
                    //
                    if( isFront ){//mostrar imagen de atras
                        isFront=false;
                        image=((ImageIcon)iconBack).getImage();                        
                    }else{//mostrar imagen de adelante
                        isFront =true;
                        image=((ImageIcon)iconFront).getImage();                        
                    }                    
                } 
                //volvio a su posicion inicial -> detener animacion
                if( inward == false && displacementHorizontal == 0 ){
                    inTransition=false;   
                    timer.stop();
                    displacementLeft=0;
                    displacementRight=0;
                    displacementHorizontal=0;
                    inward = true;                                 
                }
            }
        }; 
        //
        if( inTransition )
        {
            if(timer != null)timer.stop();
            timer = new Timer( speed, animation);
            timer.start(); //inicia animacion      
        }
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
      // flipAnimate();
    }

    @Override
    public void mousePressed(MouseEvent e) {/*...*/}

    @Override
    public void mouseReleased(MouseEvent e) {/*...*/}

    @Override
    public void mouseEntered(MouseEvent e) {/*...*/}

    @Override
    public void mouseExited(MouseEvent e) {/*...*/}

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
        iconBack = new ImageIcon(getClass().getResource(name2));
    }

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
       // iconFront = new ImageIcon(getClass().getResource(name));
    }

    
    public Icon getIconBack() {
        return iconBack;
    }

    public void setIconBack(Icon iconBack) {
        this.iconBack = iconBack;
    }

    public Icon getIconFront() {
        return iconFront;
    }

    public void setIconFront(Icon iconFront) {
        this.iconFront = iconFront;
    }

    public int getDisplacement() {
        return displacement;
    }

    public void setDisplacement(int displacement) {
        this.displacement = displacement;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
    
}//JFlip:end