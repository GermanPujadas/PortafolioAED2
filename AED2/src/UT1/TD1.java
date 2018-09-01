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
public class TD1 {
    
   public boolean busquedaLineal (int[] unVector, int unaClave){
       
      if (unVector.length == 0)
          return false;
      else{
          for (int i = 0; i<unVector.length; i++){
              if (unVector[i]== unaClave)
                  return true;
            }            
      }
      return false;       
   }
   
   public boolean busquedaBinaria (int[] unVector, int unaClave){
       boolean resultado = false;
       
       if (unVector.length == 2 && (unVector[0] == unaClave || unVector[1] == unaClave))
               return true;
       
       if (unVector.length == 0)
          return false;
      
       else{    
              int largoSubVectorIzquierdo;
              int largoSubVectorDerecho;
              int centro = unVector.length/2;
              if (unVector.length%2 != 0){
                  largoSubVectorIzquierdo = centro;
                  largoSubVectorDerecho = centro+1;
              }
              else
                  largoSubVectorIzquierdo = largoSubVectorDerecho = centro;
                  
              int[] auxDer = new int[largoSubVectorDerecho];
              int[] auxIzq = new int[largoSubVectorIzquierdo];
              
              if (unVector[centro] == unaClave){
                  return true;
              }
              else{
                  if (unVector[centro] > unaClave){
                      for (int i =0; i<centro; i++)
                          auxIzq[i] = unVector[i];
                     resultado = busquedaBinaria(auxIzq, unaClave);
                  }
                  else{
                      int j = centro;
                      for (int i =0; i<auxDer.length; i++){
                          auxDer[i] = unVector[j];
                          j++;
                      }
                      resultado = busquedaBinaria(auxDer, unaClave);
                  }
          }
          return resultado;
      }
   }
    
}
