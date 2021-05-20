package carwash;

import java.util.HashMap;
import java.util.Map;

public class Menu {

	int amount = 0;

	public void menuInPut() {
		Map<String, String> serviceAndMaterials = new HashMap<>();
		Map<String, Integer> materialsAndAmount = new HashMap<>();
		for (Consumables c : Consumables.values()) {
			serviceAndMaterials.put(c.getServiceName(), c.getConsumablesName());
			materialsAndAmount.put(c.getConsumablesName(), amount);
		}

		
	}

	private void printMenu() {
		System.out.printf("%nKérem, válasszon az alábbi lehetőségek közül:%n");
		System.out.println("1. Anyag egységek megadása");
		System.out.println("9. Kilépés");	
	}

}
