import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class TextLayout {
	static Scanner scanner = new Scanner(System.in);
	private static final int MIN_SIZE = 30;
	private static final int MAX_SIZE = 150;

	public static void main(String[] args) {
		String[] paragraphs = readParagraphsFromFile("ipari.txt");
		if (paragraphs == null) {
			System.out.println("Hiba történt a szövegfájl olvasásakor!");
		}
		int size = userInPut();
		textLayOut(paragraphs, size);

	}

	private static void textLayOut(String[] paragraphs, int size) {
		System.out.println();
		for (String paragraph : paragraphs) {
			printParagraph(paragraph, size);
		}

	}

	private static void printParagraph(String paragraph, int size) {
		int position = 0;
		for (String word : paragraph.split(" ")) {
			if (position == 0) {
				System.out.print(word);
				position += word.length();
			} else if (position + 1 + word.length() <= size) {
				System.out.printf(" %s", word);
				position += 1 + word.length();
			} else {
				System.out.printf("%n%s", word);
				position = word.length();
			}
		}
		System.out.printf("%n%n");
	}

	private static int userInPut() {
		System.out.println("Mennyi legyen az L lapszélesség?");
		int size;
		do {
			System.out.print("L = ");
			size = scanner.nextInt();
		} while (size < MIN_SIZE || size > MAX_SIZE);
		{
			scanner.close();
		}
		return size;

	}

	private static String[] readParagraphsFromFile(String fileName) {
		try (var stream = Files.lines(Path.of(fileName), StandardCharsets.UTF_8)) {
			return stream.toArray(String[]::new);
		} catch (IOException e) {
			return null;
		}
	}

}
