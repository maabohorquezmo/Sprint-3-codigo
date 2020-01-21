
package Control;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class VentasTest {
    
    private String ID_NECESARIA = "Es necesaria una ID válida para ésta operación";
    private String ID_NO_NUMERIC = "La ID debe ser un número";
    private String ID_20DIG = "La ID no puede superar los 20 dígitos";
    private String ID_NO_EXIST = "No existe ningún producto registrado con ésta ID";
    public VentasTest() {
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
    public void testVeriID() {
        Ventas v = new Ventas();
        assertEquals( v.veriID("") ,ID_NECESARIA  );
        assertEquals( v.veriID("ASD") ,ID_NO_NUMERIC  );
        assertEquals( v.veriID("123456789012345678912") ,ID_20DIG  );
        assertEquals( v.veriID("14") ,ID_NO_EXIST  );        
        
    }
}
