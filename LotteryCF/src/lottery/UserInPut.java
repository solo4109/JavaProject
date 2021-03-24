package lottery;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

class UserInPut {

	public List<Integer> addNumbers() {
		List<Integer> numbers = new ArrayList<>();

		System.out.println("Add meg a szelvény számait!");

		int count = 1;
		int userNumber = 0;
		
		while (numbers.size() < 6) {
			System.out.println(count + ". szám: ");
			try {
				Scanner scanner = new Scanner(System.in);
				userNumber = scanner.nextInt();
				if (userNumber > 0 && userNumber < 46 && !numbers.contains(userNumber)) {
					numbers.add(userNumber);
					count++;
				}
			} catch (NoSuchElementException | IllegalStateException e) {
				System.err.println("Ne legyél hülye!");
			}
			
		}
//		do {
//			int userInPut = scanner.nextInt();
//			if (userInPut > 45 || userInPut < 1) {
//				System.err.println("1 és 45 között adj meg számot, beleértve a két határértéket is!");
//				continue;
//			}
//			System.out.println(count + ". szám: " + userInPut);
//			count++;
//			numbers.add(userInPut);
//			if (count == 7) {
//				scanner.close();
//			}
//		} while (count < 7);

		printNumbers(numbers);
		return numbers;
	}

	void printNumbers(List<Integer> numbers) {
		System.out.println();
		Collections.sort(numbers);
		System.out.print("A szelvény számai sorrendben: " + numbers.get(0));
		for (int i = 1; i < numbers.size(); i++) {
			System.out.print(", " + numbers.get(i));
		}
		System.out.println();
	}
}
