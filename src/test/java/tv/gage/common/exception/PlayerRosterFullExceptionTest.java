package tv.gage.common.exception;

import static org.junit.Assert.*;

import org.junit.Test;

public class PlayerRosterFullExceptionTest {

	@Test
	public void messageTest() {
		String message = "test";
		try {
			throw new PlayerRosterFullException(message);
		} 
		catch (PlayerRosterFullException e) {
			assertEquals(message, e.getMessage());
		}
	}

}
