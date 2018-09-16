/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT2.TD7;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author germanpujadas
 */
public class TNodoTrie implements INodoTrie{
    
    private final int cantDeNumeros = 10;
    private TNodoTrie[] hijos;
    private boolean esAbonado;
    private TAbonado abonado;

    public TNodoTrie() {
        this.hijos = new TNodoTrie[cantDeNumeros];
        this.esAbonado = false;
        this.abonado = null;
    }
    
    public void insertar(String unaPalabra, TAbonado unAbonado) {
        TNodoTrie nodoActual = this;
        
        for (int i=0; i<unaPalabra.length(); i++){
                int indice = unaPalabra.charAt(i)-'0';
                if (nodoActual.hijos[indice] == null){
                    nodoActual.hijos[indice] = new TNodoTrie();
                }
                nodoActual = nodoActual.hijos[indice];
            }
            nodoActual.esAbonado = true;
            nodoActual.abonado= unAbonado;
    }


    public boolean buscar(String unaPalabra) {
        TNodoTrie nodoActual = this;
        for (int i = 0; i < unaPalabra.length(); i++) {
            int indiceBuscado = unaPalabra.charAt(i)-'0';
            if (unaPalabra.charAt(i) != unaPalabra.toLowerCase().charAt(i) || indiceBuscado > cantDeNumeros-1){
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
        if(nodoActual.esAbonado){
            return true;
        }
        else
            return false;
    }
    
    public LinkedList buscarPatron(String unPatron){
    
        LinkedList listaDeOcurrencias = new LinkedList();
        TNodoTrie nodoActual = this;
        
        for (int i = 0; i < unPatron.length(); i++){
            int indice = unPatron.charAt(i)-'0';
            if (nodoActual.hijos[indice] != null)
                nodoActual = nodoActual.hijos[indice];
            else
                return listaDeOcurrencias;
        }
        
        nodoActual.recorrer(nodoActual,listaDeOcurrencias);
        return listaDeOcurrencias;
    }
    
    public void recorrer (TNodoTrie unNodo, LinkedList unaLista){
        TNodoTrie nodoActual = unNodo;
        if (nodoActual.esAbonado){
            unaLista.add(nodoActual.abonado);
        }
        for (int i = 0; i < cantDeNumeros; i++){
            if (nodoActual.hijos[i] != null){
                nodoActual.hijos[i].recorrer(nodoActual.hijos[i], unaLista);
            }  
        }
    }

    @Override
    public void buscarTelefonos(String primerosDigitos, LinkedList<TAbonado> abonados) {
        TNodoTrie nodoActual = this;
        for (int i = 0; i < primerosDigitos.length(); i++){
            int indice = primerosDigitos.charAt(i)-'0';
            if (nodoActual.hijos[indice] != null)
                nodoActual = nodoActual.hijos[indice];
        }
        nodoActual.recorrer(nodoActual,abonados);
    }

    @Override
    public void insertar(TAbonado unAbonado) {
        TNodoTrie nodoActual = this;
        String telefono = unAbonado.getTelefono();
        for (int i=0; i<telefono.length(); i++){
                int indice = telefono.charAt(i)-'0';
                if (nodoActual.hijos[indice] == null){
                    nodoActual.hijos[indice] = new TNodoTrie();
                }
                nodoActual = nodoActual.hijos[indice];
            }
            nodoActual.esAbonado = true;
            nodoActual.abonado= unAbonado;
    }

}
