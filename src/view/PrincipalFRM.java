/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GraphicsConfiguration;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.FilmeINF;
import model.Dados;
import model.CategoriaINF;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import model.Usuario;

public class PrincipalFRM extends javax.swing.JFrame {

    public static List<FilmeINF> filmesEscolhidos = new ArrayList<FilmeINF>();
    public static List<Filme> todosFilmes = new ArrayList<Filme>();
    public static Usuario usuarioLocflix = new Usuario();

    private List<JScrollPane> listJSP = new ArrayList<JScrollPane>();

    private Dados dados = new Dados();
    private int width;

    public void clearFilmesEscolhidos() {
        for (Filme o : todosFilmes) {
            o.btnItemAdicionar.setText("Adicionar");
        }

        filmesEscolhidos.clear();
        btnMinhaListaFilmes.setText("Minha lista de filmes (" + filmesEscolhidos.size() + ")");
    }

    public PrincipalFRM() {
        initComponents();
       
        final GraphicsConfiguration config = this.getGraphicsConfiguration();

        final int left = Toolkit.getDefaultToolkit().getScreenInsets(config).left;
        final int right = Toolkit.getDefaultToolkit().getScreenInsets(config).right;
        final int top = Toolkit.getDefaultToolkit().getScreenInsets(config).top;
        final int bottom = Toolkit.getDefaultToolkit().getScreenInsets(config).bottom;

        final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        width = screenSize.width - left - right;
        final int height = screenSize.height - top - bottom;

        jPanel3.setLayout(new BorderLayout(0, 0));
        jPanel1.setSize(width - 10, 50);
        jPanel1.setLayout(new BorderLayout(0, 0));

        JPanel organizaBotoes = new JPanel();
        organizaBotoes.setLayout(new FlowLayout(FlowLayout.TRAILING, 10, 8));
        jPanel1.add(organizaBotoes, BorderLayout.EAST);

        jPanel2.add(jLabel1, BorderLayout.PAGE_END);
        jPanel3.add(jPanel2, BorderLayout.PAGE_END);

        scpGeral.setSize(width - 4, height - 130);

        organizaBotoes.add(btnMinhaListaFilmes);
        organizaBotoes.add(btnCadastrese);

        this.setSize(width, height);

        int yBox = 0;
        int xItem = 0;

        CategoriaINF catInf;
        FilmeINF filInf;

        Categoria categoria;
        Filme filme;

        //CRIANDO CATEGORIAS
        for (int i = 0; i < dados.categorias.size(); i++) {
            catInf = dados.categorias.get(i);
            categoria = new Categoria(catInf, width);

            xItem = 10;

            //CRIANDO OS FILMES
            for (int j = 0; j < catInf.getFilmes().size(); j++) {
                filInf = catInf.getFilmes().get(j);
                filme = new Filme(filInf);

                if (j > 0) {
                    xItem += 220;
                }

                categoria.pnlItems.add(filme.pnlItem, new org.netbeans.lib.awtextra.AbsoluteConstraints(xItem, 1, -1, -1));

                final Filme nfil = filme;
                final FilmeINF nfilINF = filInf;

                filme.btnItemAdicionar.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (nfil.btnItemAdicionar.getText().equals("Adicionar")) {
                            PrincipalFRM.filmesEscolhidos.add(nfilINF);
                            nfil.btnItemAdicionar.setText("Cancelar");
                        } else {
                            PrincipalFRM.filmesEscolhidos.remove(nfilINF);
                            nfil.btnItemAdicionar.setText("Adicionar");
                        }
                        btnMinhaListaFilmes.setText("Minha lista de filmes (" + filmesEscolhidos.size() + ")");

                    }
                });

                todosFilmes.add(filme);
            }

            categoria.scpItems.setViewportView(categoria.pnlItems);

            listJSP.add(categoria.scpItems);

            javax.swing.SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < listJSP.size(); j++) {
                         listJSP.get(j).getHorizontalScrollBar().setValue(0);
                    }
                }
            });

            if (i > 0) {
                yBox += 380;
            }

            pnlScrollContainer.add(categoria.pnlBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, yBox, -1, 380));
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btnCadastrese = new javax.swing.JButton();
        btnMinhaListaFilmes = new javax.swing.JButton();
        scpGeral = new javax.swing.JScrollPane();
        pnlScrollContainer = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuNavegador = new javax.swing.JMenu();
        mniMinhaLista = new javax.swing.JMenuItem();
        mniConfUsuario = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Locflix - Locadora de filmes");
        setBackground(new java.awt.Color(242, 242, 242));
        setMinimumSize(new java.awt.Dimension(900, 600));
        setResizable(false);
        setSize(new java.awt.Dimension(1024, 600));

        jPanel3.setBackground(new java.awt.Color(247, 247, 247));
        jPanel3.setAlignmentX(0.0F);
        jPanel3.setAlignmentY(0.0F);
        jPanel3.setPreferredSize(new java.awt.Dimension(900, 600));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setPreferredSize(new java.awt.Dimension(1024, 40));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCadastrese.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/resources/icnUsuario.png"))); // NOI18N
        btnCadastrese.setText("Cadastre-se");
        btnCadastrese.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastreseActionPerformed(evt);
            }
        });
        jPanel1.add(btnCadastrese, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 5, -1, 35));

        btnMinhaListaFilmes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/resources/icnFilme.png"))); // NOI18N
        btnMinhaListaFilmes.setText("Minha lista de filmes (0)");
        btnMinhaListaFilmes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMinhaListaFilmesActionPerformed(evt);
            }
        });
        jPanel1.add(btnMinhaListaFilmes, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 5, -1, 35));

        jPanel3.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 0, 1024, 44));

        scpGeral.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scpGeral.setAlignmentX(0.0F);
        scpGeral.setAlignmentY(0.0F);
        scpGeral.setPreferredSize(new java.awt.Dimension(0, 0));

        pnlScrollContainer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        scpGeral.setViewportView(pnlScrollContainer);

        jPanel3.add(scpGeral, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 1020, 500));

        jPanel2.setPreferredSize(new java.awt.Dimension(1024, 20));

        jLabel1.setText("2017 - Trabalho Acadêmico - Amanda Neves");
        jLabel1.setAlignmentX(10.0F);
        jLabel1.setAlignmentY(1.0F);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(756, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 13, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 550, 1024, 20));

        mnuNavegador.setText("Navegar");

        mniMinhaLista.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, 0));
        mniMinhaLista.setText("Minha lista de filmes ");
        mniMinhaLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniMinhaListaActionPerformed(evt);
            }
        });
        mnuNavegador.add(mniMinhaLista);

        mniConfUsuario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_MASK));
        mniConfUsuario.setText("Configuração de usuário");
        mniConfUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniConfUsuarioActionPerformed(evt);
            }
        });
        mnuNavegador.add(mniConfUsuario);

        jMenuBar1.add(mnuNavegador);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastreseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastreseActionPerformed
        // TODO add your handling code here:
        CadastroFRM frm = new CadastroFRM(btnCadastrese);
        //frm.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frm.setLocationRelativeTo(null);
        frm.setVisible(true);
    }//GEN-LAST:event_btnCadastreseActionPerformed

    private void btnMinhaListaFilmesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinhaListaFilmesActionPerformed
        ListaFilmesFRM frm = new ListaFilmesFRM();
        frm.principalFRM = this;
        frm.setLocationRelativeTo(null);
        frm.setVisible(true);
    }//GEN-LAST:event_btnMinhaListaFilmesActionPerformed

    private void mniMinhaListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniMinhaListaActionPerformed
        ListaFilmesFRM frm = new ListaFilmesFRM();
        frm.principalFRM = this;
        frm.setLocationRelativeTo(null);
        frm.setVisible(true);
    }//GEN-LAST:event_mniMinhaListaActionPerformed

    private void mniConfUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniConfUsuarioActionPerformed
        // TODO add your handling code here:
        CadastroFRM frm = new CadastroFRM(btnCadastrese);
        //frm.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frm.setLocationRelativeTo(null);
        frm.setVisible(true);
    }//GEN-LAST:event_mniConfUsuarioActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PrincipalFRM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrincipalFRM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrincipalFRM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrincipalFRM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrincipalFRM().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrese;
    private javax.swing.JButton btnMinhaListaFilmes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JMenuItem mniConfUsuario;
    private javax.swing.JMenuItem mniMinhaLista;
    private javax.swing.JMenu mnuNavegador;
    private javax.swing.JPanel pnlScrollContainer;
    private javax.swing.JScrollPane scpGeral;
    // End of variables declaration//GEN-END:variables
}
