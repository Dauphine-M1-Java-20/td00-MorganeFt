package fr.dauphine.ja.fiotmorgane.td00;

import java.awt.print.Printable;
import java.security.DrbgParameters.NextBytes;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 
 * @author Morgane Fiot
 *
 */
public class PrimeCollection 
{
	ArrayList<Integer> numbers;

	public PrimeCollection() {
		this.numbers = new ArrayList<>();
	}
	
	/**
	 * Create a list of n numbers between 0 and m.
	 * @param n number of observation
	 * @param m maximum value
	 */
	public void initRandom(int n, int m) {
		for (int i = 0; i < n; i++) {
			numbers.add(ThreadLocalRandom.current().nextInt(0, m));
		}
	}
	
	private boolean isPrime(int p) {
		boolean answer = true;
		for (int i = 2; i < Math.sqrt(p)+1; i++) {
			if ((p % i) == 0) {
				answer = false;
			}
		}
		return answer;
	}
	
	private void printPrime() {
		for (int i = 0; i < numbers.size(); i++) {
			if (isPrime(numbers.get(i))) {
				System.out.println(numbers.get(i));
			}
		}
	}
	
	public static void main(String[] args) {
		PrimeCollection myCollection = new PrimeCollection();
		myCollection.initRandom(100, 2000);
		myCollection.printPrime();
	}
}
