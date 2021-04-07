package operation;

class Subtraction extends AbstractOperation {
	public Subtraction() {
		super("Kivonás", "-");
		
	}


	public void perform(int num1, int num2) {
		result = num1 - num2;
	}
}
