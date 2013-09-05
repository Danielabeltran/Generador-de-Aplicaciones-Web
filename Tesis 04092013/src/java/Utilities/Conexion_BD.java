package Utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author 
 */

public class Conexion_BD 
{
    /* Cadena de conexion:
     * Hay que tener en cuenta el collation de la base de datos.
     * Por defecto, Java trata de conectarse con el collation utfmb4 el cual no es soporta por 
     * las ultimas versiones de MySQL.
     * Para especificar el collation (characterEncoding) en la cadena de conexión se usa la
     * siguiente cadena de conexión:
     * jdbc://mysql://localhost:3306/basededatos?characterEncoding=latin1
     * En el ejemplo se usa latin1 como character encoding.
     * La lista de las opciones para usar en ese parámetro está en 
     * http://dev.mysql.com/doc/refman/5.0/en/connector-j-reference-charsets.html
     */
    
    private String url = "jdbc:mysql://localhost:3306/Academico?characterEncoding=latin1";
    private String driver = "com.mysql.jdbc.Driver";
    private String user = "root";
    private String password = "";
    
    public  Connection connection;
    private ResultSet rs;
    private Statement statement;
    private String error;
    
    public Conexion_BD(){

        this.rs = null;
        this.error = null;

        try { // Instancia de una nueva clase para el puente
            Class.forName(this.driver);
        } catch (ClassNotFoundException e) {
            System.out.println("Error al crear el driver JDBC con MySQL.");
        }

    }
    
        /**
     * Contructor
     * @param url	URL
     * @param driver    Driver
     * @param usr       User
     * @param pswd      Password
     */

    //                 "jdbc:odbc:"  "Servlets"      ""          "registro"
    public Conexion_BD(String url, String driver, String user, String password) {
        this.url = url;
        this.driver = driver;
        this.user = user;
        this.password = password;
        this.rs = null;
        this.error = null;

        try { // Instancia de una nueva clase para el puente
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error al crear el driver JDBC con MySQL.");
        }
    }
    
    /**
     * Obtiene una conexión con el nombre del driver especificado
     * @return connection Conexión con la base de datos.
     */
    public Connection makeConnection(){
 //        this.url = this.url + this.driver;       
        try {
            this.connection = DriverManager.getConnection(this.url, this.user, this.password);
        } catch (SQLException sqle) {
            return null;
        }
        return this.connection;
    }

    /**
     * Cierra la conexión.
     * @return boolean Retorna true si la conexión fue cerrada con exito.
     */
    public boolean closeConnection() {
        try {
            connection.close();
        } catch (SQLException sqle) {
            return false;
        }
        return true;
    }
    /**
     * Utilizada para INSERT, UPDATE, o DELETE.
     * @param  sql
     * @return reg Número de registros afectados.
     */
    public int nonQuery(String sql) throws SQLException {
        try {
            this.statement = this.connection.createStatement();
            return statement.executeUpdate(sql);
        } catch (SQLException e) { // System.out.println("Error en update: " + e.getMessage());
            error = "Error en update: " + e.getMessage();
        }
        return -1;
    }

    
   /**
     * Retorna el resultado de la consulta ejecutada.
     * @param  sql Consulta a realizar.
     * @return rst Resultado de la consulta
     */
    public ResultSet query(String sql) throws SQLException {

        try {
            this.statement = this.connection.createStatement();
            this.rs = statement.executeQuery(sql);
        }catch(SQLException e){
            Logger.getLogger(Conexion_BD.class.getName()).log(Level.INFO, null, e);
        }
        
        return this.rs;
    }
    /**
     * Obtiene el identificador autonumérico generado despues de haber invocado
     * el método nonQuery con un INSERT
     * @return identificador generado por la base de datos y -1 si no se generaron llaves.
     */
    public int getGeneratedKey(){

        try {
            // Obtiene la lista de llaves generadas
            ResultSet generatedKeys = this.statement.getGeneratedKeys();
            
            // Si encontró una llave generada la retorna
            if (generatedKeys.next()) {
                return generatedKeys.getInt(1);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Conexion_BD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Si no hay llaves generadas retorna -1
        return -1;
        
    }

    public String getError() {
        return error;
    }

  
}