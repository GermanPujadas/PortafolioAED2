/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT3.TD1;


import java.util.LinkedList;
import java.util.HashMap;

/**
 *
 * @author germanpujadas
 */
public class TNodoTrie{
    
    private final int cantDeLetras = 26;
    private HashMap<Character, TNodoTrie> hijos;
    private boolean esPalabra;

    public TNodoTrie() {
        this.hijos = new HashMap(cantDeLetras);
        this.esPalabra = false;
    }
    
    public void insertar(String unaPalabra) {
        TNodoTrie nodoActual = this;
        for (int i=0; i<unaPalabra.length(); i++){
            char c = unaPalabra.charAt(i);
            TNodoTrie hijoActual = nodoActual.hijos.get(c);
            if (hijoActual == null){
                hijoActual = new TNodoTrie();
                nodoActual.hijos.put(c, hijoActual);
            }
            nodoActual = hijoActual;
        }
            nodoActual.esPalabra = true;
    }


    public boolean buscar(String unaPalabra) {
        TNodoTrie nodoActual = this;
        for (int i = 0; i < unaPalabra.length(); i++) {
            char caracterBuscado = unaPalabra.charAt(i);
            TNodoTrie hijoActual = nodoActual.hijos.get(caracterBuscado);
            if (hijoActual == null){
                return false;
            }
            else{
                nodoActual = hijoActual;
                }
        }
        if(nodoActual.esPalabra){
            return true;
        }
        else
            return false;
    }
    
    public void recorrer (LinkedList unaLista, String cadena){
        if (this.esPalabra){
            unaLista.add(cadena);
        }
        this.hijos.forEach((k,v) -> {v.recorrer(unaLista, cadena + k);});
    }

    public LinkedList predecir(String prefijo, LinkedList prefijos) {
        TNodoTrie nodoActual = this;         
        for (int i = 0; i < prefijo.length(); i++){
            char c = prefijo.charAt(i);
            TNodoTrie hijoActual = nodoActual.hijos.get(c);
            if (hijoActual != null){
                nodoActual = hijoActual;
            }
            else
                return prefijos;
        }
        nodoActual.recorrer(prefijos, prefijo);
        return prefijos;
    }


}
