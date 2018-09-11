/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT2;

import UT2.TD1.TNodoArbolGenerico;
import UT2.TD1.TArbolGenerico;
import UT2.TD1.Departamentos;
import UT2.TD2_3.TArbolTrie;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author germanpujadas
 */
public class Main {
    
    public static void main(String[] args) {
    
        /*    TAREA DOMICILIARIA 1    */
        System.out.println("Tarea domiciliaria 1");
        
        TArbolGenerico<Departamentos> arbolTD1 = new TArbolGenerico();
        TNodoArbolGenerico<Departamentos> Rectoria = new TNodoArbolGenerico<>("Rectoria",new Departamentos("Rectoria"));
        TNodoArbolGenerico<Departamentos> VMU = new TNodoArbolGenerico<>("VMU",new Departamentos("VMU"));
        TNodoArbolGenerico<Departamentos> VAca = new TNodoArbolGenerico<>("VAca",new Departamentos("VAca"));
        TNodoArbolGenerico<Departamentos> VAdm = new TNodoArbolGenerico<>("VAdm",new Departamentos("VAdm"));
        TNodoArbolGenerico<Departamentos> FCE = new TNodoArbolGenerico<>("FCE",new Departamentos("FCE"));
        TNodoArbolGenerico<Departamentos> FCH = new TNodoArbolGenerico<>("FCH",new Departamentos("FCH"));
        TNodoArbolGenerico<Departamentos> FIT = new TNodoArbolGenerico<>("FIT",new Departamentos("FIT"));
        TNodoArbolGenerico<Departamentos> FP = new TNodoArbolGenerico<>("FP",new Departamentos("FP"));
        TNodoArbolGenerico<Departamentos> DICC = new TNodoArbolGenerico<>("DICC",new Departamentos("DICC"));
        TNodoArbolGenerico<Departamentos> DIE = new TNodoArbolGenerico<>("DIE",new Departamentos("DIE"));
        TNodoArbolGenerico<Departamentos> DM = new TNodoArbolGenerico<>("DM",new Departamentos("DM"));
        TNodoArbolGenerico<Departamentos> FODON = new TNodoArbolGenerico<>("FODON",new Departamentos("FODON"));
                
        arbolTD1.insertar(Rectoria, "");
        arbolTD1.insertar(VMU, Rectoria.getEtiqueta());
        arbolTD1.insertar(VAca, Rectoria.getEtiqueta());
        arbolTD1.insertar(VAdm, Rectoria.getEtiqueta());
        arbolTD1.insertar(FCE, VAca.getEtiqueta());
        arbolTD1.insertar(FCH, VAca.getEtiqueta());
        arbolTD1.insertar(FIT, VAca.getEtiqueta());
        arbolTD1.insertar(FP, VAca.getEtiqueta());
        arbolTD1.insertar(DICC, FIT.getEtiqueta());
        arbolTD1.insertar(DIE, FIT.getEtiqueta());
        arbolTD1.insertar(DM, FIT.getEtiqueta());
        arbolTD1.insertar(FODON, VAca.getEtiqueta());
        
        
//        LinkedList<Prueba> resultado = new LinkedList<>();
//        Comparable etiquetaABuscar = "Rectoria";
//        resultado = unArbol.listarHijos(etiquetaABuscar);
//        
//        if (!resultado.isEmpty()){
//            System.out.println("El nodo '"+etiquetaABuscar.toString().toLowerCase()+"' tiene "+resultado.size()+" hijos.");
//            for(Departamentos nodo : resultado)
//                System.out.println(nodo.getNombre());
//        }    

        arbolTD1.listarIndentado();
        
        /*    TAREA DOMICILIARIA 2    */
        
        System.out.println("Tarea domiciliaria 2");
        
        TArbolTrie arbolTD2 = new TArbolTrie();
        String[] archivoTD2 = ManejadorDeArchivos.leerArchivo("src/palabras.txt");
        
        for (String linea : archivoTD2){
            String[] palabras = linea.split(",");
            arbolTD2.insertar(palabras[0], Integer.parseInt(palabras[1])); 
        }
        
        System.out.println("Al: "+arbolTD2.buscar("alimania"));
        System.out.println("Al: "+arbolTD2.buscar("alimaña"));
        
        ArrayList paginas = arbolTD2.devolverPaginas("alimania");
        String paginasEncontradas = "";
        if (paginas != null){
            for(Object pagina : paginas)
                paginasEncontradas+= pagina+", ";
            System.out.println("alimania: "+paginasEncontradas);
        }
        else
            System.out.println("Palabra no encontrada");
        
        
        /*    TAREA DOMICILIARIA 3    */
        
        System.out.println("Tarea domiciliaria 3");
        
        TArbolTrie arbolTD3 = new TArbolTrie();
        String[] indiceTD3 = ManejadorDeArchivos.leerArchivo("src/PalabrasIndice.txt");
        //String[] libroTD3 = ManejadorDeArchivos.leerArchivo("src/libro.txt");
        String[] libroTD3 = ManejadorDeArchivos.leerArchivo("src/libropru.txt");
        
        for (String palabra : indiceTD3){
            arbolTD3.insertar(palabra.toLowerCase().replace(" ", "")); 
        }
        
        arbolTD3.indizarLibro(libroTD3);
        arbolTD3.imprimirIndice();
    }
}
