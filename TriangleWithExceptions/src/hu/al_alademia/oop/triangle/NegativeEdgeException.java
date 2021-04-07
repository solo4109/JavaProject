package hu.al_alademia.oop.triangle;

class NegativeEdgeException extends TriangleException {

	private static final String MESSAGE = "HIBA: Negatív oldalhossz.";

	public NegativeEdgeException() {
		this("");
	}

	public NegativeEdgeException(String message, Throwable cause) {
		super(message, cause);
	}

	public NegativeEdgeException(String message) {
		super(MESSAGE + " ("+message +")");
	}

	public NegativeEdgeException(Throwable cause) {
		super(cause);
	}

}
