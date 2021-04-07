package menu;

import java.util.Scanner;

import main.Operation;

class NumberedMenu extends AbstractMenu {

	NumberedMenu(Operation[] operations, String prompt) {
		super(operations, prompt);
		StringBuilder text = new StringBuilder();
		int number = 1;
		for (Operation op : operations) {
			text.append(String.format("%d. %s%n", number++, op.getName()));
		}
		text.append(String.format("%d. %s%n", number++, "Kilépés"));
		menuText = text.toString();
	}

	@Override
	int getChoice(Scanner scanner) {
		try {
			return Integer.parseInt(scanner.nextLine()) - 1;
		} catch (NumberFormatException e) {
			return -1;
		}
	}

}
