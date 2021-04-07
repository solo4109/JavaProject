package operation;

class Division extends AbstractOperation {

	public Division() {
		super("Osztás", "/");
		
	}



	public void perform(int num1, int num2) {
		if (num2 == 0) {
			errorMessage = "Nullával nem lehet osztani";
		} else {
			result = num1 / num2;
		}
	}



	
}
