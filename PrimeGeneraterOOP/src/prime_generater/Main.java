package prime_generater;

public class Main {

	public static void main(String[] args) {
		System.out.printf("Üdvözöllek a prímszám generátor programban!%n%n");
		UserInPut userInPut = new UserInPut();
		int primeCount = userInPut.choose();
		PrimeGenerater primeGenerater = new PrimeGenerater();
		int[] primeArray = primeGenerater.generate(primeCount);
		Printer printer = new Printer();
		printer.print(primeArray);
		System.out.printf("%n%nViszlát!");

	}

}
