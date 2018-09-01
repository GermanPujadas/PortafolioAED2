/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT2.TD1;

import UT2.TD1.INodoArbolGenerico;
import java.util.LinkedList;

/**
 *
 * @author germanpujadas
 * @param <T>
 */
public class TNodoArbolGenerico<T> implements INodoArbolGenerico<T> {
    
    private Comparable etiqueta;
    private INodoArbolGenerico<T> primerHijo;
    private INodoArbolGenerico<T> siguienteHermano;
    private T dato;

    public TNodoArbolGenerico(Comparable unaEtiqueta, T dato){
        this.etiqueta = unaEtiqueta;
        primerHijo = null;
        siguienteHermano = null;
        this.dato = dato;
    }
    
    @Override
    public boolean insertar(INodoArbolGenerico<T> unNodo, Comparable etiquetaPadre) {
        INodoArbolGenerico<T> padre = this.buscar(etiquetaPadre);
        
        if (padre!= null){
            INodoArbolGenerico<T> nodoActual = padre.getPrimerHijo();
            if (nodoActual != null){
            while (nodoActual.getSiguienteHermano() != null){
                nodoActual = nodoActual.getSiguienteHermano();
            }
            nodoActual.setSiguienteHermano(unNodo);
            return true;
            }
            else{
                padre.setPrimerHijo(unNodo);
                return true;
            }
        }
        else{
         return false; 
        }
    }       
    
    @Override
    public INodoArbolGenerico<T> buscar(Comparable etiqueta) {
        INodoArbolGenerico<T> resultado = null;
        if (this.etiqueta.equals(etiqueta))
            return this;
        else{
            INodoArbolGenerico<T> aux = this.primerHijo;
            while (aux != null){
                resultado = aux.buscar(etiqueta);
                if (resultado != null){
                    return resultado;
                }
                else
                    aux = aux.getSiguienteHermano();       
            }
        }
        return null;                
    }

    @Override
    public INodoArbolGenerico<T> getPrimerHijo() {
        return primerHijo;
    }

    @Override
    public void setPrimerHijo(INodoArbolGenerico<T> unNodo) {
        this.primerHijo = unNodo;
    }

    @Override
    public INodoArbolGenerico<T> getSiguienteHermano() {
        return siguienteHermano;
    }

    @Override
    public void setSiguienteHermano(INodoArbolGenerico<T> unNodo) {
        this.siguienteHermano = unNodo;
    }
    
    @Override
    public Comparable getEtiqueta(){
        return this.etiqueta;
            }

    @Override
    public void listarHijos(LinkedList<T> unaLista) {
        INodoArbolGenerico<T> nodoActual = this.primerHijo;
        while (nodoActual != null){
            unaLista.add(nodoActual.getDatos());
            nodoActual = nodoActual.getSiguienteHermano();
        }
    }

    @Override
    public T getDatos() {
        return this.dato;
    }
    
    @Override
    public void listarIndentado(String tabulacionInicial){
        System.out.println(tabulacionInicial+this.etiqueta);
        if (primerHijo != null){
            primerHijo.listarIndentado(tabulacionInicial+" ");
        }
        if (siguienteHermano != null){
            siguienteHermano.listarIndentado(tabulacionInicial);
        }
    }
}
