package prime_generater;

import java.util.Scanner;

class UserInPut {

	Scanner scanner = new Scanner(System.in);
	private static final int MIN_NUMBER_PRIMES = Constants.getMinNumberPrimes();
	private static final int MAX_NUMBER_PRIMES =Constants.getMaxNumberPrimes();

	int choose() {
		System.out.println("Add meg, hány prímszámot szeretnél (10 ≤ N ≤ 20000)!");
		int number;
		do {
			System.out.print("N = ");
			number = scanner.nextInt();
		} while (number < MIN_NUMBER_PRIMES || number > MAX_NUMBER_PRIMES);
		{
			scanner.close();
		}
		return number;
	}
}
