/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT2.TA3;


import UT3.TD1.*;
import java.util.LinkedList;

/**
 *
 * @author germanpujadas
 */
public class TNodoTriePredecir{
    
    private final int cantDeLetras = 26;
    private TNodoTriePredecir[] hijos;
    private boolean esPalabra;

    public TNodoTriePredecir() {
        this.hijos = new TNodoTriePredecir[cantDeLetras];
        this.esPalabra = false;
    }
    
    public void insertar(String unaPalabra) {
        TNodoTriePredecir nodoActual = this;
        
        for (int i=0; i<unaPalabra.length(); i++){
                int indice = unaPalabra.charAt(i)-'a';
                if (nodoActual.hijos[indice] == null){
                    nodoActual.hijos[indice] = new TNodoTriePredecir();
                }
                nodoActual = nodoActual.hijos[indice];
            }
            nodoActual.esPalabra = true;
    }


    public boolean buscar(String unaPalabra) {
        TNodoTriePredecir nodoActual = this;
        for (int i = 0; i < unaPalabra.length(); i++) {
            int indiceBuscado = unaPalabra.charAt(i)-'a';
            if (unaPalabra.charAt(i) != unaPalabra.toLowerCase().charAt(i) || indiceBuscado > cantDeLetras-1){
                return false;
            }
            else{
                if (nodoActual.hijos[indiceBuscado] != null){
                    nodoActual = nodoActual.hijos[indiceBuscado];
                }
                else
                    return false;
            }
        }
        if(nodoActual.esPalabra){
            return true;
        }
        else
            return false;
    }
    
    public void recorrer (TNodoTriePredecir unNodo, LinkedList unaLista, String cadena){
        TNodoTriePredecir nodoActual = unNodo;
        if (nodoActual.esPalabra){
            unaLista.add(cadena);
        }
        for (int i = 0; i < cantDeLetras; i++){
            if (nodoActual.hijos[i] != null){
                nodoActual.hijos[i].recorrer(nodoActual.hijos[i], unaLista, cadena+(char)(i+'a'));
            }  
        }
    }

    public LinkedList predecir(String prefijo, LinkedList prefijos) {
        TNodoTriePredecir nodoActual = this;         
        for (int i = 0; i < prefijo.length(); i++){
            int indice = prefijo.charAt(i)-'a';
            if (nodoActual.hijos[indice] != null){
                nodoActual = nodoActual.hijos[indice];
            }
        }
        nodoActual.recorrer(nodoActual,prefijos, prefijo);
        return prefijos;
    }


}
