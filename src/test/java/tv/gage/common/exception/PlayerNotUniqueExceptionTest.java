package tv.gage.common.exception;

import static org.junit.Assert.*;

import org.junit.Test;

public class PlayerNotUniqueExceptionTest {

	@Test
	public void exceptionTest() {
		String message = "test";
		try {
			throw new PlayerNotUniqueException(message);
		} 
		catch (PlayerNotUniqueException e) {
			assertEquals(message, e.getMessage());
		}
	}

}
