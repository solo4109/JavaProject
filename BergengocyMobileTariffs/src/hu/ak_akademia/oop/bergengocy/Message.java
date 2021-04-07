package hu.ak_akademia.oop.bergengocy;

public class Message {
	
	public void guide() {
		System.out.println("Bergengóciában három mobiltelefon szolgáltató cégnek van koncessziós szerződése az állammal.\r\n\r\n"
				+ "A cégek ott olyan díjszabást alkalmaznak, amely csak a hívást kezdeményező fél szolgáltatójától függ (a hívott körzettől nem).\r\n"
				+ "A cégek legfontosabb adatait az alábbi táblázat foglalja össze.\r\n"
				+ " \r\n"
				+ "Szolgáltató                  Körzetszám            Tarifa típusa          Tarifa Mértéke \r\n"
				+ " \r\n"
				+ "Decens Távközlési Zrt.             876              másodperc alapú       az első 2 percben 1,5 peták / mp, azt követően 0,5 peták / mp\r\n"
				+ "\r\n"
				+ "Fecsegtető Telekom Zrt.            21               hívás alapú           300 peták / hívás   \r\n"
				+ "  \r\n"
				+ "LukRáció Kft.                       7               perc alapú             megkezdett percenként 50 peták / perc\r\n");
		System.out.println("Egy-egy hívás díjának kiszámításához elég megadnunk a hívás időtartamát (perc, másodperc), valamint a telefonszámot (miután a telefonszám a fentiek szerint azonosítja a szolgáltatót). A program ezt követően írja ki hogy az adott hívás mennyibe került.\r\n"
				+ "\r\n"
				+ "A bergengóc fizetőeszközről tudni kell, hogy minden árat és díjat egész számú petákra kell kerekíteni.\r\n"
				+ "\r\n"
				+ "A nemzetközi távhívás előhívója ’00’ vagy ’+’. Bergengócia országkódja ’355’. Az országon belüli távhívás előhívója ’06’. A körzeten belül a telefonszámok hossza 5 és 7 számjegy közt változhat.\r\n"
				+ "\r\n"
				+ "A telefonszámok megadását kezdhetjük közvetlenül a körzetszámmal, de a programnak fel kell ismernie azt is, ha a számot az országon belüli távhívás formátumában, vagy ha nemzetközi formátumban adtuk meg. A felhasználók által begépelt telefonszámok a tíz számjegykarakteren kívül tartalmazhatnak még szóközöket, kötőjeleket és kerek zárójeleket is – de e karaktereknek a telefonszámok azonosításakor Bergengóciában sincs jelentőségük.\r\n"
				+ "\r\n"
				+ "A díj kiszámítását követően a program tájékoztassa arról is a felhasználót, hogy az adott hívás melyik mobilszolgáltatónál lett volna a legolcsóbb. Valamint írja ki a legolcsóbb szolgáltató tarifáját is – ha az nem egyezik meg a körzetszámból azonosítottal.\r\n");
	}

}
