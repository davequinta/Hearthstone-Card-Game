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
public class Hechizo extends Carta{
    private String efecto;
    private String tipoEfecto;
    
    Hechizo(){
    }
    
   /* Hechizo(String nombre, int costoMana, String claseCarta, String descripcion, String rutaImg){
        super(nombre, costoMana, claseCarta, descripcion, rutaImg);
        
    }*/
    
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
    /*
    public void realizarEfecto(){
        setLife(false); 
        
        Efecto e = new Efecto();
              
    }
    */
    
}
