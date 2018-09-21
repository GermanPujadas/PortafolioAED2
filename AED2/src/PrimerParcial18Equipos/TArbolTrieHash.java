package PrimerParcial18Equipos;



import java.util.Collection;
import java.util.LinkedList;
import java.util.stream.Collectors;

/**
 * Representa un trie de IPs con datos dispositivo
 * 
 * @author Equipo 1
 */
public class TArbolTrieHash implements IArbolTrie {
    private final TNodoTrieHash raiz;

    public TArbolTrieHash() {
        raiz = new TNodoTrieHash();
    }

    /**
     * Busca la colección de dispositivos que pertenecen a la subRed dada
     * 
     * @param mascaraSubRed una mascara de sub red válida, del tipo XXX., XXX.YYY. o XXX.YYY.ZZZ.
     * @return Una colección de objetos Dispositivo pertenecientes a la subred
     */
    @Override
    public Collection<TDispositivo> buscarDispositivos(String mascaraSubRed) {
        return raiz.buscarDispositivos(mascaraSubRed);
    }

    /**
     * Inserta un dispositivo en el trie considerando su dirección IP
     * 
     * @param unDispositivo un dispositivo con una IP asignada
     */
    @Override
    public void insertar(TDispositivo unDispositivo) {
        raiz.insertar(unDispositivo);
    }
}
