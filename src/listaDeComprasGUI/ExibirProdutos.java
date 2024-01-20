
package listaDeComprasGUI;

import javax.swing.table.AbstractTableModel;
import listaDeCompras.ItemLista;
import listaDeCompras.ListaCompras;
import listaDeCompras.Produto;

/**
 *
 * @author ht300810x
 */
public class ExibirProdutos extends javax.swing.JFrame {
    private ListaCompras listaProdutos;
    private TableModel modelo;
    
    public ExibirProdutos(ListaCompras listaProdutos) {
        this.listaProdutos = listaProdutos;
        modelo = new TableModel();
        initComponents();
        configurarTabela();
    }

    private void configurarTabela() {
        tbProdutos.setModel(modelo);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbProdutos = new javax.swing.JTable();
        btnAtualizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tbProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tbProdutos);

        btnAtualizar.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        btnAtualizar.setText("Atualizar");
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 730, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAtualizar)
                .addGap(149, 149, 149))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAtualizar)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
    modelo.limparDados();
    float totalGeral = 0.0f;

    for (ItemLista item : listaProdutos.getCarrinho()) {
            Produto produto = item.getProduto();
            float total = item.calcularTotal();
            totalGeral += total;
            modelo.adicionarDados(produto.getNome(), item.getQuantidade(), produto.getPreco(), total);
        }
   
    modelo.adicionarDados("SubTotal:", "", "", totalGeral);


    }//GEN-LAST:event_btnAtualizarActionPerformed

private class TableModel extends AbstractTableModel{
    private String[] colunas = {"Nome", "Quantidade", "Preço", "Total"};
    private Object[][] dados = new Object[0][colunas.length];
    
        public void limparDados() {
            dados = new Object[0][colunas.length];
            fireTableDataChanged();
        }
        
        public void adicionarDados(Object... linha) {
            Object[][] novo = new Object[dados.length + 1][colunas.length];
            for (int i = 0; i < dados.length; i++) {
                novo[i] = dados[i];
            }
            novo[dados.length] = linha;
            dados = novo;
            fireTableDataChanged();
        }


        @Override
        public int getRowCount() {
            return dados.length;
        }

        @Override
        public int getColumnCount() {
            return colunas.length;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return dados[rowIndex][columnIndex];
        }
        
        @Override
        public String getColumnName(int column){
            return colunas[column];
        }
    
}
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbProdutos;
    // End of variables declaration//GEN-END:variables
}

/*
limparDados():
Este método limpa os dados existentes na tabela, redefinindo a matriz dados como uma matriz vazia e notificando a tabela para que ela atualize sua exibição. É útil para limpar a tabela antes de adicionar novos dados.

adicionarDados(Object... linha):
Este método adiciona uma linha de dados à tabela. Ele cria uma nova matriz que é uma cópia da matriz dados com uma nova linha no final. Os dados da nova linha são passados como argumentos para este método. Novamente, a tabela é notificada para atualizar sua exibição.

getRowCount():
Este método é uma implementação da interface TableModel que retorna o número de linhas na tabela, que é o tamanho da matriz dados.

getColumnCount():
Este método é outra implementação da interface TableModel que retorna o número de colunas na tabela, que é o tamanho da matriz colunas.

getValueAt(int rowIndex, int columnIndex):
Este método é uma implementação da interface TableModel que retorna o valor na célula da tabela especificada pelos índices rowIndex e columnIndex.

getColumnName(int column):
Este método é uma implementação da interface TableModel que retorna o nome da coluna na posição column, com base na matriz colunas.
*/


