package ex01.src.view;

import ex01.src.controle.sistemaCompra;
import java.util.concurrent.Semaphore;

public class main {
	static Semaphore s1;
	public static int qtdIng = 100;
	
	public static void main(String[] args) {
		s1 = new Semaphore(1);
		
		for (int i = 0; i < 300; i++) {
			Thread t = new sistemaCompra(s1);
			t.start();
			
			if (qtdIng > 0) { t.interrupted(); }
		}
	}

}
