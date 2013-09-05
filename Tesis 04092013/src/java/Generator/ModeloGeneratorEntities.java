/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 */

package Generator;

import Model.Entity;
import Model.Model;
import Utilities.Functions;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

public class ModeloGeneratorEntities 
{
      public static void generarCodigo(Model m) throws IOException, SQLException 
      {
           
        VelocityContext contexto = new VelocityContext();
        Velocity.init();//inicializa el motor velocity    
        
        String NameDB = m.getName();
        List<Entity> entities = m.getEntities();
        
        String myfolder = "Salida/";
        contexto.put("database", m);
        
        Functions g = new Functions();
        File f = new File(myfolder + NameDB);
        f.mkdir();
        
        
        Template ModeloGeneratorEntity = null;
         try {
           ModeloGeneratorEntity=Velocity.getTemplate("TemplatesMVC/TemplatesMVC/TEntities.vsl");
         }
        catch (Exception e){
            System.out.println("Error creating template");
        }
         
        if(ModeloGeneratorEntity != null){
            try {
                BufferedWriter escritor = new BufferedWriter(new FileWriter(myfolder + NameDB + "/src/java/CO/EDU/USBBog/Entity/" + entities +  ".java"));
                ModeloGeneratorEntity.merge(contexto, escritor);
                escritor.flush();
                escritor.close();
            }
            catch (IOException ex){
                    System.out.println("Plantillas entity no creadas");
                }
        }
        
      }
                   
                    
}