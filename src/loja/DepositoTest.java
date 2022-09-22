package loja;

import java.util.Calendar;
import java.util.ArrayList;
import java.util.List;

import java.util.Date;

import junit.framework.TestCase;

public class DepositoTest extends TestCase {
	public void testAdicionarProduto() {
		// Pega o valor inical do depósito
		int qtdProdutos = Deposito.getQuantidadeProdutos();
		// inicializando o produto
		String nome = "skate";
		double preco = 150.0;
		String marca = "priscesinha do skate";
		String descricao = "skate para manobras";
		// setando a data de fabricação do produto
		Calendar calendar = Calendar.getInstance();
		calendar.set(2022, 1, 28);
		Date dataFabricacao = calendar.getTime();
		// instanciando produto
		Produto produto = new Produto(nome, preco, marca, descricao, dataFabricacao);
		// adicionando produto no estoque
		Deposito.adicionarProduto(produto);
		// Checando se produto foi adicionado
		assertEquals(Deposito.getQuantidadeProdutos(), qtdProdutos + 1); 		// testamos se temos um produto a mais no desposito
		assertTrue(Deposito.getProdutos().contains(produto));					// checando se produto foi adicionando
	}
	
	public void testRemoverProduto() {
		// inicializando o produto
		String nome = "patenete sport";
		double preco = 120.0;
		String marca = "marmota";
		String descricao = "patinete para manobras";
		// setando a data de fabricação do produto
		Calendar calendar = Calendar.getInstance();
		calendar.set(2022, 3, 28);
		Date dataFabricacao = calendar.getTime();
		// instanciando produto
		Produto produto = new Produto(nome, preco, marca, descricao, dataFabricacao);
		// adicionando produto no estoque
		Deposito.adicionarProduto(produto);
		// Pega o valor inical do depósito
		int qtdProdutos = Deposito.getQuantidadeProdutos();
		// testando se produto é removido
		assertTrue(Deposito.removerProduto(produto));
		assertEquals(Deposito.getProdutos().size(), qtdProdutos - 1);
	}
	
	public void testGetProdutos() {
		assertTrue(Deposito.getProdutos() instanceof ArrayList);
		
		if(Deposito.getProdutos().size() != 0)
			assertTrue(Deposito.getProdutos().get(0) instanceof Produto);
	}
	
	public void testAdicionaProdutosDuraveis() {
		// Pega o valor inical do depósito
		int qtdProdutos = Deposito.getQuantidadeProdutos();
		// inicializando o produto
		String nome = "bicicleta";
		double preco = 670.0;
		String marca = "caloi";
		String descricao = "A bike é ruim, mas é melhor do que gastar com gasolina";
		int durabilidade = 12;
		// setando a data de fabricação do produto
		Calendar calendar = Calendar.getInstance();
		calendar.set(2022, 1, 28);
		Date dataFabricacao = calendar.getTime();
		// instanciando produto
		ProdutoDuravel produtoDuravel = new ProdutoDuravel(nome, preco, marca, descricao, dataFabricacao, durabilidade);
		// adicionando produto no estoque
		Deposito.adicionarProduto(produtoDuravel);
		// Checando se produto foi adicionado
		assertEquals(Deposito.getQuantidadeProdutos(), qtdProdutos + 1); 		// testamos se temos um produto a mais no desposito
		assertTrue(Deposito.getProdutos().contains(produtoDuravel));		    // checando se produto foi adicionando
	}
	
	public void testAdicionaProdutosNaoDuraveis() {
		// Pega o valor inical do depósito
		int qtdProdutos = Deposito.getQuantidadeProdutos();
		// inicializando o produto
		String nome = "bicicleta";
		double preco = 670.0;
		String marca = "caloi";
		String descricao = "A bike é ruim, mas é melhor do que gastar com gasolina";
		String genero = "Alimento";
		// setando a data de fabricação do produto
		Calendar calendar = Calendar.getInstance();
		calendar.set(2022, 1, 28);
		Date dataFabricacao = calendar.getTime();
		// setando a data de validade do produto
		calendar.set(2022, 3, 18);
		Date dataValidade = calendar.getTime();
		// instanciando produto
		ProdutoNaoDuravel produtoNaoDuravel = new ProdutoNaoDuravel(nome, preco, marca, descricao, dataFabricacao, dataValidade, genero);
		// adicionando produto no estoque
		Deposito.adicionarProduto(produtoNaoDuravel);
		// Checando se produto foi adicionado
		assertEquals(Deposito.getQuantidadeProdutos(), qtdProdutos + 1); 		// testamos se temos um produto a mais no desposito
		assertTrue(Deposito.getProdutos().contains(produtoNaoDuravel));		    // checando se produto foi adicionando
	}
}
