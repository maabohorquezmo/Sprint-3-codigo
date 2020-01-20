
package Control;

import Entidad.Producto;
import DAO.ProductoDAO;
import java.math.BigInteger;
import java.util.List;


public class GestionDeProductos extends Verificaciones{
    
    public ProductoDAO pdao = new ProductoDAO();
    
    public GestionDeProductos() {
    }
    public boolean verificarnombrenuevo(String nombre){
        Producto producto= new Producto();
        producto.setNombre(nombre);
        
        if(pdao.leerNOM(producto)==null){
            return true;
        }
        return false;
    }
    
    public String AddProductoNuevo(Producto producto){
        if(producto.getCantidad()<0){
            return "La cantidad inicial de productos no puede ser negativa";
        }
        if(producto.getCantidad()==0){
            return "La cantidad inicial de productos no puede ser cero";
        }
        if(producto.getValor()<0){
            return "El precio no puede ser negativo";
        }
                pdao.crear(producto);
        return "Nuevo producto ingresado exitosamente!";
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
    
    public String anadirExistencias(String id,String cantidad){
        if(id.length()==0){
            return "Es necesaria una ID válida para ésta operación";
        }else if(!isNumeric(id)){
            return "La ID debe ser un número";
        }else if(20<id.length()){
            return "La ID no puede superar los 20 dígitos";
        }else if(!VerificarExistenciaID(Integer.parseInt(id))){
            
            return "No existe ningún producto registrado con ésta ID";
        }else{
            
            if(cantidad.length()==0){
                return "No se ha agregado ninguna cantidad";
            }else if(!isNumeric(cantidad)){
                return "Ingrese un número como cantidad nueva";
            }else if(20<cantidad.length()){
                return "El número de digitos no debe ser mayor a 20";
            }else if(Integer.parseInt(cantidad)<0){
                return "La cantidad nueva de productos no puede ser negativa";
            }else{
                Producto producto= new Producto();
                producto.setId(Integer.parseInt(id));
                int a= pdao.leerID(producto).getCantidad();
                int b= a+Integer.parseInt(cantidad);
                pdao.actualizarCANT(producto, b);
                return "Existencias añadidas"; 
            }
        }
    }
    
    public String anadirProducto(String nombreProductoAnadido, String precio, String cantidad,String categoriaProductoAnadido){
        Producto producto= new Producto();
        producto.setNombre(nombreProductoAnadido);
        if(producto.getNombre().length()==0){
            return "Todo producto debe tener un nombre";
        }else{
            if(producto.getNombre().length()<51){
                int valor;
                if(precio.length()!=0){
                    if(cantidad.length()!=0){
                        if(!isNumeric(cantidad)){
                            return "Ingrese un numero como cantidad inicial";
                        }
                        else if (!isNumeric(precio)){
                            return "Ingrese un numero como precio";
                        }
                        else if(20<precio.length()){
                            return "El número de digitos no debe ser mayor a 20";
                        }
                        else if(20<cantidad.length()){
                            return "El número de digitos no debe ser mayor a 20";
                        }
                        else{
                            producto.setCantidad(Integer.parseInt(cantidad));
                            producto.setValor(Integer.parseInt(precio));
                            producto.setCategoria(categoriaProductoAnadido);
                        return AddProductoNuevo(producto);
                        }
                    }else{
                        return "Todo producto debe tener una cantidad inicial de unidades";
                    }
                }else{
                    return "Todo producto debe tener un precio";
                }
            }else{
                return "El nombre del producto no puede superar los 50 caracteres";
            }
        }
        
        
    }
    
    public String quitarProducto(String text){
        if(text.length()!=0){
            if(isNumeric(text)){
                if(text.length()<20){
                    if(VerificarExistenciaID(Integer.parseInt(text))){
                        Producto p= new Producto();
                        p.setId(Integer.parseInt(text));
                        pdao.eliminar(p);
                        return "Producto Eliminado con éxito";
                    }
                    else{
                        return "No existe ningún producto registrado con ésta ID";
                    }
                }
                else{
                    return "La ID no puede superar los 20 dígitos";
                }
            }
            else{
                return "La ID debe ser un número";
            }
        }
        else{
            return "Es necesaria una ID válida para ésta operación";
        }
    }
    
    public String quitarExistencias(String id,String cantidad){
        if(id.length()==0){
            return "Es necesaria una ID válida para ésta operación";
        }else if(!isNumeric(id)){
            return "La ID debe ser un número";
        }else if(20<id.length()){
            return  "La ID no puede superar los 20 dígitos";
        }else if(!VerificarExistenciaID(Integer.parseInt(id))){
            return "No existe ningún producto registrado con ésta ID";
        }else{
            if(cantidad.length()==0){
                return "No se ha agregado ninguna cantidad";
            }else if(!isNumeric(cantidad)){
                return "Ingrese un número como cantidad nueva";
            }else if(20<cantidad.length()){
                return "El número de digitos no debe ser mayor a 20";
            }else if(Integer.parseInt(cantidad)<0){
                return "La cantidad nueva de productos no puede ser negativa";
            }else{
                Producto producto= new Producto();
                    producto.setId(Integer.parseInt(id));
                    int a= pdao.leerID(producto).getCantidad();
                    if(a>=Integer.parseInt(cantidad)){
                        int b=a-Integer.parseInt(cantidad);
                        pdao.actualizarCANT(producto, b);
                        return "Existencias eliminadas";
                    }
                    else{
                        return "No hay suficientes existencias para ser eliminadas";
                    } 
            }
        }
    }
    
    public String editarProducto(String id, String nombre, String precio){
        if(id.length()==0){
            return "Es necesaria una ID válida para ésta operación";
        }else if(!isNumeric(id)){
            return "La ID debe ser un número";
        }else if(id.length()>20){
            return "La ID no puede superar los 20 dígitos";
        }else if(!VerificarExistenciaID(Integer.parseInt(id))){
            return "No existe ningún producto registrado con ésta ID";
        }else{
            if(precio.length()==0 && nombre.length()!=0){
                if(50<nombre.length()){
                    return "El nombre del producto no puede superar los 50 caracteres";
                }else{
                    Producto productoconlaID= new Producto();
                    productoconlaID.setId(Integer.parseInt(id));
                    Producto productoanterior = pdao.leerID(productoconlaID);
                    pdao.actualizarEDIT(productoanterior,nombre,productoanterior.getValor());
                    return "Producto actualizado";
                }
            }else if(precio.length()!=0 && nombre.length()==0){
                if(!isNumeric(precio)){
                    return "Ingrese un numero como precio";
                }else if(precio.length()>20){
                    return "El número de digitos no debe ser mayor a 20";
                }else if(Integer.parseInt(precio)<0){
                    return "El precio no puede ser negativo";
                }else{
                    Producto productoconlaID= new Producto();
                    productoconlaID.setId(Integer.parseInt(id));
                    Producto productoanterior = pdao.leerID(productoconlaID);
                    pdao.actualizarEDIT(productoanterior,productoanterior.getNombre(),Integer.parseInt(precio));
                    return "Producto actualizado";
                }
            }else if(precio.length()!=0 && nombre.length()!=0){
                if(50<nombre.length()){
                    return "El nombre del producto no puede superar los 50 caracteres";
                }else if(!isNumeric(precio)){
                    return "Ingrese un numero como precio";
                }else if(20<precio.length()){
                    return "El número de digitos no debe ser mayor a 20";
                }else if(Integer.parseInt(precio)<0){
                    return "El precio no puede ser negativo";
                }else{
                    Producto productoconlaID= new Producto();
                    productoconlaID.setId(Integer.parseInt(id));
                    Producto productoanterior = pdao.leerID(productoconlaID);
                    pdao.actualizarEDIT(productoanterior,nombre,Integer.parseInt(precio));
                    return "Producto actualizado";
                }
            }else{
                return "No se ha cambiado ningún elemento";
            }
        }
    }
    
    public String consultaId (String id) {
        if(id.length()==0){
                return "Es necesaria una ID válida para ésta operación";
            }else if(!isNumeric(id)){
                return "La ID debe ser un número";
            }else if(20<id.length()){
                return "La ID no puede superar los 20 dígitos";
            }else if(!VerificarExistenciaID(Integer.parseInt(id))){
                return "No existe ningún producto registrado con ésta ID";
            }else{
                Producto p= new Producto();
                p.setId(Integer.parseInt(id));
                Producto producto=pdao.leerID(p);
                return "Nombre: " + producto.getNombre() +" Cantidad: " + producto.getCantidad() +" Valor unitario: "+ producto.getValor() + " Categoría: " + producto.getCategoria();
                
            }
    }
    
    public List<Producto> consultaCategoria (String categoria){
        Producto x= new Producto();
        x.setCategoria(categoria);
        List <Producto> lista = pdao.leerCAT(x);
        return lista;
    }
}
