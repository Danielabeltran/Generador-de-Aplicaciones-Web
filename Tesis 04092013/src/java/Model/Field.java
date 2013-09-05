/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author jeysonvargasmartinez
 */
public class Field {
   
    private String nameFields;
     /**
     * Set the value of nombre
     *
     * @param nombre new value of nombre
     */
  public void setNameFields(String nameFields){
        this.nameFields = nameFields;
        //System.out.println("File:      " + nameFields);
    }
     /**
     * Get the value of nombre
     *
     * @param nombre new value of nombre
     */   
  public String getNameFields(){
         return nameFields;
    }
  
  
   private String typeFields;
  
   /**
     * Set the value of Tipo
     *
     * @param tipo new value of tipo
     */
  public void setTypes(String typeFields) 
    {
        this.typeFields = typeFields;
        //System.out.println("Type:      " + typeFields);
    }    
    /**
     * Get the value of Tipo
     *
     * @param tipo new value of nombre
     */    
  public String getTypes() 
    {
        return typeFields;
    }
    
  private String primaryFiles;
  
   /**
     * Set the value of primaryFiles
     *
     * @param primaryFiles new value of tipo
     */
  public void setPrimarys(String primaryFiles) 
    {
        this.primaryFiles = primaryFiles;
        //System.out.println("PRIMARY: " + primaryFiles);
    }    
    /**
     * Get the value of primaryFiles
     *
     * @param primaryFiles new value of nombre
     */    
  public String getPrimarys() 
    {
        return primaryFiles;
    }
    

  
}
