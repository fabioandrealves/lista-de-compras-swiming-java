package listaDeCompras;

import listaDeComprasGUI.CadastroProduto;
import listaDeComprasGUI.ExibirProdutos;

import javax.swing.SwingUtilities;

public class Programa {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ListaCompras listaCompras = new ListaCompras(); // Crie uma instância de ListaCompras

            // Crie instâncias de CadastroProduto e ExibirProdutos
            CadastroProduto cadastroProduto = new CadastroProduto(listaCompras);
            ExibirProdutos exibirProdutos = new ExibirProdutos(listaCompras); // Inicialmente com uma lista vazia

            cadastroProduto.setVisible(true); // Torna a tela de cadastro visível
            exibirProdutos.setVisible(true); // Torna a tela de exibição visível
        });
    }
}
