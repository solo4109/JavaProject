package hu.ak_akademia.oop.bergengocy;

import java.util.Scanner;

import hu.ak_akademia.oop.bergengocy.sp.ServiceProviderFactory;

/**
 * Bergengóciában három mobiltelefon szolgáltató cégnek van koncessziós szerződése az állammal.
 * A cégek ott olyan díjszabást alkalmaznak, amely csak a hívást kezdeményező fél szolgáltatójától függ (a hívott körzettől nem).
 * A cégek legfontosabb adatait az alábbi táblázat foglalja össze.
 * 
 * Szolgáltató                  Körzetszám            Tarifa típusa          Tarifa Mértéke 
 * 
 * Decens Távközlési Zrt.             876              másodperc alapú       az első 2 percben 1,5 peták / mp, azt követően 0,5 peták / mp
 * 
 * Fecsegtető Telekom Zrt.            21               hívás alapú           300 peták / hívás   
 * 
 * LukRáció Kft.                       7               perc alapú             megkezdett percenként 50 peták / perc
 */
public class Main {

	public static void main(String[] args) {
		new Main().run();
	}
	
	private final ServiceProvider[] providers = ServiceProviderFactory.getProviders();
	private final Scanner scanner = new Scanner(System.in);
	private final PhoneNumberChecker checker = new PhoneNumberChecker();

	private void run() {
		
		Message message = new Message();
		message.guide();
        // ask for user input: call duration as well as the phone number
        Duration duration = inputCallDuration("Add meg a hívás időtartamát (<perc>:<másodperc>): ");
        String phoneNumber = inputPhoneNumber("Add meg a telefonszámot (a körzetszámtól kezdve, vagy távhívás előhívókkal): ");
        scanner.close();
        phoneNumber = checker.clean(phoneNumber);
 
        // identify the provider, calculate call fee
        var provider = identifyProvider(phoneNumber);
        var localNumber = phoneNumber.substring(provider.getAreaCode().length());
        checker.checkLocalNumber(localNumber);
        System.out.printf("A hívást a %s bonyolította le, díja %d peták (%s)%n", provider.getCompanyName(),
                provider.calculateCallFee(duration), provider.getTariffDescription());
 
        // identify optimum provider (with the lowest call fee)
        var optimumProvider = identifyOptimumProvider(duration);
        if (provider == optimumProvider) {
            System.out.printf("A megadott idejű hívásra a %s az optimális szolgáltató.%n", optimumProvider.getCompanyName());
        } else {
            System.out.printf("A megadott idejű hívásra az optimális szolgáltató a %s lenne, az ő díjuk csak %d peták.%n",
                    optimumProvider.getCompanyName(), optimumProvider.calculateCallFee(duration));
        }
    }
 
    // ask the user to enter the call duration
    private Duration inputCallDuration(String prompt) {
        System.out.print(prompt);
        String[] duration = scanner.nextLine().split(":");
        if (duration.length != 2) {
            throw new IllegalArgumentException("A megadott időtartam nem értelmezhető!");
        }
        int minutes, seconds;
        try {
            minutes = Integer.parseInt(duration[0].strip());
            seconds = Integer.parseInt(duration[1].strip());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("A megadott időtartam nem értelmezhető!");
        }
        return new Duration(minutes, seconds);
    }
 
    private String inputPhoneNumber(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
 
    private ServiceProvider identifyProvider(String phoneNumber) {
        for (ServiceProvider sp : providers) {
            if (phoneNumber.startsWith(sp.getAreaCode())) {
                return sp;
            }
        }
        throw new IllegalArgumentException("A megadott telefonszám Bergengóciában nem mobilszám!");
    }
 
    private ServiceProvider identifyOptimumProvider(Duration duration) {
        ServiceProvider bestProvider = null;
        int minFee = Integer.MAX_VALUE;
        for (ServiceProvider sp : providers) {
            int fee = sp.calculateCallFee(duration);
            if (fee < minFee) {
                minFee = fee;
                bestProvider = sp;
            }
        }
        return bestProvider;
    }
}
