/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT3;

import UT3.*;

import UT2.ManejadorDeArchivos;
import UT3.TD1.TArbolTriePredecir;
import UT3.TD1.THash;
import java.util.LinkedList;

/**
 *
 * @author germanpujadas
 */
public class Main {
     public static void main(String[] args) {
         
         String[] clavesInsercion = ManejadorDeArchivos.leerArchivo("src/claves_insertar.txt");
         String[] clavesBusqueda = ManejadorDeArchivos.leerArchivo("src/claves_buscar.txt");
         int capacidad = (int) Math.ceil(clavesInsercion.length *1.1d);
         THash hash = new THash(capacidad);
         
         for(String clave : clavesInsercion){
             hash.insertarSondeoLinenal(clave);
         }
         
         for(String clave : clavesBusqueda){
             int resultado = hash.buscarSondeoLinenal(clave);
             System.out.printf("Clave: %s , Resultado de la busqueda: %d \n", clave, resultado);

         }
         
         String[] palabras = ManejadorDeArchivos.leerArchivo("src/palabrasPredecirPrueba.txt");
         TArbolTriePredecir arbolDePrefijos = new TArbolTriePredecir();
         
         for(String palabra : palabras){
             arbolDePrefijos.insertar(palabra);
         }
         
         LinkedList prefijos = new LinkedList();
         String unPrefijo = "ca";
         prefijos = arbolDePrefijos.predecir(unPrefijo);
         for(Object prefijo : prefijos)
             System.out.println(prefijo);
             

    }   
}
