package operation;

class Addition extends AbstractOperation {

	public Addition() {
		super("Összeadás", "+");
		// TODO Auto-generated constructor stub
	}
	
	public void perform(int num1, int num2) {
		result = num1 + num2;
	}
	
}
