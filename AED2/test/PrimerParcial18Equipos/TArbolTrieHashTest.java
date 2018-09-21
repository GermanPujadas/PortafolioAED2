package PrimerParcial18Equipos;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Equipo 1
 */
public class TArbolTrieHashTest {

    @Test
    public void testBuscarDispositivos() {
        TDispositivo dispositivoA = new TDispositivo("000.502.104.153", "TEST A");
        TDispositivo dispositivoB = new TDispositivo("000.506.101.333", "TEST B");
        TDispositivo dispositivoC = new TDispositivo("015.522.104.153", "TEST C");
        TDispositivo dispositivoD = new TDispositivo("001.506.101.333", "TEST D");

        TArbolTrieHash trie = new TArbolTrieHash();

        assertTrue(trie.buscarDispositivos("").isEmpty());
        assertTrue(trie.buscarDispositivos("000.").isEmpty());
        assertTrue(trie.buscarDispositivos("015.").isEmpty());
        assertTrue(trie.buscarDispositivos("095.").isEmpty());

        // Se insertar dispositivos
        trie.insertar(dispositivoA);
        trie.insertar(dispositivoB);
        
        assertEquals(Arrays.asList(dispositivoA), trie.buscarDispositivos("000.502."));
        assertEquals(Arrays.asList(dispositivoA, dispositivoB), trie.buscarDispositivos("000."));
        assertTrue(trie.buscarDispositivos("015.").isEmpty());
        assertTrue(trie.buscarDispositivos("095.").isEmpty());
        assertTrue(trie.buscarDispositivos("000.502.105.").isEmpty());
        

        
        
        // Se insertar dispositivos
        trie.insertar(dispositivoC);
        trie.insertar(dispositivoD);

        assertEquals(Arrays.asList(dispositivoA), trie.buscarDispositivos("000.502."));
        assertEquals(Arrays.asList(dispositivoA, dispositivoB), trie.buscarDispositivos("000."));
        assertEquals(Arrays.asList(dispositivoC), trie.buscarDispositivos("015."));
        assertTrue(trie.buscarDispositivos("095.").isEmpty());
        assertTrue(trie.buscarDispositivos("000.502.105.").isEmpty());

        // Una submascara XXX contiene a XXX.YYY
        assertTrue(trie.buscarDispositivos("000.").containsAll(trie.buscarDispositivos("000.502.")));

    }


}
