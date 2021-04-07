package hu.al_alademia.oop.triangle;

public class Main {
	private static final double RIGHT_ANGLE = 90.00;

	public static void main(String[] args) {

		Main main = new Main();
		main.process();
	}

	private void process() {
		 printTriangleData("Általános háromszög", 4d, 5d, 7d);
	        printTriangleData("Derékszögű háromszög", 4d, 3d, 5d);
	        printTriangleData("Háromszög rossz adatokkal", 10d, 3d, 5d);
	        printTriangleData("Háromszög negatív oldalhosszal", -4d, 3d, 5d);
	}

	private void printTriangleData(String text, double A, double B, double C) {
		try {
			Triangle triangle = new Triangle(A, B, C);
			System.out.println(triangle);
			 System.out.printf("A háromszög szögei: α=%.2f°; β=%.2f°; γ=%.2f°%n", triangle.getAlphaDegree(), triangle.getBetaDegree(),
	                    triangle.getGammaDegree());
	            System.out.printf("A háromszög kerülete: %.4f%n", triangle.getPerimeter());
	            System.out.printf("A háromszög területe: %.4f%n", triangle.getArea());
		}catch(RuntimeException e) {
			System.out.println(e.getMessage());
		}
		System.out.println();
		
	}
}
