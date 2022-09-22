package loja;

import java.util.Calendar;
import java.util.Date;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LojaView loja = new LojaView();
		
		String nome = "leite";
		double preco = 9.0;
		String marca = "vale dourado";
		String descricao = "leite em caixa 1l";
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
		Deposito.adicionarProduto(produtoNaoDuravel);
		
		loja.listarProdutos();
	}
}
