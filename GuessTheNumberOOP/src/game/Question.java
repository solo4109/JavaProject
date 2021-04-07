package game;

import java.util.Random;
import java.util.Scanner;

class Question {

	 static boolean canSession(boolean first, Scanner scanner) {
		System.out.printf("%nKezdődhet %s menet (i/n)? ", first ? "az első" : "a következő");
		String answer = scanner.nextLine();
		return answer.isEmpty() || answer.toLowerCase().charAt(0) == 'i';
	}
}
