package hu.al_alademia.oop.triangle;

class Triangle {

	private double A;
	private double B;
	private double C;

	public Triangle(double A, double B, double C) throws TriangleException {
		this.A = A;
		this.B = B;
		this.C = C;
		check(A, B, C);
	}

	private void check(double A, double B, double C) throws TriangleException {
		if (A <= 0 || B <= 0 || C <= 0) {
			throw new NegativeEdgeException();
		}
		if (A + B < C || B + C < A || C + A < B)
			throw new TriangleNotDrawableException(String.format("a=%.4f; b=%.4f; c=%.4f", A, B, C));

	}

	public String toString() {
		return String.format("Háromszög: a=%.4f; b=%.4f; c=%.4f", A, B, C);
	}

	private void setA(double A) throws TriangleException {
		check(A, B, C);
		this.A = A;
	}

	private void setB(double b) throws TriangleException {
		check(A, B, C);
		this.B = B;
	}

	private void setC(double c) throws TriangleException {
		check(A, B, C);
		this.C = C;
	}

	public double getA() {
		return A;
	}

	public double getB() {
		return B;
	}

	public double getC() {
		return C;
	}

	double getAlpha() {
		return Math.acos((B * B + C * C - A * A) / (2d * B * C));
	}

	double getAlphaDegree() {
		return Math.toDegrees(getAlpha());
	}

	private double getBeta() {
		return Math.acos((A * A + C * C - B * B) / (2d * A * C));
	}

	public double getBetaDegree() {
		return Math.toDegrees(getBeta());
	}

	private double getGamma() {
		return Math.acos((A * A + B * B - C * C) / (2d * A * B));
	}

	public double getGammaDegree() {
		return Math.toDegrees(getGamma());
	}

	double getPerimeter() {
		return A + B + C;
	}

	public double getArea() {
		double s = getPerimeter() / 2d;
		return Math.sqrt(s * (s - A) * (s - B) * (s - C));
	}

}
