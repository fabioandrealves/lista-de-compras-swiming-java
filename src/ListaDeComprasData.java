import java.util.LinkedList;
import java.util.List;
import listaDeCompras.ItemLista;

public class ListaDeComprasData {
    private final LinkedList<ItemLista> listaCompras = new LinkedList<ItemLista>();

    public List<ItemLista> getItems() {
        return listaCompras;
    }

    public void add(ItemLista item) {
        listaCompras.add(item);
    }
}


