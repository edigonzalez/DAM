/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dam_ed04_actividad;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Pruebas
 */
public class CCuentaTest {
    
    public CCuentaTest() {
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

    /**
     * Test of asignarNombre method, of class CCuenta.
     */
    @Test
    public void testAsignarNombre() {
        System.out.println("asignarNombre");
        String nom = "";
        CCuenta instance = new CCuenta();
        instance.asignarNombre(nom);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerNombre method, of class CCuenta.
     */
    @Test
    public void testObtenerNombre() {
        System.out.println("obtenerNombre");
        CCuenta instance = new CCuenta();
        String expResult = "";
        String result = instance.obtenerNombre();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of estado method, of class CCuenta.
     */
    @Test
    public void testEstado() {
        System.out.println("estado");
        CCuenta instance = new CCuenta();
        double expResult = 0.0;
        double result = instance.estado();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ingresar method, of class CCuenta.
     */
    @Test
    public void testIngresar() throws Exception {
        System.out.println("ingresar");
        double cantidad = 0.0;
        CCuenta instance = new CCuenta();
        instance.ingresar(cantidad);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of retirar method, of class CCuenta.
     */
    @Test
    public void testRetirar() throws Exception {
        System.out.println("retirar");
        double cantidad = 0.0;
        CCuenta instance = new CCuenta();
        instance.retirar(cantidad);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerCuenta method, of class CCuenta.
     */
    @Test
    public void testObtenerCuenta() {
        System.out.println("obtenerCuenta");
        CCuenta instance = new CCuenta();
        String expResult = "";
        String result = instance.obtenerCuenta();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNombre method, of class CCuenta.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        CCuenta instance = new CCuenta();
        String expResult = "";
        String result = instance.getNombre();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNombre method, of class CCuenta.
     */
    @Test
    public void testSetNombre() {
        System.out.println("setNombre");
        String nombre = "";
        CCuenta instance = new CCuenta();
        instance.setNombre(nombre);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTipoInterés method, of class CCuenta.
     */
    @Test
    public void testGetTipoInterés() {
        System.out.println("getTipoInter\u00e9s");
        CCuenta instance = new CCuenta();
        double expResult = 0.0;
        double result = instance.getTipoInterés();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTipoInterés method, of class CCuenta.
     */
    @Test
    public void testSetTipoInterés() {
        System.out.println("setTipoInter\u00e9s");
        double tipoInterés = 0.0;
        CCuenta instance = new CCuenta();
        instance.setTipoInterés(tipoInterés);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCuenta method, of class CCuenta.
     */
    @Test
    public void testGetCuenta() {
        System.out.println("getCuenta");
        CCuenta instance = new CCuenta();
        String expResult = "";
        String result = instance.getCuenta();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCuenta method, of class CCuenta.
     */
    @Test
    public void testSetCuenta() {
        System.out.println("setCuenta");
        String cuenta = "";
        CCuenta instance = new CCuenta();
        instance.setCuenta(cuenta);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSaldo method, of class CCuenta.
     */
    @Test
    public void testGetSaldo() {
        System.out.println("getSaldo");
        CCuenta instance = new CCuenta();
        double expResult = 0.0;
        double result = instance.getSaldo();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSaldo method, of class CCuenta.
     */
    @Test
    public void testSetSaldo() {
        System.out.println("setSaldo");
        double saldo = 0.0;
        CCuenta instance = new CCuenta();
        instance.setSaldo(saldo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
