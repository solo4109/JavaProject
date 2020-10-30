package hu.ak_akademia.oop.planets_enum;

enum Planet {
	MERCURY("Merkúr", 2439.64, 3.302e23), 
	VENUS("Vénusz", 6051.59, 4.869e24), 
	EARTH("Föld", 6378.1, 5.972e24), 
	MARS("Mars", 3397.0, 6.4191e23),
	JUPITER("Jupiter", 71492.68, 1.8987e27),
	SATURN("Szaturnusz", 60267.14, 5.6851e26), 
	URANUS("Uránusz", 25557.25, 8.6849e25), 
	NEPTUN("Neptunusz", 24766.36, 1.0244e26);

	private final String localName;
	private double radius;
	private double mass;
	private static double GAMMA = 6.67408e-11;

	private Planet(String localName, double radius, double mass) {
		this.localName = localName;
		this.radius = radius * 1e3;
		this.mass = mass;
	}

	double getRadius() { // sugár
		return radius / 1e3;
	}

	double getMass() { // tömeg
		return mass;
	}

	double getSurface() { // felszín
		return (4 * radius * radius * Math.PI) / 1e6;
	}

	double getCapacity() {// térfogat
		return 4.0 * Math.PI / 3.0 * radius * radius * radius;
	}

	double getDensity() {// sűrűség
		return (mass / getCapacity()) / 1e3;
	}

	double getGravity() {// gravitáció
		return GAMMA * mass / radius / radius;
	}

	double getEscapeVelocity() { // szökési sebesség
		return (Math.sqrt(GAMMA * mass / radius)) /1e3;

	}

	public String getLocalName() {
		return localName;
	}
}
