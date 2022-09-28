package loja;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

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
		// Construtor vazio
	}
	
	public void home(Scanner in) {
		int opcao;
		
		do {
			opcao = 0;
			
			listarProdutos();
			do {
				if(opcao < 0 || opcao > 2) {
					splitSubsection();
					System.out.println("Opção inválida, tente novamente");
				}
				splitSubsection();
				System.out.println("Opções: [0]Encerrar [1]Adicionar Produto [2]Remover Produto");
				
				opcao = Integer.parseInt(in.nextLine());
			} while(opcao < 0 || opcao > 2);
						
			if(opcao == 1)
				adicionarProduto(in);
			else if(opcao == 2)
				removerProduto(in);
		} while(opcao != 0);
		// Encerramento
		splitScreen();
		System.out.println("Encerrando Sistema");
	}
	
	public void adicionarProduto(Scanner in) {
		int opcao = 0;
		// inicializando parametros para criação do produto
		Produto produto;
		String nome;
		Double preco;
		String marca;
		String descricao;
		Date dataFabricacao;
				
		splitScreen();
		System.out.println("ADICIONAR UM PRODUTO");
		splitSection();
		System.out.println("O produto que deseja adicionar é durável ou não durável?");
		
		do {
			if(opcao < 0 || opcao > 1)
				System.out.println("Opção inválida, tente novamente");
			
			System.out.println("Opções: [0] Durável | [1] Não durável");
			
			opcao = Integer.parseInt(in.nextLine());
		} while(opcao < 0 || opcao > 1);
		
		splitSection();
		System.out.println("Insira os dados do produto");
		splitSubsection();
		
		System.out.print("Nome: ");
		nome = in.nextLine();
		
		System.out.print("Marca: ");
		marca = in.nextLine();
		
		System.out.print("Preço do protudo(ex.: 15,4): ");
		preco = Double.parseDouble(in.nextLine());
		
		System.out.print("Descrição do produto: ");
		descricao = in.nextLine();
		
		// coletando dados de fabricação
		System.out.println("Data de fabricação do produto");
		dataFabricacao = getDataIO(in);
		
		if(opcao == 0) {
			// coletando dados para produto durável
			int durabilidade;
			
			System.out.printf("Durabiidade do produto: ");
			durabilidade = Integer.parseInt(in.nextLine());

			produto = new ProdutoDuravel(nome, preco, marca, descricao, dataFabricacao, durabilidade);
		}
		else {
			// coletando dados para produto não durável
			Date dataValidade;
			String genero;
			
			System.out.println("Data de validade do produto");
			dataValidade = getDataIO(in);
			
			System.out.printf("Gênero do produto: ");
			genero = in.nextLine();
			
			
			produto = new ProdutoNaoDuravel(nome, preco, marca, descricao, dataFabricacao, dataValidade, genero);
		}
		
		splitSubsection();
		if(Deposito.adicionarProduto(produto))
			System.out.println("Produto adicionado com sucesso!");
		else
			System.out.println("Produto não pode ser adicionado");
		
		splitScreen();
	}
	
	public void removerProduto(Scanner in) {
		int opcao;
		
		do {
			// setando valor inicial para a opcao do usuário
			opcao = 0;
			// CABEÇALHO
			splitScreen();
			System.out.println("REMOVER PRODUTO");
			splitSection();
			// CORPO
			// avisando que não temos produtos para remover
			if(Deposito.ehVazio()) {
				System.out.println("Depósito está vazio, não temos produtos para remover");
			}
			else {
				// lista os produtos para seleção
				for(int i = 0; i < Deposito.getQuantidadeProdutos(); i++) {
					if(i > 0)
						splitSubsection();
					
					System.out.println("[" + i + 1 + "] " + Deposito.getProdutos().get(i).toString());
				}
				// pegando uma opção de ação válida do usuário
				do {
					splitSection();
					if(opcao < 0 || opcao > Deposito.getQuantidadeProdutos()) {
						System.out.println("Opção inválida, tente outra");
						splitSubsection();
					}
					System.out.println("Opções: [0]Voltar [{index produto}]Remover Produto");
					opcao = Integer.parseInt(in.nextLine());
				} while(opcao < 0 || opcao > Deposito.getQuantidadeProdutos());
				// removendo produto selecionado
				if(opcao != 0) {
					Deposito.removerProduto(Deposito.getProdutos().get(opcao - 1));
				}
			}
		} while(opcao != 0);
	}
	
	// Lista os produtos da loja
	public void listarProdutos() {
		// cabeçalho
		splitScreen();
		System.out.println("PRODUTOS DA LOJA");
		splitSection();
		// corpo
		if(Deposito.ehVazio()) {
			System.out.println("O deposito está vazio");
		}
		else {
			int qtdProdutos = Deposito.getQuantidadeProdutos();
			for(int i = 0; i < qtdProdutos; i++) {
				if(i > 0) splitSubsection();
				
				printProduto(Deposito.getProdutos().get(i));
			}
		}
	}
	
	static private void printProduto(Produto produto) {
		System.out.printf("Nome: " + produto.getNome() + " | ");
		System.out.println("Marca: " + produto.getMarca());
		
		System.out.println("Preco: R$ " + produto.getPreco());
		
		System.out.println("Data de Fabricação: " + formatarData(produto.getDataFabricacao()));
	
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
		System.out.println("Durabilidade: " + produto.getDurabilidade());
	}
	
	static private void printProdutoEpecificidade(ProdutoNaoDuravel produto) {
		System.out.println("Data de Validade: " + formatarData(produto.getDataValidade()));
		System.out.println("Gênero: " + produto.getGenero());
	}
	
	static private Date getDataIO(Scanner in) {
		Calendar calendar = Calendar.getInstance();
		int dia;
		int mes;
		int ano;
		
		System.out.print("Dia: ");
		dia = Integer.parseInt(in.nextLine());
		
		System.out.print("Mẽs: ");
		mes = Integer.parseInt(in.nextLine());
		
		System.out.print("Ano: ");
		ano = Integer.parseInt(in.nextLine());
		
		calendar.set(ano, mes - 1, dia, 0, 0, 0);
		Date date = calendar.getTime();
		
		return date;
	}
	
	static private String formatarData(Date date) {
		String datePattern = "dd MMMM yyyy";
		SimpleDateFormat simpleFormatDate = new SimpleDateFormat(datePattern);
		return simpleFormatDate.format(date);
	}
}