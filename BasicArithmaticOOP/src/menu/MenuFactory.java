package menu;

import main.Menu;
import main.MenuServicePoint;
import main.Operation;
import main.OperationServicePoint;
import operation.OperationFactory;

public class MenuFactory implements MenuServicePoint {

	private static final OperationServicePoint operationServicePoint = OperationFactory.getInstance();

	public static MenuServicePoint getInstance() {
		return new MenuFactory();
	}

	private MenuFactory() {

	}

	@Override
	public Menu getMenu(Type type, String prompt, Operation[] operations) {
		return type.isNumeral() ? new NumberedMenu(operations, prompt)
				: new LetteredMenu(operations, prompt, type.isUpperCase());
	}

	@Override
	public Menu getMenu(Type type, String prompt) {

		return getMenu(type, prompt, operationServicePoint.getAvailableOperations());
	}

	@Override
	public Menu getMenu(Type type, String prompt, String... symbols) {
		if (symbols.length == 0) {
			throw new IllegalArgumentException("Nincs megadva műveleti szimbólum");
		}
		Operation[] operations = new Operation[symbols.length];
		int i = 0;
		for (String symbol : symbols) {
			operations[i++] = operationServicePoint.get(symbol);
		}
		return getMenu(type, prompt, operations);
	}

}
