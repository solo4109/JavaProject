package main;

public interface MenuServicePoint {

	Menu getMenu(Type type, String prompt, Operation[] operations);

	Menu getMenu(Type type, String prompt);

	default Menu getMenu(Type type) {
		return getMenu(type, "> ");
	}

	default Menu getMenu() {
		return getMenu(Type.NUMERAL);
	}

	Menu getMenu(Type type, String prompt, String... symbols);

	enum Type {
		NUMERAL, LETTERED_LC, LETTERED_UC;

		public boolean isNumeral() {
			return this == NUMERAL;
		}

		public boolean isUpperCase() {
			return this == LETTERED_UC;
		}
	}
}
