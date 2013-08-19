package USBBOGEDUBusiness;


import USBBOGEDUData.profesor DAO;
import USBBOGEDUEntities.profesor;
import java.util.List;

public class profesor BO {

   
    
    /**
     * Obtiene la lista de profesor
     * @return lista de profesor
     */
    public List<profesor> getAll(){
        
        // Crea un objeto de datos
        profesor DAO dao = new profesor DAO();
        
        // Obtiene la lista de profesor
        List<profesor> lista = dao.getAll();
        
        // Retorna la lista anterior
        return lista;
    }