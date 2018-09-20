package PrimerParcial18;


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
    
    @Override
    public Collection<TDispositivo> buscarDispositivos(String mascaraSubRed) {
        LinkedList<TDispositivo> listaDeDispostivos = new LinkedList<>();
        if(raiz != null)
            raiz.buscarDispositivos(mascaraSubRed.replace(".", ""), listaDeDispostivos);
        return listaDeDispostivos;
    }

    @Override
    public void insertar(TDispositivo unDispositivo) {
        raiz.insertar(unDispositivo);
    }    
}
