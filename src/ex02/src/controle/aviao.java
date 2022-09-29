package ex02.src.controle;

import java.util.concurrent.Semaphore;

public class aviao extends Thread {

	int id, n;
	static Semaphore s1, s2;
	String nPista[] = { "norte", "sul" };

	public aviao(int id, Semaphore s1, Semaphore s2) {
		this.id = id;
		this.s1 = s1;
		this.s2 = s2;
	}

	@Override
	public void run() {
		n = (int) (Math.random() * 2);
		
		if (n == 0) {
			try {
				s1.acquire();
				System.out.println("Avião " + id + " entrou na pista " + nPista[n] + " | " + n);
				manobra();
				taxiar();
				decolagem();
				afastamento();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				s1.release();
			}
		} else {
			try {
				s2.acquire();
				System.out.println("Avião " + id + " entrou na pista " + nPista[n] + " | " + n);
				manobra();
				taxiar();
				decolagem();
				afastamento();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				s2.release();
			}
		}
	}

	private void manobra() {
		System.out.println("Avião " + id + " esta manobrando na pista " + nPista[n]);
		int delay = (int) (Math.random() * 4) + 3;
		try {
			sleep(delay * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Avião " + id + " terminou de manobrar na pista " + nPista[n]);
	}

	private void taxiar() {
		System.out.println("Avião " + id + " esta taxiando na pista " + nPista[n]);
		int delay = (int) (Math.random() * 5) + 5;
		try {
			sleep(delay * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Avião " + id + " terminou de taxiar na pista " + nPista[n]);
	}

	private void decolagem() {
		System.out.println("Avião " + id + " esta decolando na pista " + nPista[n]);
		int delay = (int) (Math.random() * 4) + 1;
		try {
			sleep(delay * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Avião " + id + " terminou de decolar na pista " + nPista[n]);
	}

	private void afastamento() {
		System.out.println("Avião " + id + " esta se afastando da pista " + nPista[n]);
		int delay = (int) (Math.random() * 5) + 3;
		try {
			sleep(delay * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Avião " + id + " se afastou da pista " + nPista[n]);
	}
}
