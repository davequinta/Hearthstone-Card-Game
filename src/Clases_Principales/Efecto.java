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
public class Efecto {
    private String nombreEfecto;
    private String tipoEfecto;
    private int entero;

    /**
     * @return the nombreEfecto
     */
    public String getNombreEfecto() {
        return nombreEfecto;
    }

    /**
     * @param nombreEfecto the nombreEfecto to set
     */
    public void setNombreEfecto(String nombreEfecto) {
        this.nombreEfecto = nombreEfecto;
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
    
    public void momentoCasteo(int entero){
        int tiempoF=1, tiempoI=0;
        if(entero== tiempoF){
        }
        else if(entero == tiempoI){
        }
        else{
        }
        
    }
    
    public void curacion(Esbirro e1, Heroe h1, int entero){
        if(e1!= null){
            int vidaAct = (e1.getVida()+entero);
            e1.setVida(vidaAct);
        }
        else if(h1!= null){
            int vidaAct = (h1.getVida()+entero);
            h1.setVida(vidaAct);
        }
    }
    
    public void destrucion(){
    }
    
    public void hacerDano(Esbirro e1, Heroe h1, int entero){
        if(e1!= null){
            int vidaAct = (e1.getVida()- entero);
            e1.setVida(vidaAct);
        }
        else if(h1!= null){
            int vidaAct = (h1.getVida()- entero);
            h1.setVida(vidaAct);
        }
    }
    
    public void tomarCarta(){
    }
    
    public void reducirDano(int entero, Esbirro e1){
        int danoAct = e1.getDano();
       danoAct-=entero;
       e1.setVida(danoAct);
    }
    
    public void reducirVida(int entero, Esbirro e1){
       int vidaAct = e1.getVida();
       vidaAct-=entero;
       e1.setVida(vidaAct);
    }
    
    public void AumentarVida(int entero, Esbirro e1){
       int vidaAct = e1.getVida();
       vidaAct = entero;
       e1.setVida(vidaAct);
    }
    
    public void carga(Esbirro e1){
        e1.setEstadoAtaque(true);
    }
    
    public void furiaViento(Esbirro e1){
        e1.setCantidadAtaque(2);
    }
    
    public void provocar(){
    }
    
}
