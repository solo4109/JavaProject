package hu.al_alademia.oop.triangle;

class TriangleException extends IllegalArgumentException {
	
	public TriangleException() {
		super();
	}

	public TriangleException(String message, Throwable cause) {
		super(message, cause);
	}

	public TriangleException(String s) {
		super(s);
	}

	public TriangleException(Throwable cause) {
		super(cause);
	}
}
