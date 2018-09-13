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
    
    private final int cantDeLetras = 26;
    private TNodoTrieTD6[] hijos;
    private boolean esPalabra;
    private ArrayList inicioDePalabra;

    public TNodoTrieTD6() {
        hijos = new TNodoTrieTD6[cantDeLetras];
        esPalabra = false;
        inicioDePalabra = new ArrayList();
    }
    
    public ArrayList buscarPatron(){
        return this.inicioDePalabra;
    }
    
    public void insertar(String unaPalabra, int inicio) {
        TNodoTrieTD6 nodoActual = this;
        for (int i=0; i<unaPalabra.length(); i++){
                int indice = unaPalabra.charAt(i)-'a';
                if (nodoActual.hijos[indice] == null){
                    nodoActual.hijos[indice] = new TNodoTrieTD6();
                }
                nodoActual = nodoActual.hijos[indice];
            }
            nodoActual.esPalabra = true;
            nodoActual.inicioDePalabra.add(inicio);
    }


    public boolean buscar(String unaPalabra) {
        TNodoTrieTD6 nodoActual = this;
        for (int i = 0; i < unaPalabra.length(); i++) {
            int indiceBuscado = unaPalabra.charAt(i) - 'a';
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
    
        TNodoTrieTD6 nodoActual = this;
        for (int i = 0; i < unPatron.length(); i++){
            if (nodoActual.hijos[i] != null)
                nodoActual = nodoActual.hijos[i];
            else
                return null;
        }
        if (nodoActual.esPalabra){
            return nodoActual.inicioDePalabra;
        }
        
        ArrayList listaDeOcurrencias = new ArrayList();   
        nodoActual.recorrer(nodoActual,listaDeOcurrencias);
        return listaDeOcurrencias;
    }
    
    public void recorrer (TNodoTrieTD6 unNodo, ArrayList unaLista){
        
    }
    
    private void imprimir(String s, TNodoTrieTD6 nodo) {
        if (nodo != null) {
            if (nodo.esPalabra) {
                System.out.print(s+": ");
                if(!nodo.buscarPatron().isEmpty()){
                    for(Object pagina : nodo.buscarPatron())
                        System.out.print(pagina+" ");
                }
                System.out.println("");
            }
            for (int c = 0; c < cantDeLetras; c++) {
                if (nodo.hijos[c] != null) {
                    imprimir(s + (char) (c + 'a'), nodo.hijos[c]);
                }
            }
        }
    }
    public void imprimir() {
        imprimir("", this);
    }
}
