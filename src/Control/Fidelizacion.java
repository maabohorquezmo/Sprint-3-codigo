
package Control;

import DAO.ClienteDAO;
import Entidad.Cliente;
import java.util.List;


public class Fidelizacion extends Verificaciones{
    
    public ClienteDAO cdao = new ClienteDAO();
    
    
    
    public String crearCliente(String cedula, String nombre, String apellido){
        if (cedula.length()==0){return "Ingrese una Cedula";}
        if (nombre.length()==0){return "Ingrese un Nombre";}
        if (apellido.length()==0){return "Ingrese un Apellido";}
        if (!isNumeric(cedula)){return "Numero de cedula invalido";}
        List<Cliente> clientes = cdao.leerCLIENT();
            boolean existe_empleado = false;
            for(Cliente c : clientes){
                if(c.getCedula()==Integer.parseInt(cedula) ){
                    existe_empleado = true;
                    return "El usuario ingresado no está disponible.";
                }
            }
        Cliente cliente = new Cliente();
        cliente.setCedula(Integer.parseInt(cedula));
        cliente.setNombre(nombre);
        cliente.setApellido(apellido);
        cdao.crear(cliente);
        return "El cliente ha sido creado exitosamente";
    }
    
    public Cliente consultarCliente(String cedula){
        if (cedula.length()==0){return null;}
        if (!isNumeric(cedula)){return null;}
        Cliente cliente = new Cliente();
        cliente.setCedula(Integer.parseInt(cedula));
        return cdao.leerCED(cliente);
    }
    
    public String editarCliente (String cedula, String nuevoNombre, String nuevoApellido){
        if (cedula.length()==0){return "Ingrese una Cedula";}
        if (!isNumeric(cedula)){return "Numero de cedula invalido";}
        Cliente cliente = new Cliente();
        cliente.setCedula(Integer.parseInt(cedula));
        if (cdao.actualizarEDIT(cliente, nuevoNombre, nuevoApellido)){
            return "Datos modificados exitosamente";
        }else {return "No se ha podido modificar los datos";}
        
    }
    
    public String eliminarCliente (String cedula) {
        if (cedula.length()==0){return "Ingrese una Cedula";}
        if (!isNumeric(cedula)){return "Numero de cedula invalido";}
        Cliente cliente = new Cliente();
        cliente.setCedula(Integer.parseInt(cedula));
        Cliente aux = new Cliente();
        aux = cdao.leerCED(cliente);
        if (aux != null) {
            cdao.eliminar(aux);
            return "Cliente Eliminado";
        }else{return "No se ha podido eliminar el cliente";}
    }
    
    public String restarPuntos (String cedula, int puntos) {
        Cliente aux = new Cliente();
        aux.setCedula(Integer.parseInt(cedula));
        aux = cdao.leerCED(aux);
        if (puntos<=aux.getPuntos()) {
            cdao.restarPuntos(aux, puntos);
            return "Cupon Generado";
        }else{return "Puntos Insuficientes";}
        
    }
    
    
}
