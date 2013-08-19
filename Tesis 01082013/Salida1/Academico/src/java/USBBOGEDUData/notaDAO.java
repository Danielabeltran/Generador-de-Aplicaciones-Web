
package USBBOGEDUData;

import USBBOGEDUEntities.nota;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Universidad de Sanbuenaventura sede Bogota
 */


public class nota\DAO {


public void create(nota a) {
        
        // Crea la conexion a la base de datos Academico
        ConexionDB database = new ConexionDB();
        database.makeConnection();
        
        try{
            // Genera la inserciÃ³n en la tabla
            String formato = "insert into nota([id, nombre, usuario, clave, id, id_Profesor, id_Universidad, asignatura, grupo, horario, id, id_Universidad, codigo, nombre, usuario, clave, email, id_Estudiante, id_Curso, corte1, corte2]) values(['%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s'])"; 
            String sql = String.format(formato, [a.get_Id(), a.get_Nombre(), a.get_Usuario(), a.get_Clave(), a.get_Id(), a.get_Id_Profesor(), a.get_Id_Universidad(), a.get_Asignatura(), a.get_Grupo(), a.get_Horario(), a.get_Id(), a.get_Id_Universidad(), a.get_Codigo(), a.get_Nombre(), a.get_Usuario(), a.get_Clave(), a.get_Email(), a.get_Id_Estudiante(), a.get_Id_Curso(), a.get_Corte1(), a.get_Corte2()]);
            
            // Guarda los datos en la base de datos Academico
            database.nonQuery(sql);
            
        }catch(Exception e){
            
        }
        
    }



    /**
     * Obtiene la lista de estudiantes
     * @return lista de estudiantes
     */
    public List<nota> getAll(){

            // Crea la conexion a la base de datos Academico
        ConexionDB database = new ConexionDB();
        database.makeConnection();

            // Crea el objeto resultado
            List<nota> lista = new ArrayList<nota>();

            try{

            // Ejecuta la sentencia en la BD
                ResultSet resultado = database.query("select * from nota");

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
                String email= resultado.getString("email");
                int id_Estudiante= resultado.getInt("id_Estudiante");
                int id_Curso= resultado.getInt("id_Curso");
                double corte1= resultado.getDouble("corte1");
                double corte2= resultado.getDouble("corte2");
                    // crea una entidad estudiante
            nota a = new nota(); 

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
                a.set_Email(email);
                a.set_Id_Estudiante(id_Estudiante);
                a.set_Id_Curso(id_Curso);
                a.set_Corte1(corte1);
                a.set_Corte2(corte2);
                    // Agrega la entidad a la lista
            lista.add(a);
                }

            }catch(Exception e){
            }

            return lista;
        }


 public void update(nota a) {
        
      // Crea la conexion a la base de datos Academico
        ConexionDB database = new ConexionDB();
        database.makeConnection();
        
        try{
            
            // Crea la sentencia de actualizacion en la tabla nota
             String formato = "update nota set [id='%s', nombre='%s', usuario='%s', clave='%s', id='%s', id_Profesor='%s', id_Universidad='%s', asignatura='%s', grupo='%s', horario='%s', id='%s', id_Universidad='%s', codigo='%s', nombre='%s', usuario='%s', clave='%s', email='%s', id_Estudiante='%s', id_Curso='%s', corte1='%s', corte2='%s'] where id='%s'";
            String sql = String.format(formato, [a.get_Id(), a.get_Nombre(), a.get_Usuario(), a.get_Clave(), a.get_Id(), a.get_Id_Profesor(), a.get_Id_Universidad(), a.get_Asignatura(), a.get_Grupo(), a.get_Horario(), a.get_Id(), a.get_Id_Universidad(), a.get_Codigo(), a.get_Nombre(), a.get_Usuario(), a.get_Clave(), a.get_Email(), a.get_Id_Estudiante(), a.get_Id_Curso(), a.get_Corte1(), a.get_Corte2()]);
            
            
            // Ejecuta la actualizaciÃ³n
            database.nonQuery(sql);
            
            
            
            
        }catch(Exception e){
            
        }
        
    }

public void deletenota(int id) {
  
// Crea la conexion a la base de datos Academico
        ConexionDB database = new ConexionDB();
        database.makeConnection();
        
        try{
            
            // Crea la sentencia de actualizacion en la base de datos
            String formato = "delete from nota where id = %s";
            String sql = String.format(formato, id);
            
            // Ejecuta la actualizaciÃ³n
            database.nonQuery(sql);
            
            
            
            
        }catch(Exception e){
            
        }
    }

}

