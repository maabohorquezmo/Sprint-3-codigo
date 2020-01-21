package Control;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class GestionDeEmpleadosTest {

    private String EMP_NOM = "El empleado debe tener un nombre.";
    private String EMP_APELL = "El empleado debe tener un apellido.";
    private String EMP_CED = "El empleado debe tener una cedula.";
    private String EMP_USER = "El empleado debe tener un usuario.";
    private String EMP_PSWRD = "El empleado debe tener una contraseña.";
    private String EMP_CEDNONUM = "La cedula no corresponde a un numero";
    private String EMP_CONTRATADO = "El empleado ha sido contratado exitosamente!";
    private String EMP_USERNAME_ND = "El usuario ingresado no está disponible.";
    private String CED_NOVAL = "La cedula ingresada no es valida.";
    private String EMP_NO_EXIST = "No existe ningún empleado con ésta cedula.";
    private String DATOS_ACT = "Datos Actualizados";
    private String EMP_DLT = "El empleado fue eliminado de la base de datos";

    public GestionDeEmpleadosTest() {
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
    public void testContratarEmpleado() {
        GestionDeEmpleados ge = new GestionDeEmpleados();
        assertEquals(ge.contratarEmpleado("", "", "", "", ""), EMP_NOM);
        assertEquals(ge.contratarEmpleado("Laura", "", "", "", ""), EMP_APELL);
        assertEquals(ge.contratarEmpleado("Laura", "Carrillo", "", "", ""), EMP_CED);
        assertEquals(ge.contratarEmpleado("Laura", "Carrillo", "99090300", "", ""), EMP_USER);
        assertEquals(ge.contratarEmpleado("Laura", "Carrillo", "99090300", "lacarrillos", ""), EMP_PSWRD);
        assertEquals(ge.contratarEmpleado("Laura", "Carrillo", "asd", "lacarrillos", "1234"), EMP_CEDNONUM);
        assertEquals(ge.contratarEmpleado("Laura", "Carrillo", "99090300", "lacarrillos", "1234"), EMP_CONTRATADO);
        assertEquals(ge.contratarEmpleado("Laura", "Carrillo", "99090300", "lacarrillos", "1234"), EMP_USERNAME_ND);
    }
    
    @Test
    public void testEditarEmpleado() {
        GestionDeEmpleados ge = new GestionDeEmpleados();
        assertEquals(ge.editarEmpleado("ASDAS", "", "", "", "", ""), CED_NOVAL   );
        assertEquals(ge.editarEmpleado("3210556", "", "", "", "", ""), EMP_NO_EXIST   );
        assertEquals(ge.editarEmpleado("99090300", "Laura Alexandra", "Carrillo Sepulveda", "", "", "asf"), EMP_CEDNONUM);
        assertEquals(ge.editarEmpleado("99090300", "Laura Alexandra", "Carrillo Sepulveda", "", "", "99090"), DATOS_ACT);
    }
    
    public void testDespedirEmpleado(){
        GestionDeEmpleados ge = new GestionDeEmpleados();
        ge.contratarEmpleado("Kevin", "Solaque", "1234", "kasolaque", "1234");
        assertEquals(ge.despediEmpleado("ash"), EMP_CEDNONUM);
        assertEquals(ge.despediEmpleado("3210556"), EMP_NO_EXIST);
        assertEquals(ge.despediEmpleado("1234"), EMP_DLT);
    }
}
