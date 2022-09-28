package loja;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		LojaView loja = new LojaView();
		loja.home(in);
		
		in.close();
	}
}
