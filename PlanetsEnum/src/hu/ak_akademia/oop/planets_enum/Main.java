package hu.ak_akademia.oop.planets_enum;

import java.util.Scanner;

public class Main {
	Scanner scanner = new Scanner(System.in);

	private static final String VOWELS = "aáeéiíoóöőuúüű";
	
	public static void main(String[] args) {
		Main main = new Main();
		main.process();
	}

	private void process() {
		Message message = new Message();
		System.out.print(message.getWelcome());
		System.out.print(message.getInfo());
		for (PlanetIdentifier identifier = new PlanetIdentifier(); !identifier.isAppToQuit(); System.out
				.print(" > "), identifier.identify(scanner.nextLine())) {
			print(identifier);
		}
		scanner.close();
		System.out.print(message.getFarewell());
	}

	private void print(PlanetIdentifier identifier) {
		if (identifier.getPlanet() != null) {
			print(identifier.getPlanet());
		} else if (identifier.getMessage() != null) {
			System.out.println("   " + identifier.getMessage());
		}
	}
	 
	    private void print(Planet planet) {
	        System.out.printf("  %s bolygó%n", addArticle(planet.getLocalName()));
	        System.out.printf("         sugara: %,.0f km%n", planet.getRadius());
	        System.out.printf("         felszíne: %.2e km²%n", planet.getSurface());
	        System.out.printf("         térfogata: %.2e km³%n", planet.getCapacity());
	        System.out.printf("         tömege: %.2e kg%n", planet.getMass());
	        System.out.printf("         sűrűsége: %.2f kg/dm³%n", planet.getDensity());
	        System.out.printf("         felszíni gravitációja: %.2f m/s²%n", planet.getGravity());
	        System.out.printf("         szökési sebessége: %.1f km/s%n", planet.getEscapeVelocity());
	    }
	    
	    private String addArticle(String planetName) {
	    	return(VOWELS.indexOf(planetName.toLowerCase().charAt(0)) < 0 ? "A ":"Az ")+planetName;
	    }
	    
}
