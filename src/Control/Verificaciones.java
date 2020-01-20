
package Control;

import DAO.EmpleadoDAO;
import Entidad.Producto;
import DAO.ProductoDAO;
import DAO.ReciboDAO;
import Entidad.Empleado;
import java.math.BigInteger;

public class Verificaciones {
    
   
    public ReciboDAO rdao= new ReciboDAO();
    
    public Verificaciones() {
    }
    
    public boolean isNumeric(String cadena){
	try {
		BigInteger a = new BigInteger(cadena);
		return true;
	} catch (NumberFormatException nfe){
		return false;
	}
    }
    
    
}
