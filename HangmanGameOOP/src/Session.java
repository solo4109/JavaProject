
import java.text.Collator;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

class Session {

	private static final int MAX_MISS = Constants.getMiss();
	private static final Collator COLLATOR = Collator.getInstance(new Locale("hu", "HU"));
	private static final String LETTERS;

	static {
		StringBuilder letters = new StringBuilder();
		for (char ch = 'A'; ch <= 'Z'; ch++) {
			letters.append(ch);
		}
		letters.append("ÁÉÍÖŐÓÚÜŰ");
		letters.append('*');
		LETTERS = letters.toString();
	}

	private final Scanner scanner;
	private final String target;
	private final boolean[] matches;
	private final String[] miss;
	private int numMiss;
	private boolean gameToExit = false;

	Session(Scanner scanner, String target) {
		this.scanner = scanner;
		this.target = target.toUpperCase();
		matches = new boolean[target.length()];
		miss = new String[MAX_MISS];
		Arrays.fill(miss, "\uFFFF");
	}

	void play() {
		for (print(); !isFinished(); print()) {
			char letter = input();
			if (letter == '*') {
				gameToExit = true;
				return;
			}
			process(letter);
		}
		System.out.println(isSuccessful() ? "Kitaláltad, gratulálok!" : "Ez most nem siekrült");
	}

	private boolean isFinished() {
		return isSuccessful() || isFailed();
	}

	private boolean isFailed() {
		return numMiss == MAX_MISS;
	}

	private boolean isSuccessful() {
		for (boolean m : matches) {
			if (!m) {
				return false;
			}
		}
		return true;
	}

	private void print() {
		System.out.println();
		printTarget();
		printMiss();

	}

	private void printMiss() {
		if (numMiss > 0) {
			System.out.print("     Rossz tippek: ");
			System.out.print(miss[0]);
			for (int i = 1; i < numMiss; i++) {
				System.out.printf(", %s", miss[i]);
			}
		}
		System.out.println();
	}

	private void printTarget() {
		for (int i = 0; i < target.length(); i++) {
			System.out.print(matches[i] ? target.charAt(i) : "_");
			System.out.print(" ");
		}

	}

	private void process(char letter) {
		if (Arrays.binarySearch(miss, "" + letter, COLLATOR) < 0) {
			boolean match = updateMatches(letter);
			if (!match) {
				updateMismatches(letter);
			}
		}

	}

	private boolean updateMatches(char letter) {
		boolean match = false;
		for (int i = 0; i < target.length(); i++) {
			if (target.charAt(i) == letter) {
				match = matches[i] = true;
			}
		}
		return match;
	}

	private void updateMismatches(char letter) {
		miss[numMiss++] = " " + letter;
		Arrays.parallelSort(miss, COLLATOR);

	}

	private char input() {
		String letter;
		do {
			System.out.print("Kérek egy betűt: ");
			letter = scanner.nextLine().trim().toUpperCase();
		} while (letter.length() != 1 || !LETTERS.contains(letter));
		return letter.charAt(0);
	}

	boolean isGameToExit() {
		return gameToExit;
	}
}
