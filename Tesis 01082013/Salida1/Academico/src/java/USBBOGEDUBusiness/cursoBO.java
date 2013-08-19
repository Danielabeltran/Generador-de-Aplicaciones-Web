package USBBOGEDUBusiness;


import USBBOGEDUData.curso DAO;
import USBBOGEDUEntities.curso;
import java.util.List;

public class curso BO {

   
    
    /**
     * Obtiene la lista de curso
     * @return lista de curso
     */
    public List<curso> getAll(){
        
        // Crea un objeto de datos
        curso DAO dao = new curso DAO();
        
        // Obtiene la lista de curso
        List<curso> lista = dao.getAll();
        
        // Retorna la lista anterior
        return lista;
    }