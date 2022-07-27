/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.CategoriaINF;

public class Categoria {

    //public javax.swing.JButton btnHeaderArrow;
    public javax.swing.JLabel lblHeaderTitle;
    public javax.swing.JPanel pnlBox;
    public javax.swing.JPanel pnlHeader;
    public javax.swing.JPanel pnlItems;
    public javax.swing.JScrollPane scpItems;

    public Categoria(CategoriaINF inf, int width) {
        pnlBox = new javax.swing.JPanel();
        pnlHeader = new javax.swing.JPanel();
        //btnHeaderArrow = new javax.swing.JButton();
        lblHeaderTitle = new javax.swing.JLabel();
        scpItems = new javax.swing.JScrollPane();
        pnlItems = new javax.swing.JPanel();

        pnlBox.setPreferredSize(new java.awt.Dimension(width - 25, 300));
        pnlBox.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlHeader.setBackground(new java.awt.Color(239, 239, 239));
        pnlHeader.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlHeader.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        /*
        btnHeaderArrow.setText("v");
        btnHeaderArrow.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnHeaderArrow.setMaximumSize(new java.awt.Dimension(60, 60));
        btnHeaderArrow.setPreferredSize(new java.awt.Dimension(60, 60));
        pnlHeader.add(btnHeaderArrow, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 4, 30, 30));
         */
        lblHeaderTitle.setText(inf.getTitulo());
        pnlHeader.add(lblHeaderTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));
        pnlBox.add(pnlHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, width - 25, 40), 0);

        scpItems.setBackground(new java.awt.Color(239, 239, 239));
        scpItems.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        scpItems.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        scpItems.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        // scpItems.add(pnlHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, width-25, 40));
        scpItems.setLocation(0, 0);

        pnlItems.setBackground(new java.awt.Color(243, 243, 243));
        pnlItems.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlBox.add(scpItems, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 39, width - 22, 330), 1);
    }
}
