package carwash;

public enum Consumables {
	M3_POLIRPASZTA("3M polírpaszta", "Polírozás", 13300, 1),
	NASIOL_PROTECT("Nasiol Protect", "Nanokerámiás kezelés", 24000, 2),
	VMD_SPRAY("VMD spray", "Kárpittisztítás", 1599, 3), ASTONISH("Astonish", "Padlótisztítás", 949, 4),
	UNIVERSAL("Universal", "Mosás", 2030, 5), HILL_VITAL("Hill Vital", "Légtérfrissítés", 2290, 6),
	PREVENT("Prevent", "Waxolás", 1999, 7), MOTOR_CLEANER("Motor cleaner", "Motormosás", 1220, 8);

// itt legyen kiszámolva hogy ha kis autó akkor az egy egység árának a 50%-a plusz felárral számoljon a getter, ha nagyobb autó akkor csak 150% .

	private final String materialsName;
	private final String serviceName;
	private int price;
	private int code;
	int extraCharge = 3000;
	double priceOfSmallCarr = 0.5;
	double priceOfBigCarr = 1.5;

	Consumables(String materialsName, String serviceName, int price, int code) {
		this.materialsName = materialsName;
		this.serviceName = serviceName;
		this.price = price;
		this.code = code;
	}

	double getSmallCarPrice() {
		return (int) price * priceOfSmallCarr + extraCharge;
	}

	double getBigCarPrice() {
		return (int) price * priceOfBigCarr;
	}

	String getConsumablesName() {
		return materialsName;
	}

	String getServiceName() {
		return serviceName;
	}

	int getCode() {
		return code;
	}
	int getPrice() {
		return price;
	}
}
