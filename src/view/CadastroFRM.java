/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.MaskFormatter;

public class CadastroFRM extends javax.swing.JFrame {

    /**
     * Creates new form Cadastro
     */
    
    private JButton btnUsuario;
    private String caminhoFotoPadrao = "resources/icnFoto.png";
    private String caminhoFotoUsuario = "resources/icnFoto.png";
    
    public CadastroFRM(JButton btnUsuario) {
        initComponents();
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e); //To change body of generated methods, choose Tools | Templates.
                
                CadastroFRM.this.dispose();
                
                /*int res = JOptionPane.showConfirmDialog(CadastroFRM.this, "Are you sure you want to close?", "Close?", JOptionPane.YES_NO_OPTION);
                if ( res == 0 ) {
                    CadastroFRM.this.dispose();
                }*/
            }
           
        });        
        
        try {
            this.btnUsuario = btnUsuario;
            
            MaskFormatter maskData = new MaskFormatter("##/##/####");
            MaskFormatter maskFone = new MaskFormatter("(##) ####-####");
            MaskFormatter maskCelular = new MaskFormatter("(##) #.####-####");
            MaskFormatter maskCep = new MaskFormatter("##.###-###");
            
            maskData.install(txfNascimento);
            maskCelular.install(txfCelular);
            maskFone.install(txfFone_fixo);
            maskCep.install(txfCep);
            
            if(PrincipalFRM.usuarioLocflix.getNomeCompleto().isEmpty()) {
                // Setando a foto padrão
                // lblFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icnFoto.png")));
                
                // Setando a data mínima para o cadastro
                SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
                Date dt = new Date();
                Calendar c = Calendar.getInstance(); 
                c.setTime(dt); 
                c.add(Calendar.DATE, -5844);
                txfNascimento.setText(dateFormat.format(c.getTime()));
            } else {
                txfNome_completo.setText(PrincipalFRM.usuarioLocflix.getNomeCompleto());
                txfNascimento.setValue(PrincipalFRM.usuarioLocflix.getDtNascimento());
                txfFone_fixo.setText(PrincipalFRM.usuarioLocflix.getTelefoneFixo());
                txfCelular.setText(PrincipalFRM.usuarioLocflix.getCelular());
                txfEndereco.setText(PrincipalFRM.usuarioLocflix.getEndereco());
                txfNumero.setText(PrincipalFRM.usuarioLocflix.getNumero());
                txfBairro.setText(PrincipalFRM.usuarioLocflix.getBairro());
                txfCidade.setText(PrincipalFRM.usuarioLocflix.getCidade());
                cbxUf.setSelectedItem(PrincipalFRM.usuarioLocflix.getUf());
                txfCep.setText(PrincipalFRM.usuarioLocflix.getCep());
                txfEmail.setText(PrincipalFRM.usuarioLocflix.getEmail());
                caminhoFotoUsuario = PrincipalFRM.usuarioLocflix.getFoto();
                if(!caminhoFotoPadrao.equals(caminhoFotoUsuario)){
                    lblFoto.setIcon(organizarFotoNoLabel(caminhoFotoUsuario));
                    btnAdicionar_foto.setText("Remover Foto");
                }
            }
        } catch (ParseException ex) {
            Logger.getLogger(CadastroFRM.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private boolean validarDadosDoUsuario(){
        String campos = "";
        boolean podeAdicionar = true;

        if(txfNome_completo.getText().trim().isEmpty()){
            campos = "Nome completo";
            podeAdicionar = false;
        }
        if(txfNascimento.getText().trim().isEmpty()){
            campos += campos.length() >= 1 ? ", " : "";
            campos += "Data de nascimento";
            podeAdicionar = false;
        }
        if(txfCelular.getText().trim().isEmpty() && txfFone_fixo.getText().trim().isEmpty()){
            campos += campos.length() >= 1 ? ", " : "";
            campos += "Telefone(s) (celular e/ou fixo)";
            podeAdicionar = false;
        }
        if(txfEndereco.getText().trim().isEmpty()){
            campos += campos.length() >= 1 ? ", " : "";
            campos += "Endereço";
            podeAdicionar = false;
        }
        if(txfNumero.getText().trim().isEmpty()){
            campos += campos.length() >= 1 ? ", " : "";
            campos += "Número";
            podeAdicionar = false;
        }
        if(txfBairro.getText().trim().isEmpty()){
            campos += campos.length() >= 1 ? ", " : "";
            campos += "Bairro";
            podeAdicionar = false;
        }
        if(txfCidade.getText().trim().isEmpty()){
            campos += campos.length() >= 1 ? ", " : "";
            campos += "Cidade";
            podeAdicionar = false;
        }

        if(!podeAdicionar){
            JOptionPane.showMessageDialog(this, "É preciso informar o(s) seguinte(s) campo(s): " + campos + ".", "Não foi possível concluir o cadastro.", JOptionPane.ERROR_MESSAGE);
        }

        return podeAdicionar;
    }

    private boolean validarIdadeDoUsuario(){
        boolean temMaisDe16 = true;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date dt = new Date();
        Calendar c = Calendar.getInstance(); 
        c.setTime(dt); 
        c.add(Calendar.DATE, -5844);
        
        Date dtUsuario = new Date(txfNascimento.getText());
        Calendar cUsuario = Calendar.getInstance();
        cUsuario.setTime(dtUsuario);
        
        if(cUsuario.getTime().compareTo(c.getTime()) > 0){
            temMaisDe16 = false;
        }

        if(!temMaisDe16){
            JOptionPane.showMessageDialog(this, "O usuário deve ter mais de 16 anos para alugar filmes.", "Não foi possível concluir o cadastro.", JOptionPane.ERROR_MESSAGE);
        }

        return temMaisDe16;
    }
    
    public ImageIcon organizarFotoNoLabel(String caminhoFotoUsuario) {
        ImageIcon fotoUsuario = new ImageIcon(caminhoFotoUsuario);
        Image img = fotoUsuario.getImage();
        Image novaFoto = img.getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(), Image.SCALE_DEFAULT);
        ImageIcon fotoReduzida = new ImageIcon(novaFoto);
        return fotoReduzida;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txfNascimento = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        txfNome_completo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txfEndereco = new javax.swing.JTextField();
        txfNumero = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txfBairro = new javax.swing.JTextField();
        txfCidade = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        cbxUf = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txfEmail = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        lblFoto = new javax.swing.JLabel();
        btnAdicionar_foto = new javax.swing.JButton();
        txfFone_fixo = new javax.swing.JFormattedTextField();
        txfCelular = new javax.swing.JFormattedTextField();
        txfCep = new javax.swing.JFormattedTextField();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Configuração de Usuário");
        setMaximumSize(new java.awt.Dimension(605, 365));
        setMinimumSize(new java.awt.Dimension(605, 365));
        setPreferredSize(new java.awt.Dimension(605, 365));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Nome Completo");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel3.setText("Nascimento");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 65, -1, -1));

        txfNascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.MEDIUM))));
        getContentPane().add(txfNascimento, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 85, 100, 25));

        jLabel4.setText("Fone Fixo/Comercial");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 65, -1, -1));

        txfNome_completo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfNome_completoActionPerformed(evt);
            }
        });
        getContentPane().add(txfNome_completo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 440, 25));

        jLabel5.setText("Celular");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 65, -1, -1));

        jLabel6.setText("Endereço");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        txfEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfEnderecoActionPerformed(evt);
            }
        });
        getContentPane().add(txfEndereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 350, 25));

        txfNumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfNumeroActionPerformed(evt);
            }
        });
        getContentPane().add(txfNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 140, 80, 25));

        jLabel7.setText("Número");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 120, -1, -1));

        jLabel8.setText("Bairro");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 175, -1, -1));

        txfBairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfBairroActionPerformed(evt);
            }
        });
        getContentPane().add(txfBairro, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 195, 190, 25));

        txfCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfCidadeActionPerformed(evt);
            }
        });
        getContentPane().add(txfCidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 195, 180, 25));

        jLabel9.setText("Cidade");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 175, -1, -1));

        cbxUf.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
        cbxUf.setSelectedIndex(12);
        cbxUf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxUfActionPerformed(evt);
            }
        });
        getContentPane().add(cbxUf, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 195, 60, 25));

        jLabel10.setText("UF");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 175, -1, -1));

        jLabel11.setText("CEP");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 175, -1, -1));

        txfEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfEmailActionPerformed(evt);
            }
        });
        getContentPane().add(txfEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 580, 25));

        jLabel12.setText("Email");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, -1, -1));

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 288, -1, -1));

        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });
        getContentPane().add(btnLimpar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 288, -1, -1));

        lblFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/resources/icnFoto.png"))); // NOI18N
        lblFoto.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(lblFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, 130, 125));

        btnAdicionar_foto.setText("Adicionar Foto");
        btnAdicionar_foto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionar_fotoActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdicionar_foto, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 138, 130, -1));
        getContentPane().add(txfFone_fixo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 85, 160, 25));

        txfCelular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfCelularActionPerformed(evt);
            }
        });
        getContentPane().add(txfCelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 85, 160, 25));
        getContentPane().add(txfCep, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 195, 120, 25));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txfNome_completoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfNome_completoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfNome_completoActionPerformed

    private void txfEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfEnderecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfEnderecoActionPerformed

    private void txfNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfNumeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfNumeroActionPerformed

    private void txfBairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfBairroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfBairroActionPerformed

    private void txfCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfCidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfCidadeActionPerformed

    private void txfEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfEmailActionPerformed

    private void cbxUfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxUfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxUfActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (!validarDadosDoUsuario() || !validarIdadeDoUsuario()){
            return;
        }
        
        PrincipalFRM.usuarioLocflix.setNomeCompleto(txfNome_completo.getText());
        PrincipalFRM.usuarioLocflix.setDtNascimento(new Date(txfNascimento.getText()));
        PrincipalFRM.usuarioLocflix.setTelefoneFixo(txfFone_fixo.getText());
        PrincipalFRM.usuarioLocflix.setCelular(txfCelular.getText());
        PrincipalFRM.usuarioLocflix.setEndereco(txfEndereco.getText());
        PrincipalFRM.usuarioLocflix.setNumero(txfNumero.getText());
        PrincipalFRM.usuarioLocflix.setBairro(txfBairro.getText());
        PrincipalFRM.usuarioLocflix.setCidade(txfCidade.getText());
        PrincipalFRM.usuarioLocflix.setUf(cbxUf.getSelectedItem().toString());
        PrincipalFRM.usuarioLocflix.setCep(txfCep.getText());
        PrincipalFRM.usuarioLocflix.setEmail(txfEmail.getText());
        PrincipalFRM.usuarioLocflix.setFoto(caminhoFotoUsuario);

        if(txfNome_completo.getText().contains(" ")){
            btnUsuario.setText(txfNome_completo.getText().substring(0, txfNome_completo.getText().indexOf(" ")));
        } else {
            btnUsuario.setText(txfNome_completo.getText());
        }

        if(caminhoFotoUsuario.equals(caminhoFotoPadrao)){
            btnUsuario.setIcon(new ImageIcon((getClass().getResource("resources/icnUsuario.png"))));
        } else {
            ImageIcon fotoUsuarioPrincipal = new ImageIcon(caminhoFotoUsuario);
            Image img = fotoUsuarioPrincipal.getImage();
            Image novaFoto = img.getScaledInstance(btnUsuario.getIcon().getIconWidth(), btnUsuario.getIcon().getIconHeight(), Image.SCALE_DEFAULT);
            ImageIcon fotoReduzida = new ImageIcon(novaFoto);
            btnUsuario.setIcon(fotoReduzida);
        }
        
        JOptionPane.showMessageDialog(this, "Configuração de usuário realizada com sucesso.", "Informação", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnAdicionar_fotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionar_fotoActionPerformed
        if(caminhoFotoUsuario.equals(caminhoFotoPadrao)){
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Selecione sua Foto");
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Imagens e Fotos", "jpg", "jpeg", "png");
            fileChooser.setFileFilter(filter);
            int result = fileChooser.showSaveDialog(null);

            if(result == JFileChooser.APPROVE_OPTION){
                File fotoSelecionada = fileChooser.getSelectedFile();
                String caminho = fotoSelecionada.getAbsolutePath();
                lblFoto.setIcon(organizarFotoNoLabel(caminho));
                caminhoFotoUsuario = caminho;
                btnAdicionar_foto.setText("Remover Foto");
            }
        } else {
            lblFoto.setIcon(new ImageIcon((getClass().getResource(caminhoFotoPadrao))));
            caminhoFotoUsuario = caminhoFotoPadrao;
            btnAdicionar_foto.setText("Adicionar Foto");
        }
          
    }//GEN-LAST:event_btnAdicionar_fotoActionPerformed

    private void txfCelularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfCelularActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfCelularActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        txfNome_completo.setText("");
        
        // Setando a data mínima para o cadastro
        SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
        Date dt = new Date();
        Calendar c = Calendar.getInstance(); 
        c.setTime(dt); 
        c.add(Calendar.DATE, -5844);
        txfNascimento.setText(dateFormat.format(c.getTime()));
        
        txfFone_fixo.setText("");
        txfCelular.setText("");
        txfEndereco.setText("");
        txfNumero.setText("");
        txfBairro.setText("");
        txfCidade.setText("");
        cbxUf.setSelectedItem("MG");
        txfCep.setText("");
        txfEmail.setText("");
        
        lblFoto.setIcon(new ImageIcon((getClass().getResource(caminhoFotoPadrao))));
        caminhoFotoUsuario = caminhoFotoPadrao;
        btnAdicionar_foto.setText("Adicionar Foto");
    }//GEN-LAST:event_btnLimparActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar_foto;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cbxUf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JTextField txfBairro;
    private javax.swing.JFormattedTextField txfCelular;
    private javax.swing.JFormattedTextField txfCep;
    private javax.swing.JTextField txfCidade;
    private javax.swing.JTextField txfEmail;
    private javax.swing.JTextField txfEndereco;
    private javax.swing.JFormattedTextField txfFone_fixo;
    private javax.swing.JFormattedTextField txfNascimento;
    private javax.swing.JTextField txfNome_completo;
    private javax.swing.JTextField txfNumero;
    // End of variables declaration//GEN-END:variables
}
