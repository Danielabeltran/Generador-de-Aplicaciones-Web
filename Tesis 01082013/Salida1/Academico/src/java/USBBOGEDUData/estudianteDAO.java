
package USBBOGEDUData;

import USBBOGEDUEntities.estudiante;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Universidad de Sanbuenaventura sede Bogota
 */


public class estudiante\DAO {


public void create(estudiante a) {
        
        // Crea la conexion a la base de datos Academico
        ConexionDB database = new ConexionDB();
        database.makeConnection();
        
        try{
            // Genera la inserciÃ³n en la tabla
            String formato = "insert into estudiante([id, nombre, usuario, clave, id, id_Profesor, id_Universidad, asignatura, grupo, horario, id, id_Universidad, codigo, nombre, usuario, clave]) values(['%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s'])"; 
            String sql = String.format(formato, [a.get_Id(), a.get_Nombre(), a.get_Usuario(), a.get_Clave(), a.get_Id(), a.get_Id_Profesor(), a.get_Id_Universidad(), a.get_Asignatura(), a.get_Grupo(), a.get_Horario(), a.get_Id(), a.get_Id_Universidad(), a.get_Codigo(), a.get_Nombre(), a.get_Usuario(), a.get_Clave()]);
            
            // Guarda los datos en la base de datos Academico
            database.nonQuery(sql);
            
        }catch(Exception e){
            
        }
        
    }



    /**
     * Obtiene la lista de estudiantes
     * @return lista de estudiantes
     */
    public List<estudiante> getAll(){

            // Crea la conexion a la base de datos Academico
        ConexionDB database = new ConexionDB();
        database.makeConnection();

            // Crea el objeto resultado
            List<estudiante> lista = new ArrayList<estudiante>();

            try{

            // Ejecuta la sentencia en la BD
                ResultSet resultado = database.query("select * from estudiante");

            // Recorre el resultado para transformar a entidades
            while (resultado.next()) {

            // Obtiene los datos del registro actual

                int id= resultado.getInt("id");
                String nombre= resultado.getString("nombre");
                String usuario= resultado.getString("usuario");
                String clave= resultado.getString("clave");
                int id= resultado.getInt("id");
                int id_Profesor= resultado.getInt("id_Profesor");
                int id_Universidad= resultado.getInt("id_Universidad");
                String asignatura= resultado.getString("asignatura");
                String grupo= resultado.getString("grupo");
                String horario= resultado.getString("horario");
                int id= resultado.getInt("id");
                int id_Universidad= resultado.getInt("id_Universidad");
                int codigo= resultado.getInt("codigo");
                String nombre= resultado.getString("nombre");
                String usuario= resultado.getString("usuario");
                String clave= resultado.getString("clave");
                    // crea una entidad estudiante
            estudiante a = new estudiante(); 

                a.set_Id(id);
                a.set_Nombre(nombre);
                a.set_Usuario(usuario);
                a.set_Clave(clave);
                a.set_Id(id);
                a.set_Id_Profesor(id_Profesor);
                a.set_Id_Universidad(id_Universidad);
                a.set_Asignatura(asignatura);
                a.set_Grupo(grupo);
                a.set_Horario(horario);
                a.set_Id(id);
                a.set_Id_Universidad(id_Universidad);
                a.set_Codigo(codigo);
                a.set_Nombre(nombre);
                a.set_Usuario(usuario);
                a.set_Clave(clave);
                    // Agrega la entidad a la lista
            lista.add(a);
                }

            }catch(Exception e){
            }

            return lista;
        }


 public void update(estudiante a) {
        
      // Crea la conexion a la base de datos Academico
        ConexionDB database = new ConexionDB();
        database.makeConnection();
        
        try{
            
            // Crea la sentencia de actualizacion en la tabla estudiante
             String formato = "update estudiante set [id='%s', nombre='%s', usuario='%s', clave='%s', id='%s', id_Profesor='%s', id_Universidad='%s', asignatura='%s', grupo='%s', horario='%s', id='%s', id_Universidad='%s', codigo='%s', nombre='%s', usuario='%s', clave='%s'] where id='%s'";
            String sql = String.format(formato, [a.get_Id(), a.get_Nombre(), a.get_Usuario(), a.get_Clave(), a.get_Id(), a.get_Id_Profesor(), a.get_Id_Universidad(), a.get_Asignatura(), a.get_Grupo(), a.get_Horario(), a.get_Id(), a.get_Id_Universidad(), a.get_Codigo(), a.get_Nombre(), a.get_Usuario(), a.get_Clave()]);
            
            
            // Ejecuta la actualizaciÃ³n
            database.nonQuery(sql);
            
            
            
            
        }catch(Exception e){
            
        }
        
    }

public void deleteestudiante(int id) {
  
// Crea la conexion a la base de datos Academico
        ConexionDB database = new ConexionDB();
        database.makeConnection();
        
        try{
            
            // Crea la sentencia de actualizacion en la base de datos
            String formato = "delete from estudiante where id = %s";
            String sql = String.format(formato, id);
            
            // Ejecuta la actualizaciÃ³n
            database.nonQuery(sql);
            
            
            
            
        }catch(Exception e){
            
        }
    }

}

