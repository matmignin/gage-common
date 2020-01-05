package tv.gage.common.game;

import tv.gage.common.socket.SocketService;

public class TestGame extends Game {

	public TestGame(SocketService socketService, String gameCode) {
		super(TestGame.class, socketService, gameCode, 4, 6);
	}

	public void receiveGameCommand(String jsonCommand) {}

	@Override
	public void receivePlayerCommand(Player player, String jsonCommand) {}
	
}
