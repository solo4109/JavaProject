package operation;

class Multiplication extends AbstractOperation {

	public Multiplication() {
		super("Szorzás", "*");
		
	}


	public void perform(int num1, int num2) {
		result = num1 * num2;
	}

}
