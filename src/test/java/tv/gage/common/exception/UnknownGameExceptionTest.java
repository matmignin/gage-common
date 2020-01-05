package tv.gage.common.exception;

import static org.junit.Assert.*;

import org.junit.Test;

public class UnknownGameExceptionTest {

	@Test
	public void messageTest() {
		String message = "test";
		try {
			throw new UnknownGameException(message);
		} 
		catch (UnknownGameException e) {
			assertEquals(message, e.getMessage());
		}
	}

}
