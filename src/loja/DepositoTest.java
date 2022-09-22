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
}
