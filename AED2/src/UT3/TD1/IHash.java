/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT3.TD1;

/**
 *
 * @author germanpujadas
 */
public interface IHash {
    
    public int insertarSondeoLinenal(Comparable clave);
    public int buscarSondeoLinenal (Comparable clave);
    public int funcionHashing(String clave);
    
}
