/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT3.TD4;

import java.util.HashMap;
import javafx.scene.input.ClipboardContent;
/**
 *
 * @author germanpujadas
 */
public class TNodoTrie {
    
    private final int cantDeLetras = 26;
    private HashMap<Character,TNodoTrie> hijos;
    private boolean esPalabra;
    private int ocurrencia;

    public TNodoTrie() {
        hijos = new HashMap<>(cantDeLetras);
        esPalabra = false;
        ocurrencia = 0;
    }
    
    public void insertar(String unaPalabra) {
        TNodoTrie nodoActual = this;
        for (int i=0; i<unaPalabra.length(); i++){
            TNodoTrie hijoActual = nodoActual.hijos.get(unaPalabra.charAt(i));
            if (hijoActual == null){
                hijoActual = new TNodoTrie();
                nodoActual.hijos.put(unaPalabra.charAt(i), hijoActual);
            }
            nodoActual = hijoActual;
        }
        nodoActual.esPalabra = true;
        nodoActual.ocurrencia +=1;
    }

    public boolean buscar(String unaPalabra) {
        TNodoTrie nodoActual = this;
        for (int i = 0; i < unaPalabra.length(); i++) {
            char caracterBuscado = unaPalabra.charAt(i);
            TNodoTrie nodoBuscado = nodoActual.hijos.get(caracterBuscado);
            if (nodoBuscado == null){
                return false;
            }
            else{
                nodoActual = nodoBuscado;
            }
        }
        return nodoActual.esPalabra;

    }
        
    private void imprimir(String s, TNodoTrie nodo) {
        if (nodo != null) {
            if (nodo.esPalabra) {
                System.out.println(s+": "+ nodo.ocurrencia);
            }
            nodo.hijos.forEach((k,v) -> {v.imprimir(s+k, v);});
        }
    }
    public void imprimir() {
        imprimir("", this);
    }
    
    public void obtenerFrecuencias(TNodoTrie unNodo, HashMap<String, Integer> resultado, String s){
        if (unNodo != null) {
            if (unNodo.esPalabra) {
                resultado.put(s, unNodo.ocurrencia);
            }
            unNodo.hijos.forEach((k,v) -> {v.obtenerFrecuencias(v,resultado,s+k);});
        }
    }
    public HashMap obtenerFrecuencias(){
        HashMap frecuencias = new HashMap();
        obtenerFrecuencias(this, frecuencias, "");
        return frecuencias;
    }
}
