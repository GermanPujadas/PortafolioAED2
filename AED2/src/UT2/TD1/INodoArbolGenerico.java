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
 */
public interface INodoArbolGenerico<T> {
    
public INodoArbolGenerico<T> getPrimerHijo();
public void setPrimerHijo(INodoArbolGenerico<T> unNodo);  

public INodoArbolGenerico<T> getSiguienteHermano();
public void setSiguienteHermano(INodoArbolGenerico<T> unNodo);  

public Comparable getEtiqueta();

public boolean insertar(INodoArbolGenerico<T> unNodo, Comparable etiquetaPadre);

public INodoArbolGenerico<T> buscar(Comparable etiqueta);

public void listarHijos(LinkedList<T> unaLista);

public T getDatos();

public void listarIndentado(String tabulacionInicial);
    
}
