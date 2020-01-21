
package Control;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class EstadisticasTest {
    
    private String CED_NEC = "Es necesario un numero de cedula";
    private String CED_NO_NUM = "Ingrese un numero como cedula";
    private String CED_NO_REG = "El numero de cedula no se encuentra registrado";
    public EstadisticasTest() {
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
    public void testConsultaIndividualEMP() {
        Estadisticas e = new Estadisticas();
        assertEquals(e.consultaIndividualEMP("") ,CED_NEC );
        assertEquals(e.consultaIndividualEMP("ASD") ,CED_NO_NUM );
        assertEquals(e.consultaIndividualEMP("3210556") ,CED_NO_REG );
        assertEquals(e.consultaIndividualEMP("99090") , "0" );
    }
    
    @Test
    public void testConsultaIndividualCLIENT(){
        Estadisticas e = new Estadisticas();
        assertEquals(  e.consultaIndividualCLIENT("") ,CED_NEC  );
        assertEquals(  e.consultaIndividualCLIENT("asd") , CED_NO_NUM );
        assertEquals(  e.consultaIndividualCLIENT("3210556") , CED_NO_REG );
        assertEquals(  e.consultaIndividualCLIENT("1234") ,  "0");
       
    }
}
