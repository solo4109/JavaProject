import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class VowelFrequencies {

	public static void main(String[] args) {

		String doc = readTextFromFile("ipari.txt");
		char[] vowels = { 'a', 'á', 'e', 'é', 'i', 'í', 'o', 'ó', 'ö', 'ő', 'u', 'ú', 'ü', 'ű' };
		doc = doc.toLowerCase();
		int[] frequency = scanFrequencyVowels(vowels, doc);
		int sumOfVowels = sum(frequency);
		print(doc, frequency, sumOfVowels, vowels);

	}

	private static void print(String doc, int[] frequency, int sumOfVowels, char[] vowels) {
		System.out.printf("Magánhangzók gyakoriságának elemzése egy állomány szövegében%n%n");
		System.out.printf("A szöveg teljes hossza %2d karakter.", doc.length());
		System.out.println("A gyakoriságok:");
		System.out.println("hangzó gyakoriság rel.gyak");
		for (int i = 0; i < frequency.length; i++) {
			System.out.printf("%6s %10d %7.1f%% %n", vowels[i], frequency[i],100.0 * frequency[i] / sumOfVowels);
		}
		System.out.println("A fenti számok a kis- és a nagybetűk előfordulásait egyaránt tartalmazzák.");

	}

	private static int sum(int[] frequency) {
		int sum = 0;
		for (int i = 0; i < frequency.length; i++) {
			sum += frequency[i];
		}
		return sum;
	}

	private static int[] scanFrequencyVowels(char[] vowels, String doc) {
		int[] frequencies = new int[vowels.length];
		char[] docArray = doc.toCharArray();

		for (int i = 0; i < vowels.length; i++) {
			for (int j = 0; j < doc.length(); j++) {
				if (docArray[j] == vowels[i]) {
					frequencies[i]++;
				}
			}
		}

		return frequencies;
	}

	private static String readTextFromFile(String fileName) {
		try {
			return Files.readString(Paths.get(fileName), StandardCharsets.UTF_8);
		} catch (IOException e) {
			return null;
		}
	}

}
