/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT1;

/**
 *
 * @author germanpujadas
 */
public class Main {
    
     public static void main(String[] args) {
       TD1 busqueda = new TD1();
       int[] unVector = {1,2,3,4,5};
       
       System.out.println("Busqueda binaria de 0: "+busqueda.busquedaBinaria(unVector, 0));
       System.out.println("Busqueda binaria de 1: "+busqueda.busquedaBinaria(unVector, 1));
       System.out.println("Busqueda binaria de 3: "+busqueda.busquedaBinaria(unVector, 3));
       System.out.println("Busqueda binaria de 5: "+busqueda.busquedaBinaria(unVector, 5));
       
       System.out.println("Busqueda lineal de 0: "+busqueda.busquedaLineal(unVector, 0));
       System.out.println("Busqueda lineal de 1: "+busqueda.busquedaLineal(unVector, 1));
       System.out.println("Busqueda lineal de 3: "+busqueda.busquedaLineal(unVector, 3));
       System.out.println("Busqueda lineal de 5: "+busqueda.busquedaLineal(unVector, 5));
    }
    
}
