/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.unirio.pm.display;

import br.edu.unirio.pm.model.Vendedor;
import br.edu.unirio.pm.service.MesEscolhido;
import br.edu.unirio.pm.service.ServicosComissoes;
import br.edu.unirio.pm.service.ServicosVendas;
import br.edu.unirio.pm.service.ServicosVendedores;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Felipe
 */
public class TelaMediasVendasComissoes extends javax.swing.JInternalFrame {
    
    private ServicosVendas servicosVendas;
    private ServicosComissoes servicosComissoes;
    private ServicosVendedores servicosVendedores;
    private DefaultTableModel modeloTabela;
    private double totalVendaAcumuladaMedia;
    private double totalComissaoAcumuladaMedia;

    /**
     * Creates new form TelaMediasVendasComissoes
     */
    public TelaMediasVendasComissoes() {
        servicosVendas = new ServicosVendas();
        servicosComissoes = new ServicosComissoes();
        servicosVendedores = new ServicosVendedores();
        initComponents();
        preencherMeses();
        preencherAnos();
        iniciarTabela();
    }
    
    private void preencherMeses(){
        for (int mes = 1; mes<=12; mes++){
            selecioneMesInicial.addItem(mes);
            selecioneMesFinal.addItem(mes);
        }   
    }
    
    private void preencherAnos(){
        try {
            List<Integer> listaAnosDisponiveisParaConsulta = servicosVendas.obterAnosDisponiveisParaConsulta();
            for (int ano : listaAnosDisponiveisParaConsulta){
                selecioneAnoInicial.addItem(ano);
                selecioneAnoFinal.addItem(ano);
            }                
        } catch (SQLException ex) {
            exibirMensagemDialogo("Ocorreu o seguinte erro: " + ex.getMessage());
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

        jLabel1 = new javax.swing.JLabel();
        selecioneAnoInicial = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        selecioneMesInicial = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        selecioneAnoFinal = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        selecioneMesFinal = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaMediasVendasComissoes = new javax.swing.JTable();
        botaoOk = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Médias de Vendas e Comissões por Vendedor");
        setMinimumSize(new java.awt.Dimension(700, 500));
        setPreferredSize(new java.awt.Dimension(700, 500));

        jLabel1.setText("Ano Inicial");

        jLabel2.setText("Mês Inicial");

        jLabel3.setText("Ano Final");

        jLabel4.setText("Mês Final");

        tabelaMediasVendasComissoes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nome do Vendedor", "Total de Vendas", "Total de Comissões"
            }
        ));
        jScrollPane1.setViewportView(tabelaMediasVendasComissoes);

        botaoOk.setText("OK");
        botaoOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoOkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 664, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(selecioneAnoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(selecioneMesInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(selecioneAnoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(selecioneMesFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botaoOk)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(selecioneAnoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(selecioneMesInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(selecioneAnoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(selecioneMesFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(botaoOk)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoOkActionPerformed
        MesEscolhido mesInicialEscolhido = verificarMesInicialEscolhido();
        MesEscolhido mesFinalEscolhido = verificarMesFinalEscolhido();
        iniciarTabela();
        try {
            List<Vendedor> listaVendedores = servicosVendedores.obterListaVendedores();
            for (Vendedor vendedor : listaVendedores){
                inserirDadosDoVendedorNaTabela(mesInicialEscolhido, mesFinalEscolhido, vendedor);
            }
        } catch (SQLException ex) {
            exibirMensagemDialogo(ex.getMessage());
        }
        servicosComissoes = new ServicosComissoes();
    }//GEN-LAST:event_botaoOkActionPerformed

    private void iniciarTabela(){
        String[][] dadosTabela = {};
        String[] cabecalhoTabela = {"Nome do Vendedor", "Média de Vendas", "Média de Comissões"};
        modeloTabela = new DefaultTableModel(dadosTabela, cabecalhoTabela);
        tabelaMediasVendasComissoes.setModel(modeloTabela);
    }
    
    private void inserirDadosDoVendedorNaTabela(MesEscolhido mesInicialEscolhido, MesEscolhido mesFinalEscolhido, Vendedor vendedor) throws SQLException{
        System.out.println("mes inicial inserir dados tabela " + mesInicialEscolhido.getAno() + " " + mesInicialEscolhido.getMes());
        System.out.println("mes final inserir dados tabela " + mesFinalEscolhido.getAno() + " " + mesFinalEscolhido.getMes());
        String nomeVendedor = vendedor.getNome();
        totalVendaAcumuladaMedia = servicosComissoes.obterVendaAcumuladaMediaPorVendedor(mesInicialEscolhido, mesFinalEscolhido, vendedor);
        totalComissaoAcumuladaMedia = servicosComissoes.obterComissaoAcumuladaMediaPorVendedor(mesInicialEscolhido, mesFinalEscolhido, vendedor);
        Object dados[] = {nomeVendedor, NumberFormat.getCurrencyInstance().format(totalVendaAcumuladaMedia), NumberFormat.getCurrencyInstance().format(totalComissaoAcumuladaMedia)};
        modeloTabela.addRow(dados);
    }
    
    private MesEscolhido verificarMesInicialEscolhido(){
        int anoInicial = (int)selecioneAnoInicial.getSelectedItem();
        int mesInicial = (int)selecioneMesInicial.getSelectedItem();
        MesEscolhido mesInicialEscolhido = new MesEscolhido(anoInicial, mesInicial);
        return mesInicialEscolhido;
    }
    
     private MesEscolhido verificarMesFinalEscolhido(){
        int anoFinal = (int)selecioneAnoFinal.getSelectedItem();
        int mesFinal = (int)selecioneMesFinal.getSelectedItem();
        MesEscolhido mesFinalEscolhido = new MesEscolhido(anoFinal, mesFinal);
        return mesFinalEscolhido;
    }
    
    private void exibirMensagemDialogo(String textoMensagem){
        JOptionPane.showMessageDialog(null, textoMensagem);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoOk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox selecioneAnoFinal;
    private javax.swing.JComboBox selecioneAnoInicial;
    private javax.swing.JComboBox selecioneMesFinal;
    private javax.swing.JComboBox selecioneMesInicial;
    private javax.swing.JTable tabelaMediasVendasComissoes;
    // End of variables declaration//GEN-END:variables
}
