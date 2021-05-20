package car_wash;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CarDemo {

	static final Scanner SCANNER = new Scanner(System.in);

	static final String[] SERVICE_NAMES = new String[8];
	static final String[] MATERIAL_NAMES = new String[8];
	static final int MENU = 9;
	static final int SMALL_LARGE_RATIO = 2;

	static int[] serviceQSmall = new int[8];
	static int[] serviceQLarge = new int[8];
	static double[] materialQ = new double[8];
	static int[] materialP = new int[8]; // material price per liter

	public static void main(String[] args) {
		initiateValues();
		work();
	}

	private static void initiateValues() {
		MATERIAL_NAMES[0] = "3M polírpaszta";
		MATERIAL_NAMES[1] = "Nasiol Protect";
		MATERIAL_NAMES[2] = "VMD spray";
		MATERIAL_NAMES[3] = "Astonish";
		MATERIAL_NAMES[4] = "Universal";
		MATERIAL_NAMES[5] = "Hill Vital";
		MATERIAL_NAMES[6] = "Prevent";
		MATERIAL_NAMES[7] = "Motor cleaner";

		SERVICE_NAMES[0] = "Polírozás";
		SERVICE_NAMES[1] = "Nanokerámiás kezelés";
		SERVICE_NAMES[2] = "Kárpittisztítás";
		SERVICE_NAMES[3] = "Padlótisztítás";
		SERVICE_NAMES[4] = "Mosás";
		SERVICE_NAMES[5] = "Légtérfrissítés";
		SERVICE_NAMES[6] = "Waxolás";
		SERVICE_NAMES[7] = "Motormosás";

		materialP[0] = 13300;
		materialP[1] = 24000 * 20;
		materialP[2] = 1599 * 2;
		materialP[3] = 949 / 3 * 4;
		materialP[4] = 2030 / 5;
		materialP[5] = 2290 * 5;
		materialP[6] = 1999 / 375 * 1000;
		materialP[7] = 1220;

		for (int i = 0; i < MATERIAL_NAMES.length; i++) {
			serviceQSmall[i] = 0;
			serviceQLarge[i] = 0;
			materialQ[i] = 0;
		}

//			Polírozás	polírpaszta (3M perfect)	1 liter	13300 forint				
//			Nanokerámiás kezelés	Nasiol Protect	50 ml	80 dollár (külföldi beszállítótól)								
//			Kárpittisztítás	VMD spray	500 ml	1599 forint													
//			Padlótisztítás	Astonish	750 ml	949 forint				
//			Mosás	Universal	5 liter	2030 forint	
//			Légtérfrissítés	Hill Vital légfrissítő olaj	200 ml	2290 forint			
//			waxolás	Prevent	375 ml	1999 forint			
//			motormosás	Motor cleaner	1 liter	1220 forint
	}

	static void work() {
		System.out.println("Üdvözlöm!");
		menu: while (true) {
			printMenu();
			int choice = userInputIntWithLimits("Az ön által kért menüpont: ", MENU);
			switch (choice) {
			case 1:
				serviceInput();
				break;
			case 2:
				materialInput();
				break;
			case 3:
				storageInput();
				break;
			case 4:
				consumption();
				break;
			case 5:
				allConsumption();
				break;
			case 6:
				changePrice();
				break;
			case 7:
				saveToFile();
				break;
			case 8:
				loadFile();
				break;
			case 9:
				break menu;
			default:
				System.out.println("Érvénytelen menüpont.");
			}
		}
		System.out.println("Viszlát!");
	}

	static void loadFile() {
		System.out.printf("%nMit szeretne betölteni?: %n1. Minden adatot%n2. Csak a mentett árakat%n");
		int choice = userInputIntWithLimits("A választás: ", 2);
		if (choice == 2) {
			loadPrices();
			printLoadedPrices();
		} else if (choice == 1) {
			loadAllData();
			printLoadedData();
		} else {
			System.out.println("A program nem töltött be adatokat, érvénytelen választás.");
		}
	}

	private static void loadPrices() {
		materialP = readDataFromFileInt("MaterialP");
	}

	private static void printLoadedPrices() {
		System.out.printf("%nA betöltött adatok a következők: %n");
		for (int i = 0; i < materialP.length; i++) {
			System.out.printf("%s, amely jelenlegi ára: %,d Ft/liter.%n", MATERIAL_NAMES[i], materialP[i]);
		}
	}

	private static void loadAllData() {
		materialQ = readDataFromFileDouble("MaterialQ");
		serviceQSmall = readDataFromFileInt("ServiceQSmall");
		serviceQLarge = readDataFromFileInt("ServiceQLarge");
		materialP = readDataFromFileInt("MaterialP");
	}

	private static void printLoadedData() {
		System.out.printf("%nA betöltött adatok a következők: %n");
		System.out.printf("%nAz eddig mentett anyagfogyás: %n");
		for (int i = 0; i < materialP.length; i++) {
			System.out.printf("%s: %,.2f liter, amely jelenlegi ára: %,d Ft/liter.%n", MATERIAL_NAMES[i], materialQ[i],
					materialP[i]);
		}
		System.out.printf("%nAz eddig mentett szolgáltatások: %n");
		for (int i = 0; i < materialP.length; i++) {
			System.out.println(
					SERVICE_NAMES[i] + ": " + serviceQSmall[i] + " kis autó, és " + serviceQLarge[i] + " nagy autó.");
		}
	}

	static void saveToFile() {
		saveDataToFileDouble("MaterialQ", materialQ);
		saveDataToFileInt("ServiceQSmall", serviceQSmall);
		saveDataToFileInt("ServiceQLarge", serviceQLarge);
		saveDataToFileInt("MaterialP", materialP);
	}

	static void serviceInput() {
		System.out.println();
		for (int i = 0; i < SERVICE_NAMES.length; i++) {
			System.out.println(1 + i + ". " + SERVICE_NAMES[i]);
		}
		int choice = userInputIntWithLimits("A szolgáltatás: ", SERVICE_NAMES.length) - 1;
		if (choice < SERVICE_NAMES.length && choice >= 0) {
			int q = userInputInt("Az eladott szolgáltatás mennyisége: ");
			int car = userInputIntWithLimits("1. kis autó vagy 2. nagy autó : ", 2);
			if (car == 2) {
				System.out.printf("Az eddigi %s szolgáltatás mennyiség %,d nagy autó volt.%n", SERVICE_NAMES[choice],
						serviceQLarge[choice]);
				serviceQLarge[choice] += q;
				System.out.printf("Az összes %s szolgáltatás mennyiség %,d nagy autó lett.%n", SERVICE_NAMES[choice],
						serviceQLarge[choice]);
			} else if (car == 1) {
				System.out.printf("Az eddigi %s szolgáltatás mennyiség %,d kis autó volt.%n", SERVICE_NAMES[choice],
						serviceQSmall[choice]);
				serviceQSmall[choice] += q;
				System.out.printf("Az összes %s szolgáltatás mennyiség %,d kis autó lett.%n", SERVICE_NAMES[choice],
						serviceQSmall[choice]);

			} else {
				System.out.println("Érvénytelen választás, az adatbevitel nem sikerült.");
			}
		} else {
			System.out.println("Érvénytelen választás, az adatbevitel nem sikerült.");
		}
	}

	static void storageInput() {
		System.out.println();
		for (int i = 0; i < MATERIAL_NAMES.length; i++) {
			System.out.println(1 + i + ". " + MATERIAL_NAMES[i]);
		}
		int choice = userInputIntWithLimits("Az anyag: ", MATERIAL_NAMES.length) - 1;
		if (choice < MATERIAL_NAMES.length && choice >= 0) {
			System.out.printf("%s. ", MATERIAL_NAMES[choice]);
			System.out.println("Az eddig nyilvántartott anyagfogyás: " + materialQ[choice]);
			materialQ[choice] -= userInputDouble("A készletváltozás literben (készletcsökkenés esetén negatív): ");
			System.out.printf("A készletváltozással korrigált felhasznált mennyiség %.2f liter lett.%n",
					materialQ[choice]);
		} else {
			System.out.println("Érvénytelen választás, az adatbevitel nem sikerült.");
		}
	}

	static void materialInput() {
		System.out.println();
		for (int i = 0; i < MATERIAL_NAMES.length; i++) {
			System.out.println(1 + i + ". " + MATERIAL_NAMES[i]);
		}
		int choice = userInputIntWithLimits("Az anyag: ", MATERIAL_NAMES.length) - 1;
		if (choice < MATERIAL_NAMES.length && choice >= 0) {
			System.out.printf("Az eddigi %s rendelt mennyiség %.2f liter volt.%n", MATERIAL_NAMES[choice],
					materialQ[choice]);
			materialQ[choice] += userInputDouble("A rendelt mennyiség literben: ");
			System.out.printf("Az összes felhasznált mennyiség %.2f liter lett.%n", materialQ[choice]);
		} else {
			System.out.println("Érvénytelen választás, az adatbevitel nem sikerült.");
		}
	}

	static void allConsumption() {
		System.out.println();
		for (int i = 0; i < MATERIAL_NAMES.length; i++) {
			printConsumption(i);
		}
	}

	static void consumption() {
		System.out.println();
		for (int i = 0; i < MATERIAL_NAMES.length; i++) {
			System.out.println(1 + i + ". " + MATERIAL_NAMES[i]);
		}
		int choice = userInputIntWithLimits("Az anyag: ", MATERIAL_NAMES.length) - 1;
		if (choice < MATERIAL_NAMES.length && choice >= 0) {
			printConsumption(choice);
		} else {
			System.out.println("Érvénytelen választás, az adatbevitel nem sikerült.");
		}
	}

	private static void printConsumption(int choice) {
		System.out.printf("%n%s%s.", "Az anyag: ", MATERIAL_NAMES[choice]);
		System.out.printf("%n%s%s.", "Az anyaghoz kapcsolódó szolgáltatás: ", SERVICE_NAMES[choice]);
		System.out.printf("%n%s%41.2f%s", "Az összes anyagfogyás: ", materialQ[choice], " liter.");
		System.out.printf("%n%s%13.2f%s", "Az anyagfogyás egy szolgáltatás esetén kis autóra: ",
				calculateMaterialPerService(choice), " liter.");
		System.out.printf("%n%s%12.2f%s%n", "Az anyagfogyás egy szolgáltatás esetén nagy autóra: ",
				calculateMaterialPerService(choice) * SMALL_LARGE_RATIO, " liter.");
		System.out.printf("%s%,47d%s%n", "Az anyag ára: ", materialP[choice], " Ft/liter.");
		System.out.printf("%s%,9.0f Ft.%n", "Az anyagköltség egy szolgáltatás esetén kis autóra: ",
				calculateCostPerService(choice));
		System.out.printf("%s%,8.0f Ft.%n", "Az anyagköltség egy szolgáltatás esetén nagy autóra: ",
				calculateCostPerService(choice) * SMALL_LARGE_RATIO);
	}

	static double calculateMaterialPerService(int serviceNumber) {
		return materialQ[serviceNumber]
				/ (serviceQSmall[serviceNumber] + serviceQLarge[serviceNumber] * SMALL_LARGE_RATIO);
	}

	static double calculateCostPerService(int serviceNumber) {
		return calculateMaterialPerService(serviceNumber) * materialP[serviceNumber];
	}

	static void changePrice() {
		System.out.println();
		for (int i = 0; i < MATERIAL_NAMES.length; i++) {
			System.out.println(1 + i + ". " + MATERIAL_NAMES[i]);
		}
		int choice = userInputIntWithLimits("Az anyag: ", MATERIAL_NAMES.length) - 1;
		if (choice < MATERIAL_NAMES.length && choice >= 0) {
			System.out.printf("%n%s%n", MATERIAL_NAMES[choice]);
			System.out.printf("%s%,d%n", "A régi ára per liter: ", materialP[choice]);
			materialP[choice] = userInputInt("Az új ára per liter: ");
		} else {
			System.out.println("Érvénytelen választás, az adatbevitel nem sikerült.");
		}
	}

	static void printMenu() {
		System.out.printf("%nKérem, válasszon az alábbi lehetőségek közül:%n");
		System.out.println("1. Szolgáltatás bevitele");
		System.out.println("2. Anyagrendelés bevitele");
		System.out.println("3. Készletváltozás bevitele");
		System.out.println("4. Anyagfogyás kiszámítása egy anyagra");
		System.out.println("5. Anyagfogyás kiszámítása az összes anyagra");
		System.out.println("6. Árváltozás");
		System.out.println("7. Adatok mentése");
		System.out.println("8. Adatok betöltése");
		System.out.println("9. Kilépés");
	}

	static int userInputInt(String text) {
		int input;
		while (true) {
			try {
				System.out.printf("%s", text);
				String inputString = SCANNER.nextLine();
				input = Integer.parseInt(inputString);
				return input;
			} catch (NumberFormatException e) {
				System.out.println("Nem sikerült. Kérem egész számot adjon meg!");
			} catch (InputMismatchException e) {
				System.out.println("Nem sikerült. Kérem egy számot adjon meg!");
			}
		}
	}

	static int userInputIntWithLimits(String text, int max) {
		int input = 0;
		do {
			try {
				System.out.printf("%s", text);
				String inputString = SCANNER.nextLine();
				input = Integer.parseInt(inputString);
			} catch (NumberFormatException e) {
				System.out.println("Nem sikerült. Kérem egész számot adjon meg!");
			} catch (InputMismatchException e) {
				System.out.println("Nem sikerült. Kérem egy számot adjon meg!");
			}
		} while (input > max || input < 1);
		return input;
	}

	static double userInputDouble(String text) {
		double input;
		while (true) {
			try {
				System.out.printf("%s", text);
				String inputString = SCANNER.nextLine();
				input = Double.parseDouble(inputString);
				return input;
			} catch (NumberFormatException e) {
				System.out.println("Nem sikerült. Kérem egy egész vagy egy tört számot (pl 1.5) adjon meg!");
			} catch (InputMismatchException e) {
				System.out.println("Nem sikerült. Kérem egy számot adjon meg!");
			}
		}
	}

	static private String readTextFromFile(String source) {
		try {
			return Files.readString(Paths.get(source), StandardCharsets.UTF_8);
		} catch (IOException e) {
			System.err.println("Hiba történt fájl olvasáskor: " + e.getMessage());
			return null;
		}
	}

	static private void writeTextToFile(String fileName, String text) {
		try {
			Files.writeString(Paths.get(fileName), text, StandardCharsets.UTF_8);
		} catch (Exception ex) {
			System.err.println("Hiba történt fájl írásakor: " + ex.getMessage());
		}
	}

	static double[] readDataFromFileDouble(String filename) {
		String[] Q = readTextFromFile(filename).replaceAll("[^0-9. ]", "").split(" ");
		return Arrays.stream(Q).mapToDouble(Double::parseDouble).toArray();
	}

	static int[] readDataFromFileInt(String filename) {
		String[] Q = readTextFromFile(filename).replaceAll("[^0-9 ]", "").split(" ");
		return Arrays.stream(Q).mapToInt(Integer::parseInt).toArray();
	}

	static void saveDataToFileDouble(String filename, double[] data) {
		writeTextToFile(filename, Arrays.toString(data));
	}

	static void saveDataToFileInt(String filename, int[] data) {
		writeTextToFile(filename, Arrays.toString(data));
	}

}
