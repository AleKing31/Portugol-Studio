package br.univali.ps.ui;

import br.univali.ps.nucleo.ExcecaoAplicacao;
import br.univali.ps.nucleo.PortugolStudio;
import br.univali.ps.ui.util.IconFactory;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.*;

public final class TelaPrincipalDesktop extends JFrame implements TelaPrincipal
{
    
    private Action acaoSelecionarAbaDireita;
    private Action acaoSelecionarAbaEsquerda;
    private Action acaoFecharAbaAtual;
    private Action acaoFecharTodasAbas;
    private Action acaoExibirAjuda;
    private Action acaoExibirTelaSobre;
    private Action acaoExibirDocumentacaoBiblioteca;
    
    private AbaAjuda abaAjuda;
    private AbaDocumentacaoBiblioteca abaDocumentacao;
    private List<File> arquivosIniciais;
    private boolean primeiraVez = true;
    
    public TelaPrincipalDesktop()
    {
        initComponents();        
        configurarJanela();        
        configurarAcoes();
        instalarObservadores();
    }
    
    private void configurarJanela()
    {
        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        try
        {
            this.setIconImage(ImageIO.read(ClassLoader.getSystemResourceAsStream(IconFactory.CAMINHO_ICONES_PEQUENOS + "/light-bulb-code.png")));
        }
        catch (IOException ioe)
        {
        }        
    }
    
    private void configurarAcoes()
    {
        configurarAcaoSelecionarAbaEsquerda();
        configurarAcaoSelecionarAbaDireita();
        
        configurarAcaoFecharAbaAtual();
        configurarAcaoFecharTodasAbas();
        
        configurarAcaoExibirAjuda();
        configurarAcaoExibirDocumentacaoBiblioteca();
        configurarAcaoExibirTelaSobre();
    }
    
    private void configurarAcaoSelecionarAbaEsquerda()
    {
        KeyStroke atalho = KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, InputEvent.ALT_DOWN_MASK);
        String nome = "Selecionar aba à esquerda";
                
        acaoSelecionarAbaEsquerda = new AbstractAction(nome)
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                painelTabulado.selecionarAbaAnterior();
            }
        };
        
        getRootPane().getActionMap().put(nome, acaoSelecionarAbaEsquerda);
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(atalho, nome);
    }
    
    private void configurarAcaoSelecionarAbaDireita()
    {
        KeyStroke atalho = KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, InputEvent.ALT_DOWN_MASK);
        String nome = "Selecionar aba á direita";
        
        acaoSelecionarAbaDireita = new AbstractAction(nome)
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                painelTabulado.selecionarProximaAba();
            }
        };
        
        getRootPane().getActionMap().put(nome, acaoSelecionarAbaDireita);
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(atalho, nome);
    }
    
    private void configurarAcaoFecharAbaAtual()
    {
        KeyStroke atalho = KeyStroke.getKeyStroke("control Q");
        String nome = "Fechar aba atual";
        
        acaoFecharAbaAtual = new AbstractAction(nome)
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Aba aba = painelTabulado.getAbaSelecionada();
                
                if (aba != null && aba.getClass() != AbaInicial.class)
                {
                    aba.fechar();
                }
            }
        };
        
        painelTabulado.getActionMap().put(nome, acaoFecharAbaAtual);
        painelTabulado.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(atalho, nome);
    }
    
    private void  configurarAcaoFecharTodasAbas()
    {
       KeyStroke atalho = KeyStroke.getKeyStroke("shift control Q");
       String nome = "Fechar todas as abas";
        
        acaoFecharTodasAbas = new AbstractAction(nome)
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                for (Class<? extends Aba> classeAba : Aba.classesFilhas())
                {
                    if (classeAba != AbaInicial.class)
                    {
                        painelTabulado.fecharTodasAbas(classeAba);
                    }
                }
            }
        };
        
        painelTabulado.getActionMap().put(nome, acaoFecharTodasAbas);
        painelTabulado.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(atalho, nome);
    }
    
    private void  configurarAcaoExibirDocumentacaoBiblioteca()
    {
       KeyStroke atalho = KeyStroke.getKeyStroke("shift F1");
        
        acaoExibirDocumentacaoBiblioteca = new AbstractAction(ACAO_EXIBIR_DOCUMENTACAO_BIBLIOTECA)
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                exibirAbaDocumentacao();
            }
        };
        
        painelTabulado.getActionMap().put(ACAO_EXIBIR_DOCUMENTACAO_BIBLIOTECA, acaoExibirDocumentacaoBiblioteca);
        painelTabulado.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(atalho, ACAO_EXIBIR_DOCUMENTACAO_BIBLIOTECA);
    } 

    private void  configurarAcaoExibirAjuda()
    {
       KeyStroke atalho = KeyStroke.getKeyStroke("F1");
        
        acaoExibirAjuda = new AbstractAction(ACAO_EXIBIR_AJUDA)
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                exibirAbaAjuda();
            }
        };
        
        painelTabulado.getActionMap().put(ACAO_EXIBIR_AJUDA, acaoExibirAjuda);
        painelTabulado.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(atalho, ACAO_EXIBIR_AJUDA);
    }
    
    private void  configurarAcaoExibirTelaSobre()
    {
       KeyStroke atalho = KeyStroke.getKeyStroke("F12");
       String nome = "Exibir tela sobre";
        
        acaoExibirTelaSobre = new AbstractAction(nome)
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                PortugolStudio.getInstancia().getTelaSobre().setVisible(true);
            }
        };
        
        painelTabulado.getActionMap().put(nome, acaoExibirTelaSobre);
        painelTabulado.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(atalho, nome);
    }
    
    private void instalarObservadores()
    {
        instalarObservadorExcecoesNaoTratadas();
        instalarObservadorJanela();
    }
    
    private void instalarObservadorExcecoesNaoTratadas()
    {
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler()
        {
            @Override
            public void uncaughtException(Thread thread, Throwable excecao)
            {
                if ((excecao instanceof ClassNotFoundException) || (excecao instanceof NoClassDefFoundError))
                {
                    String mensagem = "Uma das bibliotecas ou classes necessárias para o funcionamento do Portugol Studio não foi encontrada.\nO Portugol Studio será enecerrado.";
                    PortugolStudio.getInstancia().getTratadorExcecoes().exibirExcecao(new ExcecaoAplicacao(mensagem, excecao, ExcecaoAplicacao.Tipo.ERRO));
                    System.exit(1);
                }
                else if (excecao instanceof IllegalArgumentException)
                {
                    excecao.printStackTrace(System.err);
                }
                else
                {
                    StringWriter sw = new StringWriter();
                    PrintWriter pw = new PrintWriter(sw);
                
                    excecao.printStackTrace(pw);
                    excecao.printStackTrace(System.err);

                    if (sw.toString().contains("rsyntax"))
                    {
                        // Erro do RSyntaxTextArea, printa no console e ignora
                        System.out.println("Erro do RSyntaxTextArea");
                    }
                    else
                    {
                        PortugolStudio.getInstancia().getTratadorExcecoes().exibirExcecao(new ExcecaoAplicacao(excecao, ExcecaoAplicacao.Tipo.ERRO));
                    }
                }
            }
        });
    }
    
    private void instalarObservadorJanela()
    {
        addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                fecharAplicativo();
            }            
        });
        
        addComponentListener(new ComponentAdapter()
        {
            @Override
            public void componentShown(ComponentEvent e)
            {
                if (primeiraVez)
                {
                    primeiraVez = false;
                    
                    PortugolStudio.getInstancia().abrirArquivosCodigoFonte(arquivosIniciais);
                }
            }
        });
    }
    
    private void fecharAplicativo()
    {
        painelTabulado.fecharTodasAbas(AbaCodigoFonte.class);

        if (!painelTabulado.temAbaAberta(AbaCodigoFonte.class))
        {
            try
            {
                PortugolStudio.getInstancia().getConfiguracoes().salvar();
            }
            catch (ExcecaoAplicacao excecaoAplicacao)
            {
                PortugolStudio.getInstancia().getTratadorExcecoes().exibirExcecao(excecaoAplicacao);
            }
            
            System.exit(0);
        }
    }    

    @Override
    public PainelTabuladoPrincipal getPainelTabulado()
    {
        return painelTabulado;
    }
    
    private void exibirAbaAjuda()
    {
        if (abaAjuda == null)
        {
            abaAjuda = new AbaAjuda();
            abaAjuda.adicionar(painelTabulado);
        }
        else if (!painelTabulado.temAbaAberta(AbaAjuda.class))
        {
            abaAjuda.adicionar(painelTabulado);
        }
        
        abaAjuda.selecionar();
    }
    
    private void exibirAbaDocumentacao()
    {
        if (abaDocumentacao == null)
        {
            abaDocumentacao = new AbaDocumentacaoBiblioteca();
            abaDocumentacao.adicionar(painelTabulado);
        }
        else if (!painelTabulado.temAbaAberta(AbaDocumentacaoBiblioteca.class))
        {
            abaDocumentacao.adicionar(painelTabulado);
        }
        
        abaDocumentacao.selecionar();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        painelTabulado = new br.univali.ps.ui.PainelTabuladoPrincipal();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Portugol Studio");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setMinimumSize(new java.awt.Dimension(700, 520));

        painelTabulado.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 4, 4, 4));
        getContentPane().add(painelTabulado, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private br.univali.ps.ui.PainelTabuladoPrincipal painelTabulado;
    // End of variables declaration//GEN-END:variables

    @Override
    public void setArquivosIniciais(List<File> arquivos)
    {
        this.arquivosIniciais = arquivos;
    }
}