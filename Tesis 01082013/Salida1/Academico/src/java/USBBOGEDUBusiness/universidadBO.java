package USBBOGEDUBusiness;


import USBBOGEDUData.universidad DAO;
import USBBOGEDUEntities.universidad;
import java.util.List;

public class universidad BO {

   
    
    /**
     * Obtiene la lista de universidad
     * @return lista de universidad
     */
    public List<universidad> getAll(){
        
        // Crea un objeto de datos
        universidad DAO dao = new universidad DAO();
        
        // Obtiene la lista de universidad
        List<universidad> lista = dao.getAll();
        
        // Retorna la lista anterior
        return lista;
    }