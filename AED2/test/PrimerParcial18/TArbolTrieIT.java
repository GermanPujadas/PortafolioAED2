package PrimerParcial18;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Collection;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author germanpujadas
 */
public class TArbolTrieIT {
   
        TArbolTrie instance = new TArbolTrie();
        TDispositivo dispositivo1 = new TDispositivo("235.132.079.236","disp1");
        TDispositivo dispositivo8 = new TDispositivo("235.132.079.237","disp2");
        TDispositivo dispositivo3 = new TDispositivo("235.135.080.236","disp3");
        TDispositivo dispositivo4 = new TDispositivo("235.134.076.236","disp4");
        TDispositivo dispositivo5 = new TDispositivo("235.134.070.236","disp5");
        TDispositivo dispositivo6 = new TDispositivo("236.133.079.236","disp6");
        TDispositivo dispositivo7 = new TDispositivo("236.133.077.236","disp7");
        TDispositivo dispositivo2 = new TDispositivo("236.133.072.236","disp8");
    
        public TArbolTrieIT() {
        }

    /**
    * Test of buscarDispositivos method, of class TArbolTrie.
    */
    @Test
    public void testBuscarDispositivosEnArbolVacio() {
        
        String mascaraSubRed = "";
        int expResult = 0;
        int result = instance.buscarDispositivos(mascaraSubRed).size();
        assertEquals(expResult, result);
    }

    /**
     * Test of buscarDispositivos method, of class TArbolTrie.
     */
    @Test
    public void testBuscarDispositivosSinExito() {
        
        String mascaraSubRed = "111.111.111.";
        instance.insertar(dispositivo1);
        instance.insertar(dispositivo2);
        instance.insertar(dispositivo3);
        instance.insertar(dispositivo4);
        instance.insertar(dispositivo5);
        instance.insertar(dispositivo6);
        instance.insertar(dispositivo7);
        instance.insertar(dispositivo8);
        
        int expResult = 0;
        int result = instance.buscarDispositivos(mascaraSubRed).size();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of buscarDispositivos method, of class TArbolTrie.
     */
    @Test
    public void testBuscarDispositivos1Coincidencia() {
        
        String mascaraSubRed = "235.135.080.";
        instance.insertar(dispositivo1);
        instance.insertar(dispositivo2);
        instance.insertar(dispositivo3);
        instance.insertar(dispositivo4);
        instance.insertar(dispositivo5);
        instance.insertar(dispositivo6);
        instance.insertar(dispositivo7);
        instance.insertar(dispositivo8);
        
        int expResult = 1;
        int result = instance.buscarDispositivos(mascaraSubRed).size();
        assertEquals(expResult, result);
    }
    
    /**
    * Test of buscarDispositivos method, of class TArbolTrie.
    */
    @Test
    public void testBuscarDispositivos2Coincidencia() {
        
        String mascaraSubRed = "235.132.";
        instance.insertar(dispositivo1);
        instance.insertar(dispositivo2);
        instance.insertar(dispositivo3);
        instance.insertar(dispositivo4);
        instance.insertar(dispositivo5);
        instance.insertar(dispositivo6);
        instance.insertar(dispositivo7);
        instance.insertar(dispositivo8);
        
        int expResult = 2;
        int result = instance.buscarDispositivos(mascaraSubRed).size();
        assertEquals(expResult, result);
    }
    
    /**
    * Test of buscarDispositivos method, of class TArbolTrie.
    */
    @Test
    public void testBuscarDispositivos3Coincidencia() {
        
        String mascaraSubRed = "236.";
        instance.insertar(dispositivo1);
        instance.insertar(dispositivo2);
        instance.insertar(dispositivo3);
        instance.insertar(dispositivo4);
        instance.insertar(dispositivo5);
        instance.insertar(dispositivo6);
        instance.insertar(dispositivo7);
        instance.insertar(dispositivo8);
        
        int expResult = 3;
        int result = instance.buscarDispositivos(mascaraSubRed).size();

       assertEquals(expResult, result);
    }
    
}
