/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import DAO.EmpleadoDAO;
import Entidad.Producto;
//import Entidad.Sistema;
//import Frontera.FramePrincipal;
import DAO.ProductoDAO;
import DAO.ReciboDAO;
import Entidad.Empleado;
/**
 *
 * @author User
 */
public class Verificaciones {
    
    public ProductoDAO pdao= new ProductoDAO();
    public EmpleadoDAO edao= new EmpleadoDAO();
    public ReciboDAO rdao= new ReciboDAO();
    
    public Verificaciones() {
    }
    public boolean verificarnombrenuevo(String nombre){
        Producto producto= new Producto();
        producto.setNombre(nombre);
        
        if(pdao.leerNOM(producto)==null){
            return true;
        }
        return false;
        /*for(Producto p: FramePrincipal.sistema.getProductos()){
            if(p.getNombre().equals(nombre)){
                return false;
            }
        }
        return true;
*/
    }
    public String AddProductoNuevo(Producto producto){
        /*
        if(!verificarnombrenuevo(producto.getNombre())){
            return "Nombre ya existente!";
        }*/
        if(producto.getCantidad()<0){
            return "No puede inicializar el producto con una cantidad negativa!";
        }
        if(producto.getValor()<0){
            return "No puede inicializar el producto con un valor negativo!";
        }
        //FramePrincipal.sistema.add(producto);
                pdao.crear(producto);
        return "Nuevo producto ingresado exitosamente!";
    }
    public boolean isNumeric(String cadena){
	try {
		Integer.parseInt(cadena);
		return true;
	} catch (NumberFormatException nfe){
		return false;
	}
    }
    public boolean VerificarExistenciaID(int id){
        Producto producto= new Producto();
        producto.setId(id);
        
        if(pdao.leerID(producto)==null){
            return false;
        }
        else
            return true;
    }
    public Empleado VerificarEmpleado(Empleado empleado){
        Empleado emp1=edao.verificarUsuario(empleado);
        return emp1;
    }
}
