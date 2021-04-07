package operation;

import main.Operation;

abstract class AbstractOperation implements Operation {

	String name;
	String symbol;
	int result;
	String errorMessage;

	public AbstractOperation(String name, String symbol) {
		this.name = name;
		this.symbol = symbol;
	}

	public String getName() {
		return name;
	}

	public String getSymbol() {
		return symbol;
	}

	public int getResult() {
		return result;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public boolean isOk() {
		return errorMessage == null;
	}

}
