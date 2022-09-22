package loja;

import java.util.Date;
import java.util.List;

public class LojaView {
	static private int SCREEN_WIDTH = 100;
	
	static private void splitScreen() {
		System.out.println("+" + "=".repeat(SCREEN_WIDTH) + "+");
	}
	
	static private void splitSection() {
		System.out.println("+" + "-".repeat(SCREEN_WIDTH) + "+");
	}
	static private void splitSubsection() {
		System.out.println("+" + " -".repeat(SCREEN_WIDTH / 2) + "+");
	}
	
	public LojaView() {
		
	}
	
	// Lista os produtos da loja
	public void listarProdutos() {
		int contador = 0;
		// cabeçalho
		splitScreen();
		System.out.println("PRODUTOS DA JOJA");
		splitSection();
		// corpo
		if(Deposito.ehVazio()) {
			System.out.println("O deposito está vazio");
		}
		else {
			int qtdProdutos = Deposito.getQuantidadeProdutos();
			for(int i = 0; i < qtdProdutos; i++) {
				if(i > 0)
					splitSubsection();
				
				printProduto(Deposito.getProdutos().get(i));
			}
		}
		splitScreen();
	}
	
	static private void printProduto(Produto produto) {
		System.out.printf("Nome: " + produto.getNome() + " | ");
		System.out.println("Marca: " + produto.getMarca());
		
		System.out.println("Preco: R$ " + produto.getPreco());
		
		System.out.println("Data de Fabricação: " + produto.getDataFabricacao());
	
		printProdutoEpecificidade(produto);
		
		System.out.println("Descricao: " + produto.getDescricao());
	}
	
	static private void printProdutoEpecificidade(Produto produto) {
		if(produto instanceof ProdutoDuravel) {
			printProdutoEpecificidade((ProdutoDuravel) produto);
		}
		else if(produto instanceof ProdutoNaoDuravel) {
			printProdutoEpecificidade((ProdutoNaoDuravel) produto);
		}
	}
	
	static private void printProdutoEpecificidade(ProdutoDuravel produto) {
		System.out.println("Durabilidade: " + produto.getDescricao());
	}
	
	static private void printProdutoEpecificidade(ProdutoNaoDuravel produto) {
		System.out.println("Data de Validade: " + produto.getDataValidade());
		System.out.println("Gênero: " + produto.getGenero());
	}
}