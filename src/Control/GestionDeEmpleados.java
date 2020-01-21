
package Control;

import DAO.EmpleadoDAO;
import Entidad.Empleado;
import java.util.List;



public class GestionDeEmpleados extends Verificaciones{
    public EmpleadoDAO edao= new EmpleadoDAO();
    
    public Empleado VerificarEmpleado(Empleado empleado){
        Empleado emp1=edao.verificarUsuario(empleado);
        return emp1;
    }
    
    public String logIn (Empleado usuario) {
        Empleado empleado;
        empleado = VerificarEmpleado(usuario);
       
        if (!empExist(usuario)){
            return null;
        }else if("Gerente".equals(empleado.getCargo())){
            return "Gerente";
        }
        
        return "Empleado";
        
    }
    
    //esta funcion no hace fata probarla
    public boolean empExist (Empleado emp){
        Empleado usuario;
        usuario = VerificarEmpleado(emp);
        if (usuario==null){
            return false;
        }else{return true;}
        
    }
    
    public String contratarEmpleado(String nombre, String apellido, String cedula, String usuario, String contrasenia){
        Empleado empleado= new Empleado();
        
        if(nombre.equals("")){
            return "El empleado debe tener un nombre.";
        }else if(apellido.equals("")){
            return "El empleado debe tener un apellido.";
        }else if(cedula.equals("")){
            return "El empleado debe tener una cedula.";
        }else if(usuario.equals("")){
            return "El empleado debe tener un usuario.";
        }else if(contrasenia.equals("")){
            return "El empleado debe tener una contraseña.";
        }else{
            List<Empleado> empleados = edao.leerEMP();
            boolean existe_empleado = false;
            for(Empleado c : empleados){
                if(c.getUsuario().equals(usuario) ){
                    existe_empleado = true;
                    return "El usuario ingresado no está disponible.";
                }
            }
            if(!existe_empleado){
            empleado.setNombre(nombre);
            empleado.setApellido(apellido);
            empleado.setCargo("Empleado");
            empleado.setUsuario(usuario);
            empleado.setContrasenia(contrasenia);
            String a= cedula;
            if(isNumeric(a)){
                empleado.setCedula(Integer.parseInt(a));
                edao.crear(empleado);
                return "El empleado ha sido contratado exitosamente!";
            }
            else{
                return "La cedula no corresponde a un numero";
                }
            }
        }
        return null;
    }
    
    public String editarEmpleado (String cedulaanterior, String nuevo_nombre,String nuevo_apellido, String nuevo_usuario, String nueva_contrasenia, String nueva_cedula){
        if(isNumeric(cedulaanterior)){
            Empleado e = new Empleado();
            e.setCedula(Integer.parseInt(cedulaanterior));
            Empleado e2 = edao.leerCED(e);
            if(e2 != null){
                int n_c;
                if(nuevo_nombre.length() == 0){
                    nuevo_nombre = e2.getNombre();
                }
                if(nuevo_apellido.length() == 0){
                    nuevo_apellido = e2.getApellido();
                }
                if(nuevo_usuario.length() == 0){
                    nuevo_usuario = e2.getUsuario();
                }
                if(nueva_contrasenia.length() == 0){
                    nueva_contrasenia = e2.getContrasenia();
                }
                if(nueva_cedula.length() == 0){
                    n_c = e2.getCedula();
                }else{
                    if (!isNumeric(nueva_cedula)){return "La cedula no corresponde a un numero";}
                    n_c = Integer.parseInt(nueva_cedula);
                }
                edao.actualizarEDIT(e2, nuevo_nombre, nuevo_apellido,nuevo_usuario,nueva_contrasenia,n_c);
                return "Datos Actualizados";
            }else{
                return "No existe ningún empleado con ésta cedula.";
            }
        }else{
            return "La cedula ingresada no es valida.";
        }
      
    }

    public String despediEmpleado (String ced){
        Empleado p= new Empleado();
        if(isNumeric(ced)){
            p.setCedula(Integer.parseInt(ced));
            Empleado h=edao.leerCED(p);
            if(h==null){
                return "No existe ningún empleado con ésta cedula.";
            }
            else{
                edao.eliminar(h);
                return "El empleado fue eliminado de la base de datos";
            }
        }
        else{
            return "La cedula no corresponde a un numero";
        }
    }
}
