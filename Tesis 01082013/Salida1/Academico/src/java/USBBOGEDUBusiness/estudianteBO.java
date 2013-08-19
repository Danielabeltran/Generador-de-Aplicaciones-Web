package USBBOGEDUBusiness;


import USBBOGEDUData.estudiante DAO;
import USBBOGEDUEntities.estudiante;
import java.util.List;

public class estudiante BO {

   
    
    /**
     * Obtiene la lista de estudiante
     * @return lista de estudiante
     */
    public List<estudiante> getAll(){
        
        // Crea un objeto de datos
        estudiante DAO dao = new estudiante DAO();
        
        // Obtiene la lista de estudiante
        List<estudiante> lista = dao.getAll();
        
        // Retorna la lista anterior
        return lista;
    }