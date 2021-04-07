package game;

class Message {
	void welcome(){
		System.out.println("Üdvözöllek a számkitalálós játékban!\r\n" + 
				"A játék lényege, hogy a program \"gondol\" egy számra 1 és 200 közt, amit Neked ki kell találnod, mégpedig minél kevesebb tippeléssel.\r\n" + 
				"A program minden tipped után közli, hogy a kitalálandó szám kisebb vagy nagyobb, mint a tipp.\r\n" + 
				"Ha viszont a kettő éppen megegyezik, az aktuális menet véget ér - de ha akarod, kezdődhet a következő.\r\n" + 
				"Nulla megadásával bármikor, menet közben is ki tudsz lépni a programból.");
		System.out.println();
	}
	
	   void farewell() {
	        System.out.printf("%nViszlát!%n");
	    }
}
