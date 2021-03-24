package lottery;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

class RandomDraws {

	private final static int MAX_TIPP = 6;

	int zero = 0;
	int oneGoal = 0;
	int twoGoal = 0;
	int threeGoal = 0;
	int fourGoal = 0;
	int fiveGoal = 0;
	int sixGoal = 0;
	
	// generate six numbers while don't find a sixgoal
	public void generateNumbers(List<Integer> userNumbers) {
		Random random = new Random();
		int randomNumber = 0;
		long start = System.currentTimeMillis();

		while (sixGoal < 1) {
			List<Integer> numbers = new ArrayList<>();
			for (int i = 0; numbers.size() < MAX_TIPP; i++) {
				randomNumber = 1 + random.nextInt(45);
				if (!numbers.contains(randomNumber)) {
					numbers.add(randomNumber);
				} else {
					i--;
				}
			}
			checkNumbers(numbers, userNumbers);
		}
		long end = System.currentTimeMillis();
		printGoalsAndTime(start, end);
	}

	void checkNumbers(List<Integer> numbers, List<Integer> userNumbers) {
		int goal = 0;

		Collections.sort(numbers);

		for (int i = 0; i < numbers.size(); i++) {
			for (int j = 0; j < userNumbers.size(); j++) {
				if (numbers.get(i) == userNumbers.get(j)) {
					goal++;
				}
//				else if (numbers.get(i) != userNumbers.get(j)) {
//					zero++;
//				}
			}
		}

		switch (goal) {
		case 0:
			zero++;
			break;
		case 1:
			oneGoal++;
			break;
		case 2:
			twoGoal++;
			break;
		case 3:
			threeGoal++;
			break;
		case 4:
			fourGoal++;
			break;
		case 5:
			fiveGoal++;
			break;
		case 6:
			sixGoal++;
			break;
		}

	}

	private void printGoalsAndTime(long start, long end) {
		int allGoal = zero + oneGoal + twoGoal + threeGoal + fourGoal + fiveGoal + sixGoal;
		
		System.out.println();
		System.out.println("Sorsolások és a találatok összeszámolása...");
		System.out.printf("[futási idő: %.1f s]%n%n", (end - start) / 1000d);

		System.out.printf("%nA sorsolások megoszlása a szelvény találatainak száma szerint:%n%n");
		System.out.println("0 találat: " + zero);
		System.out.println("1 találat: " + oneGoal);
		System.out.println("2 találat: " + twoGoal);
		System.out.println("3 találat: " + threeGoal);
		System.out.println("4 találat: " + fourGoal);
		System.out.println("5 találat: " + fiveGoal);
		System.out.println("6 találat: " + sixGoal);
		System.out.println();
		System.out.println("Összesen : " + allGoal);

	}

}
