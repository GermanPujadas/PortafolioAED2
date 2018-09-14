/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT2.TD6;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author germanpujadas
 */
public class TNodoTrieTD6 {
    
    private final int cantDeLetras = 4;
    private TNodoTrieTD6[] hijos;
    private boolean esPalabra;
    private int inicioDePalabra;

    public TNodoTrieTD6() {
        hijos = new TNodoTrieTD6[cantDeLetras];
        esPalabra = false;
    }

    
    public int getIndice(char unChar){
        switch ((int) unChar){
            case 97:
                return 0;
            case 99:
                return 1;
            case 103:
                return 2;
            case 116:
                return 3;
            default:
                return -1;
        }
    }
    
    public char getChar(int unValor){
        switch (unValor){
            case 0:
                return 'a';
            case 1:
                return 'c';
            case 2:
                return 'g';
            case 3:
                return 't';
            default:
                return ' ';
        }
    }
    
    public void insertar(String unaPalabra, int inicio) {
        TNodoTrieTD6 nodoActual = this;
        for (int i=0; i<unaPalabra.length(); i++){
                int indice = getIndice(unaPalabra.charAt(i));
                if (nodoActual.hijos[indice] == null){
                    nodoActual.hijos[indice] = new TNodoTrieTD6();
                }
                nodoActual = nodoActual.hijos[indice];
            }
            nodoActual.esPalabra = true;
            nodoActual.inicioDePalabra= inicio;
    }


    public boolean buscar(String unaPalabra) {
        TNodoTrieTD6 nodoActual = this;
        for (int i = 0; i < unaPalabra.length(); i++) {
            int indiceBuscado = getIndice(unaPalabra.charAt(i));
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
    
    public ArrayList buscarPatron(String unPatron){
    
        ArrayList listaDeOcurrencias = new ArrayList();
        TNodoTrieTD6 nodoActual = this;
        
        for (int i = 0; i < unPatron.length(); i++){
            int indice = getIndice(unPatron.charAt(i));
            if (nodoActual.hijos[indice] != null)
                nodoActual = nodoActual.hijos[indice];
            else
                return listaDeOcurrencias;
        }
        
        nodoActual.recorrer(nodoActual,listaDeOcurrencias);
        return listaDeOcurrencias;
    }
    
    public void recorrer (TNodoTrieTD6 unNodo, ArrayList unaLista){
        TNodoTrieTD6 nodoActual = unNodo;
        if (nodoActual.esPalabra){
            unaLista.add(nodoActual.inicioDePalabra);
        }
        for (int i = 0; i < cantDeLetras; i++){
            if (nodoActual.hijos[i] != null){
                nodoActual.hijos[i].recorrer(nodoActual.hijos[i], unaLista);
            }  
        }
    }
    
    private void imprimir(String s, TNodoTrieTD6 nodo) {
        if (nodo != null) {
            if (nodo.esPalabra) {
                System.out.println(s+": "+nodo.inicioDePalabra);
            }
        }
        for (int c = 0; c < cantDeLetras; c++) {
            if (nodo.hijos[c] != null) {
                imprimir(s + getChar(c), nodo.hijos[c]);
            }
        }
    }
    
    public void imprimir() {
        imprimir("", this);
    }
}
