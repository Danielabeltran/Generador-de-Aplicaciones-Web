
package USBBOGEDUData;

import USBBOGEDUEntities.administrador;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Universidad de Sanbuenaventura sede Bogota
 */


public class administrador\DAO {


public void create(administrador a) {
        
        // Crea la conexion a la base de datos Academico
        ConexionDB database = new ConexionDB();
        database.makeConnection();
        
        try{
            // Genera la inserciÃ³n en la tabla
            String formato = "insert into administrador([id, nombre, usuario]) values(['%s', '%s', '%s'])"; 
            String sql = String.format(formato, [a.get_Id(), a.get_Nombre(), a.get_Usuario()]);
            
            // Guarda los datos en la base de datos Academico
            database.nonQuery(sql);
            
        }catch(Exception e){
            
        }
        
    }



    /**
     * Obtiene la lista de estudiantes
     * @return lista de estudiantes
     */
    public List<administrador> getAll(){

            // Crea la conexion a la base de datos Academico
        ConexionDB database = new ConexionDB();
        database.makeConnection();

            // Crea el objeto resultado
            List<administrador> lista = new ArrayList<administrador>();

            try{

            // Ejecuta la sentencia en la BD
                ResultSet resultado = database.query("select * from administrador");

            // Recorre el resultado para transformar a entidades
            while (resultado.next()) {

            // Obtiene los datos del registro actual

                int id= resultado.getInt("id");
                String nombre= resultado.getString("nombre");
                String usuario= resultado.getString("usuario");
                    // crea una entidad estudiante
            administrador a = new administrador(); 

                a.set_Id(id);
                a.set_Nombre(nombre);
                a.set_Usuario(usuario);
                    // Agrega la entidad a la lista
            lista.add(a);
                }

            }catch(Exception e){
            }

            return lista;
        }


 public void update(administrador a) {
        
      // Crea la conexion a la base de datos Academico
        ConexionDB database = new ConexionDB();
        database.makeConnection();
        
        try{
            
            // Crea la sentencia de actualizacion en la tabla administrador
             String formato = "update administrador set [id='%s', nombre='%s', usuario='%s'] where id='%s'";
            String sql = String.format(formato, [a.get_Id(), a.get_Nombre(), a.get_Usuario()]);
            
            
            // Ejecuta la actualizaciÃ³n
            database.nonQuery(sql);
            
            
            
            
        }catch(Exception e){
            
        }
        
    }

public void deleteadministrador(int id) {
  
// Crea la conexion a la base de datos Academico
        ConexionDB database = new ConexionDB();
        database.makeConnection();
        
        try{
            
            // Crea la sentencia de actualizacion en la base de datos
            String formato = "delete from administrador where id = %s";
            String sql = String.format(formato, id);
            
            // Ejecuta la actualizaciÃ³n
            database.nonQuery(sql);
            
            
            
            
        }catch(Exception e){
            
        }
    }

}

