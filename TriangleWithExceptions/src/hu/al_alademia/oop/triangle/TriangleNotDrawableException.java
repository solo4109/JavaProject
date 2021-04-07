package hu.al_alademia.oop.triangle;

class TriangleNotDrawableException extends TriangleException {

	private static final String MESSAGE = "HIBA: Nem teljesül a háromszög egyenlőtlenség";

	public TriangleNotDrawableException() {
		this("");
	}

	public TriangleNotDrawableException(String message, Throwable cause) {
		super(message, cause);
	}

	public TriangleNotDrawableException(String message) {
		super(MESSAGE + " ("+ message + ")");
	}

	public TriangleNotDrawableException(Throwable cause) {
		super(cause);
	}

}
