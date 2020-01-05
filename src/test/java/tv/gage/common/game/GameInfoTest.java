package tv.gage.common.game;

import static org.junit.Assert.*;

import org.junit.Test;

public class GameInfoTest {

	@Test
	public void clazzTest() {
		GameInfo gameInfo = GameInfo.builder()
				.clazz(String.class)
				.build();
		assertEquals("String", gameInfo.getClazz());
	}

}
