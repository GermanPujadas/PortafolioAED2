package UT2.TD2;

import UT2.onlyASCII;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author germanpujadas
 */
public class TArbolTrie {
    
    private TNodoTrie raiz;
    
    public TArbolTrie(){
        raiz = new TNodoTrie();
    }
    
    public void insertar (String unaPalabra, int pagina){
        raiz.insertar(unaPalabra, pagina);
    }
    
    public void insertar (String unaPalabra){
        raiz.insertar(unaPalabra);
    }
    
    public boolean buscar(String unaPalabra){
        return raiz.buscar(unaPalabra);
    }
    
    public ArrayList devolverPaginas (String unaPalabra){
        return raiz.devolverPaginas(unaPalabra);
    }
}
