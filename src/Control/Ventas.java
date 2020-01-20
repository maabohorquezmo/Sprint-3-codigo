package Control;

import DAO.ClienteDAO;
import DAO.ProductoDAO;
import Entidad.Cliente;
import Entidad.Producto;
import Entidad.Recibo;
import Frontera.Inicio;
import java.util.ArrayList;
import Frontera.Inicio;

public class Ventas extends Verificaciones {

    public ProductoDAO pdao = new ProductoDAO();
    public ClienteDAO cdao = new ClienteDAO();

    public String verificarDatos(String id, String cantidad) {
        String resultado;
        resultado = veriID(id);
        if (resultado.equals("")) {
            return veriCantidad(cantidad);
        }
        return resultado;
    }

    public String veriID(String id) {
        GestionDeProductos ver = new GestionDeProductos();
        if (id.length() == 0) {
            return "Es necesaria una ID válida para ésta operación";
        } else if (!ver.isNumeric(id)) {
            return "La ID debe ser un número";
        } else if (20 < id.length()) {
            return "La ID no puede superar los 20 dígitos";
        } else if (!ver.VerificarExistenciaID(Integer.parseInt(id))) {
            return "No existe ningún producto registrado con ésta ID";
        }
        return "";
    }

    public String veriCantidad(String cantidad) {
        if (cantidad.length() == 0) {
            return "No se ha agregado ninguna cantidad";
        } else if (!isNumeric(cantidad)) {
            return "Ingrese un número como cantidad";
        } else if (20 < cantidad.length()) {
            return "El número de digitos no puede ser mayor a 20";
        } else if (Integer.parseInt(cantidad) < 0) {
            return "La cantidad de productos no puede ser negativa";
        }
        return "";
    }

    public String anadirAlCarro(String id, String cantidad) {
        int a = Integer.parseInt(id);
        int b = Integer.parseInt(cantidad);
        Producto x = new Producto();
        x.setId(a);
        Producto transicion = pdao.leerID(x);
        if (transicion.getCantidad() >= b) {
            transicion.setCantidad(b);
            return "Producto encontrado";

        } else {
            return "No hay suficientes unidades para vender";
        }
    }
    
    public ArrayList<String> venderNoCedula (ArrayList<Producto> carrito) {
        String msj = "";
        Recibo recibo = new Recibo();
        ArrayList<String> resultado = new ArrayList<String>();
        for (Producto c : carrito) {
                Producto a = pdao.leerID(c);
                if(a.getCantidad()<c.getCantidad()){
                    msj= "##Algunos productos no han podido ser vendidos##";
                }else{
                int b = a.getCantidad() - c.getCantidad();
                int n = recibo.getValor_de_la_venta();
                recibo.setValor_de_la_venta(n + c.getCantidad() * a.getValor());
                pdao.actualizarCANT(a, b);
                }
        }
        resultado.add(0, Integer.toString(recibo.getValor_de_la_venta()));
        resultado.add(1, Inicio.empleado.getNombre() + " " +Inicio.empleado.getApellido());
        resultado.add(2, "");
        resultado.add(3, "Existencias eliminadas");
        resultado.add(4,msj);
        recibo.setEmpleado(Integer.toString(Inicio.empleado.getCedula()));
        rdao.crear(recibo);
        return resultado;
    }
    
    public ArrayList<String> venderCedula (ArrayList<Producto> carrito,String cedula) {
        String msj = "";
        Recibo recibo = new Recibo();
        Cliente client = new Cliente();
        client.setCedula(Integer.parseInt(cedula));
        ArrayList<String> resultado = new ArrayList<String>();
        for (Producto c : carrito) {
                Producto a = pdao.leerID(c);
                if(a.getCantidad()<c.getCantidad()){
                    msj= "##Algunos productos no han podido ser vendidos##";
                }else{
                int b = a.getCantidad() - c.getCantidad();
                int n = recibo.getValor_de_la_venta();
                recibo.setValor_de_la_venta(n + c.getCantidad() * a.getValor());
                pdao.actualizarCANT(a, b);
                }
        }
        client=cdao.leerCED(client);
        int puntos = recibo.getValor_de_la_venta()/700;
        resultado.add(0, Integer.toString(recibo.getValor_de_la_venta()));
        resultado.add(1, Inicio.empleado.getNombre() + " " +Inicio.empleado.getApellido());
        resultado.add(2, client.getNombre() + " " + client.getApellido());
        resultado.add(3, "Existencias eliminadas / " + puntos + " puntos añadidos al usuario.");
        resultado.add(4, msj);
        recibo.setEmpleado(Inicio.empleado.getUsuario());
        client.setPuntos(client.getPuntos()+ puntos);
        recibo.setCedula(cedula);
        cdao.sumarPuntos(client, puntos);
        recibo.setEmpleado(Integer.toString(Inicio.empleado.getCedula()));
        rdao.crear(recibo);
        
        return resultado;
    }
    
    
    
    
}
