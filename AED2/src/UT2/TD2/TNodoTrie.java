/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT2.TD2;

import java.util.ArrayList;

/**
 *
 * @author germanpujadas
 */
public class TNodoTrie {
    
    private final int cantDeLetras = 26;
    private TNodoTrie[] hijos;
    private boolean esPalabra;
    private ArrayList paginas;

    public TNodoTrie() {
        hijos = new TNodoTrie[cantDeLetras];
        esPalabra = false;
        paginas = new ArrayList();
    }
    
    public ArrayList verPaginas(){
        return paginas;
    }
    
    public void insertar(String unaPalabra) {
        TNodoTrie nodoActual = this;
        for (int i=0; i<unaPalabra.length(); i++){
            int indice = unaPalabra.charAt(i)-'a';
            if (nodoActual.hijos[indice] == null){
                nodoActual.hijos[indice] = new TNodoTrie();
            }
            nodoActual = nodoActual.hijos[indice];
        }
        nodoActual.esPalabra = true;
    }
    
    public void insertar(String unaPalabra, int pagina) {
        TNodoTrie nodoActual = this;
        for (int i=0; i<unaPalabra.length(); i++){
            int indice = unaPalabra.charAt(i)-'a';
            if (nodoActual.hijos[indice] == null){
                nodoActual.hijos[indice] = new TNodoTrie();
            }
            nodoActual = nodoActual.hijos[indice];
        }
        nodoActual.esPalabra = true;
        if (!nodoActual.paginas.contains(pagina))
            nodoActual.paginas.add(pagina);
    }

    public boolean buscar(String unaPalabra) {
        TNodoTrie nodoActual = this;
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
                TNodoTrie nodoActual = this;
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
}
