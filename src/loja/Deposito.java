package loja;

import java.util.ArrayList;
import java.util.List;

public class Deposito {
	static private List<Produto> produtos;
	
	static{
		produtos = new ArrayList<Produto>();
	}
	
	static public List<Produto> getProdutos() {
		return produtos;
	}

	static public void adicionarProduto(Produto produto) {
		produtos.add(produto);
	}
	
	static public boolean removerProduto(Produto produto) {
		return produtos.remove(produto);
	}
	
	static public int getQuantidadeProdutos() {
		return produtos.size();
	}
	
	static public boolean depositoVazio() {
		return produtos.isEmpty();
	}
	
	static public Produto produtoMaiorPreco() {
		if(produtos.isEmpty())
			return null;
		
		Produto produtoMaiorPreco = produtos.get(0);
		
		for(Produto produto : produtos) {
			if(produto.getPreco() < produtoMaiorPreco.getPreco()) {
				produtoMaiorPreco = produto;
			}
		}
		
		return produtoMaiorPreco;
	}
}
