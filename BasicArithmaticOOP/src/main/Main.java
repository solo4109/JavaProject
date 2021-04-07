package main;

import java.util.Scanner;

import main.MenuServicePoint.Type;
import menu.MenuFactory;

public class Main {
	
	private static final MenuServicePoint menuFactory = MenuFactory.getInstance();
	
	public static void main(String[] args) {
	new Main().run();
	}

	private void run() {
		
		  System.out.printf("Üdvözöllek az Alapműveletek programban!%n");
	        Scanner scanner = new Scanner(System.in);
	        Menu menu = menuFactory.getMenu(Type.LETTERED_LC, "   művelet: ", "+", "-", "*", "/");
	        for (;;) {
	            System.out.println();
	            Operation operation = menu.printAndSelect(scanner);
	            if (operation == null) {
	                break;
	            }
	            int[] operands = inputOperands(scanner);
	            operation.perform(operands[0], operands[1]);
	            printResult(operation);
	        }
	        scanner.close();
	        System.out.printf("%nViszlát!%n");
	    }
	 
	    private static int[] inputOperands(Scanner scanner) {
	        int op1 = inputOperand("első operandus", scanner);
	        int op2 = inputOperand("második operandus", scanner);
	        return new int[] { op1, op2 };
	    }
	 
	    private static int inputOperand(String prompt, Scanner scanner) {
	        for (;;) {
	            System.out.printf("   %-17s: ", prompt);
	            try {
	                int operand = scanner.nextInt();
	                scanner.nextLine();
	                return operand;
	            } catch (NumberFormatException e) {
	            }
	        }
	    }
	 
	    private void printResult(Operation op) {
	        if (op.isOk()) {
	            System.out.printf("   %-17s: %d%n", "az eredmény", op.getResult());
	        } else {
	            System.out.printf("   %s%n", op.getErrorMessage());
	        }
	    }
	

}
