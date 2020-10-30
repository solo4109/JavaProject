package prime_generater;

class PrimeChecker {

	private int[] primes;

	public PrimeChecker(int[] primes) {
		this.primes = primes;
	}

	boolean check(int testedNumber) {
		int sqrt = (int) Math.sqrt(testedNumber);
		for (int i = 1; primes[i] <= sqrt; i++) {
			if (testedNumber % primes[i] == 0) {
				return false;
			}
		}
		return true;
	}
}
