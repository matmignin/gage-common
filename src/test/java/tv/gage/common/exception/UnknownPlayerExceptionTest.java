package tv.gage.common.exception;

import static org.junit.Assert.*;

import org.junit.Test;

public class UnknownPlayerExceptionTest {

	@Test
	public void messageTest() {
		String message = "test";
		try {
			throw new UnknownPlayerException(message);
		} 
		catch (UnknownPlayerException e) {
			assertEquals(message, e.getMessage());
		}
	}

}
