package USBBOGEDUBusiness;


import USBBOGEDUData.administrador DAO;
import USBBOGEDUEntities.administrador;
import java.util.List;

public class administrador BO {

   
    
    /**
     * Obtiene la lista de administrador
     * @return lista de administrador
     */
    public List<administrador> getAll(){
        
        // Crea un objeto de datos
        administrador DAO dao = new administrador DAO();
        
        // Obtiene la lista de administrador
        List<administrador> lista = dao.getAll();
        
        // Retorna la lista anterior
        return lista;
    }