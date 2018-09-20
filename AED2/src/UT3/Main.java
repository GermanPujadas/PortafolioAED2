/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT3;

import UT2.ManejadorDeArchivos;
import UT2.TA3.TArbolTriePredecir;
import UT2.onlyASCII;
import UT3.TD1_5.THash;
import UT3.TD4.TArbolTrie;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

/**
 *
 * @author germanpujadas
 */
public class Main {
     public static void main(String[] args) {
         
         /*    TAREA DOMICILIARIA 1    */
        System.out.println("--------Tarea domiciliaria 1--------");
        System.out.println("");
         
         String[] clavesInsercion = ManejadorDeArchivos.leerArchivo("src/UT3/claves_insertar.txt");
         String[] clavesBusqueda = ManejadorDeArchivos.leerArchivo("src/UT3/claves_buscar.txt");
         int capacidad = (int) Math.ceil(clavesInsercion.length *1.1d);
         THash hash = new THash(capacidad);
         
         for(String clave : clavesInsercion){
             hash.insertarSondeoLinenal(clave);
         }
         
         for(String clave : clavesBusqueda){
             int resultado = hash.buscarSondeoLinenal(clave);
             System.out.printf("Clave: %s , Resultado de la busqueda: %d \n", clave, resultado);

         }
         
         String[] palabras = ManejadorDeArchivos.leerArchivo("src/UT3/palabrasPredecirPrueba.txt");
         TArbolTriePredecir arbolDePrefijos = new TArbolTriePredecir();
         
         for(String palabra : palabras){
             arbolDePrefijos.insertar(palabra);
         }
         
         LinkedList prefijos = new LinkedList();
         String unPrefijo = "ca";
         prefijos = arbolDePrefijos.predecir(unPrefijo);
         for(Object prefijo : prefijos)
             System.out.println(prefijo);
    

        /*    TAREA DOMICILIARIA 2    */
        System.out.println("--------Tarea domiciliaria 2--------");
        System.out.println("");
        
         for (double fc = 0.5; fc <= 0.9; fc+=0.05) {
            int capacidad_Test = (int) Math.ceil(clavesInsercion.length/fc);
            THash hash_Test = new THash(capacidad_Test);
            double insercionesPromedio = 0;
            double busquedasPromedio = 0;
            int aux = 0;
            
            for(String clave : clavesInsercion){
                aux = hash_Test.insertarSondeoLinenal(clave);
                if (aux >= 0)
                    insercionesPromedio += aux;
            }

            for(String clave : clavesBusqueda){
                aux = hash_Test.buscarSondeoLinenal(clave);
                if (aux >= 0)
                    busquedasPromedio += aux;
            }
            System.out.printf("%.2f \t %.2f \t %.2f \n", fc,insercionesPromedio/clavesInsercion.length, busquedasPromedio/clavesBusqueda.length);
        }
         
         for (double fc = 0.9; fc <= 1; fc+=0.01) {
            int capacidad_Test = (int) Math.ceil(clavesInsercion.length/fc);
            THash hash_Test = new THash(capacidad_Test);
            double insercionesPromedio = 0;
            double busquedasPromedio = 0;
            int aux = 0;
            
            for(String clave : clavesInsercion){
                aux = hash_Test.insertarSondeoLinenal(clave);
                if (aux >= 0)
                    insercionesPromedio += aux;
                else
                    insercionesPromedio += -aux;
            }

            for(String clave : clavesBusqueda){
                aux = hash_Test.buscarSondeoLinenal(clave);
                if (aux >= 0)
                    busquedasPromedio += aux;
                else
                    busquedasPromedio += -aux;
            }
            System.out.printf("%.2f \t %.2f \t %.2f \n", fc,insercionesPromedio/clavesInsercion.length, busquedasPromedio/clavesBusqueda.length);
        }
    
        /*    TAREA DOMICILIARIA 4    */
        System.out.println("--------Tarea domiciliaria 4--------");
        System.out.println("");
        
        TArbolTrie arbolLibro = new TArbolTrie();
        String[] unLibro = ManejadorDeArchivos.leerArchivo("src/libropru.txt");
        
        for (String linea : unLibro){
            String[] palabrasLibro = linea.split(" ");
            for (String palabraActual : palabrasLibro) {
                String palabraSoloASCII = onlyASCII.getOnlyStrings(palabraActual);
                String palabraSinEspacio = palabraSoloASCII.replace(" ", "").toLowerCase();
                arbolLibro.insertar(palabraSinEspacio);     
            }
        }
        
        arbolLibro.obtenerFrecuencias().forEach((k,v) -> {System.out.printf("Palabra: %s " + "Ocurrencia: %d \n",k,v);});
        HashMap<String, Integer> frecuencias = arbolLibro.obtenerFrecuencias();
        
        ArrayList frecuenciasOrdenadas = new ArrayList(frecuencias.values());
        Collections.sort(frecuenciasOrdenadas);
        for(Object value : frecuenciasOrdenadas)
             System.out.println(value);
    }
}
