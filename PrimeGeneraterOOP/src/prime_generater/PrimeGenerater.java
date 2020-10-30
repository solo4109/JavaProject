package prime_generater;

class PrimeGenerater {

	int[] generate(int primeCount) {

		int[] primeArray = new int[primeCount];
		primeArray[0] = 2;
		primeArray[1] = 3;

		int prime = 2;

		for (int i = 5; prime < primeArray.length; i += 2) {
			PrimeChecker primeChecker = new PrimeChecker(primeArray);
			if (primeChecker.check(i)) {
				primeArray[prime++] = i;
			}
		}

		return primeArray;
	}
}
