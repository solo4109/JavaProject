package prime_generater;

import java.util.Scanner;

class Printer {
	Scanner scannar = new Scanner(System.in);
	private static final int ENTER = Constants.getEnter();

	void print(int[] array) {
		System.out.printf("%nAz első %d prímszám a következő: %n", array.length);
		System.out.print(array[0]);

		int lineLength = 1;
		for (int i = 1; i < array.length; i++) {
			String primeText = String.format(", %d", array[i]);
			if (lineLength + primeText.length() <= ENTER - 1) {
				System.out.print(primeText);
				lineLength += primeText.length();
			} else {
				primeText = primeText.substring(2);
				System.out.printf(",%n%s", primeText);
				lineLength = primeText.length();
			}
		}
		

	}

}
