package tv.gage.common.exception;

public class UnknownGameException extends Exception {

	private static final long serialVersionUID = 3063901468888129314L;

	public UnknownGameException(String errorMessage) {
		super(errorMessage);
	}
}
