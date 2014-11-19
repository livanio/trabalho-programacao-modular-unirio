/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.unirio.pm.service;

import br.edu.unirio.pm.dao.AbstractArquivosDAO;
import br.edu.unirio.pm.dao.ProdutosDAO;
import br.edu.unirio.pm.model.Produto;
import br.edu.unirio.pm.resource.BDProdutosXml;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Felipe
 */
public class ServicosProduto {
    
    private AbstractArquivosDAO produtosDAO;
    private BDProdutosXml bdProdutosXml;    
    private Map<Integer, Produto> mapaCodigoProduto;

    public ServicosProduto() {
        produtosDAO = new ProdutosDAO();
        bdProdutosXml = new BDProdutosXml();
        mapaCodigoProduto = new HashMap<>();
    }
    
    
    
    public void importarProdutosDoArquivo(String nomeArquivoTxt){
        // TODO
    }
    
    public void importarPrecosDoArquivo(String nomeArquivoTxt){
        // TODO
    }
    
    public void salvarProdutoNoXml(Produto produto){
        // TODO
    }
    
    public void recuperarProdutoNoXml(){
        // TODO
    }
    
    public void atualizarPrecosDosProdutos(){
        // TODO
    }
}
