package ex01.src.controle;

import ex01.src.view.main;
import java.util.concurrent.Semaphore;

public class sistemaCompra extends Thread {
	int delay, geraIngresso;
	static int qtdIngressos = 100;

	static Semaphore s1;
	
	main m = new main();
	
	public sistemaCompra(Semaphore s1) {
		this.s1 = s1;
	}

	@Override
	public void run() {
		login();
		if (delay <= 1000) {
			compra();
			try {
				s1.acquire();
				validacao();
			} catch (InterruptedException e) {
				System.out.println(e);
			} finally {
				s1.release();
			}
		}

		System.out.println("Não há mais ingressos restantes");
	}

	private void login() {
		delay = (int) (Math.random() * 1950) + 51;

		try {
			sleep(delay);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		if (delay > 1000) { System.out.println("Login N°: " + getId() + " Falha ao logar | Demorou: " + String.format("%.1f", (double) delay / 1000)); }
	}

	private void compra() {
		int delay = (int) (Math.random() * 2000) + 1001;

		try {
			sleep(delay);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		if (delay > 2500) {
			System.out.println("Pessoa N°: " + getId() + " Falhou na compra");
		} else {
			geraIngresso = (int) (Math.random() * 3) + 2;
			System.out.println("Pessoa N°: " + getId() + " adicionou " + geraIngresso + " ao carrinho");
		}
	}

	private void validacao() {
		if (qtdIngressos > 0) { qtdIngressos -= geraIngresso; }
		m.qtdIng = qtdIngressos;
		System.out.println("Há " + qtdIngressos + " ingressos restantes");
	}

}
