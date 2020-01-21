
package Control;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class FidelizacionTest {
    
    private String CLT_CED = "Ingrese una Cedula";
    private String CLT_NOM = "Ingrese un Nombre";
    private String CLT_APLL = "Ingrese un Apellido";
    private String CED_NONUM = "Numero de cedula invalido";
    private String CLT_CREADO = "El cliente ha sido creado exitosamente";
    private String CLT_YA_EXISTE = "El usuario ingresado no está disponible.";
    private String CLT_NO_EDIT = "No se ha podido modificar los datos";
    private String CLT_ACTUALIZADO = "Datos modificados exitosamente";
    private String CLT_NO_DLT = "No se ha podido eliminar el cliente";
    private String CLT_DLT = "Cliente Eliminado";
    
    public FidelizacionTest() {
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
    public void testCrearCliente() {
        Fidelizacion f = new Fidelizacion();
        assertEquals(f.crearCliente("", "", ""),CLT_CED);
        assertEquals(f.crearCliente("1234", "", ""),CLT_NOM);
        assertEquals(f.crearCliente("asd", "Nicole", "Vargas"),CED_NONUM);
        assertEquals(f.crearCliente("1234", "Nicole", "Vargas"),CLT_CREADO);
        assertEquals(f.crearCliente("1234", "Nicole", "Vargas"),CLT_YA_EXISTE);
    }
    
    @Test
    public void testEditarCliente(){
        Fidelizacion f = new Fidelizacion();
        assertEquals( f.editarCliente("", "", "") , CLT_CED );
        assertEquals( f.editarCliente("asd", "", "") , CED_NONUM );
        assertEquals( f.editarCliente("3210556", "", "Vargas Bello") , CLT_NO_EDIT );
        assertEquals( f.editarCliente("1234", "", "Vargas Bello") , CLT_ACTUALIZADO );
    }
    
    @Test
    public void testEliminarCliente(){
        Fidelizacion f = new Fidelizacion();
        f.crearCliente("4321", "Karen", "Arenas");
        assertEquals( f.eliminarCliente("")  , CLT_CED   );
        assertEquals( f.eliminarCliente("asd")  , CED_NONUM   );
        assertEquals( f.eliminarCliente("3210556")  , CLT_NO_DLT   );
        assertEquals( f.eliminarCliente("4321")  , CLT_DLT   );
                
    }
}
