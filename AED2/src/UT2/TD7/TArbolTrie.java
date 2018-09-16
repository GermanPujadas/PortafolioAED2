package UT2.TD7;

import UT2.TD1.IArbolGenerico;
import java.util.ArrayList;
import java.util.Collection;
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
public class TArbolTrie implements IArbolTrie{
    
    private TNodoTrie raiz;
    
    public TArbolTrie(){
        raiz = new TNodoTrie();
    }
    
    public boolean buscar(String unaPalabra){
        return raiz.buscar(unaPalabra);
    }
    
    public LinkedList buscarPatron (String unaSecuencia){
        return raiz.buscarPatron(unaSecuencia);
    }


    @Override
    public LinkedList<TAbonado> buscarTelefonos(String pais, String area) {
        LinkedList<TAbonado> listaDeAbonados = new LinkedList<TAbonado>();
        raiz.buscarTelefonos(pais+area, listaDeAbonados);
        return listaDeAbonados;
    }

    @Override
    public void insertar(TAbonado unAbonado) {
        raiz.insertar(unAbonado);
    }
   
    
}
