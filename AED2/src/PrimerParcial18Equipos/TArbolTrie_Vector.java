package PrimerParcial18Equipos;



import java.util.Collection;
import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Equipo 1
 */
public class TArbolTrie_Vector implements IArbolTrie{
    
    private TNodoTrie_Vector raiz;
    
    public TArbolTrie_Vector(){
        raiz = new TNodoTrie_Vector();
    }
    
    @Override
    public LinkedList<TDispositivo> buscarDispositivos(String mascaraSubRed) {
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
