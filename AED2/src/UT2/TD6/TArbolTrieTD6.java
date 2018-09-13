package UT2.TD6;

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
public class TArbolTrieTD6 {
    
    private TNodoTrieTD6 raiz;
    
    public TArbolTrieTD6(){
        raiz = new TNodoTrieTD6();
    }
    
    public void insertar (String unaPalabra, int inicio){
        raiz.insertar(unaPalabra, inicio);
    }
    
    public boolean buscar(String unaPalabra){
        return raiz.buscar(unaPalabra);
    }
    
    public ArrayList buscarPatron (String unaSecuencia){
        return raiz.buscarPatron(unaSecuencia);
    }
    
    public void imprimirArbol() {
        if (raiz != null) {
           raiz.imprimir();
        }
    }
   
    
}
