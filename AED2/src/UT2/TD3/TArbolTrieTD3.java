package UT2.TD3;

import UT2.onlyASCII;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author germanpujadas
 */
public class TArbolTrieTD3 {
    
    private TNodoTrieTD3 raiz;
    
    public TArbolTrieTD3(){
        raiz = new TNodoTrieTD3();
    }
    
    public void insertar (String unaPalabra, int pagina){
        raiz.insertar(unaPalabra, pagina);
    }
    
    public void insertar (String unaPalabra){
        raiz.insertar(unaPalabra);
    }
    
    public boolean buscar(String unaPalabra){
        return raiz.buscar(unaPalabra);
    }
    
    public void indizarLibro (String[] unLibro){
        int pagina = 1;
        int nroLinea = 0;
        for (String linea : unLibro){
            if (nroLinea == 50){
                nroLinea = 0;
                pagina+=1;
            }
            String[] palabras = linea.split(" ");
            for (String palabraActual : palabras) {
                String palabraSoloASCII = onlyASCII.getOnlyStrings(palabraActual);
                String palabraSinEspacio = palabraSoloASCII.replace(" ", "").toLowerCase();
                
                if(raiz.buscar(palabraSinEspacio)){
                    raiz.insertar(palabraSinEspacio, pagina);
                }     
            }
            nroLinea += 1;   
        }
    }
    
    public void imprimirIndice() {
        if (raiz != null) {
           raiz.imprimir();
        }
    }
   
    
}
