package tv.gage.common.exception;

public class PlayerNotUniqueException extends Exception {

	private static final long serialVersionUID = -5263783550749415023L;

	public PlayerNotUniqueException(String errorMessage) {
		super(errorMessage);
	}
}
