package lottery;

public class Main {

	public static void main(String[] args) {
		wellcome();
		UserInPut userInPut = new UserInPut();
		RandomDraws randomDraws = new RandomDraws();
		randomDraws.generateNumbers(userInPut.addNumbers());
		
	}

	private static void wellcome() {
		System.out.println("1. részfeladat: véletlen sorsolások");
		System.out.println();
	}

}
