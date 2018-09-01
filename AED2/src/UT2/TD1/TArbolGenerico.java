/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT2.TD1;

import UT2.TD1.INodoArbolGenerico;
import UT2.TD1.IArbolGenerico;
import java.util.LinkedList;

/**
 *
 * @author germanpujadas
 */
public class TArbolGenerico<T> implements IArbolGenerico<T> {
    
    private INodoArbolGenerico<T> raiz;

    public TArbolGenerico() {
        this.raiz = null;
    }

    @Override
    public boolean insertar(INodoArbolGenerico<T> nuevoNodo, Comparable etiquetaPadre) {
        if (raiz == null){
                raiz = nuevoNodo;
                return true;
            }
        else{
            if (etiquetaPadre.equals("")){
                nuevoNodo.setPrimerHijo(raiz);
                raiz = nuevoNodo;
                return true;
            }
            else{
                return raiz.insertar(nuevoNodo, etiquetaPadre);
                }
            }       
        }

    @Override
    public INodoArbolGenerico<T> buscar(Comparable etiqueta) {
        if (raiz == null)
            return null;
        else
            return raiz.buscar(etiqueta);
    }

    @Override
    public INodoArbolGenerico<T> getRaiz() {
        return raiz;
    }

    @Override
    public void setRaiz(INodoArbolGenerico<T> nuevaRaiz) {
        raiz = nuevaRaiz;
    }

    @Override
    public LinkedList<T> listarHijos(Comparable unaEtiqueta) {
        LinkedList<T> resultado = new LinkedList<>();
        if (!esVacio()){
            raiz.buscar(unaEtiqueta).listarHijos(resultado);
            return resultado;
        }
        else
            return null;
    }

    @Override
    public boolean esVacio() {
        return raiz == null;
    }
    
    
    @Override
    public void listarIndentado(){
        if(!esVacio())
            raiz.listarIndentado("");
    }
    
    
}
