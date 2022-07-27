/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.FilmeINF;
import java.text.DecimalFormat;

public class Filme {

    public javax.swing.JButton btnItemAdicionar;
    public javax.swing.JButton btnItemMais;
    public javax.swing.JTextArea txaItemSinopse;
    public javax.swing.JLabel lblItemImagem;
    public javax.swing.JLabel lblItemNome;
    public javax.swing.JLabel lblItemTitDiaria;
    public javax.swing.JLabel lblItemValor;
    public javax.swing.JPanel pnlItem;
    public javax.swing.JPanel pnlItemDivisor;

    public Filme(FilmeINF inf) {
        pnlItem = new javax.swing.JPanel();
        pnlItemDivisor = new javax.swing.JPanel();
        lblItemImagem = new javax.swing.JLabel();
        txaItemSinopse = new javax.swing.JTextArea();
        lblItemValor = new javax.swing.JLabel();
        lblItemNome = new javax.swing.JLabel();
        lblItemTitDiaria = new javax.swing.JLabel();
        btnItemMais = new javax.swing.JButton();
        btnItemAdicionar = new javax.swing.JButton();

        pnlItem.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlItem.setPreferredSize(new java.awt.Dimension(210, 300));
        pnlItem.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlItemDivisor.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlItemDivisor.setPreferredSize(new java.awt.Dimension(212, 2));

        javax.swing.GroupLayout pnlItemDivisorLayout = new javax.swing.GroupLayout(pnlItemDivisor);
        pnlItemDivisor.setLayout(pnlItemDivisorLayout);
        pnlItemDivisorLayout.setHorizontalGroup(
                pnlItemDivisorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlItemDivisorLayout.setVerticalGroup(
                pnlItemDivisorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );

        pnlItem.add(pnlItemDivisor, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 126, 208, -1));

        lblItemImagem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblItemImagem.setIcon(new javax.swing.ImageIcon(getClass().getResource(inf.getCapaMenor()))); // NOI18N

        pnlItem.add(lblItemImagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 130));

        txaItemSinopse.setText(inf.getSinopse());
        //txaItemSinopse.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        //txaItemSinopse.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        txaItemSinopse.setPreferredSize(new java.awt.Dimension(31, 75));
        //txaItemSinopse.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        txaItemSinopse.setEditable(false);
        txaItemSinopse.setBackground(javax.swing.UIManager.getDefaults().getColor("Label.background"));
        txaItemSinopse.setLineWrap(true);
        txaItemSinopse.setRows(5);
        txaItemSinopse.setText(inf.getSinopse());
        txaItemSinopse.setWrapStyleWord(true);
        txaItemSinopse.setBorder(null);
        pnlItem.add(txaItemSinopse, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 157, 198, 75));

        lblItemValor.setText(new DecimalFormat("'R$' #,###,##0.00").format(inf.getValorAluguel()));
        pnlItem.add(lblItemValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 235, -1, 20));

        lblItemNome.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblItemNome.setText(inf.getNome());
        pnlItem.add(lblItemNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 135, -1, -1));

        lblItemTitDiaria.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblItemTitDiaria.setText("Diária:");
        pnlItem.add(lblItemTitDiaria, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 235, -1, 20));

        btnItemMais.setText("Mais");
        btnItemMais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InformacoesFilmeFRM frm = new InformacoesFilmeFRM(inf);
                frm.setLocationRelativeTo(null);
                frm.setVisible(true);
            }
        });
        pnlItem.add(btnItemMais, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 265, -1, -1));

        btnItemAdicionar.setText("Adicionar");
        pnlItem.add(btnItemAdicionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 265, -1, -1));

    }
}
