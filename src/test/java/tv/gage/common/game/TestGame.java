package tv.gage.common.game;

import tv.gage.common.messaging.BroadcastService;

public class TestGame extends Game {

	public TestGame(BroadcastService broadcastService, String gamecode) {
		super(TestGame.class, broadcastService, gamecode, 4, 6);
	}

	public void receiveGameCommand(String jsonCommand) {}

	@Override
	public void receivePlayerCommand(Player player, String jsonCommand) {}

}
