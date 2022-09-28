package loja;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Deposito {
	static private List<Produto> produtos;
	
	static{
		produtos = new ArrayList<Produto>();
		Calendar calendar = Calendar.getInstance();
		Calendar calendar2 = Calendar.getInstance();
		
		// criando produtos duráveis
		calendar.set(2014, 11, 15, 0, 0, 0);
		ProdutoDuravel carro = new ProdutoDuravel("Clio", 20000, "Renault", "Mais rápido que muita ferrari", calendar.getTime(), 50);
		
		calendar.set(2020, 0, 3, 0, 0, 0);
		ProdutoDuravel livro = new ProdutoDuravel("SCRUM", 120, "Lua de Papel", "faça o dobro na metade do tempo", calendar.getTime(), 10);
		
		calendar.set(2019, 3, 7, 0, 0, 0);
		ProdutoDuravel celular = new ProdutoDuravel("POCO", 1800, "Xiaomi", "iphone com sistema android", calendar.getTime(), 15);
		
		// criando produtos não durável (ex. chocolate, toalha e sabonete)
		calendar.set(2022, 10, 15, 0, 0, 0);
		calendar2.set(2022, 11, 15, 0, 0, 0);
		ProdutoNaoDuravel chocolate = new ProdutoNaoDuravel("Nuit", 3.5, "cacau show", "chocolate", calendar.getTime(),
															calendar2.getTime(), "alimento");
		
		calendar.set(2022, 6, 1, 0, 0, 0);
		calendar2.set(2022, 6, 18, 0, 0, 0);
		ProdutoNaoDuravel leite = new ProdutoNaoDuravel("Leite", 9, "vale dourado", "1l de leite", calendar.getTime(),
															calendar2.getTime(), "alimento");
		
		calendar.set(2022, 4, 3, 0, 0, 0);
		calendar2.set(2022, 4, 10, 0, 0, 0);
		ProdutoNaoDuravel bisteca = new ProdutoNaoDuravel("Bisteca 1kg", 13.9, "Ponto Frio", "1kg de bisteca", calendar.getTime(),
															calendar2.getTime(), "alimento");
		
		// Adicionando produtos duráveis
		produtos.add(carro);
		produtos.add(livro);
		produtos.add(celular);
		produtos.add(chocolate);
		produtos.add(leite);
		produtos.add(bisteca);
	}
	
	static public List<Produto> getProdutos() {
		return produtos;
	}

	static public boolean adicionarProduto(Produto produto) {
		return produtos.add(produto);
	}
	
	static public boolean removerProduto(Produto produto) {
		return produtos.remove(produto);
	}
	
	static public int getQuantidadeProdutos() {
		return produtos.size();
	}
	
	static public boolean ehVazio() {
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
