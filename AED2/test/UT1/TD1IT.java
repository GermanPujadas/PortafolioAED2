/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT1;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author germanpujadas
 */
public class TD1IT {
    
    public TD1IT() {
    }
    
    int[] vector = {1,2,3,4,5};
    TD1 instance = new TD1();

    /**
     * Test del método busqueda Lineal. Se buscan todas las claves para contemplar todos los casos de borde
     */
    @Test
    public void testBusquedaLinealExaustiva() {
        System.out.println("Busqueda Lineal");
        
        boolean resultado = false;
        for(int i =0; i<vector.length; i++){
            resultado = instance.busquedaLineal(vector, vector[i]);
        }
        assertEquals(resultado, true);
    }
    
    /**
     * Test del método busqueda Lineal. Se busca una clave que no esté en le vector.
     */
    @Test
    public void testBusquedaLinealConClaveFueraDelVector() {
        System.out.println("Busqueda Lineal");
        
        int unaClave = 10;
        boolean expResult = false;
        boolean result = instance.busquedaLineal(vector, unaClave);
        assertEquals(expResult, result);
    }

    /**
     * Test del método busqueda binaria. Se buscan todas las claves para contemplar todos los casos de borde
     */
    @Test
    public void testBusquedaBinariaExaustiva() {
        System.out.println("Busqueda Binaria");
        
        boolean resultado = false;
        for(int i =0; i<vector.length; i++){
            resultado = instance.busquedaLineal(vector, vector[i]);
        }
        assertEquals(resultado, true);
    }
    
     /**
     * Test del método busqueda binaria. Se busca una clave que no esté en le vector.
     */
    @Test
    public void testBusquedaBinariaConClaveFueraDelVector() {
        System.out.println("Busqueda Lineal");
        
        int unaClave = 0;
        boolean expResult = false;
        boolean result = instance.busquedaLineal(vector, unaClave);
        assertEquals(expResult, result);
    }
}
