package UT3.TD1;

import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author germanpujadas
 */
public class TArbolTriePredecir{
    
    private TNodoTrie raiz;
    
    public TArbolTriePredecir(){
        raiz = new TNodoTrie();
    }
    
    public void insertar(String unaPalabra) {
        raiz.insertar(unaPalabra);
    }
    
    public boolean buscar(String unaPalabra){
        return raiz.buscar(unaPalabra);
    }

    public LinkedList predecir(String unPrefijo) {
        LinkedList listaDePrefijos = new LinkedList();
        raiz.predecir(unPrefijo,listaDePrefijos);
        return listaDePrefijos;
    }
}
