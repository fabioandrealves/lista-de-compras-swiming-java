package listaDeCompras;
;
import java.util.LinkedList;

public class ListaCompras {
    private LinkedList<ItemLista> carrinho = new LinkedList<ItemLista>();
    private Produto novoProduto = null;

public void cadastrarProduto(ItemLista novoItem) {
    carrinho.add(novoItem); // Adiciona o novo item à lista de compras
    System.out.println("Produto cadastrado com sucesso!");
}

    public void adicionarProdutoLista() {
        if (!carrinho.isEmpty()) {
            System.out.println("Produto adicionado à lista de compras!");
            novoProduto = null;
        } else {
            System.out.println("Cadastre um produto primeiro!");
        }
    }
    
    public LinkedList<ItemLista> getCarrinho(){
        return carrinho;
    }

}



