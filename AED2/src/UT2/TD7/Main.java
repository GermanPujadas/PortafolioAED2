package UT2.TD7;

import UT2.ManejadorDeArchivos;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args){
        TArbolTrie trie = new TArbolTrie();

       // CARGAR EN EL TRIE LOS TELÉFONOS Y NOMBRES A PARTIR DEL ARCHIVO ABONADOS.TXT
        
        String[] abonados = ManejadorDeArchivos.leerArchivo("src/abonados.txt");
        for(String abonado : abonados){
            String[] datos = abonado.split(",");
            trie.insertar(new TAbonado(datos[1], datos[0]));
        }
        String codigoPais = "054" ; // utilizar el indicado en el archivo "codigos.txt"
        String codigoArea = "90" ;// utilizar el indicado en el archivo "codigos.txt"
        LinkedList<TAbonado> ab = trie.buscarTelefonos(codigoPais, codigoArea);
        for (TAbonado abonado : ab){
            System.out.printf("Telefono: %s Nombre: %s \n", abonado.getTelefono(), abonado.getNombre());           
        }
            
        // crear el archivo "salida.txt", con los abonados (1 por linea) 
        // correspondientes al pais y area 
        // imprimir Nombre y teléfono, 
        // ordenados alfabeticamente por nombre
        
        Collections.sort(ab);
        String[] salida = new String[ab.size()];
        int i = 0;
        for(TAbonado abonado : ab){
            String dato="";
            dato = abonado.getNombre()+", "+abonado.getTelefono();
            salida[i] = dato;
            i++;
        }
        ManejadorArchivosGenerico.escribirArchivo("src/salida.txt", salida);
    }
}