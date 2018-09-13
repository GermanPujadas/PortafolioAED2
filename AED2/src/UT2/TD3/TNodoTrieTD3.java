/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT2.TD3;

import java.util.ArrayList;

/**
 *
 * @author germanpujadas
 */
public class TNodoTrieTD3 {
    
    private final int cantDeLetras = 26;
    private TNodoTrieTD3[] hijos;
    private boolean esPalabra;
    private ArrayList paginas;

    public TNodoTrieTD3() {
        hijos = new TNodoTrieTD3[cantDeLetras];
        esPalabra = false;
        paginas = new ArrayList();
    }
    
    public ArrayList verPaginas(){
        return paginas;
    }
    
    public void insertar(String unaPalabra) {
        TNodoTrieTD3 nodoActual = this;
        for (int i=0; i<unaPalabra.length(); i++){
            int indice = unaPalabra.charAt(i)-'a';
            if (nodoActual.hijos[indice] == null){
                nodoActual.hijos[indice] = new TNodoTrieTD3();
            }
            nodoActual = nodoActual.hijos[indice];
        }
        nodoActual.esPalabra = true;
    }
    
    public void insertar(String unaPalabra, int pagina) {
        TNodoTrieTD3 nodoActual = this;
        for (int i=0; i<unaPalabra.length(); i++){
            int indice = unaPalabra.charAt(i)-'a';
            if (nodoActual.hijos[indice] == null){
                nodoActual.hijos[indice] = new TNodoTrieTD3();
            }
            nodoActual = nodoActual.hijos[indice];
        }
        nodoActual.esPalabra = true;
        if (!nodoActual.paginas.contains(pagina))
            nodoActual.paginas.add(pagina);
    }

    public boolean buscar(String unaPalabra) {
        TNodoTrieTD3 nodoActual = this;
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
    
    public ArrayList devolverPaginas (String unaPalabra){
        if (buscar(unaPalabra)) {
                TNodoTrieTD3 nodoActual = this;
                int posicion = 0;
                while (!nodoActual.esPalabra){
                    int index = unaPalabra.charAt(posicion) - 'a';
                    nodoActual = nodoActual.hijos[index];
                    posicion++;
                }
                return nodoActual.verPaginas();
            }
        return null;
    }
    
    private void imprimir(String s, TNodoTrieTD3 nodo) {
        if (nodo != null) {
            if (nodo.esPalabra) {
                System.out.print(s+": ");
                if(!nodo.verPaginas().isEmpty()){
                    for(Object pagina : nodo.verPaginas())
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
