package MainPackage;

public class InvalidContactInfoException extends Exception {
    private static final long serialVersionUID = 1L;

	public InvalidContactInfoException(String message) {
        super(message);
    }
}
