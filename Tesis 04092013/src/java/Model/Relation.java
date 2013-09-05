/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author jeysonvargasmartinez
 */
public class Relation {
   private String entidadOrigen;
   private String campoOrigen;
   private String entidadDestino;
   private String campoDestino;

    /**
     * Set the value of entidadOrigen
     *
     * @param entidadOrigen new value of nombre
     */
    public String getEntidadOrigen() {
        return entidadOrigen;
    }
    /**
     * Get the value of campoOrigen
     *
     * @param campoOrigen new value of nombre
     */
    public String getCampoOrigen() {
        return campoOrigen;
    }
    /**
     * Get the value of entidadDestino
     *
     * @param entidadDestino new value of nombre
     */
    public String getEntidadDestino() {
        return entidadDestino;
    }
    /**
     * Get the value of campoDestino
     *
     * @param campoDestino new value of nombre
     */
    public String getCampoDestino() {
        return campoDestino;
    }
    /**
     * Set the value of entidadOrigen
     *
     * @param entidadOrigen new value of nombre
     */
    public void setEntidadOrigen(String entidadOrigen) {
        this.entidadOrigen = entidadOrigen;
        //System.out.println("entidadOrigen:  " + entidadOrigen);
    }
    /**
     * Set the value of campoOrigen
     *
     * @param campoOrigen new value of nombre
     */
    public void setCampoOrigen(String campoOrigen) {
        this.campoOrigen = campoOrigen;
        //System.out.println("campoOrigen:   " + campoOrigen);
    }
    /**
     * Set the value of entidadDestino
     *
     * @param entidadDestino new value of nombre
     */
    public void setEntidadDestino(String entidadDestino) {
        this.entidadDestino = entidadDestino;
        //System.out.println("entidadDestino:  " + entidadDestino);
    }
    /**
     * Set the value of campoDestino
     *
     * @param campoDestino new value of nombre
     */
    public void setCampoDestino(String campoDestino) {
        this.campoDestino = campoDestino;
        //System.out.println("campoDestino:  " + campoDestino);
    }
   
}
