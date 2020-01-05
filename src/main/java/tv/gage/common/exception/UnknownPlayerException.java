package tv.gage.common.exception;

public class UnknownPlayerException extends Exception {

	private static final long serialVersionUID = 2426818555177469503L;

	public UnknownPlayerException(String errorMessage) {
		super(errorMessage);
	}
	
}
