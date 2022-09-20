package loja;

import java.util.ArrayList;
import java.util.List;

public class Deposito {
	static private List<Produto> produtos;
	{
		produtos = new ArrayList<Produto>();
	}

	static public void adicionarProduto(Produto produto) {
		produtos.add(produto);
	}
	
	static public Produto removerProduto(Produto produto) {
		return null;
	}
	
	static public int getQuantidadeProdutos() {
		return produtos.size();
	}
	
	static public boolean depositoVazio() {
		return true;
	}
	
	static public Produto produtoMaiorPreco() {
		return null;
	}
}
