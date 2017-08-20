package trabalhointerface.telas;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.SwingUtilities;
import trabalhointerface.modelo.ProdutoDTO;
import trabalhointerface.persistencia.ProdutoDAO;
import trabalhointerface.persistencia.VendaDAO;
import trabalhointerface.util.Mensagens;

public class Vendas extends javax.swing.JFrame {

    private float totalVendas;

    public float getTotalVendas() {
        return totalVendas;
    }

    public void setTotalVendas(float totalVendas) {
        this.totalVendas = totalVendas;
    }
    private float vendaAtual;

    VendaDAO venda = new VendaDAO();

    public Vendas() {
        initComponents();
        this.setLocationRelativeTo(null);
        criaBotoes();
    }

    public Object[][] mprodutos = null;

    public void criaBotoes() {
        // posições nos eixos X e Y de cada botão...
        int posX = 25;
        int posY = 20;

        ProdutoDAO produto = new ProdutoDAO();
        ArrayList<ProdutoDTO> listaProdutos = produto.carregaProdutos();
        mprodutos = new Object[listaProdutos.size()][2];
        int linha = 0;
        for (ProdutoDTO pdto : listaProdutos) {
            JButton botao = new JButton();
            botao.setName(String.valueOf(pdto.getCodigo()));
            mprodutos[linha][0] = botao;
            mprodutos[linha][1] = pdto;
            linha++;
            botao.setText("0");
            botao.setToolTipText(pdto.getNome() + " - R$ " + pdto.getPreco());
            botao.setBounds(posX, posY, 135, 60);
            botao.setIcon(pdto.getIcone());

            // o método setBounds serve para definir a posição nos eixos x e y, além
            // da largura e altura do botão.
            botao.setVisible(true);

            // adicionar um ActionListener em um controle permite que o programa
            // possa responder a eventos específicos. o ActionListener adicionado
            // desvia a execução do código para o método "processaPressionamentoBotao()"
            // no qual é possível "identificar" qual foi o botão pressionado.
            botao.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    processaPressionamentoBotao(e, botao);
                }
                
               
            });

            // o botão criado acima precisa ser adicionado ao JFrame (isso não é feito
            // de modo automático).
            // this = JFrame. getContentPane() = método para acessar o container de controles do JFrame.
            //this.setContentPane(scroll);
            painel.add(botao);

            // incrementa a posição no eixo Y para evitar a sobreposição dos botões.
            posX += 165;
            painel.add(botao);

            if (posX >= 645) {
                posX = 25;
                posY += 90;
                //if (posY >= 400) {
                //}
            }
        }
        this.repaint();
    }

    private void processaPressionamentoBotao(MouseEvent e, JButton botao) {
        total.setText("");
        vendaAtual = 0;
        btnEncerra.setEnabled(true);
        finaliza.setEnabled(false);
        botao = (JButton) e.getSource();
        if (SwingUtilities.isRightMouseButton(e)) {
            if (botao.getText().equals("0")) {
                Mensagens.msgAviso("Quantidade inválida.");
            } else {
                botao.setText((String.valueOf(Integer.valueOf(botao.getText()) - 1)));
            }
        } else if (SwingUtilities.isLeftMouseButton(e)) {
            botao.setText((String.valueOf(Integer.valueOf(botao.getText()) + 1)));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelP = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        total = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnEncerra = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        scroll = new javax.swing.JScrollPane();
        painel = new javax.swing.JPanel();
        finaliza = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Vendas");
        setMaximumSize(new java.awt.Dimension(694, 501));
        setMinimumSize(new java.awt.Dimension(694, 501));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        painelP.setBackground(new java.awt.Color(153, 255, 204));
        painelP.setAutoscrolls(true);
        painelP.setMaximumSize(new java.awt.Dimension(694, 501));
        painelP.setMinimumSize(new java.awt.Dimension(694, 501));

        jLabel2.setFont(new java.awt.Font("Baskerville Old Face", 1, 36)); // NOI18N
        jLabel2.setText("Vendas");

        total.setEditable(false);

        jLabel1.setFont(new java.awt.Font("Baskerville Old Face", 0, 24)); // NOI18N
        jLabel1.setText("Total");

        btnEncerra.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        btnEncerra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/coins.png"))); // NOI18N
        btnEncerra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEncerraActionPerformed(evt);
            }
        });

        btnVoltar.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        btnVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/002-voltar.png"))); // NOI18N
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        scroll.setBackground(new java.awt.Color(153, 255, 204));
        scroll.setToolTipText("");
        scroll.setAutoscrolls(true);

        painel.setBackground(new java.awt.Color(153, 255, 204));
        painel.setAutoscrolls(true);
        painel.setPreferredSize(new java.awt.Dimension(100, 100));

        javax.swing.GroupLayout painelLayout = new javax.swing.GroupLayout(painel);
        painel.setLayout(painelLayout);
        painelLayout.setHorizontalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 671, Short.MAX_VALUE)
        );
        painelLayout.setVerticalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 360, Short.MAX_VALUE)
        );

        scroll.setViewportView(painel);

        finaliza.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/maquina.png"))); // NOI18N
        finaliza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finalizaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelPLayout = new javax.swing.GroupLayout(painelP);
        painelP.setLayout(painelPLayout);
        painelPLayout.setHorizontalGroup(
            painelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelPLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(btnEncerra, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(finaliza, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
            .addGroup(painelPLayout.createSequentialGroup()
                .addGroup(painelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelPLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 673, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelPLayout.createSequentialGroup()
                        .addGap(284, 284, 284)
                        .addComponent(jLabel2)))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        painelPLayout.setVerticalGroup(
            painelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelPLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(17, 17, 17)
                .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(painelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelPLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(painelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(finaliza, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                            .addComponent(btnEncerra, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnVoltar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(painelPLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(painelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        System.exit(0);
    }//GEN-LAST:event_formWindowClosed

    private void finalizaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finalizaActionPerformed
        if (vendaAtual != 0) {
            if (Mensagens.msgConf("O total da sua compra é de R$" + vendaAtual + ".\n Você deseja finalizar essa compra?")) {
                totalVendas = totalVendas + vendaAtual;
                Mensagens.msgInfo("Sua compra foi finalizada.");
                venda.insereVendaBD(totalVendas);
                Menu menu = new Menu();
                menu.setVisible(true);
                this.setVisible(false);
            }
        } else {
            Mensagens.msgAviso("Nenhum produto foi selecionado.");
        }
    }//GEN-LAST:event_finalizaActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        Menu menu = new Menu();
        menu.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnEncerraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEncerraActionPerformed
        btnEncerra.setEnabled(false);
        finaliza.setEnabled(true);
        int aux;
        for (int i = 0; i < mprodutos.length; i++) {
            Object[] mproduto = mprodutos[i];
            JButton botao = (JButton) mprodutos[i][0];
            ProdutoDTO pdto = (ProdutoDTO) mprodutos[i][1];
            aux = Integer.valueOf(botao.getText());
            if (aux != 0) {
                vendaAtual = vendaAtual + (aux * pdto.getPreco());
            }
        }
        total.setText(String.valueOf(vendaAtual));
    }//GEN-LAST:event_btnEncerraActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEncerra;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JButton finaliza;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel painel;
    private javax.swing.JPanel painelP;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JTextField total;
    // End of variables declaration//GEN-END:variables

}
