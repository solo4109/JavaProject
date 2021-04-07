package main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Encoder2 {

	/*
	 * 1.) Minden nagybetűt alakítson át a program kisbetűvé. 2.) Az angol nyelv
	 * magánhangzóinak helyére kerüljön az eggyel utánuk következő magánhagzó (pl: a
	 * -> e). 3.) Az angol nyelv mássalhangzóinak helyére kerüljön a kettővel utánuk
	 * következő mássalhangzó (pl: b -> d). 3.1) Az y mássalhangzónak számít! 4.)
	 * Minden egyéb karakter ami nem az angol abc része kerüljön törlésre.
	 */

	public static void main(String[] args) throws IOException {
		new Encoder2().run();
	}

	private void run() throws IOException {
		List<String> text = readFile();
		List<String> replacedVowelsText = changeVowels(text);
		List<String> repalcedConsonant = changeConsonant(replacedVowelsText);
		printCodedText(repalcedConsonant);

	}

	private void printCodedText(List<String> repalcedConsonant) {
		for (String word : repalcedConsonant) {
			System.out.println(word);
		}

	}

	private List<String> changeConsonant(List<String> replacedVowelsText) {
		char[] consonant = { 'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w',
				'y', 'z' };
		Map<Character, Integer> mapConsonant = new HashMap<>();
		for (int i = 0; i < consonant.length; i++) {
			mapConsonant.put(consonant[i], i);
		}

		char[] letters = new char[replacedVowelsText.size()];
		List<String> newWords = new ArrayList<>();

		// If the current character is a consonant find the index in HashMap and switch it
					// with next + 1 (2) consonant from HashMap
		for (String word : replacedVowelsText) {
			letters = word.toCharArray();
			for (int i = 0; i < letters.length; i++) {
				char c = letters[i];
				for (int j = 0; j < consonant.length; j++) {
					if (c == consonant[j]) {
						int index = mapConsonant.get(c) + 2;
						int newIndex = index % consonant.length;
						letters[i] = consonant[newIndex];
					}
				}
			}
			//Convert the char arrays back into String words and add a new List 
			String str = String.valueOf(letters);
			newWords.add(str);
		}
		return newWords;
	}

	private List<String> changeVowels(List<String> text) {
		char vowels[] = { 'a', 'e', 'i', 'o', 'u' };
		Map<Character, Integer> mapVowels = new HashMap<>();
		for (int i = 0; i < vowels.length; i++) {
			mapVowels.put(vowels[i], i);
		}
//		mapVowels.put('a', 0);
//		mapVowels.put('e', 1);
//		mapVowels.put('i', 2);
//		mapVowels.put('o', 3);
//		mapVowels.put('u', 4);

		char[] letters = new char[text.size()];
		List<String> newWords = new ArrayList<>();
		
		// Iterate over the Text and delete all character which not in the English abc
		for (String word : text) {
			word = word.toLowerCase();
			word = word.replaceAll("\\s", ""); // delete space
			word = word.replace(",", "");
			word = word.replace(";", "");
			word = word.replace(".", "");
			word = word.replace("‘", "");
			word = word.replace("’", "");
			word = word.replace("“", "");
			word = word.replace("”", "");
			word = word.replace("-", "");
			word = word.replace(":", "");
			letters = word.toCharArray();

			// If the current character is a vowel, find the index in HashMap and switch it
			// with next vowel from HashMap
			for (int i = 0; i < letters.length; i++) {
				char c = letters[i];
				if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
					int index = mapVowels.get(c) + 1;
					int newIndex = index % vowels.length;
					letters[i] = vowels[newIndex];
				}
			}
			// Convert the char arrays back into String words and add a new List 
			String str = String.valueOf(letters);
			newWords.add(str);
		}
		return newWords;
	}

	//Read the file and handling exception
	private static List<String> readFile() throws IOException {
		List<String> words = Files.readAllLines(Path.of("Angol szöveg.txt"));
		return words;
	}
}
