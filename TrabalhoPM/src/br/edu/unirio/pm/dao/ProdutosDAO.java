/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.unirio.pm.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.unirio.pm.model.Produto;
import br.edu.unirio.pm.resource.FabricaConexao;
import br.edu.unirio.pm.util.Parser;
import br.edu.unirio.pm.util.ParserProduto;
import org.joda.time.LocalDate;

/**
 *
 * @author MCE
 * @alter  Rogerio
 */
public class ProdutosDAO extends AbstractArquivosDAO<Produto> {
    //Agora referenciado na Classe FabricadeConexoes
    //private Connection conexao;
    //private PreparedStatement comando;
    private ResultSet resultado;
    private final String INSERT = "insert into produto (codigo, nome)"
                + "values (?, ?)";
    private final String SELECT = "select * from produto where codigo = ?";
    private final String UPDATE_NOME = "update produto set nome = ? where codigo = ?";
    private final String UPDATE_PRECO_VIGENCIA = "update produto set preco=?, "
            + "data_inicio_vigencia=? where codigo = ?";
    PreparedStatement comando;

    @Override
    public Parser<Produto> getParser() {
        return new ParserProduto();
    }

	public boolean inserirProduto(Produto produto) throws SQLException {
		comando = null;
		try {
			if (produtoEstaNoBanco(produto.getCodigo())) {
				atualizarNomeProduto(produto);
				return false;
			} else {
				FabricaConexao.iniciarConexao();
				comando = FabricaConexao.criarComando(INSERT);
				comando.setLong(1, produto.getCodigo());
				comando.setString(2, produto.getNome());
				comando.execute();
				return true;
			}
		} finally {
			FabricaConexao.fecharComando(comando);
			FabricaConexao.fecharConexao();
		}
	}
    
    public void atualizarNomeProduto(Produto produto) throws SQLException{
		comando = null;
		
		try {
		FabricaConexao.iniciarConexao();
		comando = FabricaConexao.criarComando (UPDATE_NOME);
        comando.setString(1, produto.getNome());
        comando.setLong(2, produto.getCodigo());
        comando.execute();
		}

		finally {
			FabricaConexao.fecharComando(comando);
			FabricaConexao.fecharConexao();
		}

	}
    
	public boolean inserirDadosDePrecoNoProduto(Produto produto)throws SQLException {
		comando = null;
		try {
			if (!produtoEstaNoBanco(produto.getCodigo())) {
                 System.out.println("Produto nao esta no banco");
				return false;
			} else {
				FabricaConexao.iniciarConexao();
				comando = FabricaConexao.criarComando(UPDATE_PRECO_VIGENCIA);
				comando.setDouble(1, produto.getPreco());
				comando.setDate(2, Date.valueOf(produto.getInicioVigenciaPreco().toString()));
				comando.setLong(3, produto.getCodigo());
				comando.executeUpdate();
				return true;
			}
		} finally {
			FabricaConexao.fecharComando(comando);
			FabricaConexao.fecharConexao();
		}
	}

    public boolean produtoEstaNoBanco(long codigoProduto) throws SQLException {
		comando = null;

        try{
		FabricaConexao.iniciarConexao();
            comando = FabricaConexao.criarComando(SELECT);
            comando.setLong(1, codigoProduto);
            resultado = comando.executeQuery();
            while (resultado.next()){            
                return true;
            }
            return false;
         }

	finally {
		FabricaConexao.fecharComando(comando);
		FabricaConexao.fecharConexao();
	}

}
    
    public Produto buscarProdutoNoBanco(long codigoProduto) throws SQLException{
        FabricaConexao.iniciarConexao();
        comando = FabricaConexao.criarComando(SELECT);
        comando.setLong(1, codigoProduto);
        resultado = comando.executeQuery();
        while (resultado.next()){
            if(resultado.getLong("codigo") == codigoProduto){
                Produto produto = new Produto();
                produto.setCodigo(resultado.getLong("codigo"));
                produto.setNome(resultado.getString("nome"));
                produto.setPreco(resultado.getDouble("preco"));
                produto.setInicioVigenciaPreco(new LocalDate(resultado.getDate("data_inicio_vigencia")));
                return produto;
            }
        }
        return null;
        
    }
    
    public boolean produtoTemPrecoCadastrado(long codigoProduto){
        //TODO
        return false;
    }
   
}
