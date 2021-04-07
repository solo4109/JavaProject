package menu;

import java.util.Scanner;

import main.Menu;
import main.Operation;

abstract class AbstractMenu implements Menu {

	private final Operation[] operations;
	private final String prompt;
	String menuText;

	AbstractMenu(Operation[] operations, String prompt) {
		this.operations = operations;
		this.prompt = prompt;
	}

	public Operation printAndSelect(Scanner scanner) {
		System.out.print(menuText);
		int choice;
		do {
			System.out.print(prompt);
			choice = getChoice(scanner);
		} while (choice < 0 || choice > operations.length);
		return choice < operations.length ? operations[choice] : null;
	}

	abstract int getChoice(Scanner scanner);

}
