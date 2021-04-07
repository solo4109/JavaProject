package game;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		new Main().run();
	}

	private void run() {
		Scanner scanner = new Scanner(System.in);
		Question game = new Question();
		GenerateNumber generateNumber = new GenerateNumber();
		Sessesion sessesion = new Sessesion();
		Message message = new Message();
		message.welcome();
		for (boolean first = true; game.canSession(first, scanner); first = false) {
			int target = generateNumber.generateTarget();
			if(sessesion.playSession(target, scanner)) {
				break;
			}
		}
		scanner.close();
		message.farewell();
	}
	

}
