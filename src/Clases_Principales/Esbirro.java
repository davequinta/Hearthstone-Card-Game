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
public class Esbirro extends Carta {
    private int vida;
    private int dano;
    private String efecto;
    private String tipoEfecto;
    private boolean estadoAtaque = false;
    private int cantidadAtaque =1;
    
    Esbirro(){
    }
    
   /* Esbirro(String nombre, int costoMana, String claseCarta, String descripcion, String rutaImg){
        super(nombre, costoMana, claseCarta, descripcion, rutaImg);
        
    }*/
    /**
     * @return the cantidadAtaque
     */
    public int getCantidadAtaque() {
        return cantidadAtaque;
    }

    /**
     * @param cantidadAtaque the cantidadAtaque to set
     */
    public void setCantidadAtaque(int cantidadAtaque) {
        this.cantidadAtaque = cantidadAtaque;
    }
    
     /**
     * @return the estadoAtaque
     */
    public boolean isEstadoAtaque() {
        return estadoAtaque;
    }

    /**
     * @param estadoAtaque the estadoAtaque to set
     */
    public void setEstadoAtaque(boolean estadoAtaque) {
        this.estadoAtaque = estadoAtaque;
    }
    
    /**
     * @return the vida
     */
    public int getVida() {
        return vida;
    }

    /**
     * @param vida the vida to set
     */
    public void setVida(int vida) {
        this.vida = vida;
    }

    /**
     * @return the dano
     */
    public int getDano() {
        return dano;
    }

    /**
     * @param dano the dano to set
     */
    public void setDano(int dano) {
        this.dano = dano;
    }

    /**
     * @return the efecto
     */
    public String getEfecto() {
        return efecto;
    }

    /**
     * @param efecto the efecto to set
     */
    public void setEfecto(String efecto) {
        this.efecto = efecto;
    }

    /**
     * @return the tipoEfecto
     */
    public String getTipoEfecto() {
        return tipoEfecto;
    }

    /**
     * @param tipoEfecto the tipoEfecto to set
     */
    public void setTipoEfecto(String tipoEfecto) {
        this.tipoEfecto = tipoEfecto;
    }
    
    public void realizarEfecto(){
    }
    
    public void atacar(Esbirro e1, Heroe h1){
        if(e1!= null){
           // e1.recibirDano(dano);
            
        }
        else if(h1!= null){
            h1.restarVida(dano);
        }
        else{
            System.out.println("Falla ataque");
        }
    }
    /*
    public void recibirDano(int dano){
        vida-=dano;
        if(vida ==0){
               setLife(false); 
            }
    } 
    */
}
