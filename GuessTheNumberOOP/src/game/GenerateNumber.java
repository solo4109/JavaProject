package game;

import java.util.Random;

class GenerateNumber {
	private static final int TARGET_LIMIT = 200;
	static Random random = new Random();

	static int generateTarget() {
		System.out.println("Megvan a kitalálandó szám.");
		return 1 + random.nextInt(TARGET_LIMIT);
	}
}
