
package Control;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import Control.GestionDeProductosTest;
import static org.junit.Assert.*;


public class GestionDeProductosTest {
    
    //AÑADIR & EDITAR PRODUCTO
    private String TODO_PRO_NOM = "Todo producto debe tener un nombre";
    private String PRO_NOM_MAY_50 = "El nombre del producto no puede superar los 50 caracteres";
    private String PRO_ING_EXITO = "Nuevo producto ingresado exitosamente!";
    private String TODO_PRO_PRE = "Todo producto debe tener un precio";
    private String ING_NUM_PRE = "Ingrese un numero como precio";
    private String NUM_DIG_MAY_20 = "El número de digitos no debe ser mayor a 20";
    private String PRE_NEGATIVO = "El precio no puede ser negativo";
    private String CANT_INICIAL_UNIDADES = "Todo producto debe tener una cantidad inicial de unidades";
    private String CANT_INICIAL_NUM = "Ingrese un numero como cantidad inicial";
    private String CANT_INICIAL_NEG = "La cantidad inicial de productos no puede ser negativa";
    private String CANT_INICIAL_CERO = "La cantidad inicial de productos no puede ser cero";
    
    //QUITAR PRODUCTO & EDITAR & (ANADIR&QUITAR_EXISTENCIAS)
    private String ID_NECESARIA = "Es necesaria una ID válida para ésta operación";
    private String ID_MAY_20 = "La ID no puede superar los 20 dígitos";
    private String ID_NO_NUM = "La ID debe ser un número";
    private String ID_NO_EXISTE = "No existe ningún producto registrado con ésta ID";
    private String PRO_ELIMINADO = "Producto Eliminado con éxito";
    
    //EDITAR
    private String PROD_ACTUALIZADO = "Producto actualizado";
    private String NO_HAY_CAMBIO = "No se ha cambiado ningún elemento";
    
    //ANADIR_EXISTENCIAS
    private String NO_SE_AGREGO = "No se ha agregado ninguna cantidad";
    private String CANT_NO_NUM = "Ingrese un número como cantidad nueva";
    private String CANT_NEGATIVA = "La cantidad nueva de productos no puede ser negativa";
    private String CANT_ACTUALIZADA = "Existencias añadidas";
    
    //QUITAR_EXISTENCIAS
    private String PRODUCTO_ELIM = "Existencias eliminadas";
    private String NO_HAY_SUFUCIENTES = "No hay suficientes existencias para ser eliminadas";
    
    //CONDULTA_ID
    private String EJM_CONSULTA = "Nombre: Shell Cantidad: 55 Valor unitario: 80000 Categoría: Lubricantes";
    
    public GestionDeProductosTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testAnadirProducto() {
        GestionDeProductos gp= new GestionDeProductos();
        assertEquals(gp.anadirProducto("", "30", "20", "Combustible"), TODO_PRO_NOM);
        assertEquals(gp.anadirProducto("Acpm1234567890poiuytrewqasdfghjkklññmnbvcxzeae256ya", "30", "20", "Combustible"), PRO_NOM_MAY_50);
        assertEquals(gp.anadirProducto("Acpm", "30", "20", "Combustible"),PRO_ING_EXITO );
        assertEquals(gp.anadirProducto("Acpm", "", "20", "Combustible"), TODO_PRO_PRE);
        assertEquals(gp.anadirProducto("Acpm", "A3d", "20", "Combustible"), ING_NUM_PRE);
        assertEquals(gp.anadirProducto("Acpm", "123456789012345678901", "20", "Combustible"),NUM_DIG_MAY_20 );
        assertEquals(gp.anadirProducto("Acpm", "-1", "20", "Combustible"), PRE_NEGATIVO);
        assertEquals(gp.anadirProducto("Acpm", "30", "", "Combustible"), CANT_INICIAL_UNIDADES);
        assertEquals(gp.anadirProducto("Acpm", "30", "A3d", "Combustible"), CANT_INICIAL_NUM);
        assertEquals(gp.anadirProducto("Acpm", "30", "123456789012345678901", "Combustible"),NUM_DIG_MAY_20 );
        assertEquals(gp.anadirProducto("Acpm", "30", "-1", "Combustible"), CANT_INICIAL_NEG);
        assertEquals(gp.anadirProducto("Acpm", "30", "0", "Combustible"), CANT_INICIAL_CERO);
    }
    
    @Test
    public void testEditarProducto() {
        GestionDeProductos gp= new GestionDeProductos();
        assertEquals(gp.editarProducto("", "Corriente", "40"), ID_NECESARIA);
        assertEquals(gp.editarProducto("123456789012345678901", "Corriente", "40"),ID_MAY_20 );
        assertEquals(gp.editarProducto("1t3", "Corriente", "40"), ID_NO_NUM);
        assertEquals(gp.editarProducto("-3", "Corriente", "40"), ID_NO_EXISTE);
        assertEquals(gp.editarProducto("1", "Corriente", "40"), PROD_ACTUALIZADO);
        
        assertEquals(gp.editarProducto("1", "Acpm1234567890poiuytrewqasdfghjkklññmnbvcxzeae256ya", "40"), PRO_NOM_MAY_50);
        assertEquals(gp.editarProducto("1", "Corriente", "A3d"), ING_NUM_PRE);
        assertEquals(gp.editarProducto("1", "Corriente", "123456789012345678901"), NUM_DIG_MAY_20);
        assertEquals(gp.editarProducto("1", "Corriente", "-1"), PRE_NEGATIVO);
        assertEquals(gp.editarProducto("1", "", ""), NO_HAY_CAMBIO);
        assertEquals(gp.editarProducto("1", "Corriente", ""), PROD_ACTUALIZADO);
        assertEquals(gp.editarProducto("1", "", "40"), PROD_ACTUALIZADO);
    }
    
    @Test
    public void testAnadirExistencias() {
        GestionDeProductos gp= new GestionDeProductos();
        assertEquals(gp.anadirExistencias("", "40"),ID_NECESARIA );
        assertEquals(gp.anadirExistencias("123456789012345678901", "40"), ID_MAY_20);
        assertEquals(gp.anadirExistencias("-3", "40"), ID_NO_EXISTE);
        assertEquals(gp.anadirExistencias("1",""), NO_SE_AGREGO);
        assertEquals(gp.anadirExistencias("1", "A3d"), CANT_NO_NUM);
        assertEquals(gp.anadirExistencias("1", "123456789012345678901"), NUM_DIG_MAY_20);
        assertEquals(gp.anadirExistencias("1", "-1"), CANT_NEGATIVA);
        assertEquals(gp.anadirExistencias("1", "99"), CANT_ACTUALIZADA);
        
    }
    
    @Test
    public void testQuitarExistencias() {
        GestionDeProductos gp= new GestionDeProductos();
        assertEquals(gp.quitarExistencias("", "40"), ID_NECESARIA);
        assertEquals(gp.quitarExistencias("123456789012345678901", "40"),ID_MAY_20 );
        assertEquals(gp.quitarExistencias("1t3", "40"), ID_NO_NUM);
        assertEquals(gp.quitarExistencias("-3", "40"), ID_NO_EXISTE);
        assertEquals(gp.quitarExistencias("1", ""), NO_SE_AGREGO);
        assertEquals(gp.quitarExistencias("1", "A3d"), CANT_NO_NUM);
        assertEquals(gp.quitarExistencias("1", "123456789012345678901"), NUM_DIG_MAY_20);
        assertEquals(gp.quitarExistencias("1", "-1"), CANT_NEGATIVA);
        assertEquals(gp.quitarExistencias("1", "1000"), NO_HAY_SUFUCIENTES);
        assertEquals(gp.quitarExistencias("1", "2"), PRODUCTO_ELIM);
        
    }
    
    @Test 
    public void testConsultarProductoID(){
        GestionDeProductos gp= new GestionDeProductos();
        gp.anadirProducto("Shell", "80000", "55", "Lubricantes");
        assertEquals(gp.consultaId(""),ID_NECESARIA);
        assertEquals(gp.consultaId("123456789012345678901"),ID_MAY_20);
        assertEquals(gp.consultaId("1t3"),ID_NO_NUM);
        assertEquals(gp.consultaId("-3"),ID_NO_EXISTE);
        assertEquals(gp.consultaId("2"),EJM_CONSULTA);
        gp.quitarProducto("2");
    }
    
    @Test
    public void testQuitarProducto() {
        GestionDeProductos gp= new GestionDeProductos();
        assertEquals(gp.quitarProducto(""),ID_NECESARIA);
        assertEquals(gp.quitarProducto("123456789012345678901"), ID_MAY_20);
        assertEquals(gp.quitarProducto("1t3"), ID_NO_NUM);
        assertEquals(gp.quitarProducto("-3"), ID_NO_EXISTE);
        assertEquals(gp.quitarProducto("1"), PRO_ELIMINADO);   
    }
}