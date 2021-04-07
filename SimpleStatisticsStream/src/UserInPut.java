import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInPut {
	static Scanner scanner = new Scanner(System.in);

	List<Integer> addNumbers() {
		System.out.println("Add meg az adatokat (legalább kettőt), üss Entert a befejezéshez!");
		List<Integer> numbers = new ArrayList<>();
		String number = null;
		int count = 0;
			do {
			System.out.print(count == 0 ? "első adat: " : "következő szám: ");
			number = scanner.nextLine();
			if (number != null && !number.isEmpty()) {
				numbers.add(Integer.parseInt(number));
				count++;
			}
		}  while (!number.isEmpty());
		return numbers;
	}

	public void closeScanner() {
		scanner.close();
	}
}
