import java.util.Collection;

public class Main {

	public static void main(String[] args) {
		new Main().run();
	}

	private void run() {
		UserInPut userInPut = new UserInPut();
		System.out.printf("Üdvözöllek az Alapstatisztika alkalmazásban!%n%n");
		Statistic statistic = new Statistic(userInPut.addNumbers());
		print(statistic);
	}
	
	private void print(Statistic statistic) {
		System.out.println();
		System.out.printf("A számtartomány: %d ... %d %n",statistic.calculateMin(),statistic.calculateMax());
		System.out.printf("A módusz: %s%n", collectionToText(statistic.calculateMode(), "; "));
		System.out.printf("Az átlag: %.2f%n",statistic.calculateAverage());
		System.out.printf("A medián: %.2f%n%n", statistic.calculateMedian());
	}
	
	private String collectionToText(Collection<Integer> array, String delimeter) {
		StringBuilder sb = new StringBuilder();
		for (int d : array) {
			sb.append(delimeter).append(d);
		}
		return sb.substring(delimeter.length());
	}
	

}
