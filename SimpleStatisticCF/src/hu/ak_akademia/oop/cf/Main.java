package hu.ak_akademia.oop.cf;

import java.util.Collection;
import java.util.SortedSet;



public class Main {

	public static void main(String[] args) {
		new Main().process();
	}

	private void process() {
		UserInPut userInPut = new UserInPut();
		System.out.println("Üdvözöllek az Alapstatisztika alkalmazásban!");
		System.out.println();
		Statistic statistic = new Statistic(userInPut.addNumbers());
		print(statistic);
		System.out.println("Viszlát!");
	}

	private void print(Statistic statistic) {
		System.out.println();
		System.out.printf("A számtartomány: %s%n", collectionToText(statistic.getRange(), " ... "));
		System.out.printf("A módusz: %s%n", collectionToText(statistic.getMode(), ", "));
		System.out.printf("Az átlag: %.2f%n",statistic.getAverage());
		System.out.printf("A medián: %.2f%n%n", statistic.getMedian());
	}

	private String collectionToText(Collection<Integer> array, String delimeter) {
		StringBuilder sb = new StringBuilder();
		for (int d : array) {
			sb.append(delimeter).append(d);
		}
		return sb.substring(delimeter.length());
	}

}
