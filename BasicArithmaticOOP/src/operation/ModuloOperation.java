package operation;

import main.Operation;

class ModuloOperation extends AbstractOperation {

	public ModuloOperation() {
		super("Maradékképzés", "%");
		
	}

	public void perform(int num1, int num2) {
		if (num2 == 0) {
			errorMessage = "Nullával nem lehet osztani";
		} else {
			result = num1 % num2;
		}
	}
}
