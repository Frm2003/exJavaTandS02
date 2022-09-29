package ex02.src.view;

import java.util.concurrent.Semaphore;
import ex02.src.controle.aviao;

public class main {

	public static Semaphore s1, s2;
	
	public static void main(String[] args) {
		s1 = new Semaphore(1);
		s2 = new Semaphore(1);
		
		for (int i = 0; i < 12; i++) {
			Thread t = new aviao(i, s1, s2);
			t.start();
		}
	}

}
