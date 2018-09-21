package PrimerParcial18Equipos;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.LinkedList;

/**
 *
 * @author Equipo 1
 */
public class TNodoTrie_Vector implements INodoTrie{
    
    private final int cantDeNumeros = 10;
    private TNodoTrie_Vector[] hijos;
    private boolean esDispositivo;
    private TDispositivo dispositivo;

    public TNodoTrie_Vector() {
        this.hijos = new TNodoTrie_Vector[cantDeNumeros];
        this.esDispositivo = false;
        this.dispositivo = null;
    }

    @Override
    public void insertar(TDispositivo unDispositivo) {
        TNodoTrie_Vector nodoActual = this;
        String ip = unDispositivo.getDirIP().replace(".", "");
        for (int i=0; i<ip.length(); i++){
            char c = ip.charAt(i);
            if (Character.isDigit(c)) {
                int indice = c-'0';
                if (nodoActual.hijos[indice] == null){
                    nodoActual.hijos[indice] = new TNodoTrie_Vector();
                }
                nodoActual = nodoActual.hijos[indice];
            }
        }
        nodoActual.esDispositivo = true;
        nodoActual.dispositivo= unDispositivo;
    }
    
    //NO SE CONTEMPLA EL CASO EN QUE SE CARGUEN DOS DISPOSITIVOS CON LA MISMA IP
    
    public void buscarDispositivos(String mascara, LinkedList<TDispositivo> dispositivos) {
        TNodoTrie_Vector nodoActual = this;
        for (int i = 0; i < mascara.length(); i++){
            int indice = mascara.charAt(i)-'0';
            if (nodoActual.hijos[indice] != null)
                nodoActual = nodoActual.hijos[indice];
            else
                return;
        }
        nodoActual.recorrer(nodoActual,dispositivos);
    }
    
    public void recorrer (TNodoTrie_Vector unNodo, LinkedList unaLista){
        TNodoTrie_Vector nodoActual = unNodo;
        if (nodoActual.esDispositivo){
            unaLista.add(nodoActual.dispositivo);
        }
        for (int i = 0; i < cantDeNumeros; i++){
            if (nodoActual.hijos[i] != null){
                nodoActual.hijos[i].recorrer(nodoActual.hijos[i], unaLista);
            }  
        }
    }

}
