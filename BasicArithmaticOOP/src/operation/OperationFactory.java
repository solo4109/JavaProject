package operation;

import main.Operation;
import main.OperationServicePoint;

public class OperationFactory implements OperationServicePoint {

	private static final Operation[] operations = { new Addition(), new Division(), new ModuloOperation(),
			new Multiplication(), new Subtraction() };

	public static final OperationServicePoint getInstance() {
		return new OperationFactory();
	}

	private OperationFactory() {

	}

	@Override
	public Operation[] getAvailableOperations() {
		return operations;
	}

}
