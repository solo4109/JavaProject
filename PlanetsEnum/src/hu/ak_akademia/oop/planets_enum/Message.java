package hu.ak_akademia.oop.planets_enum;

class Message {
	
	String getWelcome() {
        return String.format("Üdvözöllek a Bolygók adatlekérdező programban!%n%n");
    }
	
	String getInfo() {
        return String.format("A program segítségével lekérdezheted a Naprendszer nyolc bolygójának néhány adatát.%n"
                + "A neve kezdőbetűinek megadásával kiválaszthatsz egy bolygót, amelynek adatait a program kilistázza.%n"
                + "A programból úgy léphetsz ki, hogy nem adsz meg egyetlen karaktert sem.%n%n");
    }
	
	String getFarewell() {
        return String.format("%nViszlát!%n");
    }
}
