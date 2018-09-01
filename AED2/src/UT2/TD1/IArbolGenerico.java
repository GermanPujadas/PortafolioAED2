/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT2.TD1;

import java.util.LinkedList;

/**
 *
 * @author germanpujadas
 * @param <T>
 */
public interface IArbolGenerico<T> {

public INodoArbolGenerico<T> getRaiz();
public void setRaiz(INodoArbolGenerico<T> nuevaRaiz);  

public boolean insertar(INodoArbolGenerico<T> nuevoNodo, Comparable etiquetaPadre);

public INodoArbolGenerico<T> buscar(Comparable etiqueta);

public LinkedList<T> listarHijos(Comparable unaEtiqueta);

public boolean esVacio();

public void listarIndentado();
}
