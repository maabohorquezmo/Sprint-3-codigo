package Entidad;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="recibos")
public class Recibo implements Serializable{
    private ArrayList<Producto> productos_vendidos = new ArrayList();
    private int valor_de_la_venta = 0;
    private String empleado;
                @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
                
    public void generar_recibo(){
        
    }
    
    public ArrayList<Producto> getProductos_vendidos() {
        return productos_vendidos;
    }

    public void setProductos_vendidos(ArrayList<Producto> productos_vendidos) {
        this.productos_vendidos = productos_vendidos;
    }

    public int getValor_de_la_venta() {
        return valor_de_la_venta;
    }

    public void setValor_de_la_venta(int valor_de_la_venta) {
        this.valor_de_la_venta = valor_de_la_venta;
    }

    public String getEmpleado() {
        return empleado;
    }

    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
