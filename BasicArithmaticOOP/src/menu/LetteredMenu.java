package menu;

import java.util.Scanner;

import main.Operation;

class LetteredMenu extends AbstractMenu {

	LetteredMenu(Operation[] operations, String prompt, boolean isCapital) {
		super(operations, prompt);
		StringBuilder text = new StringBuilder();
		char menuChar = isCapital ? 'A' : 'a';
		for (Operation op : operations) {
			text.append(String.format("%c) %s%n", menuChar++, op.getName()));
		}
		text.append(String.format("%c) %s%n", menuChar++, "Kilépés"));
		menuText = text.toString();
	}

	int getChoice(Scanner scanner) {
		try {
			String response = scanner.nextLine().toLowerCase();
			return response.isEmpty() ? -1 : response.charAt(0) - 'a';
		} catch (RuntimeException e) {
			return -1;
		}
	}


}
