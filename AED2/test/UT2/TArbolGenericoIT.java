/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT2;

import UT2.TD1.TNodoArbolGenerico;
import UT2.TD1.TArbolGenerico;
import UT2.TD1.Departamentos;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author germanpujadas
 */
public class TArbolGenericoIT {
    
    public TArbolGenericoIT() {    
    }
    
    TArbolGenerico instance = new TArbolGenerico();
    TNodoArbolGenerico<Departamentos> nodo1 = new TNodoArbolGenerico<>("Uno",new Departamentos("Uno"));
    TNodoArbolGenerico<Departamentos> nodo2 = new TNodoArbolGenerico<>("Dos",new Departamentos("Dos"));
    TNodoArbolGenerico<Departamentos> nodo3 = new TNodoArbolGenerico<>("Tres",new Departamentos("Tres"));
    TNodoArbolGenerico<Departamentos> nodo4 = new TNodoArbolGenerico<>("Cuatro",new Departamentos("Cuatro"));
    
    /**
     * Test of insertar method, of class TArbolGenerico.
     */
    @Test
    public void testInsertar() {
        System.out.println("insertar");
        instance.insertar(nodo1, "");
        
        Comparable etiquetaPadre = nodo1.getEtiqueta();
        
        boolean expResult = true;
        boolean result = instance.insertar(nodo2, etiquetaPadre);
        assertEquals(expResult, result);
    }

    /**
     * Test of buscar method, of class TArbolGenerico.
     */
//    @Test
//    public void testBuscar() {
//        System.out.println("buscar");
//        Comparable etiqueta = null;
//        TArbolGenerico instance = new TArbolGenerico();
//        INodoArbolGenerico expResult = null;
//        INodoArbolGenerico result = instance.buscar(etiqueta);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of getRaiz method, of class TArbolGenerico.
     */
//    @Test
//    public void testGetRaiz() {
//        System.out.println("getRaiz");
//        TArbolGenerico instance = new TArbolGenerico();
//        INodoArbolGenerico expResult = null;
//        INodoArbolGenerico result = instance.getRaiz();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setRaiz method, of class TArbolGenerico.
//     */
//    @Test
//    public void testSetRaiz() {
//        System.out.println("setRaiz");
//        TArbolGenerico instance = new TArbolGenerico();
//        instance.setRaiz(null);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
