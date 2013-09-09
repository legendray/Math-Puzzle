package CalculatePrime;

import java.util.ArrayList;

/**
 * 
 * @author LEGENDRAY In this class I implement a function to calculate the Nth
 *         prime number. As we know, to determine a prime number K, we just need
 *         to use a group of prime numbers which are less than or equal to
 *         Sqrt(K) to divide K, if their remainders are not zero, then K is
 *         prime. I use a PrimePool to hold those prime numbers.
 * 
 */

public class CalculatePrime {

	public static void main(String[] args) {

		CalculatePrime cp = new CalculatePrime();
		System.out.println(cp.getPrime(200000));

	}

	public int getPrime(int N) {

		ArrayList<Integer> PrimePool = new ArrayList<Integer>();
		PrimePool.add(2);
		PrimePool.add(3);
		PrimePool.add(5);
		PrimePool.add(7);

		if (N <= PrimePool.size()) {
			return PrimePool.get(N - 1);
		} else {

			int base = PrimePool.get(PrimePool.size() - 1);

			while (PrimePool.size() < N) {
				boolean isPrime = true;
				base = base + 2;
				int i = 0;
				int cut = (int) Math.sqrt(base);
				while (PrimePool.get(i) <= cut) {
					if (base % PrimePool.get(i) == 0) {
						isPrime = false;
						break;
					} else {
						i++;
					}
				}

				if (isPrime) {
					PrimePool.add(base);
				}

			}

		}

		return PrimePool.get(N - 1);
	}

}
