package PrimerParcial18Equipos;



import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Representa un nodo interno del Trie de Dispositivos con IP.
 * 
 * @author Equipo 1
 */
public class TNodoTrieHash implements INodoTrie {
    HashMap<Character, TNodoTrieHash> hijos = new HashMap<>();
    TDispositivo dispositivo = null;

    /**
     * Inserta un dispositivo en el trie considerando su dirección IP
     * 
     * @param unDispositivo un dispositivo con una IP asignada
     */
    @Override
    public void insertar(TDispositivo unDispositivo) {
        TNodoTrieHash nodo = this;
        String dirIP = unDispositivo.getDirIP();
        for (int i = 0; i < dirIP.length(); i++) {
            char c = dirIP.charAt(i);
            if (Character.isDigit(c)) {
                if (nodo.hijos.get(c) == null) {
                    nodo.hijos.put(c, new TNodoTrieHash());
                }
                nodo = nodo.hijos.get(c);
            }
            
        }
        if (nodo.dispositivo != null) {
            throw new IllegalArgumentException("Another pc with same IP exists");
        }
        nodo.dispositivo = unDispositivo;
    }

    /**
     * Busca la colección de dispositivos que pertenecen a la subRed dada.
     * 
     * Equivalente a la búsqueda de dispositivos cuya IP tiene como prefijo la 
     * mascara dada.
     * 
     * @param mascaraSubRed una mascara de sub red válida, del tipo XXX., XXX.YYY. o XXX.YYY.ZZZ.
     * @return Una colección de objetos Dispositivo pertenecientes a la subred
     */
    
    public Collection<TDispositivo> buscarDispositivos(String mascaraSubRed) {
        TNodoTrieHash nodo = this;
        for (int i = 0; i < mascaraSubRed.length(); i++) {
            char c = mascaraSubRed.charAt(i);
            if (Character.isDigit(c)) {
                nodo = nodo.hijos.get(c);
                if (nodo == null) {
                    return new LinkedList<>();
                }
            }
            
        }
        
        Collection<TDispositivo> dispositivos = new LinkedList<>();
        nodo.todosLosAbonados(dispositivos);
        return dispositivos;
    }

    /**
     * Recorre el trie hasta las hojas (a partir de un nodo) y agrega todos los
     * dispositivos asociados a la coleccion dada. 
     * 
     * @param dispositivos una coleccion en la cual insertar dispositivos
     */
    private void todosLosAbonados(Collection<TDispositivo> dispositivos) {
        if (this.dispositivo != null) {
            dispositivos.add(this.dispositivo);
        }
        for (TNodoTrieHash hijo : hijos.values()) {
            if (hijo != null) {
                hijo.todosLosAbonados(dispositivos);
            }
        }
    }
}
