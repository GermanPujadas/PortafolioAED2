package PrimerParcial18;



import java.util.Collection;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args){
        TArbolTrie trie = new TArbolTrie();

        // CARGAR EN EL TRIE LOS DISPOSITIVOS PARTIR DEL ARCHIVO DISPOSITIVOS.TXT
        
        String[] dispositivosDatos = ManejadorArchivosGenerico.leerArchivo("src/dispositivos.txt");
        for(String disp : dispositivosDatos){
            String[] datos = disp.split(",");
            trie.insertar(new TDispositivo(datos[0], datos[1]));
        }
        
        String subRed1 = "141." ; // utilizar el indicado en el archivo "subredes.txt"
        String subRed2 = "005.116";
        Collection<TDispositivo> dispositivos = trie.buscarDispositivos(subRed1);
        Collection<TDispositivo> dispositivos2 = trie.buscarDispositivos(subRed2);
        
        
        for (TDispositivo disp : dispositivos){
            System.out.printf("Nombre de dispositivo: %s, IP: %s \n", disp.getDirIP(), disp.getNombre());           
        }
        
        for (TDispositivo disp : dispositivos2){
            System.out.printf("Nombre de dispositivo: %s, IP: %s \n", disp.getDirIP(), disp.getNombre());           
        }
            
        String[] salida = new String[dispositivos.size()+dispositivos2.size()];
        
        int i = 0;
        for(TDispositivo disp : dispositivos){
            String dato="";
            dato = "Nombre de dispositivo: "+disp.getNombre()+", IP: "+disp.getDirIP();
            salida[i] = dato;
            i++;
        }
        
        for(TDispositivo disp : dispositivos2){
            String dato="";
            dato = "Nombre de dispositivo: "+disp.getNombre()+", IP: "+disp.getDirIP();
            salida[i] = dato;
            i++;
        }
        
        // crear el archivo "salida.txt", con los dispositivos(1 por linea) 
        // correspondientes a la subred indicada
        // imprimir Nombre y dirección de  IP, 
        ManejadorArchivosGenerico.escribirArchivo("src/salida.txt", salida);
        
    }
}