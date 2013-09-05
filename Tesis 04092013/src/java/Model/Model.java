package Model;

import java.util.ArrayList;
/**
 *
 * @author Jeyson Vargas
 */

public class Model { 
    
  private String name;
  
    /**
    * Get the value of name
    *
    * @return the value of name
    */
    public String getName() {
        return name;
    }
    
    /**
    * Set the value of name
    *
    * @param nombre new value of name
    */
    
    public void setName(String name) {
        this.name = name;
        //System.out.println("DATABASE: " + name);
    }
   
    
  private ArrayList<Entity>  entities;
     
      /**
     * Get the value of entities
     *
     * @return the value of entities
     */
  public ArrayList<Entity> getEntities() {
        return entities; 
    }

  /**
     * Set the value of entities
     *
     * @param entities new value of entities
     */
    public void setEntities(ArrayList<Entity> entities) {
        this.entities = entities;
    }
    
    
        public Model(){
        this.entities = new ArrayList<Entity>();
        this.name = "";
    }
 
}
