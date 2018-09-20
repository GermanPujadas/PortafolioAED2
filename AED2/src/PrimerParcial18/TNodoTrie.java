package PrimerParcial18;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.LinkedList;

/**
 *
 * @author germanpujadas
 */
public class TNodoTrie implements INodoTrie{
    
    private final int cantDeNumeros = 10;
    private TNodoTrie[] hijos;
    private boolean esDispositivo;
    private TDispositivo dispositivo;

    public TNodoTrie() {
        this.hijos = new TNodoTrie[cantDeNumeros];
        this.esDispositivo = false;
        this.dispositivo = null;
    }

    @Override
    public void insertar(TDispositivo unDispositivo) {
        TNodoTrie nodoActual = this;
        String ip = unDispositivo.getDirIP().replace(".", "");
        for (int i=0; i<ip.length(); i++){
                int indice = ip.charAt(i)-'0';
                if (nodoActual.hijos[indice] == null){
                    nodoActual.hijos[indice] = new TNodoTrie();
                }
                nodoActual = nodoActual.hijos[indice];
            }
            nodoActual.esDispositivo = true;
            nodoActual.dispositivo= unDispositivo;
    }
    
    //NO SE CONTEMPLA EL CASO EN QUE SE CARGUEN DOS DISPOSITIVOS CON LA MISMA IP
    
    public void buscarDispositivos(String mascara, LinkedList<TDispositivo> dispositivos) {
        TNodoTrie nodoActual = this;
        for (int i = 0; i < mascara.length(); i++){
            int indice = mascara.charAt(i)-'0';
            if (nodoActual.hijos[indice] != null)
                nodoActual = nodoActual.hijos[indice];
            else
                return;
        }
        nodoActual.recorrer(nodoActual,dispositivos);
    }
    
    public void recorrer (TNodoTrie unNodo, LinkedList unaLista){
        TNodoTrie nodoActual = unNodo;
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
