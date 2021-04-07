import java.util.Scanner;

public class Main {

	Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		Main main = new Main();
		main.process();
	}

	private void process() {
		  TargetSetter targetSetter = new TargetSetter(); // try to load words from disk file
	        if (targetSetter.getErrorMessage() != null) { // program can't start if words couldn't be loaded
	            System.out.printf("A játék nem indul el; hibaüzenet: %s%n", targetSetter.getErrorMessage());
	            return;
	        }
	        Messages messages = new Messages();
	        messages.welcome();
	        messages.rule();;
	        for (boolean first = true; canSessionStart(first); first = false) {
	            Session session = new Session(scanner, targetSetter.getNext());
	            session.play();
	            if (session.isGameToExit()) {
	                break;
	            }
	        }
	        scanner.close();
	        messages.bye();
	    }
	 
	    private boolean canSessionStart(boolean first) {
	        System.out.printf("%nIndulhat %s menet? ", first ? "az első" : "a következő");
	        return !scanner.nextLine().toLowerCase().startsWith("n");
	    }
		
	}


