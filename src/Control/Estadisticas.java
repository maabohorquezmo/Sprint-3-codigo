
package Control;

import DAO.ClienteDAO;
import DAO.EmpleadoDAO;
import DAO.ReciboDAO;
import Entidad.Cliente;
import Entidad.Empleado;        
import Entidad.Recibo;
import java.util.List;


public class Estadisticas extends Verificaciones{

    ReciboDAO rdao = new ReciboDAO();
    public ClienteDAO cdao = new ClienteDAO();
    public EmpleadoDAO edao = new EmpleadoDAO();
    
    
    public int getVentas(String cedula) {
        List<Recibo> recibo = rdao.ventasEmpleado(cedula);
        return recibo.size();
    }
    
    public int getCompras(String cedula){
        List <Recibo> cliente = rdao.comprasCliente(cedula);
        return cliente.size();
    }
    
    public String consultaIndividualEMP(String cedula){
        if(cedula.length()==0){return "Es necesario un numero de cedula";}
        if(!isNumeric(cedula)){return "Ingrese un numero como cedula";}
        Empleado aux = new Empleado();
        aux.setCedula(Integer.parseInt(cedula));
        aux= edao.leerCED(aux);
        if (aux == null){return "El numero de cedula no se encuentra registrado";}
        return Integer.toString(getVentas(cedula));
    }
    
    public String consultaIndividualCLIENT (String cedula){
        if(cedula.length()==0){return "Es necesario un numero de cedula";}
        if(!isNumeric(cedula)){return "Ingrese un numero como cedula";}
        Cliente aux = new Cliente();
        aux.setCedula(Integer.parseInt(cedula));
        aux= cdao.leerCED(aux);
        if (aux == null){return "El numero de cedula no se encuentra registrado";}
        return Integer.toString(getCompras(cedula));
    }
    
}
