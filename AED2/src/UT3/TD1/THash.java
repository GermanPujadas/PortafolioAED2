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
public class THash implements IHash {
    
    private int capacidad;
    private Comparable[] tabla;
    
    public THash(int capacidad){
        this.capacidad = capacidad;
        this.tabla = new Comparable[capacidad];
    }
    

    @Override
    public int insertarSondeoLinenal(Comparable clave) {
        int indiceAInsertar = this.funcionHashing(clave.toString());
        int indiceInicial = indiceAInsertar;
        int comparaciones = 0;
        while (this.tabla[indiceAInsertar] != null){
            indiceAInsertar = (indiceAInsertar+1)%this.capacidad;
            comparaciones+=1;
            if (indiceAInsertar == indiceInicial)
                return -indiceAInsertar;
        }
        tabla[indiceAInsertar] = clave;
        return comparaciones;
    }


    @Override
    public int buscarSondeoLinenal(Comparable clave) {
        int indiceABuscar = this.funcionHashing(clave.toString());
        int indiceInicial = indiceABuscar;
        int comparaciones = 0;
        
        while (this.tabla[indiceABuscar] != null){ 
            comparaciones+=1;
            if (!this.tabla[indiceABuscar].equals(clave)){    
                indiceABuscar = (indiceABuscar+1)%this.capacidad;
                if (indiceABuscar == indiceInicial)
                    return -comparaciones;
            }
            else
                return comparaciones;
        }
        return -comparaciones;
    }

    @Override
    public int funcionHashing(String clave) {
        try {
            return Integer.parseInt(clave) % this.capacidad;
        
        } catch (NumberFormatException excepcion) {
            int valor = 0;
            for(int i = 0; i< clave.length(); i++){
                valor+= clave.charAt(i)-'0';
            }
            return valor%this.capacidad;
        }
    }
}
