package Builder;

import Model.Field;
import Model.Entity;
import Model.Model;
import Model.Relation;
import Utilities.Conexion_BD;
import java.io.IOException;
import java.sql.*;


public class ModeloBuilder 
{
        public static String nameBD; 
    //Metodo carga modelo
    public static Model cargarModelo() throws IOException, SQLException
    {
        Conexion_BD database = new Conexion_BD();
        database.makeConnection();
        Model m = new Model();
        try 
        {
                    
            //Método para traer columnas, campos, tipo del campo, tablas etc        
            DatabaseMetaData metadata = database.connection.getMetaData(); //Método general de java para extraer metadata de la base de datos
            ResultSet resultSet2 = metadata.getColumns(null, null, null, null);//Método para obtener las columnas de los metadatos obtenidos
            ResultSet resultTables = database.query("SHOW TABLES");//Metodo para obtener las tablas de los metadatos obtenidos
           
            resultSet2.next();
            nameBD = resultSet2.getString("TABLE_CAT");// retorna el nombre de la BD
            m.setName(nameBD);
            Entity ent = new Entity();
             while (resultTables.next()) {
                //Entity ent = new Entity();
                String nameTables = resultTables.getString(1);//retorna las tablas de la BD
                ent.setName(nameTables);
                
            ResultSet resultFields = database.query("DESC " + nameTables);//Metodo para obtener los campos de la tabla 
            while(resultFields.next()){
                    Field f = new Field();
                    String nameFields = resultFields.getString(1);//retorna los campos de las tablas
                    f.setNameFields(nameFields);
                    ent.getFields().add(f);
                
                    ResultSet resultTypes = database.query("SELECT data_type FROM INFORMATION_SCHEMA.COLUMNS \n" + 
                                                           "WHERE table_schema = '" + nameBD + "' AND table_name = '" + 
                                                            nameTables + "' AND column_name = '" + 
                                                            nameFields + "' AND data_type IS NOT NULL");//Metodo para obtener los types de la tabla 
                    while(resultTypes.next()){
                            String types = resultTypes.getString(1);//retorna los campos de las tablas
                            f.setTypes(types);
                            ent.getFields().add(f);
                
                    }
            }
                            ResultSet resultPrimary = database.query(   "SELECT column_name FROM INFORMATION_SCHEMA.COLUMNS \n" +
                                                                        "WHERE table_schema = '" + nameBD + "' \n" +
                                                                        "AND table_name = '"+ nameTables + "' \n" +
                                                                        "AND column_key = 'PRI'\n" +
                                                                        "AND data_type IS NOT NULL");//Metodo para obtener los types de la tabla 
                            while(resultPrimary.next()){
                                Field f = new Field();
                                    String namePrimary = resultPrimary.getString(1);//retorna los campos de las tablas
                                    f.setPrimarys(namePrimary);
                                    ent.getFields().add(f);
                                    m.getEntities().add(ent);
                            }
               
              
            }
             
             
             ResultSet resultForeign = database.query("SELECT table_name, column_name, referenced_table_name, referenced_column_name \n" +
                                                        "FROM INFORMATION_SCHEMA.key_column_usage \n" +
                                                        "WHERE referenced_table_schema = '" + nameBD + "'\n" +
                                                        "AND referenced_table_name \n" +
                                                        "IS NOT NULL\n" +
                                                        "ORDER BY table_name, column_name");//Metodo para obtener los llaves Foraneas
                    while(resultForeign.next()){
                            Relation r = new Relation();
                            String tabla_name = resultForeign.getString(1);//retorna los campos de las tablas
                            String column_name = resultForeign.getString(2);//retorna los campos de las tablas
                            String referenced_tabla_name = resultForeign.getString(3);//retorna los campos de las tablas
                            String referenced_column_name = resultForeign.getString(4);//retorna los campos de las tablas
                            r.setEntidadOrigen(tabla_name);
                            r.setCampoOrigen(column_name);
                            r.setEntidadDestino(referenced_tabla_name);
                            r.setCampoDestino(referenced_column_name);
                            ent.getRelations().add(r);
                
                    }
              
             
             
             
        }
        
        catch(Exception e){  
        }
        return m; 
    }


}
