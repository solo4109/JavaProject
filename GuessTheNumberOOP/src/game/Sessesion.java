package game;

import java.util.Scanner;

class Sessesion {
	private static final int TARGET_LIMIT = 200;
	private static final int NOMINAL_NUM_TIPS = (int) Math.ceil(Math.log(TARGET_LIMIT) / Math.log(2));
	private static final int MAX_NUM_TIPS = 2 * NOMINAL_NUM_TIPS - 1;

	static boolean playSession(int target, Scanner scanner) {
		for (int counter = 1; true; counter++) {
			System.out.printf("%d. tipp: ", counter);
			int tip = scanner.nextInt();
			scanner.nextLine();
			boolean hit = tip == target;
			if (tip == 0) {
				return true;
			} else if (hit || counter == TARGET_LIMIT) {
				appraise(hit, counter);
				return false;
			} else {
				System.out.printf("   %s, mint %d%n", target < tip ? "kisebb" : "nagyobb", tip);
			}
		}

	}

	  static void appraise(boolean success, int tipCount) {
		if (success) {
			if (tipCount <= 2) {
				System.out.println("Eltaláltad! Nagy szerencséd volt!");
			} else if (tipCount < NOMINAL_NUM_TIPS) {
				System.out.println("Korán eltaláltad! Szerencsés vagy!");
			} else if (tipCount == NOMINAL_NUM_TIPS) {
				System.out.println("Ok, időben eltaláltad!");
			} else {
				System.out.println("Eltaláltad, bár lehettél volna kicsit gyorsabb is.");
			}
		} else {
			System.out.println("Ez most nem sikerült. Gondold végig a tippelési stratégiát!");
		}
	}
}
