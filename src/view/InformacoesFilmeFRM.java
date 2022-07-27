/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DecimalFormat;
import model.FilmeINF;

public class InformacoesFilmeFRM extends javax.swing.JFrame {

    /**
     * Creates new form InformacoesFilmeFRM
     */
    public InformacoesFilmeFRM(FilmeINF inf) {
        initComponents();
        
        lblImagem.setIcon(new javax.swing.ImageIcon(getClass().getResource(inf.getCapaOriginal())));
        lblTitulo.setText(inf.getNome());
        txaSinopse.setText(inf.getSinopse());
        lblDataLancamento.setText(inf.getDataLancamento());
        lblDuracao.setText(inf.getDuracao());
        lblClassificacaoImagem.setIcon(new javax.swing.ImageIcon(getClass().getResource(inf.getClassificacao())));
        lblValorAluguel.setText(new DecimalFormat("'R$' #,###,##0.00").format(inf.getValorAluguel()));
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e); //To change body of generated methods, choose Tools | Templates.
                
                InformacoesFilmeFRM.this.dispose();
                
                /*int res = JOptionPane.showConfirmDialog(CadastroFRM.this, "Are you sure you want to close?", "Close?", JOptionPane.YES_NO_OPTION);
                if ( res == 0 ) {
                    CadastroFRM.this.dispose();
                }*/
            }
           
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblImagem = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblValorAluguel = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblDuracao = new javax.swing.JLabel();
        lblClassificacaoImagem = new javax.swing.JLabel();
        lblDataLancamento = new javax.swing.JLabel();
        txaSinopse = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Informações do Filme");
        setAlwaysOnTop(true);
        setMaximumSize(new java.awt.Dimension(620, 415));
        setMinimumSize(new java.awt.Dimension(620, 415));
        setPreferredSize(new java.awt.Dimension(620, 415));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblImagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/resources/filmes/acao/batman_capa.png"))); // NOI18N
        getContentPane().add(lblImagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 230, 360));

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("jLabel1");
        getContentPane().add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(254, 20, 340, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Classificação:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(252, 340, -1, -1));

        lblValorAluguel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblValorAluguel.setText("R$ 3,30");
        getContentPane().add(lblValorAluguel, new org.netbeans.lib.awtextra.AbsoluteConstraints(548, 340, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Lançamento:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(252, 310, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Valor do aluguel:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(425, 340, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Duração:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(482, 310, -1, -1));

        lblDuracao.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblDuracao.setText("1h 20m");
        getContentPane().add(lblDuracao, new org.netbeans.lib.awtextra.AbsoluteConstraints(548, 310, -1, -1));

        lblClassificacaoImagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/resources/filmes/classificacao/classificacao_14.png"))); // NOI18N
        getContentPane().add(lblClassificacaoImagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(352, 335, 25, 25));

        lblDataLancamento.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblDataLancamento.setText("99/99/9999");
        getContentPane().add(lblDataLancamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 310, -1, -1));

        txaSinopse.setEditable(false);
        txaSinopse.setBackground(javax.swing.UIManager.getDefaults().getColor("Label.background"));
        txaSinopse.setLineWrap(true);
        txaSinopse.setRows(5);
        txaSinopse.setText("...\n");
        txaSinopse.setWrapStyleWord(true);
        txaSinopse.setBorder(null);
        getContentPane().add(txaSinopse, new org.netbeans.lib.awtextra.AbsoluteConstraints(254, 42, 340, 245));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel lblClassificacaoImagem;
    private javax.swing.JLabel lblDataLancamento;
    private javax.swing.JLabel lblDuracao;
    private javax.swing.JLabel lblImagem;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblValorAluguel;
    private javax.swing.JTextArea txaSinopse;
    // End of variables declaration//GEN-END:variables
}