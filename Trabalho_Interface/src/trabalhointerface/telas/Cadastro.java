package trabalhointerface.telas;

import javax.swing.JLabel;
import javax.swing.JTextField;
import trabalhointerface.modelo.ProdutoDTO;
import trabalhointerface.persistencia.ProdutoDAO;
import trabalhointerface.util.Mensagens;
import trabalhointerface.util.Validacao;

public class Cadastro extends javax.swing.JFrame {

    private final boolean modoInclusao;
    private final ProdutoDTO produto;
    private final ProdutoDAO produtoDAO = new ProdutoDAO();

    //caminho.setText(cod.getIcone().toString());
    public Cadastro(boolean modoInclusao, ProdutoDTO produto) {
        this.modoInclusao = modoInclusao;
        this.produto = produto;
        initComponents();
        if (modoInclusao == false) {
            nomeProduto.setText(produto.getNome());
            precoProduto.setText(String.valueOf(produto.getPreco()));
            iconeProduto.setIcon(produto.getIcone());

        }
        this.setLocationRelativeTo(null);
    }

    public boolean cadastraOuAlteraProduto(JTextField nome, JTextField preco, JLabel caminhoIcone) {
        boolean aux = false, pesquisaIcone = false;
        
        if (alteraIcone.getActionCommand().equals("alteraIconeActionPerformed")) {
            pesquisaIcone = true;
        }
        
        if (Validacao.validaCampo(nome)) {
            if (produtoDAO.verificaNome(nome.getText(), produto.getCodigo())) {
                Mensagens.msgAviso("Esse produto já está cadastrado no BD.");
            } else if ((Validacao.validaFloat(preco, 0, 101)) && (!modoInclusao || (modoInclusao && Validacao.validaIcone(caminhoIcone)))) {
                if (modoInclusao) {
                    produtoDAO.cadastraProdutoBD(nome.getText(), Float.valueOf(preco.getText()), caminhoIcone.getText());
                } else {
                    produtoDAO.alteraProdutoBD(nomeProduto.getText(), Float.valueOf(precoProduto.getText()), caminhoIcone.getText(), produto.getCodigo(), pesquisaIcone);
                }
                aux = true;
            }
        } else {
            if (modoInclusao) {
                nome.setText("");
                preco.setText("");
                caminho.setText("");
                caminhoIcone.setIcon(null);
            }
        }
        return aux;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        nomeProduto = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        precoProduto = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        iconeProduto = new javax.swing.JLabel();
        caminho = new javax.swing.JLabel();
        alteraIcone = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro de Produtos");
        setMaximumSize(new java.awt.Dimension(460, 329));
        setMinimumSize(new java.awt.Dimension(460, 329));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(153, 255, 204));

        jLabel3.setFont(new java.awt.Font("Baskerville Old Face", 1, 24)); // NOI18N
        jLabel3.setText("Cadastro de Produtos");

        nomeProduto.setToolTipText("Digite o nome do produto.");

        jLabel1.setFont(new java.awt.Font("Baskerville Old Face", 1, 18)); // NOI18N
        jLabel1.setText("Produto");

        jLabel2.setFont(new java.awt.Font("Baskerville Old Face", 1, 18)); // NOI18N
        jLabel2.setText("Preço");

        precoProduto.setToolTipText("Digite o preço do produto.");

        jLabel4.setFont(new java.awt.Font("Baskerville Old Face", 1, 18)); // NOI18N
        jLabel4.setText("Ícone");

        caminho.setToolTipText("Adicione um ícone ao produto.");

        alteraIcone.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        alteraIcone.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/magnifier.png"))); // NOI18N
        alteraIcone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alteraIconeActionPerformed(evt);
            }
        });

        btnSalvar.setFont(new java.awt.Font("Baskerville Old Face", 1, 18)); // NOI18N
        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/correct-symbol.png"))); // NOI18N
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Baskerville Old Face", 1, 18)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/cancel-mark.png"))); // NOI18N
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Baskerville Old Face", 0, 12)); // NOI18N
        jLabel5.setText("Entre R$ 1,00 e R$ 100. ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(128, 128, 128))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(37, 37, 37))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(18, 18, 18)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(38, 38, 38)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(iconeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(caminho, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(alteraIcone, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(nomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(precoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel3)
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(precoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(alteraIcone)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(1, 1, 1)
                            .addComponent(jLabel4))
                        .addComponent(caminho, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(iconeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSalvar)
                    .addComponent(btnCancelar))
                .addGap(35, 35, 35))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void alteraIconeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alteraIconeActionPerformed
        Arquivos arquivos = new Arquivos(this, true);
        arquivos.setVisible(true);
        if (arquivos.verificaAcao()) {
            String arquivoSelecionado = arquivos.getSelected();
            caminho.setText(arquivoSelecionado);
            iconeProduto.setIcon(new javax.swing.ImageIcon(arquivoSelecionado));
        }
    }//GEN-LAST:event_alteraIconeActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        Consulta consulta = null;
        consulta = new Consulta();
        consulta.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (cadastraOuAlteraProduto(nomeProduto, precoProduto, caminho)) {
            if (modoInclusao) {
                Mensagens.msgInfo("Produto adicionado com sucesso.");
            } else {
                Mensagens.msgInfo("Produto alterado com sucesso.");
            }
            Consulta consulta = new Consulta();
            consulta.setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_btnSalvarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton alteraIcone;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel caminho;
    private javax.swing.JLabel iconeProduto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nomeProduto;
    private javax.swing.JTextField precoProduto;
    // End of variables declaration//GEN-END:variables
}
