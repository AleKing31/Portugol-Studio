package br.univali.ps.ui;

import br.univali.ps.controller.PortugolControladorTelaPrincipal;
import br.univali.ps.ui.acoes.Acao;
import br.univali.ps.ui.acoes.FabricaAcao;
import br.univali.ps.ui.acoes.AcaoCopiar;
import br.univali.ps.ui.acoes.AcaoRecortar;
import br.univali.ps.ui.acoes.AcaoColar;
import br.univali.ps.ui.acoes.AcaoNovoArquivo;
import br.univali.ps.ui.acoes.AcaoAbrirArquivo;
import br.univali.ps.ui.acoes.AcaoRefazer;
import br.univali.ps.ui.acoes.AcaoSalvarComo;
import br.univali.ps.ui.acoes.AcaoSalvarArquivo;
import br.univali.ps.ui.acoes.AcaoDesfazer;
import br.univali.ps.nucleo.PortugolStudio;
import br.univali.ps.ui.ajuda.NavegadorAjuda;
import br.univali.ps.ui.swing.filtro.FiltroArquivoPortugol;
import br.univali.ps.ui.util.IconFactory;
import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class TelaPrincipal extends JFrame {

    
    private JFileChooser dialogoEscolhaArquivo = new JFileChooser();
    private AcaoNovoArquivo acaoNovoArquivo = null;
    private AcaoAbrirArquivo abrirArquivo = null;
    private AcaoSalvarArquivo acaoSalvarArquivo = null;
    private AcaoSalvarComo acaoSalvarComo = null;
    private AcaoCopiar acaoCopiar = null;
    private AcaoRecortar acaoRecortar = null;
    private AcaoColar acaoColar = null;
    private AcaoRefazer acaoRefazer = null;
    private AcaoDesfazer acaoDesfazer = null;
    private PortugolControladorTelaPrincipal controle = null;
 
    
    
    private void acoesprontas() {
        acaoNovoArquivo = (AcaoNovoArquivo) FabricaAcao.getInstancia().criarAcao(AcaoNovoArquivo.class);
        acaoNovoArquivo.configurar(controle);

        abrirArquivo = (AcaoAbrirArquivo) FabricaAcao.getInstancia().criarAcao(AcaoAbrirArquivo.class);
        abrirArquivo.configurar(controle,this, dialogoEscolhaArquivo);
        
        acaoSalvarArquivo = (AcaoSalvarArquivo) FabricaAcao.getInstancia().criarAcao(AcaoSalvarArquivo.class);
        acaoSalvarArquivo.setEnabled(false);

        acaoSalvarComo = (AcaoSalvarComo) FabricaAcao.getInstancia().criarAcao(AcaoSalvarComo.class);
        acaoSalvarComo.setEnabled(false);
        acaoSalvarComo.setup(controle,this, dialogoEscolhaArquivo);

        mniNovo.setAction(acaoNovoArquivo);
        mniSalvar.setAction(acaoSalvarArquivo);
        mniAbrir.setAction(abrirArquivo);
        mniSalvarComo.setAction(acaoSalvarComo);
        
    }

    public void setAcaoSalvar(AcaoSalvarArquivo acaoSalvarArquivo) {
        this.acaoSalvarArquivo = acaoSalvarArquivo;
        mniSalvar.setAction(this.acaoSalvarArquivo);
    }
    
    private void acoesAindaParaFazer() {
        mnuEdit.setEnabled(false);
        mniRecortar.setAction(acaoRecortar);
        mniCopiar.setAction(acaoCopiar);
        mniColar.setAction(acaoColar);
        mniDesfazer.setAction(acaoDesfazer);
        mniRefazer.setAction(acaoRefazer);
        mniFechar.setEnabled(false);
        mniFecharTodos.setEnabled(false);
    }

    public TelaPrincipal(PortugolControladorTelaPrincipal controle)  {
        this.controle = controle;
        try {
        this.setIconImage(ImageIO.read(ClassLoader.getSystemResourceAsStream(IconFactory.CAMINHO_ICONES_PEQUENOS +"/light-bulb-code.png")));
        } catch (IOException ioe) {} 
        initComponents();
        this.setLocationRelativeTo(null);
        configurarSeletorArquivo();
        this.addWindowListener(new TelaPrincipalListener());
        
        dialogoEscolhaArquivo.setCurrentDirectory(new File("./exemplos"));
        
        acoesprontas();

        acoesAindaParaFazer();
        this.painelTabulado.init(abrirArquivo, acaoNovoArquivo);
       
        bottomPane.setLayout(new BorderLayout());
       
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        if (!PortugolStudio.getInstancia().isDepurando())
        {
            //TODO ACHAR UM LUGAR PARA ESSE BOTÃO
    //        btnAlgoritmoTeste.setVisible(false);            
        }
    }
    
    private void configurarSeletorArquivo() {
        dialogoEscolhaArquivo.setMultiSelectionEnabled(true);
        dialogoEscolhaArquivo.addChoosableFileFilter(new FiltroArquivoPortugol());
        dialogoEscolhaArquivo.setAcceptAllFileFilterUsed(false);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bottomPane = new javax.swing.JPanel();
        painelTabulado = new br.univali.ps.ui.PainelTabulado();
        mnuBar = new javax.swing.JMenuBar();
        mnuFile = new javax.swing.JMenu();
        mniNovo = new javax.swing.JMenuItem();
        mniAbrir = new javax.swing.JMenuItem();
        mniSalvar = new javax.swing.JMenuItem();
        mniSalvarComo = new javax.swing.JMenuItem();
        mnuFileSeparator1 = new javax.swing.JPopupMenu.Separator();
        mniFechar = new javax.swing.JMenuItem();
        mniFecharTodos = new javax.swing.JMenuItem();
        mnuFileSeparator2 = new javax.swing.JSeparator();
        mniExit = new javax.swing.JMenuItem();
        mnuEdit = new javax.swing.JMenu();
        mniDesfazer = new javax.swing.JMenuItem();
        mniRefazer = new javax.swing.JMenuItem();
        mnuEditSeparator1 = new javax.swing.JSeparator();
        mniRecortar = new javax.swing.JMenuItem();
        mniCopiar = new javax.swing.JMenuItem();
        mniColar = new javax.swing.JMenuItem();
        mnuEditSeparator2 = new javax.swing.JPopupMenu.Separator();
        mniFindReplace = new javax.swing.JMenuItem();
        mnuHelp = new javax.swing.JMenu();
        mniAbout = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Portugol Studio");
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        javax.swing.GroupLayout bottomPaneLayout = new javax.swing.GroupLayout(bottomPane);
        bottomPane.setLayout(bottomPaneLayout);
        bottomPaneLayout.setHorizontalGroup(
            bottomPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 632, Short.MAX_VALUE)
        );
        bottomPaneLayout.setVerticalGroup(
            bottomPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 28, Short.MAX_VALUE)
        );

        mnuFile.setText("Arquivo");
        mnuFile.add(mniNovo);
        mnuFile.add(mniAbrir);
        mnuFile.add(mniSalvar);
        mnuFile.add(mniSalvarComo);
        mnuFile.add(mnuFileSeparator1);

        mniFechar.setText("Fechar");
        mniFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniFecharActionPerformed(evt);
            }
        });
        mnuFile.add(mniFechar);

        mniFecharTodos.setText("Fechar todos.");
        mniFecharTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniFecharTodosActionPerformed(evt);
            }
        });
        mnuFile.add(mniFecharTodos);
        mnuFile.add(mnuFileSeparator2);

        mniExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        mniExit.setText("Sair");
        mniExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniExitActionPerformed(evt);
            }
        });
        mnuFile.add(mniExit);

        mnuBar.add(mnuFile);

        mnuEdit.setText("Editar");

        mniDesfazer.setText("desfazer");
        mnuEdit.add(mniDesfazer);

        mniRefazer.setText("refazer");
        mnuEdit.add(mniRefazer);
        mnuEdit.add(mnuEditSeparator1);

        mniRecortar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        mniRecortar.setText("Recortar");
        mnuEdit.add(mniRecortar);

        mniCopiar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        mniCopiar.setText("Copiar");
        mnuEdit.add(mniCopiar);

        mniColar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        mniColar.setText("Colar");
        mnuEdit.add(mniColar);
        mnuEdit.add(mnuEditSeparator2);

        mniFindReplace.setText("Procurar e substituir");
        mnuEdit.add(mniFindReplace);

        mnuBar.add(mnuEdit);

        mnuHelp.setText("Ajuda");

        mniAbout.setText("Sobre");
        mnuHelp.add(mniAbout);

        jMenuItem1.setText("Tópicos de Ajuda");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        mnuHelp.add(jMenuItem1);

        mnuBar.add(mnuHelp);

        setJMenuBar(mnuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bottomPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(painelTabulado, javax.swing.GroupLayout.DEFAULT_SIZE, 619, Short.MAX_VALUE)
                .addGap(13, 13, 13))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(painelTabulado, javax.swing.GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bottomPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
    new AbaAjuda(painelTabulado);
}//GEN-LAST:event_jMenuItem1ActionPerformed

private void mniExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniExitActionPerformed
    controle.fecharAplicativo();
}//GEN-LAST:event_mniExitActionPerformed

private void mniFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniFecharActionPerformed
    controle.fecharAbaAtual();
}//GEN-LAST:event_mniFecharActionPerformed

private void mniFecharTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniFecharTodosActionPerformed
    controle.fecharTodasAbas();
}//GEN-LAST:event_mniFecharTodosActionPerformed
    //Converter em action.    // <editor-fold defaultstate="collapsed" desc="IDE Declaration Code">
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bottomPane;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem mniAbout;
    private javax.swing.JMenuItem mniAbrir;
    private javax.swing.JMenuItem mniColar;
    private javax.swing.JMenuItem mniCopiar;
    private javax.swing.JMenuItem mniDesfazer;
    private javax.swing.JMenuItem mniExit;
    private javax.swing.JMenuItem mniFechar;
    private javax.swing.JMenuItem mniFecharTodos;
    private javax.swing.JMenuItem mniFindReplace;
    private javax.swing.JMenuItem mniNovo;
    private javax.swing.JMenuItem mniRecortar;
    private javax.swing.JMenuItem mniRefazer;
    private javax.swing.JMenuItem mniSalvar;
    private javax.swing.JMenuItem mniSalvarComo;
    private javax.swing.JMenuBar mnuBar;
    private javax.swing.JMenu mnuEdit;
    private javax.swing.JSeparator mnuEditSeparator1;
    private javax.swing.JPopupMenu.Separator mnuEditSeparator2;
    private javax.swing.JMenu mnuFile;
    private javax.swing.JPopupMenu.Separator mnuFileSeparator1;
    private javax.swing.JSeparator mnuFileSeparator2;
    private javax.swing.JMenu mnuHelp;
    private br.univali.ps.ui.PainelTabulado painelTabulado;
    // End of variables declaration//GEN-END:variables

    public void habilitaSalvar(boolean b) {
        acaoSalvarArquivo.setEnabled(b);
    }

    public void dialogoSalvar() {
        acaoSalvarComo.actionPerformed(null);
    }

    public Acao getAcaoColar(){
        return acaoColar;
    }

    public void configurarBotoesEditar(AcaoDesfazer desfazer, AcaoRefazer refazer, AcaoCopiar copiar, AcaoColar colar, AcaoRecortar recortar) {
        acaoDesfazer = desfazer;
        acaoRefazer = refazer;
        acaoCopiar = copiar;
        acaoColar = colar;
        acaoRecortar = recortar;
    }

    public void habilitaSalvarComo(boolean b) {
        acaoSalvarComo.setEnabled(b);
    }

    public void desabilitarBotoesEditar() {
        acaoDesfazer.setEnabled(false);
        acaoRefazer.setEnabled(false);
        acaoCopiar.setEnabled(false);
        acaoColar.setEnabled(false);
        acaoRecortar.setEnabled(false);
    }

    public JTabbedPane getPainelTabulado() {
        return painelTabulado;
    }

    private class TelaPrincipalListener extends WindowAdapter {

        @Override
        public void windowClosing(WindowEvent we) {
            controle.fecharAplicativo();
        }
        
    }
}