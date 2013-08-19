package USBBOGEDUBusiness;


import USBBOGEDUData.nota DAO;
import USBBOGEDUEntities.nota;
import java.util.List;

public class nota BO {

   
    
    /**
     * Obtiene la lista de nota
     * @return lista de nota
     */
    public List<nota> getAll(){
        
        // Crea un objeto de datos
        nota DAO dao = new nota DAO();
        
        // Obtiene la lista de nota
        List<nota> lista = dao.getAll();
        
        // Retorna la lista anterior
        return lista;
    }