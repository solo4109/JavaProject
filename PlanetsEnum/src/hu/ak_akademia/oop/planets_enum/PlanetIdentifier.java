package hu.ak_akademia.oop.planets_enum;

class PlanetIdentifier {

	private Planet planet;
	private String message;
	private boolean appToQuit;

	void identify(String input) {
		input = input.trim();
		if (input.isEmpty()) {
			appToQuit = true;
			return;
		}

		int count = 0;
		for (Planet p : Planet.values()) {
			if (p.getLocalName().toLowerCase().startsWith(input.toLowerCase())) {
				planet = p;
				count++;
			}
		}
		if (count == 1) { 
			message = null;
		} else { 
			planet = null;
			message = String.format("A(z) \"%s\" %s", input,
					count == 0 ? "nem határoz meg egyetlen bolygót sem!" : "nem határozza meg egyértelműen a bolygót!");
		}
	}

	Planet getPlanet() {
		return planet;
	}

	String getMessage() {
		return message;
	}

	boolean isAppToQuit() {
		return appToQuit;
	}

}
